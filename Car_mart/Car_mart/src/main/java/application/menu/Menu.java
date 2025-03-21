package application.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import application.exceptions.InvalidChoiceException;

public class Menu {
	public static void mainMenu() {
		System.out.println("java CarMart"+
				"\n-----------------------------"+
				"\n1.Add Car"+
				"\n2.Search Cars"+
				"\n3.Update Status"+
				"\n4.Sold"+
				"\n5.Exit");
	}
	public static void searchMenu() {
		System.out.println("Search Cars By"+
				"\n-----------------------------"+
				"\n1.All Unsold Car"+
				"\n2.Search Cars By Company"+
				"\n3.Search Cars by Type"+
				"\n4.Search Cars by Price Range"+
				"\n5.Exit");
	}
	public static void soldMenu() {
		System.out.println("Sold Menu"+
				"\n-----------------------------"+
				"\n1.Display All Sold Cars"+
				"\n2.Update Car status"+
				"\n3.Exit");
	}
	
	public static int readChoice(int max) {
        int choice = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter Choice: ");
            try {
                String input = reader.readLine();
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > max) {
                    throw new InvalidChoiceException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer only.");
            } catch (InvalidChoiceException e) {
                e.displayMessage(max);
            } catch (IOException e) {
                System.out.println("Error reading input: " + e.getMessage());
            }
        }
    }

}
