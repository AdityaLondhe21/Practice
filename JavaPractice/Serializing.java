import java.io.*;

public class Serializing
{
	public static void main(String args[]) throws Exception
	{
		Person P1 = new Person();
		p1.name = "Pavitra";
		p1.age = 25;
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
		oos.writeObject(p1);
		
		System.out.println("Serialized succesfully....");
	}
}