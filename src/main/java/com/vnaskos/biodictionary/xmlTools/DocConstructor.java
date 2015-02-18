package com.vnaskos.biodictionary.xmlTools;

import com.vnaskos.biodictionary.search.Token;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Vasilis Naskos
 */
public class DocConstructor {

    public static Document getDoc(List<Token> tokens) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root element
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("dictionary");
        doc.appendChild(rootElement);

        for (Token dictionaryToken : tokens) {
            Element token = doc.createElement("token");
            rootElement.appendChild(token);
            Element word = doc.createElement("word");
            Element definition = doc.createElement("definition");
            Element category = doc.createElement("category");
            Element image = doc.createElement("image");
            word.appendChild(doc.createTextNode(dictionaryToken.getWord()));
            token.appendChild(word);
            definition.appendChild(doc.createTextNode(dictionaryToken.getDefinision()));
            token.appendChild(definition);
            category.appendChild(doc.createTextNode(dictionaryToken.getCategory()));
            token.appendChild(category);
            image.appendChild(doc.createTextNode(dictionaryToken.getImage()));
            token.appendChild(image);
        }
        
        return doc;
    }
    
}
