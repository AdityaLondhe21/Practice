import java.sql.*;
import java.io.*;

public class JdbcDemo
{
	public static void main(String args[])
	{
		try(
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demoDB","postgres","tiger");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("");
			CallableStatement cstmt = con.prepareCall("");
		)
		{	
			//stmt.executeUpdate("insert into Employee values('Raju',33),('Sanju',35),('Kaju',43),('Baju',53),('Taju',25)");
			//stmt.executeUpdate("update Employee set AGE=AGE+1");
			//stmt.executeUpdate("delete from Employee where AGE<60");
			

			//pstmt = con.prepareStatement("insert into Employee values(?,?)");
			//System.out.println("Enter Name :");
			//String name = br.readLine();
			//System.out.println("Enter age :");
			//int age = Integer.parseInt(br.readLine());
			//pstmt.setString(1,name);
			//pstmt.setInt(2,age);
			//pstmt.execute();

			//cstmt.execute();
			
			stmt.addBatch("insert into Employee values('Rohan',23)");
			stmt.addBatch("insert into Employee values('Mohan',43)");
			stmt.addBatch("insert into Employee values('Nolan',53)");
			stmt.addBatch("insert into Employee values('Jimmy',52)");
			stmt.addBatch("insert into Employee values('Noa',64)");
			stmt.executeBatch();
			ResultSet rs = stmt.executeQuery("select * from Employee");
			while(rs.next())
			{
				System.out.println("Name :"+rs.getString(1));
				System.out.println("Age: "+rs.getInt(2)+"\n");
			}
			rs.close();
			//pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}