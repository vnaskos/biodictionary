package com.vnaskos.biodictionary.xmlTools;

import com.vnaskos.biodictionary.translator.Translate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.w3c.dom.Document;

/**
 *
 * @author Vasilis Naskos
 */
public class XMLExporter {

    Translate tr;
    Document doc;
    String outputPath;
    
    protected XMLExporter(Translate tr, Document doc, String outputPath) {
        this.tr = tr;
        this.doc = doc;
        this.outputPath = outputPath;
        
        if (!outputPath.endsWith(".xml")) {
            this.outputPath += ".xml";
        }
    }
    
    public static void export(Translate tr, Document doc, String outputPath) {
        try {
            XMLExporter exporter = new XMLExporter(tr, doc, outputPath);
            
            exporter.exportXML();
        } catch (IOException ex) {
            Logger.getLogger(XMLExporter.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorNewDictionary"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void exportXML() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(outputPath));
        String xmlContent = XMLFormatter.format(doc);
        
        if (xmlContent == null) {
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorNewDictionary"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        out.write(xmlContent);
        out.close();
        
        JOptionPane.showMessageDialog(null,
                tr.getString("biodictionary.success"),
                tr.getString("biodictionary.Main.windowTitle"),
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}
