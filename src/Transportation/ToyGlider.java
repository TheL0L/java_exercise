package Transportation;

public class ToyGlider extends AerialVehicle implements iNonMotorized
{
	private char energy_score;
	private String power_source;
	
	/**
	 * constructor for ToyGlider class.
	 */
	public ToyGlider()
	{
		super("Toy", 10, 0, Usage.civilian);
		this.energy_score = 'A';
		this.power_source = "manual";
	}
	
	@Override
	public char GetEnergyScore()
	{
		return this.energy_score;
	}
	
	@Override
	public String GetPowerSource()
	{
		return this.power_source;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!super.equals(obj))
		{
			return false; 
		}
		if(!(obj instanceof ToyGlider))
		{
			return false; 
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		return "ToyGlider: " + super.toString() + ", Enrgy score: " + this.GetEnergyScore()
			+ ", Power source: " + this.GetPowerSource();
	}
}
