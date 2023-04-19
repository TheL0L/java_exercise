package Transportation;

public class SpyGlider extends AerialVehicle implements iNonMotorized
{
	private char energyScore;
	private String powerSource;
	
	/**
	 * constructor for SpyGlider class.
	 * @param powerSource vehicle's power source.
	 */
	public SpyGlider(String powerSource)
	{
		super("privileged", 50, 1, Type_of_use.military);
		this.energyScore = 'C';
		this.powerSource = powerSource;
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
		if(!(obj instanceof SpyGlider))
		{
			return false; 
		}
		
		SpyGlider other = (SpyGlider)obj;
		
		if(this.powerSource != other.powerSource)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Spyglider: " + super.toString() + ",Enrgy score : " + this.GetEnergyScore()
			+ " Power source:  " + this.GetPowerSource() + "  type of use: " + this.GetTypeOfUse();
	}
}
