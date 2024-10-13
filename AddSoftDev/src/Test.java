import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        DogRegister register = new DogRegister();


        System.out.println("Before grouping by breed:");
        System.out.println(register);
        register.groupByBreed();
        System.out.println("After grouping by breed:");
        System.out.println(register);

        DogsNamedBarry dc = new DogsNamedBarry();
        Collection<Dog> dogsNamedBarry = register.getByCondition(dc);
        System.out.println("Dogs named Barry:");
        for (Dog dog : dogsNamedBarry) {
            System.out.println(dog);
        }
    }
}

