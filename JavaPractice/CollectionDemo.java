import java.util.*;
public class CollectionDemo
{
	public static void main(String args[])
	{
		Vector v1 = new Vector(2);
		
		v1.add("HELLO");
		v1.add(23342);
		v1.add(new Date());
		v1.add(new Thread());
		v1.add(23.54);
		
		Enumeration e = v1.elements();
		while(e.hasMoreElements())
		{	
		System.out.println(e.nextElement());
		}
		System.out.println("-------------");
		
		//HashSet obj = new HashSet();
		//TreeSet obj = new TreeSet();
		//LinkedHashSet obj = new LinkedHashSet();
		
		//ArrayList obj = new ArrayList();
		//LinkedList obj = new LinkedList();
		
		//PriorityQueue obj = new PriorityQueue();
		ArrayDeque obj = new ArrayDeque();

		obj.add("222");
		obj.add("555");
		obj.add("333");
		obj.add("444");
		obj.add("111");
		obj.add("333");
		
		
	}
}