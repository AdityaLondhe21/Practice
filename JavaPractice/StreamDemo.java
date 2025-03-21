import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;

public class StreamDemo
{
	public static void main(String args[])
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);		list.add(23);		list.add(34);		list.add(45);
		list.add(56);		list.add(67);		list.add(78);		list.add(89);
		list.add(90);		list.add(13);		list.add(25);
		
		System.out.println(list);
		
		Predicate<Integer> p1 = (x)-> x%2==0;
		
		//Initialization
		Stream<Integer> s = list.stream();
		//Processing
		Stream<Integer> en = s.filter(p1);
		//Termination
		List<Integer> elist = en.collect(Collectors.toList());
	
		List<Integer> olist = list.stream().filter(p1.negate()).collect(Collectors.toList());	
		System.out.println(olist);
		
		List<Integer> dlist = list.stream().map( x -> x+x ).collect(Collectors.toList());	
		System.out.println(dlist);

		List<Integer> slist = list.stream().sorted().limit(5).skip(2).collect(Collectors.toList());	
		System.out.println(slist);
		
		Random random = new Random();
		random.ints().map(x->Math.abs(x)).limit(5).forEach(System.out::println);
		
		IntStream is = IntStream.rangeClosed(1,10);
		is.forEach(System.out::println);

		OptionalInt oi = IntStream.range(1,6).reduce((a,b)->a*b);
		System.out.println(oi.getAsInt());

		int res1= Stream.of(1,2,3).reduce(10,(a,b)->a+b);
		System.out.println(res1);

		int res2= Stream.of(1,2,3).reduce(10,(a,b)->a+b,(a,b)->a+b);   //second is not executed 
						//as it is sequential stream ,treating in sequential manner
		System.out.println(res2);

		int res3= Arrays.asList(1,2,3).parallelStream().reduce(10,(a,b)->a+b,(a,b)->a+b);   
		System.out.println(res3);

		IntSummaryStatistics stats = IntStream.rangeClosed(1,10).summaryStatistics();
		System.out.println(stats);
		System.out.println("Min:"+stats.getMin());
		System.out.println("Max:"+stats.getMax());
		System.out.println("Count:"+stats.getCount());
		System.out.println("Average:"+stats.getAverage());
		System.out.println("Sum:"+stats.getSum());
	}
}