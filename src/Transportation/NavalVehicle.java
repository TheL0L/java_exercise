package Transportation;

public abstract class NavalVehicle extends Vehicle
{
	private boolean swimming_with_wind;
	private String Country;
	
	/**
	 * constructor for class NavalVehicle.
	 * 
	 * @param model_name  vehicle's model name.
	 * @param max_speed   vehicle's top speed.
	 * @param max_seats   vehicle's seat count.
	 * @param swimming_with_wind   vehicle's direction.
	 * @param Country     country that the vehicle represents.
	 */
	public NavalVehicle(String model_name, float max_speed, int max_seats,boolean swimming_with_wind,String Country)
	{
		super(model_name,max_speed,max_seats);
		this.swimming_with_wind = swimming_with_wind;
		this.Country = Country;
	}

	/**
	 * method that update if the vehicle's direction with or against the wind.
	 * @param swimming_with_wind boolean value that that contains the answer if the vehicle is with or against the direction of the wind.
	 */
	public void SetDirection(boolean swimming_with_wind)
	{
		this.swimming_with_wind = swimming_with_wind;
	}

	/**
	 * method that update the country that the vehicle represents.
	 * @param Country string containing the intended country of vehicle.
	 */
	public void SetCountry(String Country)
	{
		this.Country = Country;
	}

	/**
	 * Method for retrieving if the vehicle moves with the wind's direction.  
	 * @return boolean value that indicates if the vehicle moves with the wind's direction.
	 */
	public boolean GetDirection()
	{
		return this.swimming_with_wind;
	}

	/**
	 * method retrieving what a country are represents the vehicle.
	 * @return string value of the country.
	 */
	public String GetCountry()
	{
		return this.Country;
	}
	
	@Override
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
	
	@Override
	public String toString()
	{
		return super.toString() + "type of country : " + this.GetCountry() + "direction with wind: " + this.GetDirection();
	}
}
