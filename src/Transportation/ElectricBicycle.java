package Transportation;

public class ElectricBicycle extends LandVehicle implements iMotorized
{
	private float fuel_consumption;
	private float engine_life_expectancy;
	
	/**
	 * Constructor for class ElectricBicycle
	 * 
	 * @param model_name    vehicle's model name.
	 * @param max_speed     vehicle's top speed.
	 * @param max_seats     vehicle's seat count.
	 * @param road_type     vehicle's intended road type.
	 * @param fuel_consumption       vehicle's average fuel consumption.
	 * @param engine_life_expectancy vehicle's engine life expectancy.
	 */
	public ElectricBicycle(String model_name, float max_speed, int max_seats, RoadType road_type, float fuel_consumption, float engine_life_expectancy)
	{
		super(model_name, max_speed, max_seats, 2, road_type);
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
	
	@Override
	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false;
		}
		
		if (!(obj instanceof ElectricBicycle))
		{
			return false;
		}
		
		ElectricBicycle other = (ElectricBicycle)obj;
		
		if (this.fuel_consumption != other.fuel_consumption)
			return false;
		
		if (this.engine_life_expectancy != other.engine_life_expectancy)
			return false;
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Electric Bicycle: " + super.toString() + ", Average fuel consumption: " + this.GetAvgFuel()
			+ " L/km, Engine life expectancy: " + this.GetMotorLife() + " years";
	}
}
