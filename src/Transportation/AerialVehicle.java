package Transportation;

public abstract class AerialVehicle extends Vehicle
{
	/**
	 * Available types of use
	 */
	public static enum Type_of_use { military, civilian };
	
	private Type_of_use type;
	
	/**
	 * constructor for  class AreialVehicle  
	 * 
	 * @param model_name vehicle's model name.
	 * @param max_speed  vehicle's top speed.
	 * @param max_seats	 vehicle's seat count.		
	 * @param type       vehicle's type of use.  
	 */
	public AerialVehicle(String model_name, float max_speed, int max_seats, Type_of_use type)
	{
		super(model_name, max_speed, max_seats);
		this.type = type;
	}

	/**
	 * method for update the vehicle usage type.
	 * @param type  vehicle's type of use.
	 */
	public void SetTypeOfUse(Type_of_use type)
	{
		this.type = type;
	}

	/**
	 * method retrieving vehicle's intended type of use.
	 * @return string containing the intended type of use.
	 */
	public String GetTypeOfUse()
	{
		return this.type.name();
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
		if (this.type != Other.type)
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "type of use : " + this.GetTypeOfUse();
	}
}
