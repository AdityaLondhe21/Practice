import java.io.*;
/*
final class Student implements Serializable
{
	private final int rollNo;
	private final String name;
	private final int standard;
	public Student(int rn,String n,int s)
	{
		rollNo = rn;
		name=n;
		standard=s;
	}
	public int getRollNo()
	{
		return rollNo;
	}
	public String getName()
	{
		return name;
	}
	public int getStandard()
	{
		return standard;
	}
	public String toString()
	{
		return "Student[Roll No. :"+rollNo+", Name :"+name+", Standard :"+standard+"]";
	}
	public int hashCode()
	{
		return  rollNo;
	}
	public bool equals(Object obj)
	{
		Student s2 =(Student) obj;
		return this.rollNo==s2.getRollNo() && this.name.equals(s2.getName()) && this.standard==s2.getStandard();
	}
}
*/
//All this can be done using single line.
//record Student(int rollNo,String name,int standard) {}

record Student(int rollNo,String name,int standard)
{
	static String schoolName="DSP";
	Student()
	{
		this(22,"Raj",3);
	}
	Student(int rollNo,String name,int standard)
	{
		if(rollNo<=0)
			throw new NullPointerException();
		this.rollNo=rollNo;
		this.name=name;
		this.standard=standard;
	}
	public void display()
	{
		System.out.println("School Name : "+schoolName);
	}
	public boolean equals(Object obj)
	{
		return this.rollNo == ((Student)obj).rollNo;
	}
	public int hashCode()
	{
		return this.rollNo;
	}
	
}

public class ImmutableClass
{
	public static void main(String args[])
	{
		Student s1 = new Student(11,"Rinku",5);
		Student s2 = new Student(11,"Rinku",5);
		Student s3 = new Student();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());

		System.out.println(s1.equals(s2));

		s1.display();
		s2.display();
		s3.display();
	}
}

