import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class WordListComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return (int) (s1.length() - s2.length());
    }
}