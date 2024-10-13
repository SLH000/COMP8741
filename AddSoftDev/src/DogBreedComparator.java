import java.util.Comparator;

public class DogBreedComparator {
    public static Comparator<Dog> dogBreedComparator = new Comparator<Dog>() {
        public int compare(Dog dog1, Dog dog2) {
            String breed1 = dog1.getBreed();
            String breed2 = dog2.getBreed();
            return breed1.compareTo(breed2);
        }
    };
}