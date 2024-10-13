public class Wombat implements Comparable<Wombat> {
    private String name;
    private int severity;
    private double time;
    public Wombat(String name, int severity, double time) throws SeverityOutOfBoundsException{
        if (severity < 1 || severity > 10) {
            throw new SeverityOutOfBoundsException("Severity is not within 1-10");
        }
        this.name = name;
        this.severity = severity;
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public int getSeverity() {
        return severity;
    }
    public double getTime() {
        return time;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSeverity(int severity) {
        this.severity = severity;
    }
    public void setTime(double time) {
        this.time = time;
    }
    public String toString(){
        return this.name + ", "+this.severity+ ", "+ this.time;
    }
    @Override
    public int compareTo(Wombat other) {
        if (this.severity != other.severity) {
            return other.severity - this.severity;
        } else {
            return Double.compare(this.time, other.time);
        }
    }
}
