package com.vnaskos.biodictionary.search;

/**
 * Token is the general non indexed item
 * which holds all information for dictionary entries
 * 
 * @author Vasilis Naskos
 */
public class Token {
    
    private String word;
    private String definition;
    private String category;
    private String image;

    public static Token createNew(String word, String definition, String category, String image) {
        Token token = new Token();
        
        token.setWord(word);
        token.setDefinition(definition);
        token.setImage(image);
        token.setCategory(category);
        
        return token;
    }
    
    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefinision() {
        return definition;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return word;
    }
    
}
