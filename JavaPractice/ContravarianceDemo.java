import java.util.ArrayList;
import java.util.List;

class Food {
    public String toString() {
        return "Food";
    }
}

class Fruit extends Food {
    public String toString() {
        return "Fruit";
    }
}
class Apple extends Fruit {
    public String toString() {
        return "Apple";
    }
}

public class ContravarianceDemo {
    public static void main(String[] args) {
	//Contravariant collection
        List<Food> food = new ArrayList<Food>(); 
	food.add(new Food());
	
	List<? super Food> fruits = food;
	fruits.add(new Apple()); // Safe to add Fruit/Apple (subtype of Fruit)  

	Fruit fruit = fruits.get(0); // Compile-time error: cannot read from a contravariant collection 

	
    }
}