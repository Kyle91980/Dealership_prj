package pkgDealership;

/*
 * 			Project: DealerShip
 * 
 * 			@AUTHOR 			Kyle Gerken
 * 			Date Created:		June 8th, 2021 			
 * 			Purpose: 			This program.processes car sales and commission.
 */

import java.util.*;
import java.text.*;
import java.time.*;
import java.io.*;



public class Dealership {
	
	String dealerShipName;
	Scanner keyboard;
	Customer client;
	
	//new variables
	float totalsales;
	float totalcomm;
	int totalcars;
	ArrayList<Transaction> sales;

	public Dealership()  {
		//Dealer ship declarations
		/*
		 * 1. Load Data (Salespeople, Customers, Vehicles)
		 * 2. Login
		 * 3. Display VEhicles
		 * 4. Process Sale (&Commission)
		 * 5. Display Total Sales
		 * 6. Write Transactions to a file
		 */
				
				keyboard = new Scanner(System.in);
				dealerShipName = "Kyle's Cars";
				client = new Customer(001,"Joe Biden");
				sales = new ArrayList<Transaction>();
				totalsales = 0;
				totalcomm = 0;
				totalcars = 0;
			}

	
	
	/**************************************LOAD SALES PEOPLE METHOD *********************************/
	
	void loadSalesPeople(SalesPerson[] staff, int STAFF_SIZE ) throws FileNotFoundException {
		
		//create a file for the sales people
		FileReader sfile = new FileReader("salespeople.dat");
		Scanner sReader = new Scanner(sfile);
		
		//create the variables for the file
		int i = 0;
		int salesid = 0;
		String salesname = "";
		float commrate = 0f;
		
		String eachLine = "";
		StringTokenizer st;
		
		while(sReader.hasNextLine()) {
			eachLine = sReader.nextLine();
			st = new StringTokenizer(eachLine, ",");
			while (st.hasMoreTokens())
			{
				//remember order of the text file
				
				salesid = Integer.parseInt(st.nextToken());
				salesname = st.nextToken();
				commrate = Float.parseFloat(st.nextToken());
				
				staff[i] = new SalesPerson(salesname, salesid, commrate);
				i++;
			} //end of reading line
		}//end of reading the file
		
		sReader.close();
		
		System.out.println("Staff Loaded");
		
		//BUG FIX THE FOR LOOP  OR DELETE IT.
		
		/*for(int i = 0; i < STAFF_SIZE; i++) //Instatiate each salesPerson object
			{
					staff[i] = new SalesPerson();
			}
				
				staff[0] = new SalesPerson("Mahatma Handi", 100, 0.15f);
				staff[1] = new SalesPerson("Mother Theresa" , 200, 0.20f);
				staff[2] = new SalesPerson("Mrs. Biden" , 300, 0.10f);
			}
			*/
	/**************************************ENF OF LOAD SALES PEOPLE METHOD ***********************************/
	/**************************************LOAD CUSTOMERS METHOD ********************************************/
	void loadCustomers() {
		client = new Customer(001,"Joe Biden");
	}
	/**************************************ENF OF LOAD CUSTOMERS METHOD ************************************/
	
	/**************************************LOAD VEHICLES METHOD *********************************************/
	void loadVehicles(Vehicle[] fleet, int FLEET_SIZE) {
		
		FileReader vfile = new FileReader("salespeople.dat");
		Scanner vReader = new Scanner(vfile);
		
		//create the variables for the file
		int i = 0; //index for the array
		int vin = 0;
		String make = "";
		String model = "";
		int year = 0;
		String color = "";
		float price = 0f;
		float miles = 0f;
		
		
		String eachLine = "";
		StringTokenizer st;
		
		while(vReader.hasNextLine()) {
			//tests for eof
			eachLine = vReader.nextLine();
			st = new StringTokenizer(eachLine, ",");
			while (st.hasMoreTokens())
			{
				//remember order of the text file
				
				vin  = Integer.parseInt(st.nextToken());
				make = st.nextToken();
				model = st.nextToken();
				color = st.nextToken();
				price = Float.parseFloat(st.nextToken());
				miles = Float.parseFloat(st.nextToken());
				
				
				fleet[i] = new Vehicle(color, model, make, year, price, miles, vin );
				i++;
			} //end of reading line
		}//end of reading the file
		
		vReader.close();
		
		System.out.println("Staff Loaded");
	}
		/*for(int i = 0; i < FLEET_SIZE; i++) //Instantiate each Vehicle object
		{
			fleet[i] = new Vehicle();
		}
		
		fleet[0] = new Vehicle("Blue", "Cayman", "Porche", 2021, 75000f, 0.0f, false, 11111);
						
		fleet[1] = new Vehicle("White", "F-Pace", "Jaguar", 2021, 49999f, 10.0f, false, 22222);
		
		fleet[2] = new Vehicle("Red", "Mustang", "Ford", 2021, 50000f, 0.0f, false, 33333);
		
		*/
	}
	/**************************************END OFLOAD VEHICLES METHOD *****************************************/
	
	/**************************************LOGIN METHOD *******************************************************/
	int login(String dealerName, SalesPerson[] staff, int STAFF_SIZE) {
		
		boolean validLogin = false;
		Scanner keyboard = new Scanner(System.in);
		int selSalesId = 0, enteredSalesId = 0, attempts = 0;
		boolean  validateChoice = false;
		do { 
			
			System.out.print("Enter Sales ID: "); 
			enteredSalesId = keyboard.nextInt();

			for(int i = 0; i < STAFF_SIZE; i++)
			{
				//System.out.println(staff[i].salesID);     // -- //USED FOR DEBUG
				if (enteredSalesId ==  staff[i].getSalesID()) 
				{
					validLogin = true; 
					selSalesId = i;
					break;
				}
			}
			//System.out.println(staff[selSalesId].name);   // -- //USED FOR DEBUG
			if (validLogin == false)
				{
					System.out.println("Invalid Login");
					attempts++;
				}
				
			
		}while (attempts < 3 && !validLogin);
		
		
		//sales ID = 001, 002, 003 for each name
		if (validateChoice)
		{
			System.out.println("Number of attempts exceeded, program terminated!");
			System.exit(100);
		}
		
		return selSalesId;
	}
	
	/**************************************DISPLAY VEHICLES METHOD******************************************************/
	void displayVehicles(Vehicle[] fleet, int FLEET_SIZE){
		System.out.println("We have the following cars: \n");
		
		for(int i = 0; i < FLEET_SIZE; i ++ ) {
			System.out.print( i + 1 + ". "); //Prints the car value.
			System.out.println( fleet[i].getYear() +" " + fleet[i].getColor() +" " + fleet[i].getMake() +" " 
			+ fleet[i].getModel() +" for $" + fleet[i].getPrice());
		}
	}
	/**************************************END OF DISPLAY VEHICLES METHOD******************************************************/

	/**************************************PROCESS SALE METHOD******************************************************/
	void processSale(Vehicle[] fleet, int FLEET_SIZE, SalesPerson selStaff, Customer selCust) {
		int wantCar = 0;
		Scanner keyboard = new Scanner(System.in);
		float totalprice = 0f, commEarned = 0f;
		int attempts = 0;
		boolean  validateChoice = false;
		final float SALESTAX = 0.0875f;

		do {
			
			System.out.print("\nWhich car would you like to purchase?:    ");
			wantCar = keyboard.nextInt();
			
				if ( wantCar < 1 ||  wantCar > FLEET_SIZE) {
					System.out.print("Invalid choice");
					attempts++;
				}
				else {
					validateChoice = true;
				}
				
		} while ( attempts < 3 && !validateChoice);
		
		if (!validateChoice)
		{
			System.out.println("\nNumber of attempts exceeded, program terminated!");
			System.exit(100);
		}
		System.out.print("----------------------------------------------------\n");
		 {
			totalprice =  ( fleet[wantCar-1].getPrice() * SALESTAX ) + fleet[wantCar -1].getPrice();
			commEarned = totalprice * selStaff.getCommision(); 
			System.out.println("Thank you for your purchase " + selCust.getCustName() + "." );
			System.out.println("The total price is:  $" + totalprice + "." );
			System.out.println(selStaff.getName() + " earned $"+ commEarned + "." );
		}
		 
		 keyboard.close(); //close Scanner class
	}
	
}// END OF DEALERSHIP CLASS

