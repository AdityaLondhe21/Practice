import java.io.*;

public class IODemo
{
	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter File name : ");
			String fname = br.readLine();
			
			File f = new File(fname);
			
			if(!f.exists())
			{
				System.out.println("File doesn't exist");
				return;
			}
			BufferedReader fr = new BufferedReader(new FileReader(fname));
			String line = null;
			while((line = fr.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}