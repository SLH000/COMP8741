import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

interface DogCondition {
    boolean satisfies(Dog dog);
}
class DogsNamedBarry implements DogCondition {
    @Override
    public boolean satisfies(Dog dog) {
        return dog.getName().equalsIgnoreCase("Barry");
    }
}
public class DogRegister {
    private ArrayList<Dog> dogList = new ArrayList<>();
    public void addDog(Dog dog){
        dogList.add(dog);
    }
    public Dog getDog(int regNum){
        for (Dog dog : dogList){
            if(dog.getRegNum()==regNum){
                return dog;
            }
        }
        return null;
    }
    public String toString() {
        StringBuilder result = new StringBuilder("Dog Register:\n");
        for (Dog dog : dogList) {
            result.append(dog.toString()).append("\n");
        }
        return result.toString();
    }
    public List<Dog> getRegister(){
        return dogList;
    }
    public Dog deleteDog(int regNum) {
        for (int i = 0; i < dogList.size(); i++) {
            if (dogList.get(i).getRegNum() == regNum) {
                return dogList.remove(i);
            }
        }
        return null;
    }
    public Collection<Dog> getDogsWhoseNameContains(String charSequence) {
        List<Dog> matchingDogs = new ArrayList<>();
        for (Dog dog : dogList) {
            if (dog.getName().contains(charSequence)) {
                matchingDogs.add(dog);
            }
        }
        return matchingDogs;
    }
    public void groupByBreed(){
        Collections.sort(dogList, DogBreedComparator.dogBreedComparator);
    }


    public Collection<Dog> getByCondition(DogCondition c) {
        List<Dog> result = new ArrayList<>();
        for (Dog dog : dogList) {
            if (c.satisfies(dog)) {
                result.add(dog);
            }
        }
        return result;
    }
}





