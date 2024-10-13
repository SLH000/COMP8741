
import javax.swing.JOptionPane;

    public class Words {
        public static void main(String[] args) {
            WordList ws = new WordList();
            String in = JOptionPane.showInputDialog("Click cancel to end or enter a word and click OK");
            while (in != null) {
                ws.addWord(in);
                in = JOptionPane.showInputDialog("Click cancel to end or enter a word and click OK");
            }
            JOptionPane.showMessageDialog(null, "Word list = " + ws.sortAlpha());
            JOptionPane.showMessageDialog(null, "First word = " + ws.getFirst());
            JOptionPane.showMessageDialog(null, "Last word = " + ws.getLast());
            JOptionPane.showMessageDialog(null, "The average length = "+ws.getAvgLength());
            JOptionPane.showMessageDialog(null, "Word list = "+ ws.sortByLength());
        }
    }

