sealed class Manager permits SalesManager, MarketingManager
{
	int x=10;
	public void abs()
	{
		System.out.println("HI");
	}
}
final class Peun //entends Manager
{
//Not able to Extend manager
}
non-sealed class SalesManager extends Manager
{
}
sealed class MarketingManager extends Manager permits DistributionManager
{
}
final class DistributionManager extends MarketingManager
{
}
class GlobalManager extends SalesManager
{
}
public class CantInherit
{
	public static void main(String args[])
	{
		GlobalManager gm = new GlobalManager();
		gm.abc();
	}
}