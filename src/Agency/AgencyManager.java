package Agency;

import java.awt.Image;
import java.util.Vector;
import Transportation.*;

/**
 * Singleton class for managing vehicles in an agency.
 */
public class AgencyManager
{
	private static AgencyManager instance;
	private Vector<Vehicle> vehicles;
	private Vector<Image> images;
	
	/**
	 * Constructor for AgencyManager class.
	 */
	private AgencyManager()
	{
		vehicles = new Vector<Vehicle>();
		images = new Vector<Image>();
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
	 * @return integer value referring to the vehicle's index in the agency.
	 */
	public int AddVehicle(Vehicle vehicle, Image image)
	{
		this.vehicles.add(vehicle);
		this.images.add(image);
		return this.vehicles.size() - 1;
	}
	
	/**
	 * Method for retrieving vehicle's index in the agency.
	 * 
	 * @param vehicle the vehicle to be searched.
	 * 
	 * @return integer value referring to the vehicle's index in the agency.
	 */
	private int GetVehicleIndex(Vehicle vehicle)
	{
		return this.vehicles.indexOf(vehicle);
	}
	
	/**
	 * Method for removing a vehicle from the agency.
	 * 
	 * @param vehicle the vehicle to be removed.
	 */
	public void RemoveVehicle(Vehicle vehicle)
	{
		int id = this.GetVehicleIndex(vehicle);
		
		if (id != -1)
		{
			this.vehicles.remove(id);
			this.images.remove(id);
		}
	}
	
	/**
	 * Method for retrieving vehicles count in agency.
	 */
	public int GetVehiclesCount()
	{
		return this.vehicles.size();
	}
	
	/**
	 * Method for retrieving a vehicle from the agency.
	 * 
	 * @param index the vehicle's index in the agency.
	 * 
	 * @return requested vehicle's reference.
	 */
	public Vehicle GetVehicle(int index)
	{
		if (index >= 0 && index < this.vehicles.size())
		{
			return this.vehicles.get(index);
		}
		return null;
	}
	
	/**
	 * Method for resetting travel distance of all vehicles in agency.
	 */
	public void ResetAllVehiclesTravelDistance()
	{
		for (Vehicle vehicle : this.vehicles)
		{
			vehicle.ResetTravelDistance();
		}
	}
	
	/**
	 * Method for changing flag of a vehicle in the agency.
	 * 
	 * @param index     the vehicle's index in the agency.
	 * @param flag_name the new flag name.
	 */
	public void ChangeVehicleFlag(int index, String flag_name)
	{
		Vehicle match = GetVehicle(index);
		
		if (match == null)
			return;
		
		if (match instanceof NavalVehicle)
		{
			((NavalVehicle)match).SetCountry(flag_name);
		}
		else if (match instanceof AmphibiousVehicle)
		{
			((AmphibiousVehicle)match).SetCountry(flag_name);
		}
	}
	
	/**
	 * Method for retrieving vehicle's tooltip text.
	 * 
	 * @param index the vehicle's index in the agency.
	 * 
	 * @return string containing requested vehicle's tooltip text.
	 */
	public String GetVehicleTooltip(int index)
	{
		Vehicle match = GetVehicle(index);
		
		if (match == null)
			return null;
		
		return match.toString();
	}
	
	/**
	 * Method for retrieving vehicle's image data.
	 * 
	 * @param index the vehicle's index in the agency.
	 * 
	 * @return image containing requested vehicle's image data.
	 */
	public Image GetVehicleImage(int index)
	{
		Vehicle match = GetVehicle(index);
		
		if (match == null)
			return null;
		
		return this.images.get(index);
	}
	
}
