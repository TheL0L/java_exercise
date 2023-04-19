package Transportation;

public class Toyglider extends AerialVehicle implements NotMotorized
{
	private char energyScore;
	private String powerSource;
	
	public Toyglider()
	{
		super("Toy", 10, 0, Type_of_use.civilian);
		this.energyScore = 'A';
		this.powerSource = "manual";
	}
	
	@Override
	public char GetEnergyScore()
	{
		return this.energyScore;
	}
	
	@Override
	public String GetPowerSource()
	{
		return this.powerSource;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!super.equals(obj))
		{
			return false; 
		}
		if(!(obj instanceof Toyglider))
		{
			return false; 
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Toyglider: " + super.toString() + ",Enrgy score : " + this.GetEnergyScore()
			+ " Power source:  " + this.GetPowerSource() + "  type of use: " + this.GetTypeOfUse();
	}
}
