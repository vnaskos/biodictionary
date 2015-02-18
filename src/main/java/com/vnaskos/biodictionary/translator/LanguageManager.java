package com.vnaskos.biodictionary.translator;

import java.util.ResourceBundle;
import java.util.prefs.Preferences;

/**
 *
 * @author vasilis
 */
public class LanguageManager {
    
    private final Preferences prefs;
    private ResourceBundle bundle;
    private Languages lang;
    
    public LanguageManager() {
        prefs = Preferences.userNodeForPackage(this.getClass());
        setDefaultLang();
        setBundle();
    }
    
    private void setDefaultLang() {
        if(!prefs.get("lang", "").isEmpty()) {
            String defaultLang = prefs.get("lang", "");
            lang = Languages.valueOf(defaultLang);
        } else {
            lang = Languages.EN;
        }
    }
    
    private void setBundle(){
        bundle = ResourceBundle.getBundle("lang."+lang);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }
    
    public void setLanguage(Languages lang) {
        prefs.put("lang", lang.toString());
        this.lang = lang;
        setBundle();
    }
    
    public Languages getLanguage() {
        return lang;
    }
    
}
