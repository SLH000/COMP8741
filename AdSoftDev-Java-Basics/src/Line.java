public class Line {
    private final String text;
    private final int seqNum;

    public Line(String text, int seqNum) {
        this.seqNum = seqNum;
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
    public int getSeqNum() {
        return this.seqNum;
    }

}
