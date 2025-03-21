import java.util.concurrent.*;

public class ConcurrencyDemo2
{
	public static void main(String args[]) throws Exception
	{
		ExecutorService es =  
		Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
		);
		es.submit(new Greet());
		Future<Integer> f1 = es.submit(new Sum(20));
		Future<Integer> f2 = es.submit(new Sum(5));
		Future<Integer> f3 = es.submit(new Sum(100));

		System.out.println("sum(20) : "+f1.get());
		System.out.println("sum(5) : "+f2.get());
		System.out.println("sum(100) : "+f3.get());
		
		es.shutdown();
	}
}
class Greet implements Runnable
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("From Greet :"+i);
		}
	}	
}
class Sum implements Callable<Integer>
{	
	int val;
	Sum(int val)
	{
		this.val=val;
	}
	public Integer call()
	{
		int res=0;
		for(int i=0;i<=val;i++)
		{
			res=res+i;
		}
		return res;
	}	
}