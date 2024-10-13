import java.util.Stack;
public class BracketChecker {
    private Stack<Character> characterStack = new Stack<>();
    private char[] opening = {'{'};
    private char[] closing = {'}'};
    private int position;

    public BracketChecker(char[] opening, char[] closing) {
        this.characterStack = characterStack;
        this.opening = opening;
        this.closing = closing;
        this.position = position;
    }
    public boolean check(String text) {
        for (int i = 0; i<text.length(); i++){
            char c = text.charAt(i);
            if (c == opening[0]){
                characterStack.push(c);
            }else if (c== closing[0]){
                if (characterStack.isEmpty()){
                    position = i;
                    return false;
                } characterStack.pop();
            }
        }
        return characterStack.isEmpty();
    }

    public int getPosition() {
        return position;
    }
}
