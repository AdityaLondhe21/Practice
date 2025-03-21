import java.util.concurrent.*;

class Shared
{
	static int count = 0;
}
class IncThread extends Thread
{
	String name;
	Semaphore sem;
	IncThread(String n,Semaphore s)
	{
		this.name=n;
		this.sem=s;
		new Thread(this).start();
	}
	public void run()
	{
		try
		{
			System.out.println(name+" waiting for permission");
			sem.acquire();   	//
			System.out.println(name+" got the permission");
			for(int i=1;i<=5;i++)
			{
				System.out.println(name+" : "+ ++Shared.count);
				Thread.sleep(800);
			}
			System.out.println(name+" released the permission");
			sem.release();		//
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class DecThread extends Thread
{
	String name;
	Semaphore sem;
	DecThread(String n,Semaphore s)
	{
		this.name=n;
		this.sem=s;
		new Thread(this).start();
	}
	public void run()
	{
		try
		{
			System.out.println(name+" waiting for permission");
			sem.acquire();   	//
			System.out.println(name+" got the permission");
			for(int i=1;i<=5;i++)
			{
				System.out.println(name+" : "+ --Shared.count);
				Thread.sleep(800);
			}
			System.out.println(name+" released the permission");
			sem.release();		//
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

public class ConcurrencyDemo
{
	public static void main(String args[])
	{
		Semaphore sem = new Semaphore(2);  
		//2 threads get the permission to run parallely.

		new IncThread("Rajesh",sem);
		new DecThread("Suresh",sem);
		new IncThread("Mahesh",sem);
		new DecThread("Ramesh",sem);
		new IncThread("Mukesh",sem);
		new DecThread("Mahesh",sem);
		new IncThread("Ganesh",sem);
		new IncThread("Dinesh",sem);
	}
}