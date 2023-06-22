package Transportation;

public interface iVehicle
{
	/**
	 * Method for moving the vehicle a certain distance.
	 * 
	 * @param distance  the distance to travel.
	 */
	public void Move(float distance);
	
	/**
	 * Method for retrieving vehicle's model name.
	 * 
	 * @return string containing the model name.
	 */
	public String GetModelName();
	
	/**
	 * Method for retrieving vehicle's top speed.
	 * 
	 * @return float value of the top speed.
	 */
	public float GetMaxSpeed();
	
	/**
	 * Method for retrieving vehicle's seat count.
	 * 
	 * @return integer value of the seats count.
	 */
	public int GetMaxSeats();
	
	/**
	 * Method for retrieving vehicle's travel distance.
	 * 
	 * @return float value of the total traveled distance.
	 */
	public float GetTotalDistance();
	
	/**
	 * Method for comparing a vehicle against other objects.
	 * 
	 * @param obj  the object to be compared against.
	 * @return boolean value of the comparison.
	 */
	@Override
	public boolean equals(Object obj);
	
	/**
	 * Method for converting a vehicle to a string representation.
	 * 
	 * @return string containing a text representation of the vehicle's details.
	 */
	@Override
	public String toString();
	
	/**
	 * Method for reseting the vehicle's travel distance.
	 */
	public void ResetTravelDistance();
}
