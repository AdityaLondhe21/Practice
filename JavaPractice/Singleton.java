/*
final class Principal
{
	//Early Instantiation
	static private final Principal p1 = new Principal(); 
	private Principal()
	{
	}
	public static Principal getPrincipal()
	{
		return p1;
	}
}
*/
final class Principal
{
	//Lazy Instantiation
	static private final Principal p1 = null; 
	private Principal()
	{
	}
	public static Principal getPrincipal()
	{
		if(p1==null)
			p1=new Principal();
		return p1;
	}
}
public class Singleton
{
	//Part of early Instantiation
	static
	{
		try
		{
			Class.forName("Principal");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		Principal p1 = Principal.getPrincipal();
		Principal p2 = Principal.getPrincipal();
		Principal p3 = Principal.getPrincipal();

	}
}