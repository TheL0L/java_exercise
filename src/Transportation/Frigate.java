package Transportation;

public class Frigate extends NavalVehicle implements Motorized
{
	private float fuel_consumption;
	private float engine_life_expectancy;

	/**
	 * Constructor for class Frigate
	 * 
	 * @param model_name               vehicle's model name.
	 * @param fuel_consumption         vehicle's average fuel consumption.
	 * @param max_speed                vehicle's top speed.
	 * @param engine_life_expectancy   vehicle's engine life expectancy.
	 */
	public Frigate(String model_name, float max_speed, int max_seats, boolean swimming_with_wind)
	{
		super(model_name, max_speed, max_seats, swimming_with_wind, "israel");
		this.fuel_consumption = 500;
		this.engine_life_expectancy = 4;
	}
	
	@Override
	public void SetMotorLife(float value)
	{
		this.engine_life_expectancy = value;
	}

	@Override
	public void SetAvgFuel(float value)
	{
		this.fuel_consumption = value; 
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
	public boolean equals(Object obj)
	{
		if(!super.equals(obj))
		{
			return false;
		}
		if(!(obj instanceof Frigate))
		{
			return false;
		}

		Frigate other = (Frigate)obj;
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
		return "Frigate: " + super.toString() + ", Average fuel consumption: " + this.GetAvgFuel()
			+ " L/km, Engine life expectancy: " + this.GetMotorLife() + "type of country: " + this.GetCountry()
			+ "direction with wind :" +this.GetDirection();
	}
}
