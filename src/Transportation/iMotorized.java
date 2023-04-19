package Transportation;

/**
 * Interface for motorized vehicles.
 */
public interface iMotorized
{
	/**
	 * Method for retrieving the vehicle's average fuel consumption.
	 * 
	 * @return float value of the vehicle's average fuel consumption.
	 */
	public float GetAvgFuel();

	/**
	 * Method for retrieving the vehicle's engine life expectancy.
	 * 
	 * @return float value of the vehicle's engine life expectancy.
	 */
	public float GetMotorLife();

	/**
	 * Method for setting the vehicle's average fuel consumption.
	 * 
	 * @param value float value of the vehicle's average fuel consumption.
	 */
	public void SetAvgFuel(float value);

	/**
	 * Method for setting the vehicle's engine life expectancy.
	 * 
	 * @param value float value of the vehicle's engine life expectancy.
	 */
	public void SetMotorLife(float value);
}
