import java.io.*;

public class Desrializing
{
	public static void main(Stirng args[]) throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));
		Person obj = (Person) ois.readObject();
		
		System.out.println(obj.name);
		System.out.println(obj.age);
	}
}