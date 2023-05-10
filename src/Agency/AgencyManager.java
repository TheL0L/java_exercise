package Agency;

import java.util.Vector;
import Transportation.*;
import graphics.AmphibiousCreationFrame;

/**
 * Singleton class for managing vehicles in an agency.
 */
public class AgencyManager
{
	private static AgencyManager instance;
	private Vector<Vehicle> vehicles;
	
	/**
	 * Constructor for AgencyManager class.
	 */
	private AgencyManager()
	{
		vehicles = new Vector<Vehicle>();
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
	 * 
	 * @return integer value referring to the vehicle's index in the agency.
	 */
	public int AddVehicle(Vehicle vehicle)
	{
		this.vehicles.add(vehicle);
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
	
}
