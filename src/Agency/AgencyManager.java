package Agency;

import java.awt.Image;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Transportation.*;
import Transportation.decorators.StatusDecorator;
import Transportation.decorators.StatusDecorator.VehicleStatus;
import graphics.MainFrame;

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
			
			this.vehicle = new Vehicle(vehicle) {};
			this.image = image;
			this.id = unique_id;
		}
		
		/**
		 * Copy constructor for Entry class..
		 * 
		 * @param other  the copied Entry.
		 */
		public Entry(Entry other)
		{
			this.vehicle = new Vehicle(other.vehicle) {};
			this.image = other.image;
			this.id = other.id;
		}
	}
	
	private static AgencyManager instance;
	private Vector<Entry> data;
	
	private EventService service;
	
	private final int drivers_count = 7;
	private int free_drivers;
	private ExecutorService driver_pool;
	
	private float total_distance;
	
	private final int max_backups = 3;
	private SizedStack<AgencyManager> backups;
	
	
	/**
	 * Method for saving a backup of the AgencyManager.
	 * 
	 * @return amount of backups left.
	 */
	public int backup_save()
	{
		backups.push(new AgencyManager(this));
		
		return backups.size();
	}
	
	/**
	 * Method for loading a backup of the AgencyManager.
	 * 
	 * @return amount of backups left.
	 */
	public int backup_load()
	{
		if (backups.size() == 0)
			return -1;
		
		AgencyManager backup = backups.pop();
		reset_status(backup);
		
		data = new Vector<Entry>();
		for (Entry entry : backup.data)
			data.add(new Entry(entry));
		
		service = new EventService(backup.service);
		driver_pool = Executors.newFixedThreadPool(drivers_count);
		free_drivers = drivers_count;
		total_distance = backup.total_distance;
		
		return backups.size();
	}
	
	/**
	 * Method for resetting all vehicles status inside an AgencyManager.
	 * 
	 * @param db the AgencyManager that requires a reset.
	 */
	private void reset_status(AgencyManager db)
	{
		for (Entry entry : db.data)
		{
			entry.vehicle.SetStatus(VehicleStatus.AVAILABLE);
		}
	}
	
	/**
	 * Copy constructor for AgencyManager class.
	 * 
	 * @param other the copied AgencyManager.
	 */
	private AgencyManager(AgencyManager other)
	{
		data = new Vector<Entry>();
		for (Entry entry : other.data)
			data.add(new Entry(entry));
		
		service = new EventService(other.service);
		driver_pool = Executors.newFixedThreadPool(drivers_count);
		free_drivers = drivers_count;
		total_distance = other.total_distance;
	}
	
	/**
	 * Constructor for AgencyManager class.
	 */
	private AgencyManager()
	{
		data = new Vector<Entry>();
		service = new EventService();
		driver_pool = Executors.newFixedThreadPool(drivers_count);
		free_drivers = drivers_count;
		total_distance = 0;
		
		backups = new SizedStack<AgencyManager>(max_backups);
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
 		
 		if (ref == null)
 			return false;
 		
 		if (free_drivers > 0 && ref.GetStatus() == VehicleStatus.AVAILABLE)
 		{
 			ref.SetStatus(VehicleStatus.DRIVING);
 			free_drivers--;
 			driver_pool.execute(new Driver(id, distance));
 			return true;
 		}
 		
 		return false;
 	}
 	
 	public void EndTestDrive(int id, float distance)
 	{
 		Vehicle ref = GetVehicle(id);
 		
 		ref.Move(distance);
 		ref.SetStatus(VehicleStatus.AVAILABLE);
 		free_drivers++;
 		
 		total_distance += distance;
 		service.Update(id, Event.TEST_DRIVE);
 	}
 	
 	public EventService GetEventService()
 	{
 		return this.service;
 	}

 	public float GetTotalDistance()
 	{
 		return total_distance;
 	}
}
