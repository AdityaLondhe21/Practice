class A<T>
{
	public void add(T a,T b)
	{
		System.out.println(a);
	}
}

public class CustomGenerics
{
	public static void main(String args[])
	{
		A<String> a1 = new A<String>();
		a1.add("Good","Morning");
		
		A<Integer> a2 = new A<Integer>();
		a2.add(11,22);

		A<Double> a3 = new A<Double>();
		a3.add(1.1,2.5);

	}
}