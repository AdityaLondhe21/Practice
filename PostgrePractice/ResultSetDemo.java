import java.sql.*;

public class ResultSetDemo
{
	public static void main(String args[]) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demoDB","postgres","tiger");
		//Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);

		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   //TYPE_SCROLL_INSENSITIVE  - Will not directly update to db

		ResultSet rs = stmt.executeQuery("select * from Employee");
				
		while(rs.next())
		{
			System.out.println("Name "+rs.getString(1));
			System.out.println("Age "+rs.getInt(2));
		}
		System.out.println("-------------------");
		while(rs.previous())
		{
			System.out.println("Name "+rs.getString(1));
			System.out.println("Age "+rs.getInt(2));
		}
		System.out.println("-------------------");
		rs.absolute(7);
		{
			System.out.println("Name "+rs.getString(1));
			System.out.println("Age "+rs.getInt(2));
		}
		System.out.println("-------------------");
		rs.relative(-4);
		{
			System.out.println("Name "+rs.getString(1));
			System.out.println("Age "+rs.getInt(2));
		}
		System.out.println("-------------------");
		rs.last();    //rs.afterLast(),isLast(),isAfterLast()
		{
			System.out.println("Name "+rs.getString(1));
			System.out.println("Age "+rs.getInt(2));
		}
		System.out.println("-------------------");
		rs.first();   //rs.beforeFirst(),isFirst(),isBeforeFirst()
		{
			System.out.println("Name "+rs.getString(1));
			System.out.println("Age "+rs.getInt(2));
		}

		rs.close();
		stmt.close();
		con.close();
	}

}