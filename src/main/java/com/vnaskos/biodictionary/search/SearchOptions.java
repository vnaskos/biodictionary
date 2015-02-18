package com.vnaskos.biodictionary.search;

/**
 * SearchOptions provides only one object
 * which holds the advanced options for search
 * 
 * @author Vasilis Naskos
 */
public class SearchOptions {
    
    private static SearchOptions instance;
    private String[] searchFields;
    private boolean fuzzySearch;

    protected SearchOptions(String[] searchFields, boolean fuzzySearch) {
        this.searchFields = searchFields;
        this.fuzzySearch = fuzzySearch;
    }
    
    public static SearchOptions getInstance() {
        if(instance == null) {
            String[] fields = new String[]{"word","definition","category"};
            boolean fuzzy = true;
            instance = new SearchOptions(fields, fuzzy);
        }
        return instance;
    }

    public String[] getSearchFields() {
        return searchFields;
    }

    public void setSearchFields(String[] searchFields) {
        this.searchFields = searchFields;
    }

    public boolean isFuzzySearch() {
        return fuzzySearch;
    }

    public void setFuzzySearch(boolean fuzzySearch) {
        this.fuzzySearch = fuzzySearch;
    }
    
}
