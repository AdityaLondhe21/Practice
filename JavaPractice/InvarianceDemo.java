import java.util.ArrayList;
import java.util.List;

class Animal {
    public String toString() {
        return "Animal";
    }
}

class Dog extends Animal {
    public String toString() {
        return "Dog";
    }
}

public class InvarianceDemo {
     public static void processAnimals(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        
        List<Animal> animals = dogs; // Compilation error
        processAnimals(dogs); // Compilation error
    }
}