package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmployeeList{
	
	private static HashMap<Integer,Employee> employees = new HashMap<Integer,Employee>();
	private static HashMap<Integer,Employee> newEmployees = new HashMap<Integer,Employee>();

	public static int getEmployeeCount() {
		return employees.size();
	}
	public static boolean checkEmployeeID(int ID) {
		return employees.containsKey(ID);
	}
	public static Employee getEmployeeByID(int ID) {
		if(employees.containsKey(ID)) {
			return (Employee) employees.get(ID);
		}
		return null;
	}
	public static void createCEO() {
		CEO ceo = CEO.getCEO();
		employees.put(ceo.getID(), ceo);
	}
//	//load previous data
	public static void loadData() { 
//		EmployeeData.getData(employees);
//		EmployeeData.deserializeData(employees);
	}
	//save modified data
	public static void saveData() {
//		EmployeeData.putData(employees);
//		EmployeeData.serializeData(employees);
	}
	
	public static void addEmployee() {
		int subChoice=0;
    	do {    
			Menu.createEmployeeMenu(); 
			subChoice = Menu.readChoice(4);  
			
        	if (subChoice == 4) { 
                break;                    
        	}
        	int empID = EmployeeDetails.readCheckID(100);   
        	
            if (subChoice == 1) {
                employees.put(empID, Clerk.getClerk(empID));
                newEmployees.put(empID, Clerk.getClerk(empID));

            } 
            else if (subChoice == 2) {
                employees.put(empID,Programmer.getProgrammer(empID));
                newEmployees.put(empID,Programmer.getProgrammer(empID));

            }
            else {
                employees.put(empID,Manager.getManager(empID));
                newEmployees.put(empID,Manager.getManager(empID));

            }
            System.out.println("----------Employee Created-----------");
            Employee employee =   (Employee) newEmployees.get(empID);
            employee.display();
        } while (subChoice != 4); 
	}
	public static void displayEmployees() {
		int sortChoice=0;
		do {
			List<Employee> employeeList = new ArrayList<>(employees.values());
//			Menu.sortEmployeeMenu();
			sortChoice = Menu.readChoice(6);
			
			if(sortChoice==6) {
				break;
			}
			if (sortChoice == 1) {
			    employeeList.sort(Comparator.comparingInt(Employee::getID));
			} else if (sortChoice == 2) {
			    employeeList.sort(Comparator.comparing(Employee::getName));
			} else if (sortChoice == 3) {
			    employeeList.sort(Comparator.comparingInt(Employee::getAge));
			} else if (sortChoice == 4) {
			    employeeList.sort(Comparator.comparingInt(Employee::getSalary));
			} else if (sortChoice == 5) {
			    employeeList.sort(Comparator.comparing(Employee::getDesignation));
			} else {
			    System.out.println("Invalid choice. Displaying unsorted list.");
			}
	        
	        for (Employee employee : employeeList) {
	            employee.display();
	            System.out.println("-------------------------------------------------------------");
	        }
		}while(sortChoice!=6);
	}
	public static void raiseEmployeeSalaries() {
		System.out.println("------Salary Raised------");
		for (Map.Entry<Integer, Employee> empEntry : employees.entrySet()) {
		    Employee employee = empEntry.getValue();
		    employee.raiseSalary();
		    employee.display();
            System.out.println("-------------------------------------------------------------");
		}
	}
	public static void deleteEmployee() {
		int empID = EmployeeDetails.readID(100);
		if(!checkEmployeeID(empID)) {
			System.out.println("Employee for this ID doesn't exist.");
			return;
		}
		Employee employee = getEmployeeByID(empID);
		employee.display();
        if(employee.getDesignation()=="CEO") {
        	System.out.println("CEO cannot be deleted.");
        	return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to delete this employee? (y/n): ");
        String ch = sc.next();
        if (ch.equals("y")) {
            employees.remove(empID);
            System.out.println("------Employee Deleted------");
        }
        sc.close();
        
	}
	public static void searchEmployee() {
		int searchChoice;
		List<Employee> employeeList = new ArrayList<>(employees.values());

		do {
			List<Employee> matchList = new ArrayList<>();
			Menu.searchEmployeeMenu();
			searchChoice = Menu.readChoice(4);
			if(searchChoice==4) {
				break;
			}else if(searchChoice==1) {
				int empID = EmployeeDetails.readID(100);
				if(checkEmployeeID(empID)) {
					matchList.add( getEmployeeByID(empID) );
				}else {
					System.out.println("Employee for this ID doesn't exist.");
				}
			}
			else if(searchChoice==2) {
				String designation = EmployeeDetails.readDesignation();
				for (Employee employee : employeeList) {
		            if (employee.getDesignation().equalsIgnoreCase(designation)) {
		                matchList.add(employee);
		            }
		        }
			}
			else if(searchChoice==3) {
				String name = EmployeeDetails.readName();
				for (Employee employee : employeeList) {
		            if (employee.getName().equalsIgnoreCase(name)) {
		                matchList.add(employee);
		            }
		        }
			}
			System.out.println("-------------Search Results--------------");
			for (Employee employee : matchList) {
	            employee.display();
	            System.out.println("-------------------------------------------------------------");
	        }
		}while(searchChoice!=4);
	}

}
