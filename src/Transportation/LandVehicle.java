package Transportation;

public abstract class LandVehicle extends Vehicle
{
	public static enum RoadType { Asphalt, Dirt };

	private int wheels_count;
	private RoadType road_type;
	
	public LandVehicle(String model_name, float max_speed, int max_seats, int wheels_count, RoadType road_type)
	{
		super(model_name, max_speed, max_seats);
		this.wheels_count = wheels_count;
		this.road_type = road_type;
	}
	
	public int GetWheelsCount()
	{
		return this.wheels_count;
	}
	
	public String GetRoadType()
	{
		return this.road_type.name();
	}
	
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
	
	public String toString()
	{
		return super.toString() + ", Wheels count: " + this.GetWheelsCount() + ", Road type: " + this.GetRoadType();
	}
}
