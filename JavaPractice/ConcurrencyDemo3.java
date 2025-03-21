import java.util.concurrent.*;

public class ConcurrencyDemo3
{
	public static void main(String args[]) throws Exception
	{
		//Becomes background thread
		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
			for(int i=1;i<=10;i++)
			{
				System.out.println("Using supplyAsync for String :"+i);
				try
				{
					Thread.sleep(1000);	
				}
				catch(Exception e){System.out.println(e);}
			}
			return "Complete the execution......";
		}).orTimeout(5, TimeUnit.SECONDS).exceptionally(s -> "You failed to do the task");
		
		CompletableFuture.runAsync(()->{
			for(int i=1;i<=10;i++)
			{
				System.out.println("Using runAsync :"+i);	
			}

		});
		CompletableFuture<Double> cf2 = CompletableFuture.supplyAsync(()->{
			Double res=0.0;
			for(int i=1;i<=10;i++)
			{
				System.out.println("Using supplyAsync for Double :"+i);	
			}
			for(int j=1;j<=100;j++)
			{
				res+=j;
			}
			return res;
			//Becomes background thread
		});
		
		cf2.thenApplyAsync((x)->{
			System.out.println("Summing till 100 is :"+x);
			return x;
		});       //for Asynchronous
		//cf.thenApply(...); for Synchronous
		
		System.out.println("Result from CF1: "+cf1.get()); 
			//wait for real result (Blocking)
			//By this the main thread will wait for 
			//the background thread to complete their execution
		//System.out.println("Result from CF1: "+cf1.getNow("Just for Demo"));  
			//when we dont want to wait for the actual result
		
		//CompletableFuture<Void> f = CompletableFuture.allOf(cf1,cf2);
		//f.join(); //Waiting for both CF to complete 
		//and then continue main thread
		
		System.out.println("Main Exit");
		Thread.sleep(1000);
		//Sleep because main thread will not wait for 
		//background thread to complete and terminate as main thread is complete.
	
	}
}