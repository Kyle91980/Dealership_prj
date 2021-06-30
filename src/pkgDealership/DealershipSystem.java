package pkgDealership;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DealershipSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dealership dealer = new Dealership();
		
		final int STAFF_SIZE = 3;
		SalesPerson[] staff = new SalesPerson[STAFF_SIZE];
		Customer client = dealer.client;
		final int FLEET_SIZE = 3;
		Vehicle fleet[] = new Vehicle[FLEET_SIZE];
		
		
		//Working variables
		
		Scanner keyboard = new Scanner(System.in);
		char morecars = 'x';
		int selSalesId = 0;
		
		
		//Load the Dealership data
		try {
			dealer.loadSalesPeople(staff, STAFF_SIZE);
			dealer.loadCustomer();
			dealer.loadVehicles(fleet, FLEET_SIZE);
			//
		}
		catch (FileNotFoundException e){
			System.out.println("File not found, program terminated!");
			System.exit(100);
		}
		catch( IOException e ) {
			System.out.println("Error on input or output, program terminated!");
			System.exit(1000);
			
		}
		catch (Exception e ) {
			System.out.println("File data is in incorrect format, program terminated.");
			System.exit(1000);
		}
		
		//Data loaded successfully
		
		selSalesId = dealer.login(staff, STAFF_SIZE);
		//repeat loop for multiple cars
		
		do {
			dealer.displayVehicles(fleet, FLEET_SIZE);
			dealer.processSale(fleet, FLEET_SIZE, staff[selSalesId]);
			System.out.println("\nWould you like to purchase another car? (Y/N): ");
			morecars = keyboard.next().charAt(0);
		} while (morecars == 'Y');
		
		//Display the total sales
		dealer.displaySales();
		
		//Write the sles file
		try {
			dealer.writeSales();
		}
		catch (IOException e ) {
			System.out.println("Error writing to file, program terminated!");
			System.exit(1000);
		}
		
		System.out.println("Thank you for usiong the " + dealer.dealerShipName + " system!");
		keyboard.close();
		
	}

}
