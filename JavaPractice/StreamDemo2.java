import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;

public class StreamDemo2
{
	public static void main(String args[])
	{
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(11,"Rakesh");			
		map.put(22,"Suresh");
		map.put(33,"Rajesh");
		map.put(44,"Dinesh");
		map.put(55,"Ramesh");
		
		map.entrySet().stream().map(Map.Entry::getKey).forEach(System.out::println);
				map.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
		System.out.println("--------------");
				map.entrySet().stream().filter(me->me.getKey()>30).forEach(System.out::println);
		System.out.println("------------------------------");
		
		List<Integer> l1 = Arrays.asList(1,2,3);
		Set<Integer> l2 = new TreeSet<Integer>();
		l2.add(4);  l2.add(5);  l2.add(6);  l2.add(7);
		List<Integer> l3 = Arrays.asList(8,9,10);
		
		List<Collection<Integer>> list = Arrays.asList(l1,l2,l3);
		System.out.println(list);

		List<Integer> flatList = list.stream().flatMap(cl->cl.stream()).map(x->x+x).collect(Collectors.toList());
		System.out.println(flatList);


	}	
}