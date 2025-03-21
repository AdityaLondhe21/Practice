abstract A
{
	//abstract int x =10;
	A(){}
	public abstract void abs();
	public void xyz(){ }
}
abstract class B extends A
{
}
class C extends B
{
	public void abs(){
	}
}
public class AbstractDemo
{
	public static void main(String args[])
	{
		B b1 =new B();		
	}
}