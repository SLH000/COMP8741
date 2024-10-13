import java.util.Scanner;

public class Checkpoint1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String msg1, msg2, msg3;
        int i =1;
        System.out.println(i + ": "+"Enter a line");
        i++;
        msg1 = in.nextLine();
        System.out.println(i + ": " + "Enter another line");
        i++;
        msg2 = in.nextLine();
        System.out.println(i + ": " +"Enter the last line");
        i++;
        msg3 = in.nextLine();
        System.out.println(msg3 + ", " + msg2 + ", " + msg1);

    }

}
