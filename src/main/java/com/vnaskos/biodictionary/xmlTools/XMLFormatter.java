package com.vnaskos.biodictionary.xmlTools;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

/**
 *
 * @author Vasilis Naskos
 */
public class XMLFormatter {
    
    public static String format(Node source) {
        try {
            return getFormated(source);
        } catch (ClassCastException ex) {
            Logger.getLogger(XMLFormatter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(XMLFormatter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(XMLFormatter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XMLFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    private static String getFormated(Node source)
            throws ClassCastException, IllegalAccessException,
            InstantiationException, ClassNotFoundException {
        StringWriter stringWriter = new StringWriter();

        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementationLS impls = (DOMImplementationLS) registry.getDOMImplementation("LS");

        //Prepare the output
        LSOutput domOutput = impls.createLSOutput();
        domOutput.setEncoding(java.nio.charset.Charset.defaultCharset().name());
        domOutput.setCharacterStream(stringWriter);
        domOutput.setEncoding("UTF-8");
        //Prepare the serializer
        LSSerializer domWriter = impls.createLSSerializer();
        DOMConfiguration domConfig = domWriter.getDomConfig();
        domConfig.setParameter("format-pretty-print", true);
        domConfig.setParameter("element-content-whitespace", true);
        domWriter.setNewLine("\r\n");
        domConfig.setParameter("cdata-sections", Boolean.TRUE);
        //And finaly, write
        domWriter.write(source, domOutput);
        String subscrXML = domOutput.getCharacterStream().toString();

//        DOMStringList dsl = domConfig.getParameterNames();
//        System.out.println(subscrXML);
//
//        for (int i = 0; i < dsl.getLength(); i++) {
//            String item = dsl.item(i);
//            Object param = domConfig.getParameter(item);
//            System.out.printf("%s = [%s]", item, param);
//        }

        return subscrXML;
    }
    
}
