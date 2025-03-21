package application;

import application.db_operations.CarDAOImpl;
import application.menu.Menu;

public class CarMartApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarDAOImpl dao = new CarDAOImpl();
		int choice = 0;
        while (choice != 5) {
            Menu.mainMenu();
            choice = Menu.readChoice(6);
            if(choice==1) {
            	dao.addCar();
            }else if(choice==2) {
            	dao.searchCars();
            }else if(choice==3) {
            	dao.updateCar();
            }else if(choice==4) {
            	dao.soldCar();
            }else {
            	System.err.println("---Exited---");
            }
            
        }
	}
}
