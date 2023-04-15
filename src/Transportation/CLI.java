package Transportation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI
{
	public static void main(String[] args)
	{
		// open a transportation firm
		// add vehicles (type -> details)
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		AddVehicles(vehicles);
		
		
		// start loop
		// options:
		/*
		 	1. buy vehicle
		 	2. test drive
		 	3. reset total distance (for all at once)
		 	4. switch flag for naval types
		 	5. exit
		*/
		boolean stop_flag = false;
		int input;
		Scanner scanner = new Scanner(System.in);
		
		while (!stop_flag)
		{
			PrintOptions();
			input = scanner.nextInt();
			
			switch (input)
			{
			case 1:
				PrintAllVehicles(vehicles);
				input = FindVehicle(vehicles);
				BuyVehicle(vehicles, input);
				break;
			
			case 2:
				PrintAllVehicles(vehicles);
				input = FindVehicle(vehicles);
				TestDriveVehicle(vehicles, input);
				break;
			
			case 3:
				ResetAllVehiclesTravelDistance(vehicles);
				break;
				
			case 4:
				break;
				
			case 5:
				stop_flag = true;
				break;
				
			default:
				System.out.println("Error: Invalid input.");
				break;
			}
		}
		

		System.out.println("Goodbye.");
		scanner.close();
	}
	
	/**
	 * Function for printing the main loop options.
	 */
	private static void PrintOptions()
	{
		System.out.println("1. Buy a vehicle");
		System.out.println("2. Test drive a vehicle");
		System.out.println("3. Reset travel distance for all vehicles");
		System.out.println("4. Switch naval vehicle flag");
		System.out.println("5. Exit");
	}

	/**
	 * Function handles the vehicle list filling loop, managing the inputs.
	 * 
	 * Function handles relevant prints and inputs.
	 * 
	 * @param vehicles  the list to be filled with entries.
	 */
	private static void AddVehicles(List<Vehicle> vehicles)
	{
		boolean stop_flag = false;
		
		while (!stop_flag)
		{
			switch (SelectType())
			{
			case 1:
				CreateJeep();
				break;
			
			case 2:
				CreateFrigate();
				break;
				
			case 3:
				CreateReconGlider();
				break;
				
			case 4:
				CreateToyGlider();
				break;
				
			case 5:
				if (vehicles.size() != 0)
					stop_flag = true;
				else {
					System.out.println("Error: Add at least one vehicle to procced!");
				}
				break;
				
			default:
				System.out.println("Error: Invalid input.");
				break;
			}
		}
		
	}
	
	/**
	 * Function for prompting the user to select a vehicle type from a list.
	 * 
	 * Function handles relevant prints and inputs.
	 * 
	 * @return integer value depicting a valid user input.
	 */
	private static int SelectType()
	{
		System.out.println("Select vehicle type:");
		System.out.println("1. Jeep");
		System.out.println("2. Frigate");
		System.out.println("3. Reconnaissance Glider");
		System.out.println("4. Toy Glider");
		System.out.println();
		System.out.println("5. None (exit creation menu)");
		
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		
		do
		{
			input = scanner.nextInt();
		} while (input > 0 && input < 6);
		
		scanner.close();
		return input;
	}
	
	/**
	 * Function for prompting the user to fill out the necessary details for a jeep creation.
	 * 
	 * Function handles relevant prints and inputs.
	 * 
	 * @return jeep object created from user input.
	 */
	private static Jeep CreateJeep()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the model name: ");
		String model_name = scanner.next();
		
		System.out.print("Enter the average fuel consumption: ");
		float fuel_consumption = scanner.nextFloat();
		
		System.out.print("Enter the top speed: ");
		float max_speed = scanner.nextFloat();
		
		System.out.print("Enter the engine life expectancy: ");
		float engine_life_expectancy = scanner.nextFloat();
		
		scanner.close();
		return new Jeep(model_name, fuel_consumption, max_speed, engine_life_expectancy);
	}

	/*
	 * Function for printing all vehicles from a list.
	 * 
	 * @param vehicles the list of vehicles to be printed out.
	 */
	private static void PrintAllVehicles(List<Vehicle> vehicles)
	{
		System.out.println("Available vehicles: ( " + vehicles.size() + " )");
		for (Vehicle vehicle : vehicles)
		{
			System.out.println(vehicle);
		}
		System.out.println();
	}
	
	/*
	 * Function for resetting travel distance of all vehicles in a list.
	 * 
	 * @param vehicles the list of vehicles to be reset.
	 */
	private static void ResetAllVehiclesTravelDistance(List<Vehicle> vehicles)
	{
		System.out.println("Available vehicles: ( " + vehicles.size() + " )");
		for (Vehicle vehicle : vehicles)
		{
			vehicle.ResetTravelDistance();
		}
		System.out.println("Done.");
		System.out.println();
	}
	
	/*
	 * Function for finding a vehicle in a list.
	 * 
	 * @param vehicles the list of vehicles to be searched in.
	 * 
	 * @return integer value of vehicle's index in the given list, -1 if doesn't exist.
	 */
	private static int FindVehicle(List<Vehicle> vehicles)
	{
		
		return -1;
	}
	
	/*
	 * Function for buying a vehicle.
	 * 
	 * If given index is valid, vehicle will be removed from the list.
	 * 
	 * @param vehicles  the list of vehicles from which a purchase is attempted.
	 * @param index     integer value of the wanted vehicle's index in the list.
	 */
	private static void BuyVehicle(List<Vehicle> vehicles, int index)
	{
		if (index < 0)
		{
			System.out.println("Error: Vehicle was not found.");
		}
		else
		{
			vehicles.remove(index);
			System.out.println("Thank you for your purchase!");
		}
	}
	
	/*
	 * Function for test driving a vehicle.
	 * 
	 * If given index is valid, vehicle will be taken on a test drive.
	 * 
	 * @param vehicles  the list of vehicles from which a test drive is attempted.
	 * @param index     integer value of the wanted vehicle's index in the list.
	 */
	private static void TestDriveVehicle(List<Vehicle> vehicles, int index)
	{
		if (index < 0)
		{
			System.out.println("Error: Vehicle was not found.");
			return;
		}
		
		Scanner scanner = new Scanner(System.in);
		float distance;
		
		System.out.print("Please enter the test drive distance: ");
		distance = scanner.nextFloat();
		scanner.close();
		
		if (distance <= 0)
		{
			System.out.println("Error: Value can not be non positive.");
			return;
		}
		
		vehicles.get(index).Move(distance);
		System.out.println("Test drive completed.");
	}
}
