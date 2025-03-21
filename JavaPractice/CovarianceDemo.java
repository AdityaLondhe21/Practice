import java.util.ArrayList;
import java.util.List;

class Fruit {
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }
}

public class CovarianceDemo {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());

        // Safe to read as Fruit
        List<? extends Fruit> fruits = apples;     //Covariant collection
        //Fruit fruit = fruits.get(0); 
        //System.out.println(fruit); // Outputs: Apple
	
	//Unsafe to write
	fruits.add(new Apple()); //Compile-time error: cannot add to a covariant collection 
	fruit = fruits.get(1);
	System.out.println(fruit); 	
    }
}