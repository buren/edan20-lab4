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
                if (word.getDeprel().equals("SS"))
                    pairList.add(new Triple(word, sentence.get(word.getHead())));
            }
        }
        return pairList;
    }

    public List<Triple> buildTriplets(List<List<Word>> sentenceList) {
        for (List<Word> currentSentence : sentenceList){
            HashMap<Integer, Triple> sentenceTriplets = new HashMap<Integer, Triple>();
            for (Word currentWord : currentSentence) {
                if (currentWord.getDeprel().equals("SS") || currentWord.getDeprel().equals("OO")) {
                    sentenceTriplets.put(currentWord.getHead(), this.findOrCreateTriplet(currentWord, sentenceTriplets, currentSentence));
                }
            }
            for (Triple sentenceTriple : sentenceTriplets.values()){
                if (sentenceTriple.isTriplet())
                    tripletList.add(sentenceTriple);
            }
        }
        return tripletList;
    }

    private Triple findOrCreateTriplet(Word currentWord, HashMap<Integer, Triple> sentenceTriplets, List<Word> currentSentence) {
        Triple currentTriple = new Triple();
        if (sentenceTriplets.containsKey(currentWord.getHead()))
            currentTriple = sentenceTriplets.get(currentWord.getHead());

        if (currentWord.getDeprel().equals("SS"))
            currentTriple.setSubject(currentWord);
        else if (currentWord.getDeprel().equals("OO"))
            currentTriple.setwObject(currentWord);

        currentTriple.setVerb(currentSentence.get(currentWord.getHead()));

        return currentTriple;
    }


    public HashMap<Triple, Integer> getTripletsByFrequency(List<Triple> triples) {
        HashMap<Triple, Integer> frequencyTriplets = new HashMap<Triple, Integer>();
        for (Triple triple : triples) {
            if (frequencyTriplets.containsKey(triple)){
                Integer frequency = frequencyTriplets.get(triple) + 1;
                frequencyTriplets.put(triple, frequency);
                triple.addOccurrence();
            } else {
                frequencyTriplets.put(triple, 1);
            }
        }
        return frequencyTriplets;
    }

    public Map<Integer, Triple> invertTripletsByFrequency(HashMap<Triple, Integer> tripletsFrequency){
        return invert(tripletsFrequency);
    }

    // Inverts a HashMap's key -> value
    private static <V, K> Map<V, K> invert(Map<K, V> map) {
        Map<V, K> inv = new HashMap<V, K>();
        for (Map.Entry<K, V> entry : map.entrySet())
            inv.put(entry.getValue(), entry.getKey());
        return inv;
    }

}
