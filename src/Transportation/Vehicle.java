package Transportation;

public abstract class Vehicle
{
	private String model_name;
	private float max_speed;
	private int max_seats;
	private float total_distance;
	
	public Vehicle(String model_name, float max_speed, int max_seats)
	{
		this.model_name = model_name;
		this.max_speed = max_speed;
		this.max_seats = max_seats;
		this.total_distance = 0;
	}
	
	public void Move(float distance)
	{
		this.total_distance += distance;
	}
	
	public String GetModelName()
	{
		return this.model_name;
	}
	
	public float GetMaxSpeed()
	{
		return this.max_speed;
	}
	
	public int GetMaxSeats()
	{
		return this.max_seats;
	}
	
	public float GetTotalDistance()
	{
		return this.total_distance;
	}
	
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
	
	public String toString()
	{
		return "Model: " + this.GetModelName() + ", Traveled: " + this.GetTotalDistance()
			+ " km, Max speed: " + this.GetMaxSpeed() + " km/h, Seats: " + this.GetMaxSeats();
	}
	
}
