//import java.sql.*;   //not required
import javax.sql.*;
import javax.sql.rowset.*;
public class RowSetDemo
{
	public static void main(String args[])
	{
		try
		{
			//RowSetFactory rsf = RowSetProvider.newFactory();
			//JdbcRowSet rs = rsf.createJdbcRowSet();
			
			JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
			
			rs.setUrl("jdbc:postgresql://localhost:5432/empdb");
			rs.setUsername("postgres");
			rs.setPassword("tiger");
			
			rs.setCommand("select * from Student");
			rs.execute();
			
			rs.addRowSetListener(new MyListener());
			rs.addRowSetListener(new MyListener2());
			
			rs.setCommand("select * from Employee");
			//ROW SET CHANGED

			rs.execute();   //returns boolean
			
			while(rs.next())
			{
				//CURSOR MOVED

				System.out.println("\nEID : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Age : "+rs.getInt(3));
				System.out.println("Salary : "+rs.getInt(5));
				System.out.println("Designation : "+rs.getString(6));
			}
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
}

class MyListener implements RowSetListener
{
	public void cursorMoved(RowSetEvent evt)
	{
		System.out.println("-----CURSOR MOVED-----");
	}
	public void rowChanged(RowSetEvent evt)
	{
		System.out.println("-----ROW CHANGED-----");
	}
	public void rowSetChanged(RowSetEvent evt)
	{
		System.out.println("-----ROWSET CHANGED-----");
	}
}
class MyListener2 implements RowSetListener
{
	public void cursorMoved(RowSetEvent evt)
	{
		System.out.println(".....CURSOR MOVED.....");
	}
	public void rowChanged(RowSetEvent evt)
	{
		System.out.println(".....ROW CHANGED.....");
	}
	public void rowSetChanged(RowSetEvent evt)
	{
		System.out.println(".....ROWSET CHANGED.....");
	}
}





