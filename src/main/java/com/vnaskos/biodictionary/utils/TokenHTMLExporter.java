package com.vnaskos.biodictionary.utils;

import com.vnaskos.biodictionary.Main;
import com.vnaskos.biodictionary.search.Token;
import com.vnaskos.biodictionary.translator.Translate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vasilis Naskos
 */
public class TokenHTMLExporter {

    public static void export(Translate tr, Token token, String output) {
        try {
            String text = formatText(tr, token);
            writeOutput(text, output);
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.successHTMLExport"),
                    tr.getString("biodictionary.Main.windowTitle"),
                    JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static String formatText(Translate tr, Token token) {
        StringBuilder builder = new StringBuilder();

        builder.append("<html>\r\n<head>\r\n");
        builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
        builder.append("</head>\r\n<body>\r\n");
        builder.append("<table border=\"1\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\r\n");
        builder.append("<tbody><tr bgcolor=\"#CCCCFF\" class=\"TableHeadingColor\">\r\n");
        builder.append("<th align=\"left\" colspan=\"2\"><font size=\"+2\">\r\n");
        builder.append("<b>");
        builder.append(token.getWord());
        builder.append("</b></font></th></tr>\r\n");
        builder.append("<tr bgcolor=\"white\" class=\"TableRowColor\">\r\n");
        builder.append("<td width=\"25%\"><b><img width=\"400px\" height=\"auto\" src=\"");
        builder.append(token.getImage());
        builder.append("\" /></b></td>\r\n");
        builder.append("<td>");
        builder.append(token.getDefinision());
        builder.append("</td>\r\n");
        builder.append("</tr>\r\n</table>\r\n");
        builder.append("<h2 style=\"clear:both;\">");
        builder.append(tr.getString("biodictionary.HTML.category"));
        builder.append(": <span style=\"color:#777\">");
        builder.append(token.getCategory());
        builder.append("</span></h2>\r\n");
        builder.append("</body>\r\n</html>");
        
        return builder.toString();
    }
    
    private static void writeOutput(String text, String output) throws IOException {
        FileWriter fw = new FileWriter(output);
        BufferedWriter out = new BufferedWriter(fw);
        out.write(text);
        out.close();
        fw.close();
    }
    
}
