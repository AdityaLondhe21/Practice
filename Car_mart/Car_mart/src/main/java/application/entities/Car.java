package application.entities;

public class Car {
	private int carID;
	private String company;
	private String model;
	private int seater;
	private String fuelType;
	private String type;
	private int price;
	private boolean sold;
	
	private Car() {
		
	}
	
	private Car(int carID, String company, String model, int seater, String fuelType, String type, int price,boolean sold) {
		this.carID = carID;
		this.company = company;
		this.model = model;
		this.seater = seater;
		this.fuelType = fuelType;
		this.type = type;
		this.price = price;
		this.sold=sold;
	}
		
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSeater() {
		return seater;
	}
	public void setSeater(int seater) {
		this.seater = seater;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public static Car loadCar(int carID, String company, String model, int seater, String fuelType, String type,int price,boolean sold) {
		return new Car(carID, company, model, seater, fuelType, type,price,sold);
	}
	public static Car getCar() {
		return new Car();
	}
	
}
