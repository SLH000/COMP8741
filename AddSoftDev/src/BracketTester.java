import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BracketTester {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting Bracket Checker application");
        char[] opening = {'{'};
        char[] closing = {'}'};
        BracketChecker checker = new BracketChecker(opening, closing);
        Queue<String> buffer = new ArrayDeque<>();
        String filePath = "/Users/Ashley/Desktop/Practical02-AddSoftDev/assets/brackets01.txt";
        Scanner in;
        try {
            in = new Scanner(new FileReader(filePath));
            boolean lastLineEmpty = false;

            while (in.hasNextLine()) {
                String input = in.nextLine();
                buffer.offer(input);
                System.out.println(input);

                if (input.isEmpty()) {
                    lastLineEmpty = true;
                } else {
                    boolean result = checker.check(input);

                    if (result) {
                        System.out.println("Syntax Correct");
                    } else {
                        System.out.println("Syntax Error");
                    }
                }
            }
            in.close();
            if (lastLineEmpty) {
                System.out.println("Exiting Checker");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }


    }
}