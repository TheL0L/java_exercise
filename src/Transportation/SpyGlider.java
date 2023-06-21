package Transportation;

public class SpyGlider extends AerialVehicle implements iNonMotorized
{
	private char energy_score;
	private String power_source;
	
	/**
	 * constructor for SpyGlider class.
	 * @param power_source vehicle's power source.
	 */
	public SpyGlider(String power_source)
	{
		super("classified", 50, 1, Usage.military);
		this.energy_score = 'C';
		this.power_source = power_source;
	}
	
	/**
	 * Copy constructor for class SpyGlider
	 * 
	 * @param other  the copied vehicle.
	 */
	public SpyGlider(SpyGlider other)
	{
		super(other);
		this.energy_score = other.energy_score;
		this.power_source = other.power_source;
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
		if(!(obj instanceof SpyGlider))
		{
			return false; 
		}
		
		SpyGlider other = (SpyGlider)obj;
		
		if(this.power_source != other.power_source)
		{
			return false;
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		return "SpyGlider: " + super.toString() + ", Energy score: " + this.GetEnergyScore()
			+ ", Power source: " + this.GetPowerSource();
	}
}
