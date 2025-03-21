import java.io.*;

public class RAFDemo
{
	public static void main(String args[])
	{
		try
		{
			RandomAccessFile raf = new RandomAccessFile("SampleText.txt","rw");

			raf.seek(5);
			System.out.println(raf.readLine());
			System.out.println(raf.readLine());

			raf.seek(raf.length());
			raf.writeBytes("(Text modified/added by random access file)\n");

			//PrintWriter demo
			//PrintWriter pw = new PrintWriter(System.out);
			//PrintWriter pw = new PrintWriter(new File("SampleText.txt"));
			PrintWriter pw = new PrintWriter(new FileOutputStream("SampleText.txt",true)); // for append set true
			pw.println("Text by  PrintWriter");
			pw.flush();
			pw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}