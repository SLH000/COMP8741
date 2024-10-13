import java.util.Collection;

public class DogBreeder {
    public static void main(String[] args) {
        /*        System.out.println("Starting dog application");
        Dog myDog = new Dog();
        System.out.println(myDog.toString());
        myDog.setRegNum(3496);
        myDog.setDogBreed("Poodle");
        myDog.setName("Fluffy");
        System.out.println(myDog.toString());
        Dog mydog = new Dog("Fluffy","Poodle",3496);
        System.out.println(mydog.toString());

 */
        System.out.println("Starting dog application");
        Dog myDog1 = new Dog();
        myDog1.setName("Fido");
        myDog1.addOwner("Anne");
        myDog1.addOwner("Bob");

        Dog myDog2 = new Dog("Fluffy", "Poodle", 3496);
        myDog2.addOwner("Martha");

        System.out.println(myDog1);
        System.out.println(myDog2);

        System.out.println(myDog1.getName());
        System.out.println(myDog2.getName());
        Dog.printTotal();


        DogRegister dogRegister = new DogRegister();

        dogRegister.addDog(myDog1);
        dogRegister.addDog(myDog2);

        dogRegister.addDog(new Dog("Buddy", "Labrador", 1234));
        dogRegister.addDog(new Dog("Max", "German Shepherd", 5678));

        System.out.println("Registered Dogs: " + dogRegister);

        Dog dogWithRegNum = dogRegister.getDog(3496);
        if (dogWithRegNum != null) {
            System.out.println("Found dog: " + dogWithRegNum.getName());
        } else {
            System.out.println("Dog not found.");
        }

        Collection<Dog> dogsWithNameFluff = dogRegister.getDogsWhoseNameContains("Fluff");
        System.out.println("Dogs with 'Fluff' in name: " + dogsWithNameFluff);

        Dog deletedDog = dogRegister.deleteDog(5678);
        if (deletedDog != null) {
            System.out.println("Deleted dog: " + deletedDog);
        } else {
            System.out.println("Dog not found for deletion.");
        }

        System.out.println("Updated Register: " + dogRegister);
    }
}
