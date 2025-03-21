package application.db_operations;

public interface CarDAO {
	public void addCar();
	public void searchCars();
	public void updateCar();
	public void soldCar();
	public boolean findCar(int carID);
	public void printAllCarsByPriceRange();
	public void printAllCarsByType();
	public void printAllCarsByCompany();
	public void printAllSoldCars();
	public void printAllUnsoldCars();
	public void updateAsSold(); 
}
