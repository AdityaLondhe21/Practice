
public class EmployeeManagementApp {
	
    public static void main(String[] args) {
    	
    	EmployeeList.loadData();
    	
        int choice=0;
        do {
            Menu.mainMenu();
            choice = Menu.readChoice(6); 
            switch(choice) {
            	case 1-> EmployeeList.addEmployee();
            	case 2-> EmployeeList.displayEmployees();
            	case 3-> EmployeeList.raiseEmployeeSalaries();
            	case 4-> EmployeeList.searchEmployee(); 
            	case 5-> EmployeeList.deleteEmployee();
            	default-> System.out.println("Total Number Of Employees: " + EmployeeList.getEmployeeCount());
            }
        } while (choice != 6);
        
        EmployeeList.saveData();
        
    }
}