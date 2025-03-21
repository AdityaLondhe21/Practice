/*
class var
{
}
*/
class A
{
	//var i=10;
}
public class Variables
{
	public static void main(String args[])
	{
		var a ="hi";
		System.out.println(a);
		//a=20;
		//System.out.println(a);
		//a="Hello";
		//System.out.println(a);
		float var =3.14f;
		System.out.println(var);
		var arr[] = new int[5];


		enum Month
		{
			JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC;
		}
		switch(Month.FEB)
		{
			case JAN,FEB,MAR -> {
				System.out.println("SPRING");
				System.out.println("I love this weather");
			}
			case APR -> System.out.println("SUMMER");
			case MAY -> System.out.println("SUMMER");
			case JUN -> System.out.println("RAINY");
			case JUL -> System.out.println("RAINY");
			case AUG -> System.out.println("RAINY");
			case SEP -> System.out.println("RAINY");
			case OCT -> System.out.println("WINTER");
			case NOV -> System.out.println("WINTER");
			case DEC -> System.out.println("WINTER");
			default -> System.out.println("WINTER");
		}
		String weather = switch(Month.Nov)
		{
			case JAN,FEB,MAR ->"SPRING I LOVE SPRING"
			case APR -> "SUMMER";
			case MAY -> "SUMMER";
			case JUN -> "RAINY";
			case JUL -> "RAINY";
			case AUG -> "RAINY";
			case SEP -> "RAINY";
			case OCT -> "WINTER";
			case NOV -> "WINTER";
			case DEC -> "WINTER";
			default -> "WINTER";
		}
		System.out.println("Weather : "+weather);

	}		
}
