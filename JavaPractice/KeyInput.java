import java.io.*;

public class KeyInput
{
	public static void main(String args[])
	{
		try
		{
			BufferReader br =new bufferReader(new InputStreamReader(System.in));
			System.out.println("Please enter your name: ");
			String name = br.readLine();

			System.out.println("Enter age: ");
			int age = Integer.parseInt(br.readLine());

			System.out.println("Name : "+name);
			System.out.println("Age after 10 years : "+ (age+10));

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}