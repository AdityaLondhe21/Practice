class A extends Thread
{
	public void run()
	{
		for(int i=1;i<=20;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
			try
			{
				if(i%2==0)
					Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
class B extends Thread
{
	public void run()
	{
		for(int i=1;i<=20;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
			try
			{
				if(i%2==0)
					Thread.sleep(800);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
class C extends Thread
{
	public void run()
	{
		for(int i=1;i<=20;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
			try
			{
				if(i%2==0)
					Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
public class ThreadsDemo
{
	public static void main(String args[]) throws Exception
	{
		ThreadGroup tg = new ThreadGroup("People"); 

		Thread a1 = new Thread(tg, new A()); 
		Thread b1 = new Thread(tg, new B()); 
		Thread c1 = new Thread(tg, new C()); 
		
		a1.setName("Ram");
		b1.setName("Sita");
		c1.setName("Lakshman");
		
		a1.setPriority(5);
		b1.setPriority(7);
		c1.setPriority(9);

		a1.start();
		b1.start();
		c1.start();
		
		for(int i=1;i<=20;i++)
		{
			System.out.println("*******Main : "+i+"********");
			
			if(i==5)
				tg.suspend();
			if(i==13)
				tg.resume();
			if(i==12)
			{
				System.out.println("a1 is alive :"+ a1.isAlive());
				System.out.println("b1 is alive :"+ b1.isAlive());
				System.out.println("c1 is alive :"+ c1.isAlive());
			}
			Thread.sleep(800);
		}
		a1.join();
		c1.join();
		System.out.println("---- Main End ----");
	}
}
