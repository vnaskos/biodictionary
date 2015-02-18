package com.vnaskos.biodictionary.translator;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Vasilis Naskos
 */
public abstract class Translate implements ChangeListener {

    LanguageManager manager;

    public Translate() {
        manager = new LanguageManager();
    }
    
    public String getString(String key) {
        return manager.getBundle().getString(key);
    }
    
    public void setLanguage(Languages lang) {
        manager.setLanguage(lang);
        this.stateChanged(new ChangeEvent(lang));
    }
    
    public Languages getLanguage() {
        return manager.getLanguage();
    }

    @Override
    public abstract void stateChanged(ChangeEvent e);
    
}
