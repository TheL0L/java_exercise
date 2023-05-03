package Transportation;

import Transportation.LandVehicle.RoadType;

public class AmphibiousVehicle extends Vehicle implements iMotorized
{
	private final LandVehicle land_vehicle;
	private final NavalVehicle naval_vehicle;
	
	public AmphibiousVehicle(String model_name, float max_speed, int max_seats, int wheels_count, boolean swimming_with_wind, String country)
	{
		super(model_name, max_speed, max_seats);
		
		// TODO: fix this part
		// the issue is, that both classes are abstract...
		// should ask the prof. about the instructions on the previous part, probably got them wrong.
		land_vehicle = new LandVehicle(model_name, max_speed, max_seats, wheels_count, RoadType.Asphalt);
		naval_vehicle = new NavalVehicle(model_name, max_speed, max_seats, swimming_with_wind, country);
	}

	@Override
	public float GetAvgFuel()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float GetMotorLife()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void SetAvgFuel(float value)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SetMotorLife(float value)
	{
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Method for retrieving vehicle's wheels count.
	 * @return integer value of the wheels count.
	 */
	public int GetWheelsCount()
	{
		return this.land_vehicle.GetWheelsCount();
	}
	
	/**
	 * Method for retrieving vehicle's intended road type.
	 * 
	 * @return string containing the intended road type.
	 */
	public String GetRoadType()
	{
		return this.land_vehicle.GetRoadType();
	}
	
	/**
	 * Method that updates if the vehicle's direction is with or against the wind.
	 * @param swimming_with_wind boolean value that indicates if the vehicle is traveling with or against the wind.
	 */
	public void SetDirection(boolean swimming_with_wind)
	{
		this.naval_vehicle.SetDirection(swimming_with_wind);
	}

	/**
	 * Method that updates the country to which the vehicle belongs.
	 * @param country string containing the intended country of vehicle.
	 */
	public void SetCountry(String country)
	{
		this.naval_vehicle.SetCountry(country);
	}

	/**
	 * Method for retrieving if the vehicle moves with the wind's direction.  
	 * @return boolean value that indicates if the vehicle moves with the wind's direction.
	 */
	public boolean GetDirection()
	{
		return this.naval_vehicle.GetDirection();
	}

	/**
	 * Method retrieving to which country the vehicle belongs.
	 * @return string value of the country.
	 */
	public String GetCountry()
	{
		return this.naval_vehicle.GetCountry();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false;
		}
		
		if (!(obj instanceof AmphibiousVehicle))
		{
			return false;
		}
		
		AmphibiousVehicle other = (AmphibiousVehicle)obj;
		
		if (this.GetWheelsCount() != other.GetWheelsCount())
			return false;
		
		if (this.GetRoadType() != other.GetRoadType())
			return false;
		
		// TODO: add more stuff
		
		return true;
	}
	
	@Override
	public String toString()
	{
		// TODO: replace the return value, super refers to Vehicle...
		return super.toString() + ", Wheels count: " + this.GetWheelsCount() + ", Road type: " + this.GetRoadType();
	}
}
