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
				
				staff[0] = new SalesPerson();
				staff[0].salesID = 100;
				staff[0].name = "Mahatma Ghandi";
				staff[0].commision = 0.15f;
				
				staff[1] = new SalesPerson();
				staff[1].salesID = 200;
				staff[1].name = "Mother Theresa";
				staff[1].commision = 0.20f;
				
				staff[2] = new SalesPerson();
				staff[2].salesID = 300;
				staff[2].name = "Mrs. Biden";
				staff[2].commision = 0.10f;
				
				//Customer Variables
				Customer client = new Customer();
				client.custName = "Joe Biden";
				
				//Vehicle variables
				final int FLEET_SIZE = 3;
				Vehicle fleet[ ] = new Vehicle[FLEET_SIZE];
				
				
				fleet[0] = new Vehicle();
				fleet[0].vinNum = 11111;
				fleet[0].color = "Blue";
				fleet[0].make = "Porche";
				fleet[0].model ="Cayman"; 
				fleet[0].year = 2020;
				fleet[0].price = 75000f;
				
				fleet[1] = new Vehicle();
				fleet[1].vinNum = 22222;
				fleet[1].color = "White";
				fleet[1].make = "Jaguar";
				fleet[1].model ="F-Pace"; 
				fleet[1].year = 2020;
				fleet[1].price = 49995f;
				
				fleet[2] = new Vehicle();
				fleet[2].vinNum = 333333;
				fleet[2].color = "Red";
				fleet[2].make = "Ford";
				fleet[2].model ="Mustang"; 
				fleet[2].year = 2020;
				fleet[2].price = 50000f;
				

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
						if (enteredSalesId ==  staff[i].salesID) 
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
				
				System.out.println("Hello! " + staff[selSalesId].name + " will be your car salesman for today."
												+ "\nPlease take a look at our car inventory below.");
				
				//Spacing for Menu options
				System.out.print("----------------------------------------------------\n");
				
				
				//Display vehicles
				System.out.println("We have the following cars: \n");
				
				for(int i = 0; i < FLEET_SIZE; i ++ ) {
					System.out.print( i + 1 + ". "); //Prints the car value.
					System.out.println( fleet[i].year +" " + fleet[i].color +" " + fleet[i].make +" " + fleet[i].model +" for $" + fleet[i].price);
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
					totalprice =  ( fleet[wantCar-1].price * SALESTAX ) + fleet[wantCar -1].price;
					commEarned = totalprice * staff[0].commision; 
					System.out.println("Thank you for your purchase " + client.custName + "." );
					System.out.println("The total price is:  $" + totalprice + "." );
					System.out.println(staff[selSalesId].name + " earned $"+ commEarned + "." );
				}
				
				
				System.out.println("Thank you for using the " + dealerShipName +  " system");
			}

}