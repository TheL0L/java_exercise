package Agency;

import java.awt.Image;
import java.util.Vector;
import Transportation.*;

/**
 * Singleton class for managing vehicles in an agency.
 */
public class AgencyManager
{
	/**
	 * Class for holding data entries.
	 */
	private class Entry
	{
		static int unique_id = 0;
		
		public Vehicle vehicle;
		public Image image;
		public int id;
		
		/**
		 * Constructor for Entry class..
		 * 
		 * @param vehicle  vehicle reference.
		 * @param image    image reference.
		 */
		public Entry(Vehicle vehicle, Image image)
		{
			unique_id++;
			
			this.vehicle = vehicle;
			this.image = image;
			this.id = unique_id;
		}
	}
	
	private static AgencyManager instance;
	private Vector<Entry> data;
	
	private EventService service;
	
	private Driver driver_aerial;
	private Driver driver_land;
	private Driver driver_naval;
	
	/**
	 * Constructor for AgencyManager class.
	 */
	private AgencyManager()
	{
		data = new Vector<Entry>();
		service = new EventService();
	}
	
	/**
	 * Method for retrieving singleton AgencyManager instance.
	 * 
	 * @return AgencyManager singleton reference.
	 */
	public static AgencyManager GetInstance()
	{
		if (instance == null)
		{
			instance = new AgencyManager();
		}
		
		return instance;
	}
	
	/**
	 * Method for adding a vehicle to the agency.
	 * 
	 * @param vehicle the vehicle to be added.
	 * @param image   the added vehicle's image data.
	 * 
	 * @return integer value referring to the vehicle's unique id in the agency, it will be used to gain future access to the vehicle.
	 */
	public int AddVehicle(Vehicle vehicle, Image image)
	{
		Entry entry = new Entry(vehicle, image);
		this.data.add(entry);
		return entry.id;
	}
	
	/**
	 * Method for removing a vehicle from the agency.
	 * 
	 * @param id the unique id that was given during entry creation.
	 */
	public void RemoveVehicle(int id)
	{
		Entry entry = findEntry(id);
		if (entry != null)
		{
			this.data.remove(entry);
		}
	}

	/**
	 * Method for retrieving vehicles count in agency.
	 * 
	 * @return integer value representing vehicle count in agency.
	 */
	public int GetVehiclesCount()
	{
		return this.data.size();
	}
	
	/**
	 * Method for retrieving all vehicle ids from within the agency.
	 * 
	 * @return vector containing all vehicle ids.
	 */
	public Vector<Integer> GetVehicleIDs()
	{
		Vector<Integer> ids = new Vector<Integer>();
		for (Entry entry : this.data)
		{
			ids.add(entry.id);
		}
		return ids;
	}
	
	/**
	 * Method for retrieving a vehicle from the agency.
	 * 
	 * @param id the unique id that was given during entry creation.
	 * 
	 * @return requested vehicle's reference.
	 */
	public Vehicle GetVehicle(int id)
	{
		Entry entry = findEntry(id);
		
		if (entry == null)
			return null;
		
		return entry.vehicle;
	}
	
	/**
	 * Method for resetting travel distance of all vehicles in agency.
	 */
	public void ResetAllVehiclesTravelDistance()
	{
		for (Entry entry : this.data)
		{
			entry.vehicle.ResetTravelDistance();
		}
	}
	
	/**
	 * Method for changing flag of a vehicle in the agency.
	 * 
	 * @param id        the unique id that was given during entry creation.
	 * @param flag_name the new flag name.
	 */
	public void ChangeVehicleFlag(int id, String flag_name)
	{
		Entry entry = findEntry(id);
		
		if (entry != null)
		{
			if (entry.vehicle instanceof NavalVehicle)
			{
				((NavalVehicle)entry.vehicle).SetCountry(flag_name);
			}
			else if (entry.vehicle instanceof AmphibiousVehicle)
			{
				((AmphibiousVehicle)entry.vehicle).SetCountry(flag_name);
			}
		}
	}
	
	/**
	 * Method for retrieving vehicle's tooltip text.
	 * 
	 * @param id the unique id that was given during entry creation.
	 * 
	 * @return string containing requested vehicle's tooltip text.
	 */
	public String GetVehicleTooltip(int id)
	{
		Entry entry = findEntry(id);
		
		if (entry == null)
			return null;
		
		return formatHtmlPrompt(entry.vehicle.toString());
	}
	
	/**
	 * Method for retrieving vehicle's description text.
	 * 
	 * @param id the unique id that was given during entry creation.
	 * 
	 * @return string containing requested vehicle's description text.
	 */
	public String GetVehicleDescription(int id)
	{
		Entry entry = findEntry(id);
		
		if (entry == null)
			return null;
		
		return formatPrompt(entry.vehicle.toString());
	}
	
	/**
	 * Method for retrieving vehicle's image data.
	 * 
	 * @param id the unique id that was given during entry creation.
	 * 
	 * @return image containing requested vehicle's image data.
	 */
	public Image GetVehicleImage(int id)
	{
		Entry entry = findEntry(id);
		
		if (entry == null)
			return null;
		
		return entry.image;
	}
	
	/**
	 * Method for searching a specific entry within the agency.
	 * 
	 * @param id the unique id that was given during entry creation.
	 * 
	 * @return the requested entry reference.
	 */
	private Entry findEntry(int id)
	{
		for (Entry entry : this.data)
		{
			if (entry.id == id)
			{
				return entry;
			}
		}
		return null;
	}
	
	/**
	 * Function for formating string into visually appealing description message.
	 * 
	 * @param prompt the string that needs to be formated.
	 * 
	 * @return formated string that can be used as description text.
	 */
 	private static String formatPrompt(String prompt)
	{
		String result;
		result = prompt.substring(prompt.indexOf(':') + 2).replace(", ", "\n * ");
		return result;
	}
 	
 	/**
	 * Function for formating string into visually appealing tooltip message.
	 * 
	 * @param prompt the string that needs to be formated.
	 * 
	 * @return formated string that can be used as tooltip text.
	 */
 	private static String formatHtmlPrompt(String prompt)
	{
		String result;
		result = "<html>" + prompt.replace(", ", "<br/> * ") + "</html>";
		return result;
	}
	
 	public boolean TestDrive(int id, float distance)
 	{
 		Vehicle ref = GetVehicle(id);
 		
 		if (ref instanceof AerialVehicle)
 		{
 			if (driver_aerial == null || driver_aerial.isAlive() == false)
 			{
 				driver_aerial = new Driver(ref, distance);
 				driver_aerial.start();
 				return true;
 			}
 		}
 		
 		else if (ref instanceof LandVehicle)
 		{
 			if (driver_land == null || driver_land.isAlive() == false)
 			{
 				driver_land = new Driver(ref, distance);
 				driver_land.start();
 				return true;
 			}
 		}
 		
 		else if (ref instanceof NavalVehicle)
 		{
 			if (driver_naval == null || driver_naval.isAlive() == false)
 			{
 				driver_naval = new Driver(ref, distance);
 				driver_naval.start();
 				return true;
 			}
 		}
 		
 		else if (ref instanceof AmphibiousVehicle)
 		{
 			// TODO: decide on what to do here...
 		}
 		
 		else if (ref instanceof HybridPlane)
 		{
 			// TODO: decide on what to do here...
 		}
 		
 		return false;
 	}
 	
 	public EventService GetEventService()
 	{
 		return this.service;
 	}
}
