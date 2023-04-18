package Transportation;

public abstract class NavalVehicle extends Vehicle
{

	private boolean swimming_with_wind;
	private String Country;
	
	public NavalVehicle(String model_name, float max_speed, int max_seats,boolean swimming_with_wind,String Country)
	{
		super(model_name,max_speed,max_seats);
		this.swimming_with_wind = swimming_with_wind;
		this.Country = Country;
	}
	
	public void SetDirection(boolean swimming_with_wind)
	{
		this.swimming_with_wind = swimming_with_wind;
	
	}
	public void SetCountry(String Country)
	{
		this.Country = Country;
	
	}
	
	public boolean GetDirection()
	{
		return this.swimming_with_wind;
	}
	public String GetCountry()
	{
		return this.Country;
	}
	
	public boolean equals(Object obj)
	{
		if(!super.equals(obj))
		{
			return false;
		}
		if(!(obj instanceof NavalVehicle))
		{
			return false;
		}
		
		NavalVehicle Other = (NavalVehicle)obj;
		if (this.swimming_with_wind != Other.swimming_with_wind)
		{
			return false;
		}
		if (this.Country != Other.Country)
		{
			return false;
		}
		
		return true;
	}
	
	public String toString()
	{
		return super.toString() + "type of country : "+ this.GetCountry()+ "direction with wind: "+this.GetDirection();
	}
	
	
}
