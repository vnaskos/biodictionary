package com.vnaskos.biodictionary.translator;

/**
 *
 * @author Vasilis Naskos
 */
public class LanguageItem {

    String name;
    Languages lang;
    
    public LanguageItem(String name, Languages lang) {
        this.name = name;
        this.lang = lang;
    }

    public Languages getLang() {
        return lang;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
