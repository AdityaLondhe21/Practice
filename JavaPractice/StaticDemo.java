class A
{
	static int x;
	static int y = 20;
	public static void abc()
	{
		System.out.println("From static method : "+y);
	}
	public static void xyz()
	{
		System.out.println("From static method xyz:");
	}
}
public class StaticDemo
{
	static
	{
		System.out.println("1. From static block...");
	}
	public static void main(String args[])
	{
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		a1.x = 10;
		a2.x = 20;
		a3.x = 30;

		a2.x = 50;
		
		System.out.println(a1.x);
		System.out.println(a2.x);
		System.out.println(a3.x);
	static
	{
		System.out.println("2. From static block...");
	}
}