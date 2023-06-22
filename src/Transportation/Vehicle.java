package Transportation;

import java.awt.Color;

import Transportation.decorators.StatusDecorator.VehicleStatus;

public abstract class Vehicle //implements iVehicle
{
	private String model_name;
	private float max_speed;
	private int max_seats;
	private float total_distance;
	
	private Color color;
	private VehicleStatus status;
	
	/**
	 * Constructor for class Vehicle
	 * 
	 * @param model_name  vehicle's model name.
	 * @param max_speed   vehicle's top speed.
	 * @param max_seats   vehicle's seat count.
	 */
	public Vehicle(String model_name, float max_speed, int max_seats)
	{
		this.model_name = model_name;
		this.max_speed = max_speed;
		this.max_seats = max_seats;
		this.total_distance = 0;
		
		this.color = Color.BLACK;
		this.status = VehicleStatus.AVAILABLE;
	}
	
	/**
	 * Copy constructor for class Vehicle
	 * 
	 * @param other  the copied vehicle.
	 */
	public Vehicle(Vehicle other)
	{
		this.model_name = other.model_name;
		this.max_speed = other.max_speed;
		this.max_seats = other.max_seats;
		this.total_distance = other.total_distance;
		
		this.color = other.color;
		this.status = other.status;
	}
	
	/**
	 * Method for moving the vehicle a certain distance.
	 * 
	 * @param distance  the distance to travel.
	 */
	public void Move(float distance)
	{
		this.total_distance += distance;
	}
	
	/**
	 * Method for retrieving vehicle's model name.
	 * 
	 * @return string containing the model name.
	 */
	public String GetModelName()
	{
		return this.model_name;
	}
	
	/**
	 * Method for retrieving vehicle's top speed.
	 * 
	 * @return float value of the top speed.
	 */
	public float GetMaxSpeed()
	{
		return this.max_speed;
	}
	
	/**
	 * Method for retrieving vehicle's seat count.
	 * 
	 * @return integer value of the seats count.
	 */
	public int GetMaxSeats()
	{
		return this.max_seats;
	}
	
	/**
	 * Method for retrieving vehicle's travel distance.
	 * 
	 * @return float value of the total traveled distance.
	 */
	public float GetTotalDistance()
	{
		return this.total_distance;
	}
	
	/**
	 * Method for comparing a vehicle against other objects.
	 * 
	 * @param obj  the object to be compared against.
	 * @return boolean value of the comparison.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Vehicle))
		{
			return false;
		}
		
		Vehicle other = (Vehicle)obj;
		
		if (!this.model_name.equals(other.model_name))
			return false;
		
		if (this.max_speed != other.max_speed)
			return false;
		
		if (this.max_seats != other.max_seats)
			return false;
		
		if (this.total_distance != other.total_distance)
			return false;
		
		return true;
	}
	
	/**
	 * Method for converting a vehicle to a string representation.
	 * 
	 * @return string containing a text representation of the vehicle's details.
	 */
	@Override
	public String toString()
	{
		return "Model: " + this.GetModelName() + ", Traveled: " + this.GetTotalDistance()
			+ " km, Max speed: " + this.GetMaxSpeed() + " km/h, Seats: " + this.GetMaxSeats()
			+ ", Color: " + this.GetColor() + ", Status: " + this.GetStatus().name();
	}
	
	/**
	 * Method for reseting the vehicle's travel distance.
	 */
	public void ResetTravelDistance()
	{
		this.total_distance = 0;
	}
	
	public Color GetColor()
	{
		return this.color;
	}
	
	public VehicleStatus GetStatus()
	{
		return this.status;
	}
	
	public void SetColor(Color color)
	{
		this.color = color;
	}
	
	public void SetStatus(VehicleStatus status)
	{
		this.status = status;
	}
}
