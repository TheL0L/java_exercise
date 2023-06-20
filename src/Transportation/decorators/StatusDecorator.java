package Transportation.decorators;

import Transportation.Vehicle;

/**
 * Status decorator class for Vehicle types.
 */
public class StatusDecorator extends VehicleDecorator
{
	/**
	 * Types of vehicle statuses available.
	 */
	public static enum VehicleStatus { AVAILABLE, DRIVING, PURCHASING };
	
	private VehicleStatus status;

	/**
	 * Constructor for StatusDecorator class.
	 * 
	 * @param vehicle  the vehicle to be decorated.
	 * @param status   the intended vehicle status.
	 */
    public StatusDecorator(Vehicle vehicle, VehicleStatus status)
    {
        super(vehicle);
        this.status = status;
    }
    
    /**
	 * Method for retrieving vehicle's status.
	 * 
	 * @return enum value of the status.
	 */
    public VehicleStatus GetStatus()
    {
    	return this.status;
    }
    
    /**
	 * Method for changing vehicle's status.
	 * 
	 * @param status enum value of the status.
	 */
    public void SetStatus(VehicleStatus status)
    {
    	this.status = status;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Status: " + status.name();
    }
}