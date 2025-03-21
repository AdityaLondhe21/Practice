package application.db_operations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import application.menu.Menu;

public class CarDAOImpl implements CarDAO {
	
	@Override
	public boolean findCar(int carID) {
	    String sql = "SELECT * FROM Car WHERE CarID = ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setInt(1, carID);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String company = rs.getString("Company");
	            String model = rs.getString("Model");
	            int seater = rs.getInt("Seater");
	            String fuelType = rs.getString("FuelType");
	            String type = rs.getString("Type");
	            double price = rs.getDouble("Price");

	            System.out.println("Car Details:");
	            System.out.println("CarID: " + carID);
	            System.out.println("Company: " + company);
	            System.out.println("Model: " + model);
	            System.out.println("Seater: " + seater);
	            System.out.println("Fuel Type: " + fuelType);
	            System.out.println("Type: " + type);
	            System.out.println("Price: " + price);

	            return true;
	        } else {
	            System.out.println("Car not found!");
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	        return false;
	    }
	}
	@Override
	public void addCar() {
		String sql = "INSERT INTO Car (Company, Model, Seater, FuelType, Type, Price,Sold) VALUES (?, ?, ?, ?, ?, ?,?)";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql);
	    		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
	    {	    	
	    	System.out.println("Enter Car Details:");

            System.out.print("Company: ");
            String company = reader.readLine();

            System.out.print("Model: ");
            String model = reader.readLine();

            System.out.print("Seater: ");
            int seater = Integer.parseInt(reader.readLine());

            System.out.print("Fuel Type: ");
            String fuelType = reader.readLine();

            System.out.print("Type: ");
            String type = reader.readLine();

            System.out.print("Price: ");
            int price = Integer.parseInt(reader.readLine());
            
	        pstmt.setString(1, company);
	        pstmt.setString(2, model);
	        pstmt.setInt(3, seater);
	        pstmt.setString(4, fuelType);
	        pstmt.setString(5,type);
	        pstmt.setDouble(6, price);
	        pstmt.setBoolean(7, false);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

	@Override
	public void searchCars() {
		// TODO Auto-generated method stub
		int choice=0;
		while(choice!=5) {
			Menu.searchMenu();
			choice=Menu.readChoice(5);
			if(choice==1) {
				printAllUnsoldCars();
			}else if(choice==2) {
				printAllCarsByCompany();
			}else if(choice==3) {
				printAllCarsByType();
			}else if(choice==4) {
				printAllCarsByPriceRange();
			}
		}
		
	}

	@Override
	public void updateCar() {
		String sql = "UPDATE Car SET Price = ? WHERE CarID = ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql);
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
	    	System.out.println("Enter CarID");
	    	int carID = Integer.parseInt(reader.readLine());
	    	if(findCar(carID)) {
	    		int newPrice =Integer.parseInt(reader.readLine());
	    		pstmt.setDouble(1, newPrice);
		        pstmt.setInt(2, carID);
		        pstmt.executeUpdate();
		        System.out.println("Car price updated successfully!");
	    	}
	    } catch (Exception e) {
	        System.out.println(e);
	    }		
	}

	@Override
	public void soldCar() {
		// TODO Auto-generated method stub
		int choice=0;
		while(choice!=3) {
			choice=Menu.readChoice(3);
			if(choice==1) {
				printAllSoldCars();
			}else if(choice==2) {
				updateAsSold();
			}
		}		
	}
	@Override
	public void printAllSoldCars() {
	    String sql = "SELECT * FROM Car WHERE Sold = TRUE";
	    try (Connection con = DBConnection.getConnection();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        System.out.println("Sold Cars:");
	        while (rs.next()) {
	            int carID = rs.getInt("CarID");
	            String company = rs.getString("Company");
	            String model = rs.getString("Model");
	            int seater = rs.getInt("Seater");
	            String fuelType = rs.getString("FuelType");
	            String type = rs.getString("Type");
	            double price = rs.getDouble("Price");

	            System.out.println("CarID: " + carID);
	            System.out.println("Company: " + company);
	            System.out.println("Model: " + model);
	            System.out.println("Seater: " + seater);
	            System.out.println("Fuel Type: " + fuelType);
	            System.out.println("Type: " + type);
	            System.out.println("Price: " + price);
	            System.out.println("-------------------------");
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	@Override
	public void printAllUnsoldCars() {
	    String sql = "SELECT * FROM Car WHERE Sold = FALSE";
	    try (Connection con = DBConnection.getConnection();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        System.out.println("Sold Cars:");
	        while (rs.next()) {
	            int carID = rs.getInt("CarID");
	            String company = rs.getString("Company");
	            String model = rs.getString("Model");
	            int seater = rs.getInt("Seater");
	            String fuelType = rs.getString("FuelType");
	            String type = rs.getString("Type");
	            double price = rs.getDouble("Price");

	            System.out.print("CarID: " + carID);
	            System.out.print(", Company: " + company);
	            System.out.print(", Model: " + model);
	            System.out.print(", Seater: " + seater);
	            System.out.print(", Fuel Type: " + fuelType);
	            System.out.print(", Type: " + type);
	            System.out.print(", Price: " + price);
	            System.out.println("\n-------------------------");
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	@Override
	public void updateAsSold() {
		String sql = "UPDATE Car SET Sold = TRUE WHERE CarID = ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql);
 	    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
 	    ){
	    	System.out.println("Enter CarID");
	    	int carID = Integer.parseInt(reader.readLine());
	    	if(findCar(carID)) {
		        pstmt.setInt(1, carID);
		        pstmt.executeUpdate();
		        System.out.println("Car marked as sold successfully!");
	    	}
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	@Override
	public void printAllCarsByCompany() {
	    String sql = "SELECT * FROM Car WHERE Company = ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql);
 	    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
		) {
	    	System.out.println("Enter Name Of Company: ");
	    	String company =reader.readLine();
	        pstmt.setString(1, company);
	        ResultSet rs = pstmt.executeQuery();
	        System.out.println("Cars from " + company + ":");
	        while (rs.next()) {
	            int carID = rs.getInt("CarID");
	            String model = rs.getString("Model");
	            int seater = rs.getInt("Seater");
	            String fuelType = rs.getString("FuelType");
	            String type = rs.getString("Type");
	            double price = rs.getDouble("Price");

	            System.out.println("CarID: " + carID);
	            System.out.println("Model: " + model);
	            System.out.println("Seater: " + seater);
	            System.out.println("Fuel Type: " + fuelType);
	            System.out.println("Type: " + type);
	            System.out.println("Price: " + price);
	            System.out.println("-------------------------");
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	@Override
	public void printAllCarsByType() {
	    String sql = "SELECT * FROM Car WHERE Type = ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql);
 	    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
	     ) {
	    	System.out.println("Enter Type of Car :");
	    	String type = reader.readLine();
	        pstmt.setString(1, type);
	        ResultSet rs = pstmt.executeQuery();

	        System.out.println("Cars of type " + type + ":");
	        while (rs.next()) {
	            int carID = rs.getInt("CarID");
	            String company = rs.getString("Company");
	            String model = rs.getString("Model");
	            int seater = rs.getInt("Seater");
	            String fuelType = rs.getString("FuelType");
	            double price = rs.getDouble("Price");

	            System.out.println("CarID: " + carID);
	            System.out.println("Company: " + company);
	            System.out.println("Model: " + model);
	            System.out.println("Seater: " + seater);
	            System.out.println("Fuel Type: " + fuelType);
	            System.out.println("Price: " + price);
	            System.out.println("-------------------------");
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	@Override
	public void printAllCarsByPriceRange() {
	    String sql = "SELECT * FROM Car WHERE Price BETWEEN ? AND ?";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql);
 	    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
		 ) {
	    	System.out.println("Min price :");
	    	int minPrice = Integer.parseInt(reader.readLine());
	    	System.out.println("Max price :");
	    	int maxPrice = Integer.parseInt(reader.readLine());
	    	
	        pstmt.setInt(1, minPrice);
	        pstmt.setInt(2, maxPrice);
	        ResultSet rs = pstmt.executeQuery();

	        System.out.println("Cars in price range " + minPrice + " to " + maxPrice + ":");
	        while (rs.next()) {
	            int carID = rs.getInt("CarID");
	            String company = rs.getString("Company");
	            String model = rs.getString("Model");
	            int seater = rs.getInt("Seater");
	            String fuelType = rs.getString("FuelType");
	            String type = rs.getString("Type");
	            double price = rs.getDouble("Price");

	            System.out.println("CarID: " + carID);
	            System.out.println("Company: " + company);
	            System.out.println("Model: " + model);
	            System.out.println("Seater: " + seater);
	            System.out.println("Fuel Type: " + fuelType);
	            System.out.println("Type: " + type);
	            System.out.println("Price: " + price);
	            System.out.println("-------------------------");
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
}
