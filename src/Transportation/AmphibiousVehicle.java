package Transportation;

import Transportation.LandVehicle.RoadType;

public class AmphibiousVehicle extends Vehicle implements iMotorized
{
	private final LandVehicle land_vehicle;
	private final NavalVehicle naval_vehicle;
	
	private float fuel_consumption;
	private float engine_life_expectancy;
	
	/**
	 * constructor for  class AmphibiousVehicle  
	 * 
	 * @param model_name          vehicle's model name.
	 * @param max_speed           vehicle's top speed.
	 * @param max_seats	          vehicle's seat count.
	 * @param wheels_count        vehicle's wheel count.
	 * @param swimming_with_wind  vehicle's direction.
	 * @param country             vehicle's country flag name.
	 * @param fuel_consumption    vehicle's average fuel consumption.
	 * @param engine_life_expectancy  vehicle engine's life expectancy.
	 */
	public AmphibiousVehicle(String model_name, float max_speed, int max_seats, int wheels_count,
			boolean swimming_with_wind, String country, float fuel_consumption, float engine_life_expectancy)
	{
		super(model_name, max_speed, max_seats);
		
		this.land_vehicle = new LandVehicle(model_name, max_speed, max_seats, wheels_count, RoadType.Asphalt) {};
		this.naval_vehicle = new NavalVehicle(model_name, max_speed, max_seats, swimming_with_wind, country) {};
		this.fuel_consumption = fuel_consumption;
		this.engine_life_expectancy = engine_life_expectancy;
	}

	@Override
	public float GetAvgFuel()
	{
		return this.fuel_consumption;
	}

	@Override
	public float GetMotorLife()
	{
		return this.engine_life_expectancy;
	}

	@Override
	public void SetAvgFuel(float value)
	{
		this.fuel_consumption = value;
	}

	@Override
	public void SetMotorLife(float value)
	{
		this.engine_life_expectancy = value;
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
		
		if (this.land_vehicle != other.land_vehicle)
			return false;
		
		if (this.naval_vehicle != other.naval_vehicle)
			return false;
		
		if (this.fuel_consumption != other.fuel_consumption)
			return false;
		
		if (this.engine_life_expectancy != other.engine_life_expectancy)
			return false;
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Amphibious: " + super.toString()
			+ ", Wheels count: " + this.GetWheelsCount() + ", Road type: " + this.GetRoadType()
			+ ", Country : " + this.GetCountry() + ", Moves with wind's direction: " + this.GetDirection()
			+ ", Average fuel consumption: " + this.GetAvgFuel() + " L/km, Engine life expectancy: "
			+ this.GetMotorLife() + " years";
	}
}
