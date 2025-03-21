import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;

public class StreamDemo3
{
	public static void main(String args[])
	{
		List<Emp>list = new ArrayList<Emp>();
		list.add(new Emp("Sanju",35,60000,"Programmer"));	
		list.add(new Emp("Manju",45,120000,"Manager"));	
		list.add(new Emp("Rekha",28,45000,"Tester"));	
		list.add(new Emp("Surekha",32,90000,"Admin"));	
		list.add(new Emp("Raju",25,30000,"Tester"));	
		list.add(new Emp("Dinesh",31,70000,"Programmer"));	
		list.add(new Emp("Mahesh",42,150000,"Manager"));	
		list.add(new Emp("Ganesh",22,25000,"Tester"));	
		list.add(new Emp("Sunil",38,65000,"Admin"));	
		list.add(new Emp("Anil",27,40000,"Tester"));	
		list.add(new Emp("Daniel",54,180000,"Manager"));	
		list.add(new Emp("Amit",29,30000,"Tester"));	
		list.add(new Emp("Hameed",36,75000,"Programmer"));	
			
		Map<Boolean,List<Emp>>m1 = list.stream().collect(Collectors.partitioningBy(e->e.getAge()>30));
		System.out.println("Senior: "+m1.get(true));
		System.out.println("Junior: "+m1.get(false));

		System.out.println("--------------------------------------");
		Map<Boolean,Long>m2 = list.stream().collect(Collectors.partitioningBy(e->e.getAge()>30,Collectors.counting() ));
		System.out.println(m2);
		
		System.out.println("--------------------------------------");
		Map<String,List<Emp>>m3 = list.stream().collect(Collectors.groupingBy(e->e.getDesig()));
		System.out.println(m3);

		System.out.println("--------------------------------------");
		Map<String,Long>m4 = list.stream().collect(Collectors.groupingBy(e->e.getDesig(),Collectors.counting()));
		System.out.println(m4);
		
		System.out.println("--------------------------------------");
		Map<String,List<String>>m5 = list.stream().collect(Collectors.groupingBy(e->e.getDesig(),Collectors.mapping(e->e.getName(),Collectors.toList())));
		System.out.println(m5);
	}	
}

class Emp
{
	private String name;
	private int age;
	private int salary;
	private String desig;
	public Emp(String n,int a,int s,String d)
	{	
		name=n;age=a;salary=s;desig=d;
	}
	public int getAge()
	{
		return age;
	}
	public int getSalary()
	{
		return salary;
	}
	public String getDesig()
	{
		return desig;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return "("+name+" , "+age+", "+salary+", "+desig+")";
	}
}