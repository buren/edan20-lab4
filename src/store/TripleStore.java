package store;

import format.Word;
import java.util.*;

/**
 * User: buren
 * Date: 10/1/13
 * Time: 5:03 PM
 */
public class TripleStore {
    private List<Triple> pairList;
    private List<Triple> tripletList;

    public TripleStore() {
        this.pairList =    new ArrayList<Triple>();
        this.tripletList = new ArrayList<Triple>();
    }

    public List<Triple> getPairs(List<List<Word>> sentenceList) {
        for (List<Word> sentence : sentenceList){
            for (Word word : sentence) {
                if (word.getDeprel().toLowerCase().equals("ss"))
                    pairList.add(new Triple(word, sentence.get(word.getHead())));
            }
        }
        return pairList;
    }

    public List<Triple> getTriplets(List<List<Word>> sentenceList) {
        for (List<Word> sentence : sentenceList){
            HashMap<Integer, Triple> sentenceTriplets = new HashMap<Integer, Triple>();
            for (Word word : sentence) {
                String deprel = word.getDeprel().toLowerCase();
                Triple currentTriple = null;
                if (sentenceTriplets.containsKey(word.getHead())){
                    currentTriple = sentenceTriplets.get(word.getHead());
                }
                if (deprel.equals("ss")){
                    if (currentTriple == null){
                        currentTriple = new Triple();
                    }
                    currentTriple.setSubject(word);
                    currentTriple.setVerb(sentence.get(word.getHead()));
                    sentenceTriplets.put(word.getHead(), currentTriple);
                } else if (deprel.equals("oo")){
                    if (currentTriple == null) {
                        currentTriple = new Triple();
                    }
                    currentTriple.setwObject(word);
                    currentTriple.setVerb(sentence.get(word.getHead()));
                    sentenceTriplets.put(word.getHead(), currentTriple);
                }
            }
            for (Triple sentenceTriple : sentenceTriplets.values()){
                if (sentenceTriple.isTriplet())
                    tripletList.add(sentenceTriple);
            }
        }
        return tripletList;
    }


}
