class A
{
	public class B
	{
		public class C
		{
			public void demo()
			{
				System.out.println("I am coming from the innermost class method");
			}
		}
	}
	
}
public class InnerClasses
{
	public static void main(String args[])
	{
		A a = new A();
        	A.B b = a.new B();
        	A.B.C c = b.new C();
        	c.demo();
	}
}