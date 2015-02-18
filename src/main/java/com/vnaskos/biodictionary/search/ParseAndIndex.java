package com.vnaskos.biodictionary.search;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.store.LockObtainFailedException;
import org.xml.sax.SAXException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import org.apache.commons.digester3.Digester;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 *
 * @author Vasilis Naskos
 */
public class ParseAndIndex {
    private static IndexWriter writer;
    private Directory index;
    private static ParseAndIndex instance;
    
    public static ParseAndIndex getInstance() {
        if(instance == null) {
            instance = new ParseAndIndex();
        }
        return instance;
    }
    
    public void addToken(Token token) throws IOException {
        //System.out.println("Adding " + token.getWord());
        Document tokenDocument  = new Document();
        tokenDocument.add(new Field("word", token.getWord(), Field.Store.YES, Field.Index.ANALYZED));
        tokenDocument.add(new Field("definition", token.getDefinision(), Field.Store.YES, Field.Index.ANALYZED));
        tokenDocument.add(new Field("category", token.getCategory(), Field.Store.YES, Field.Index.ANALYZED));
        tokenDocument.add(new Field("image", token.getImage(), Field.Store.YES, Field.Index.ANALYZED));
        writer.addDocument(tokenDocument);
    }

    public void createIndex(String xmlDir) throws IOException, SAXException, ParseException { 
        index = new RAMDirectory();
        addDict(xmlDir);
    }
    
    public void addDict(String xmlDir) throws CorruptIndexException, LockObtainFailedException, IOException, SAXException{
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_35, analyzer);
        if(index == null) {
            index = new RAMDirectory();
        }
        writer = new IndexWriter(index, indexWriterConfig);   

        Digester digester = new Digester();
        digester.setValidating(false);

        digester.addObjectCreate("dictionary", ParseAndIndex.class );
        digester.addObjectCreate("dictionary/token", Token.class );
        
        // set different properties of Token instance using specified methods
        digester.addCallMethod("dictionary/token/word", "setWord", 0);
        digester.addCallMethod("dictionary/token/definition", "setDefinition", 0);
        digester.addCallMethod("dictionary/token/category", "setCategory", 0);
        digester.addCallMethod("dictionary/token/image", "setImage", 0);
        
        digester.addSetNext("dictionary/token", "addToken" );
        
        digester.parse(new File(xmlDir));
        writer.close();
    }
    
    public Document getDocument(int docId){
        Document d = null;
        try {
            IndexReader reader = IndexReader.open(index);
            //FilterIndexReader filteredReader = new FilterIndexReader(reader)
            IndexSearcher searcher = new IndexSearcher(reader);
            d = searcher.doc(docId);
        } catch (CorruptIndexException ex) {
            Logger.getLogger(ParseAndIndex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParseAndIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public Token getToken(int docId) {
        Document doc = getDocument(docId);
        Token token = Token.createNew(
                doc.get("word"), doc.get("definition"),
                doc.get("category"), doc.get("image"));
        return token;
    }
    
    public TreeSet<ResultWord> searchByFields(String word, String[] field, boolean fuzzy){
        if(index == null) {
            return new TreeSet<ResultWord>();
        }
        TreeSet<ResultWord> wordKeySet = new TreeSet<ResultWord>();
        try {
            ArrayList<ScoreDoc> hits = new ArrayList<ScoreDoc>();
            hits.addAll(search(word, field, fuzzy));
            
            IndexReader reader = IndexReader.open(index);
            //FilterIndexReader filteredReader = new FilterIndexReader(reader)
            IndexSearcher searcher = new IndexSearcher(reader);
            for (ScoreDoc doc : hits) {
                int docId = doc.doc;
                Document d = searcher.doc(docId);
                wordKeySet.add(new ResultWord(d.get("word"), docId, doc.score));
                //System.out.println(doc.score + ". " + d.get("word"));
            }
        } catch (CorruptIndexException ex) {
            Logger.getLogger(ParseAndIndex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParseAndIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wordKeySet;
    }
    
    public List<ScoreDoc> search(String word, String[] fields, boolean fuzzy){
        ScoreDoc[] hits = new ScoreDoc[0];
        try {
            BooleanQuery query = new BooleanQuery();
            if(fuzzy){
                for(String field : fields){
                    query.add(new FuzzyQuery(new Term(field,word)), Occur.SHOULD);
                }
            } else{
                for(String field : fields){
                    query.add(new TermQuery(new Term(field, word)), Occur.SHOULD);
                }
            }
            Query queryAll = new MatchAllDocsQuery();
            int hitsPerPage = 200;
            IndexReader reader = IndexReader.open(index);
            int all = reader.numDocs();
            //FilterIndexReader filteredReader = new FilterIndexReader(reader)
            IndexSearcher searcher = new IndexSearcher(reader);
            TopScoreDocCollector collectorAll = TopScoreDocCollector.create(all, true);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
            if(word.equals("")){
                searcher.search(queryAll, collectorAll);
                hits = collectorAll.topDocs().scoreDocs;
            }else{
                searcher.search(query, collector);
                hits = collector.topDocs().scoreDocs;
            }
        } catch (CorruptIndexException ex) {
            Logger.getLogger(ParseAndIndex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParseAndIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Arrays.asList(hits);
    }
}
