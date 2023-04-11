package Transportation;


public abstract class AerialVehicle extends Vehicle
{
	public static enum Type_of_use { military, civilian };
	
	private Type_of_use type;
	
	public AerialVehicle(String model_name, float max_speed, int max_seats,Type_of_use type )
	{
		super(model_name,max_speed,max_seats);
		this.type = type;
		
	}
	
	public void Set(Type_of_use type)
	{
		this.type = type;
	
	}
	
	public String GetType_of_use()
	{
		return this.type.name();
	}
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
	
	public String toString()
	{
		return super.toString() + "type of use : "+this.GetType_of_use();
	}
}
