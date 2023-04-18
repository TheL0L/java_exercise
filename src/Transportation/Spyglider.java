package Transportation;

public class Spyglider extends AerialVehicle implements NotMotorized
{
	private char energyScore;
	private String powerSource;
	
	/**
	 * constructor for Spy glider class.
	 * @param powerSource vehicle's power source.
	 */
	public Spyglider(String powerSource)
	{
		super("privileged",50,1,Type_of_use.military);
		this.energyScore = 'C';
		this.powerSource = powerSource;
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
		
		Spyglider other = (Spyglider)obj;
		
		if(this.powerSource != other.powerSource)
		{
			return false;
		}
		return true;
	}
	
	public String toString()
	{
		return "Spyglider: " + super.toString() + ",Enrgy score : " + this.GetEnergyScore()
			+ " Power source:  " + this.GetPowerSource() + "  type of use: " + this.GetType_of_use();
	}
}
