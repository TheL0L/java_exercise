package Transportation;

public class CruiseShip extends NavalVehicle implements iMotorized, iCommercial
{
	private float fuel_consumption;
	private float engine_life_expectancy;
	
	/**
	 * Constructor for class CruiseShip
	 * 
	 * @param model_name               vehicle's model name.
	 * @param max_speed                vehicle's top speed.
	 * @param max_seats				   vehicle's seats count.
	 * @param country                  vehicle's country flag name.
	 * @param fuel_consumption         vehicle's average fuel consumption.
	 * @param engine_life_expectancy   vehicle's engine life expectancy.
	 */
	public CruiseShip(String model_name, float max_speed, int max_seats, String country, float fuel_consumption, float engine_life_expectancy)
	{
		super(model_name, max_speed, max_seats, true, country);
		this.fuel_consumption = fuel_consumption;
		this.engine_life_expectancy = engine_life_expectancy;
	}
	
	/**
	 * Copy constructor for class CruiseShip
	 * 
	 * @param other  the copied vehicle.
	 */
	public CruiseShip(CruiseShip other)
	{
		super(other);
		this.fuel_consumption = other.fuel_consumption;
		this.engine_life_expectancy = other.engine_life_expectancy;
	}

	@Override
	public String GetCommercialUsage()
	{
		return CommercialUse.UNLIMIT.name();
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
	
	@Override
	public boolean equals(Object obj)
	{
		if(!super.equals(obj))
		{
			return false;
		}
		if(!(obj instanceof CruiseShip))
		{
			return false;
		}

		CruiseShip other = (CruiseShip)obj;
		if(this.engine_life_expectancy != other.engine_life_expectancy)
		{
			return false;
			
		}
		if(this.fuel_consumption != other.fuel_consumption)
		{
			return false;
		}
		
		return true;	
	}

	@Override
	public String toString()
	{
		return "Cruise Ship: " + super.toString() + ", Average fuel consumption: " + this.GetAvgFuel()
			+ " L/km, Engine life expectancy: " + this.GetMotorLife() + " years, License type: " + this.GetCommercialUsage();
	}
}
