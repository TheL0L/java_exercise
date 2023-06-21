package Transportation;

public abstract class LandVehicle extends Vehicle
{
	/**
	 * Available road types.
	 */
	public static enum RoadType { Asphalt, Dirt };

	private int wheels_count;
	private RoadType road_type;
	
	/**
	 * Constructor for class LandVehicle
	 * 
	 * @param model_name    vehicle's model name.
	 * @param max_speed     vehicle's top speed.
	 * @param max_seats     vehicle's seat count.
	 * @param wheels_count  vehicle's wheel count.
	 * @param road_type     vehicle's intended road type.
	 */
	public LandVehicle(String model_name, float max_speed, int max_seats, int wheels_count, RoadType road_type)
	{
		super(model_name, max_speed, max_seats);
		this.wheels_count = wheels_count;
		this.road_type = road_type;
	}
	
	/**
	 * Copy constructor for class LandVehicle
	 * 
	 * @param other  the copied vehicle.
	 */
	public LandVehicle(LandVehicle other)
	{
		super(other);
		this.wheels_count = other.wheels_count;
		this.road_type = other.road_type;
	}
	
	/**
	 * Method for retrieving vehicle's wheels count.
	 * @return integer value of the wheels count.
	 */
	public int GetWheelsCount()
	{
		return this.wheels_count;
	}
	
	/**
	 * Method for retrieving vehicle's intended road type.
	 * 
	 * @return string containing the intended road type.
	 */
	public String GetRoadType()
	{
		return this.road_type.name();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false;
		}
		
		if (!(obj instanceof LandVehicle))
		{
			return false;
		}
		
		LandVehicle other = (LandVehicle)obj;
		
		if (this.wheels_count != other.wheels_count)
			return false;
		
		if (this.road_type != other.road_type)
			return false;
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", Wheels count: " + this.GetWheelsCount() + ", Road type: " + this.GetRoadType();
	}
}
