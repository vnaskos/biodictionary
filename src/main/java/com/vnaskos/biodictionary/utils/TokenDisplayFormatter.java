package com.vnaskos.biodictionary.utils;

import com.vnaskos.biodictionary.search.Token;
import com.vnaskos.biodictionary.translator.Translate;

/**
 *
 * @author Vasilis Naskos
 */
public class TokenDisplayFormatter {
    
    public static String format(Translate tr, Token token) {
        StringBuilder builder = new StringBuilder();
        
        builder.append("<html><body style=\"background-image: url(");
        builder.append(TokenDisplayFormatter.class.getResource("/img/pattern.jpg"));
        builder.append(");\">");
        builder.append("<h1 style=\"text-align:center; border-bottom: 1px solid #000;\">");
        builder.append(token.getWord());
        builder.append("</h1><p><b>");
        builder.append(tr.getString("biodictionary.HTML.definition"));
        builder.append("</b>:<br>");
        builder.append(token.getDefinision());
        builder.append("<br><br><b>");
        builder.append(tr.getString("biodictionary.HTML.category"));
        builder.append("</b>:<br>");
        builder.append(token.getCategory());
        builder.append("<br><br><b>");
        builder.append(tr.getString("biodictionary.HTML.image"));
        builder.append("</b>:<br>");
        builder.append(tr.getString("biodictionary.HTML.imageTip"));
        builder.append("</p></body></html>");
        
        return builder.toString();
    }
    
}
