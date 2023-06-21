package Transportation;

public class Bicycle extends LandVehicle implements iNonMotorized
{
	/**
	 * Constructor for class Bicycle
	 * 
	 * @param model_name    vehicle's model name.
	 * @param max_speed     vehicle's top speed.
	 * @param max_seats     vehicle's seat count.
	 * @param road_type     vehicle's intended road type.
	 */
	public Bicycle(String model_name, float max_speed, int max_seats, RoadType road_type)
	{
		super(model_name, max_speed, max_seats, 2, road_type);
	}
	
	/**
	 * Copy constructor for class Bicycle
	 * 
	 * @param other  the copied vehicle.
	 */
	public Bicycle(Bicycle other)
	{
		super(other);
	}

	@Override
	public String GetPowerSource()
	{
		return "Manual";
	}

	@Override
	public char GetEnergyScore()
	{
		return 'A';
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false;
		}
		
		if (!(obj instanceof Bicycle))
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Bicycle: " + super.toString() + ", Energy score: " + this.GetEnergyScore()
			+ ", Power source: " + this.GetPowerSource();
	}
}
