package store;

import format.Word;

/**
 * User: buren
 * Date: 10/1/13
 * Time: 5:03 PM
 */
public class Triple {
    private Word subject, verb, wObject;

    public Triple(){}



    public Triple(Word subject, Word verb) {
        this.subject = subject;
        this.verb = verb;
    }

    public Triple(Word subject, Word verb, Word wObject) {
        this.subject = subject;
        this.verb = verb;
        this.wObject = wObject;
    }

    public Word getSubject() {
        return subject;
    }

    public Word getVerb() {
        return verb;
    }

    public Word getwObject() {
        return wObject;
    }

    public void setVerb(Word verb) {
        this.verb = verb;
    }

    public void setSubject(Word subject) {
        this.subject = subject;
    }

    public void setwObject(Word wObject) {
        this.wObject = wObject;
    }


    public boolean isTriplet(){
        return subject != null && verb != null && wObject  != null;
    }

}
