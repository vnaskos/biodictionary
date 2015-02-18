package com.vnaskos.biodictionary.xmlTools;

import com.vnaskos.biodictionary.translator.Translate;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author Vasilis Naskos
 */
public class XMLMergeManager {

    Translate tr;
    String outputPath;
    ArrayList<File> files;
    
    protected XMLMergeManager(Translate tr, String output, String... xmlFiles) {
        this.tr = tr;
        this.outputPath = output;
        
        files = new ArrayList<File>();
        
        for (String xml : xmlFiles) {
            files.add(new File(xml));
        }
    }
    
    public static void merge(Translate tr, String output, String... xmlFiles) {
        XMLMergeManager manager = new XMLMergeManager(tr, output, xmlFiles);

        if(!manager.checkParams()) {
            return;
        }
        
        try {
            manager.merge();
            manager.terminate();
        } catch (Exception ex) {
            Logger.getLogger(XMLMergeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean checkParams() {
        if (files.size() < 2) {
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorXMLMergeAtLeast"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (outputPath.equals("")) {
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorXMLMergeOutput"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    private void merge() throws Exception {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression compiledExpression = xpath.compile("/dictionary");
        
        Document doc = getBaseDocument(compiledExpression);
        
        XMLExporter.export(tr, doc, outputPath);
    }
    
    private Document getBaseDocument(XPathExpression compiledExpr) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document base = docBuilder.parse(files.get(0));
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i <= base.getDocumentElement().getElementsByTagName("token").getLength() - 1; i++) {
            words.add(base.getDocumentElement().getElementsByTagName("word").item(i).getTextContent());
        }
        Node results = (Node) compiledExpr.evaluate(base, XPathConstants.NODE);
        if (results == null) {
            throw new IOException(files.get(0)
                    + ": expression does not evaluate to node");
        }

        for (int i = 1; i < files.size(); i++) {
            Document merge = docBuilder.parse(files.get(i));
            Node nextResults = (Node) compiledExpr.evaluate(merge, XPathConstants.NODE);
            while (nextResults.hasChildNodes()) {
                Node kid = nextResults.getFirstChild();
                String testCondition;
                try {
                    testCondition = kid.getChildNodes().item(1).getTextContent();
                } catch (NullPointerException e) {
                    testCondition = "";
                }
                nextResults.removeChild(kid);
                if (!words.contains(testCondition)) {
                    if (!testCondition.equals("")) {
                        words.add(testCondition);
                    }
                    kid = base.importNode(kid, true);
                    results.appendChild(kid);
                }
            }
        }
        
        return base;
    }
    
    private void terminate() {
        files.clear();
    }
    
}
