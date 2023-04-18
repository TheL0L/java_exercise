package Transportation;

public class Toyglider extends AerialVehicle implements NotMotorized
{
	private char energyScore;
	private String powerSource;
	
	public Toyglider()
	{
		super("Toy",10,0,Type_of_use.civilian);
		this.energyScore = 'A';
		this.powerSource = "manual";
	}
	public char GetEnergyScore()
	{
		return this.energyScore;
	}
	public String GetPowerSource()
	{
		return this.powerSource;
	}
	public boolean equals(Object obj)
	{
		if(!super.equals(obj))
		{
			return false; 
		}
		if(!(obj instanceof Spyglider))
		{
			return false; 
		}
		
		Toyglider other = (Toyglider)obj;
		if(this.energyScore!= other.energyScore)
		{
			return false;
		}
		if(this.powerSource != other.powerSource)
		{
			return false;
		}
		return true;
	}
	
	public String toString()
	{
		return "Toyglider: " + super.toString() + ",Enrgy score : " + this.EnergyScore()
			+ " Power source:  " + this.PowerSource() + "  type of use: " + this.GetType_of_use();
	}
	
}
