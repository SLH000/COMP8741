import java.util.ArrayList;
//import java.util.Collections;
import java.util.*;

public class WordList {
    private final ArrayList<String> theWordList = new ArrayList<>();

    /**
     * Adds a word to this wordlist
     *
     * @param s the word to add
     */
    public void addWord(String s) {
        theWordList.add(s);
    }

    /**
     * Gets the first word of this WordList,
     *
     * @return the first word of the list, or "-" if the list is empty
     */
    public String getFirst() {
        if (theWordList.isEmpty())
            return "-";
        return theWordList.get(0);
    }

    /**
     * Gets the last word of this WordList,
     *
     * @return the last word of the list, or "-" if the list is empty
     */
    public String getLast() {
        if (theWordList.isEmpty())
            return "-";
        return theWordList.get(theWordList.size() - 1);
    }

    /**
     * @return a String representation of this WordList
     */
    public String toString() {
        return theWordList.toString();
    }

    /**
     * @return the number of elements in this WordList
     */
    public int size() {
        return theWordList.size();
    }

    public ArrayList<String> sortAlpha() {
        Collections.sort(theWordList);
        return theWordList;
    }

    public double getAvgLength() {
        double numWord = theWordList.size();
        double numChar = 0;
        double totalChar = 0;
        for (int i =0; i< theWordList.size(); i++) {
            numChar = theWordList.get(i).length();
            totalChar = totalChar + numChar;
        }
        return (totalChar/numWord);
    }
    public ArrayList<String> sortByLength(){
        theWordList.sort(new WordListComparator());
        return theWordList;
    }
}

