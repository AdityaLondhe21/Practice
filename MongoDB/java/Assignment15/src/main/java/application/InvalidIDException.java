package application;

public class InvalidIDException extends Exception {

	InvalidIDException(){
		super();
	}
	InvalidIDException(String msg){
		super(msg);
	}
	public void displayMessage(int maxID) {
		System.out.println("Employee ID should be in between 1 and "+maxID);
	}
}

