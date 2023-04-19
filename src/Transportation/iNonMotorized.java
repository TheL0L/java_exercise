package Transportation;

/**
 * Interface for non-motorized vehicles.
 */
public interface iNonMotorized
{
	/**
	 * Method for retrieving the vehicle's power source.
	 * 
	 * @return string representaion of the vehicle's power source.
	 */
	public String GetPowerSource();
	
	/**
	 * Method for retrieving the vehicle's energy scoring.
	 * 
	 * @return char value of the vehicle's energy score.
	 */
	public char GetEnergyScore();
}

