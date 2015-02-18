package com.vnaskos.biodictionary.search;

/**
 * ResultWord is the indexed dictionary item
 * 
 * @author Vasilis Naskos
 */
public class ResultWord implements Comparable<ResultWord> {
    private final String word;
    private final int docId;
    private final float distance;

    public ResultWord(String word, int docId, float distance) {
        this.word = word;
        this.docId = docId;
        this.distance = distance;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getDocId(){
        return docId;
    }
    
    public float getDistance(){
        return distance;
    }
    
    @Override
    public String toString(){
        return word;
    }

    @Override
    public int compareTo(ResultWord t) {
        if(t.getWord().endsWith(word)){
            return 0;
        }else if(t.getDistance() > this.distance){
            return 1;
        }else{
            return -1;
        }
    }
}
