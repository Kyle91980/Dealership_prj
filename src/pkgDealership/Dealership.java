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
import java.time.format.DateTimeFormatter;
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
				
				sales = new ArrayList<Transaction>();
				totalsales = 0;
				totalcomm = 0;
				totalcars = 0;
	}

	/****************************End of Constructor*************************************************/
	
	/******************************Load in Customer *************************************************/
	
	void loadCustomer() {
		client = new Customer(123, "Joe Biden");
	}
	
	/**********************************End load Customer ***********************************************/
	
	/**************************************LOAD SALES PEOPLE METHOD *********************************/
	
	void loadSalesPeople(SalesPerson[] staff, int STAFF_SIZE ) throws FileNotFoundException {
		
		//create a file for the sales people
		FileReader sfile = new FileReader("salespeople.dat");
		Scanner sReader = new Scanner(sfile);
		
		//create the variables for the file
		int i = 0; //index for the array
		int salesid = 0;
		String salesname = "";
		float commrate = 0f;
		
		String eachLine = "";
		StringTokenizer st;
		
		while(sReader.hasNextLine()) {		//Tests for EOF
			
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
	}
		
		
	/**************************************ENF OF LOAD SALES PEOPLE METHOD ***********************************/
	
	//Repeat similar processed for Loading in the Vehicles
	
	/**************************************LOAD VEHICLES METHOD *********************************************/
	void loadVehicles(Vehicle[] fleet, int FLEET_SIZE) throws IOException {
		
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
		
		while(vReader.hasNextLine()) {		//tests for eof
			
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
				year = Integer.parseInt(st.nextToken());
				
				//Add the car to the array
				fleet[i] = new Vehicle(color, model, make, year, price, miles, vin );
				i++;
			} //end of reading line
		}//end of reading the file
		
		vReader.close();
		
		System.out.println("Staff Loaded");
	}
		
	
	/**************************************END OFLOAD VEHICLES METHOD *****************************************/
	
	/**************************************LOGIN METHOD *******************************************************/
	int login(SalesPerson[] staff, int STAFF_SIZE) {
		
		boolean validLogin = false;
		
		int selSalesId = 0, enteredSalesId = 0, attempts = 0;
		
		System.out.println("Welcome to " + dealerShipName);
		
		//validate the login is correct
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
					
				}
			}
			//System.out.println(staff[selSalesId].name);   // -- //USED FOR DEBUG
			if (!validLogin)
				{
					System.out.println("Invalid Login");
					attempts++;
				}
				
			
		} while (attempts < 3 && !validLogin);
		
		
		//sales ID = 001, 002, 003 for each name
		if (!validLogin)
		{
			System.out.println("Number of attempts exceeded, program terminated!");
			System.exit(100);
		} else {
			System.out.println("Loggin in Successful: " + staff[selSalesId].getName());
		}
		
		return selSalesId;
	}
	
	/**************************************DISPLAY VEHICLES METHOD******************************************************/
	void displayVehicles(Vehicle[] fleet, int FLEET_SIZE){
		
		
		System.out.println("We have the following cars: \n");
		
		for(int i = 0; i < FLEET_SIZE; i ++ ) {
			System.out.print( (i + 1) + ". "); //Prints the car value.
			System.out.println( fleet[i].getYear() +" " + fleet[i].getColor() +" " + fleet[i].getMake() +" " 
			+ fleet[i].getModel() +" for $" + fleet[i].getPrice());
		}
	}
	/**************************************END OF DISPLAY VEHICLES METHOD******************************************************/

	/**************************************PROCESS SALE METHOD******************************************************/
	void processSale(Vehicle[] fleet, int FLEET_SIZE, SalesPerson selStaff) {
		
		
		float commEarned = 0f, totalprice = 0f;
		String choice = "";
		int wantCar = 0,  attempts = 0;
		final float SALESTAX = 0.0875f;
		boolean validChoice = false;
		LocalDateTime  currentdt = LocalDateTime.now(); // Create a date time object
		String salesdate = currentdt.toString(); //convert to a string

		do
		{
			System.out.print("Which car would you like to purchase?: ");
			choice = keyboard.next();
			wantCar = Integer.parseInt(choice);
			if (wantCar < 1 || wantCar > FLEET_SIZE)
			{		System.out.println("Invalid Choice!");
					attempts++;
			}
			else 
			{
				validChoice = true;
			}
		} while (attempts < 3 && !validChoice);

			if (!validChoice) 
			{
				System.out.println("Number of attempts exceeded, program terminated!");
				System.exit(100); // 100 = attempts exceeded
			}
			
			//Calculate Price & Commission

			totalprice = (fleet[wantCar-1].getPrice() * SALESTAX) + fleet[wantCar-1].getPrice();
			commEarned = totalprice * selStaff.getCommision();
			System.out.println("Thank you for your purchase " + client.getCustName() +".");
			System.out.printf("The total price with tax is $ %.2f.\n", totalprice);
			System.out.printf(selStaff.getName()+" earned $ %.2f.\n", commEarned);

			//Update total sales
			totalsales += totalprice;
			totalcomm += commEarned;
			totalcars++;
			
			//add to the arraylist
			 sales.add(new Transaction(fleet[wantCar-1].getVinNum(), selStaff.getSalesID(), client.getCustid(),
					 totalprice, salesdate));
	}
	/**************************************Display Sales Method ******************************************************/
	
	void displaySales() {
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter mdy = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String todaysdate = dt.format(mdy);
		
		//Display sales
			System.out.println("\n**********************************************************");
			System.out.println( dealerShipName  + "Sales For " + todaysdate);
			System.out.println("Cars Sold: " + totalcars);
			System.out.printf("Total Sales: $%.2f \n", totalsales);
			System.out.printf("Total Commission Paid:  $%.2f \n", totalcomm);
			System.out.println("*****************************************************\n");
	}
	
	/***********************************End of display Method *******************************************************/
	
	/*****************************************Write Sales Method *****************************************************/
	
	void writeSales() throws IOException {
		
		FileWriter salesWriter = new FileWriter("sales.dat", true); //Opens the file for appending
		
		for (int i = 0; i < totalcars; i ++) {
			salesWriter.write(sales.get(i).getVin() + ". " +
											sales.get(i).getSalesid() + ", " +
											sales.get(i).getCustid() + "," +
											sales.get(i).getTotalprice() + "," +
											sales.get(i).getSalesdate() + "\n");
		}
		salesWriter.close();
			System.out.println("Sales File Written!");
	}
	/**************************************End of Write Sales MEthod **********************************************************/
	
}// END OF DEALERSHIP CLASS

