import java.util.HashSet;
import java.util.Set;
public class Dog {


    private String name = "unknown";
    private String breed = "unknown";
    private int regNum = -1;
    private Set<String> owners = new HashSet<>();
    public static int count = 0;
    public int seqNum = 0;

    public Dog (String name, String breed, int regNum){
        this.name = name;
        this.breed = breed;
        this.regNum = regNum;
        count++;
        seqNum = count;
    }
    public Dog (){
        this.name = name;
        this.breed = breed;
        this.regNum = regNum;
        count++;
        seqNum = count;
    }

    public String toString (){
        return "Dog " + this.name + ", Breed = "+ this.breed+ ", #owners = " + owners.size() + ", Registration #: "+this.regNum
                + ", Sequence #: "+ seqNum;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public int getRegNum() {
        return regNum;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setRegNum(int regNum) {
        this.regNum = regNum;
    }
    public Set<String> getOwners() {
        return owners;
    }
    public void addOwner(String ownerName){
        owners.add(ownerName);
    }
    public static int getCount() {
        return count;
    }
    public static void printTotal(){
        System.out.println("Total number of dog bred= " + count);
    }
    public int getSeqNum() {
        return seqNum;
    }

}
