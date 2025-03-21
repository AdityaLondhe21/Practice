class A implements Runnable
{
	/*
	synchronized public void run()
	{
		for(int i=1;i<=20;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+i);
			try{
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	*/
	
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+" is waiting");
		
		synchronized(this){
			System.out.println(Thread.currentThread().getName()+" got permission");

			for(int i=1;i<=20;i++)
			{
				System.out.println(Thread.currentThread().getName()+" : "+i);
				try{
					Thread.sleep(500);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
	}
	
}
public class SyncDemo
{
	public static void main(String args[])
	{
		A a1 = new A();
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a1);
		Thread t3 = new Thread(a1);
		
		t1.setName("T1");
		t2.setName("T2");
		t3.setName("T3");
		
		t1.start();
		t2.start();
		t3.start();		
	}
}