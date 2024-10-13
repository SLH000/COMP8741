import java.util.ArrayList;
import java.util.Scanner;
public class Checkpoint2 {
    public static void main(String[] args) {
/*        int count = 1;
        String msg1, msg2, msg3;
        Scanner in = new Scanner(System.in);
        System.out.println(count + ": Enter a line");
        msg1= in.nextLine();
        Line line1 = new Line(count, msg1);
        String result1 = line1.getSeqNum() + ": " + line1.getText();
        count++;
        System.out.println(count + ": Enter another line");
        msg2= in.nextLine();
        Line line2 = new Line(count, msg1);
        String result2 = line2.getSeqNum() + ": "+line2.getText();
        count++;
        System.out.println(count + ": Enter the last line");
        msg3= in.nextLine();
        Line line3 = new Line(count, msg3);
        String result3 = line3.getSeqNum() + ": "+line3.getText();
*/
        Scanner in = new Scanner(System.in);
        ArrayList<String> lineStore = new ArrayList<>();
        int count = 0;
        while (true) {
            count++;
            System.out.println(count + ": Enter a line");
            String scanline = in.nextLine();
            Line line = new Line(scanline, count);
            lineStore.add(line.getSeqNum() + ": " + line.getText());
            if (scanline.equalsIgnoreCase("STOP"))
                break;
        }
        for (int j = count-2; j >=0; j--) {
        System.out.println(lineStore.get(j));
        }
    }
}
