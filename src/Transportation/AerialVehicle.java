package Transportation;

public abstract class AerialVehicle extends Vehicle
{
	/**
	 * Available usages
	 */
	public static enum Usage { military, civilian };
	
	private Usage usage;
	
	/**
	 * constructor for  class AreialVehicle  
	 * 
	 * @param model_name vehicle's model name.
	 * @param max_speed  vehicle's top speed.
	 * @param max_seats	 vehicle's seat count.
	 * @param usage      vehicle's usage.
	 */
	public AerialVehicle(String model_name, float max_speed, int max_seats, Usage usage)
	{
		super(model_name, max_speed, max_seats);
		this.usage = usage;
	}

	/**
	 * method for update the vehicle usage type.
	 * @param usage  vehicle's usage.
	 */
	public void SetUsage(Usage usage)
	{
		this.usage = usage;
	}

	/**
	 * method retrieving vehicle's intended usage.
	 * @return string containing the intended usage.
	 */
	public String GetUsage()
	{
		return this.usage.name();
	}

	@Override
	public boolean equals(Object obj)
	{
		if(!super.equals(obj))
		{
			return false;
		}
		if(!(obj instanceof AerialVehicle))
		{
			return false;
		}
		
		AerialVehicle Other = (AerialVehicle)obj;
		if (this.usage != Other.usage)
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", Usage: " + this.GetUsage();
	}
}
