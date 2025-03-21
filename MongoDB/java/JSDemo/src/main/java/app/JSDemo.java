package app;
import java.io.*;
import javax.script.*;
public class JSDemo {

	public static void main(String args[])
	{
		try
		{
			ScriptEngineManager mgr = new ScriptEngineManager();
			
			//ScriptEngine engine = mgr.getEngineByName("JavaScript");
			//engine.eval("print('Hello Everyone')");

//			ScriptEngine engine = mgr.getEngineByName("nashorn");
//			engine.eval(new FileReader("C:\\Users\\Wissen\\MongoDB\\java\\JSDemo\\src\\main\\java\\app\\demo.js"));

//			Invocable inv = (Invocable) engine;
			
//			inv.invokeFunction("abc");
//			inv.invokeFunction("add",40,50);
//			String cname = (String) inv.invokeFunction("greet","Wissen","Technology");
//			System.out.println("Welcome to "+cname);
		
			
			ScriptEngine engine = mgr.getEngineByName("graal.js");
			engine.eval(new FileReader("C:\\Users\\Wissen\\MongoDB\\java\\JSDemo\\src\\main\\java\\app\\demo.js"));
			Invocable inv = (Invocable) engine;
			inv.invokeFunction("abc");
			inv.invokeFunction("add",40,50);
			String cname = (String) inv.invokeFunction("greet","Wissen","Technology");
			System.out.println("Welcome to "+cname);


		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
