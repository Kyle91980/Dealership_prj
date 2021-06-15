package pkgDealership;

/*
 * 			Project: DealerShip
 * 
 * 			@AUTHOR 			Kyle Gerken
 * 			Date Created:		June 8th, 2021 			
 * 			Purpose: 			This program.processes car sales and commission.
 */

import java.util.*;

public class Dealership {

	public static void main(String[] args) {
		//Dealer ship declarations
				String dealerShipName;
				final float SALESTAX = 0.0875f;
				dealerShipName = "Kyle's Cars";
				
				//SalesPerson variables
				final int STAFF_SIZE = 3;
				SalesPerson staff[] = new SalesPerson[STAFF_SIZE];
				//instatiate array;
				
				
				for(int i = 0; i < STAFF_SIZE; i++) //Instatiate each salesPerson object
				{
					staff[i] = new SalesPerson();
				}
				
				staff[0] = new SalesPerson("Mahatma Handi", 100, 0.15f);
				staff[1] = new SalesPerson("Mother Theresa" , 200, 0.20f);
				staff[2] = new SalesPerson("Mrs. Biden" , 300, 0.10f);
				
				
				//getter for Staff
				int tempsid = staff[0].getSalesID();
				
				//Customer Variables
				Customer client = new Customer("Joe Biden");
				
				
				//Vehicle variables
				final int FLEET_SIZE = 3;
				Vehicle fleet[ ] = new Vehicle[FLEET_SIZE];
				
				for(int i = 0; i < FLEET_SIZE; i++) //Instantiate each Vehicle object
				{
					fleet[i] = new Vehicle();
				}
				
				fleet[0] = new Vehicle("Blue", "Cayman", "Porche", 2021, 75000f, 0.0f, false, 11111);
								
				fleet[1] = new Vehicle("White", "F-Pace", "Jaguar", 2021, 49999f, 10.0f, false, 22222);
				
				fleet[2] = new Vehicle("Red", "Mustang", "Ford", 2021, 50000f, 0.0f, false, 33333);
				

				// Working Variables
				Scanner keyboard = new Scanner(System.in);
				int wantCar = 0;
				float totalprice = 0f, commEarned = 0f;
				int attempts = 0;
				boolean  validateChoice = false;
				int selSalesId = 0, enteredSalesId = 0;
				boolean validLogin = false;
				
				//Validate Login
				
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
				
				System.out.println("Hello! " + staff[selSalesId].getName() + " will be your car salesman for today."
												+ "\nPlease take a look at our car inventory below.");
				
				//Spacing for Menu options
				System.out.print("----------------------------------------------------\n");
				
				
				//Display vehicles
				System.out.println("We have the following cars: \n");
				
				for(int i = 0; i < FLEET_SIZE; i ++ ) {
					System.out.print( i + 1 + ". "); //Prints the car value.
					System.out.println( fleet[i].getYear() +" " + fleet[i].getColor() +" " + fleet[i].getMake() +" " + fleet[i].getModel() +" for $" + fleet[i].getPrice());
				}
				
				//Validate Choice
				
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
				
				
				//Purchase section
				System.out.print("----------------------------------------------------\n");
				 {
					totalprice =  ( fleet[wantCar-1].getPrice() * SALESTAX ) + fleet[wantCar -1].getPrice();
					commEarned = totalprice * staff[0].getCommision(); 
					System.out.println("Thank you for your purchase " + client.getCustName() + "." );
					System.out.println("The total price is:  $" + totalprice + "." );
					System.out.println(staff[selSalesId].getName() + " earned $"+ commEarned + "." );
				}
				
				
				System.out.println("Thank you for using the " + dealerShipName +  " system");
			}

}