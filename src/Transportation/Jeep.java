package Transportation;

public class Jeep extends LandVehicle implements Motorized, iCommercial
{
	private float fuel_consumption;
	private float engine_life_expectancy;
	
	public Jeep(String model_name, float fuel_consumption, float max_speed, float engine_life_expectancy)
	{
		super(model_name, max_speed, 5, 4, RoadType.Dirt);
		this.fuel_consumption = fuel_consumption;
		this.engine_life_expectancy = engine_life_expectancy;
	}
	
	@Override
	public String GetCommercialUsage()
	{
		return CommercialUse.MINI.name();
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

	public boolean equals(Object obj)
	{
		if (!super.equals(obj))
		{
			return false;
		}
		
		if (!(obj instanceof Jeep))
		{
			return false;
		}
		
		Jeep other = (Jeep)obj;
		
		if (this.fuel_consumption != other.fuel_consumption)
			return false;
		
		if (this.engine_life_expectancy != other.engine_life_expectancy)
			return false;
		
		return true;
	}
	
	public String toString()
	{
		return super.toString() + ", Average fuel consumption: " + this.GetAvgFuel()
			+ " L/km, Engine life expectancy: " + this.GetMotorLife() + " years, License type: " + this.GetCommercialUsage();
	}
}
