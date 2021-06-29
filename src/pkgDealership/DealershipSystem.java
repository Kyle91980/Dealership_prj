package pkgDealership;

import java.util.Scanner;

public class DealershipSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dealership dealer = new Dealership("Kyle Cars");
		
		
		
		final int STAFF_SIZE = 3;
		SalesPerson[] staff = new SalesPerson[STAFF_SIZE];
		
		//customer variables
		
		
		//vehicle variables
		final int FLEET_SIZE = 3;
		Vehicle fleet[ ] = new Vehicle[FLEET_SIZE];
		
		//Working variables
		int selSalesId = 0;
		Scanner keyboard = new Scanner(System.in);
		char morecars = 'x';
		
		
		//Load the Dealership data
		try {
			dealer.loadSalesPeople(staff, STAFF_SIZE);
			dealer.
		}
		//program running
		dealer.loadSalesPeople(staff, STAFF_SIZE);
		
		dealer.loadCustomers();
		
		dealer.loadVehicles(fleet, FLEET_SIZE);
		
		selSalesId = dealer.login(null, staff, STAFF_SIZE);
		dealer.processSale(fleet, FLEET_SIZE, null);
		
		System.out.println("Hello! " + staff[selSalesId].getName() + " will be your car salesman for today."
				+ "\nPlease take a look at our car inventory below.");
		
		System.out.println("Thank you for using the " + dealer.getDealershipName() +  " system");
		
	}

}
