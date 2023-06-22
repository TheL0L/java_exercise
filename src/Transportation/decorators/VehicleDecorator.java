package Transportation.decorators;

import Transportation.iVehicle;

/**
 * Base decorator class for Vehicle types.
 */
public abstract class VehicleDecorator implements iVehicle
{
	protected iVehicle vehicle;
	
	/**
	 * Constructor for VehicleDecorator class.
	 * 
	 * @param vehicle  the vehicle to be decorated.
	 */
    public VehicleDecorator(iVehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    @Override
    public String toString()
    {
        return vehicle.toString();
    }

	@Override
	public void Move(float distance)
	{
		vehicle.Move(distance);
	}

	@Override
	public String GetModelName()
	{
		return vehicle.GetModelName();
	}

	@Override
	public float GetMaxSpeed()
	{
		return vehicle.GetMaxSpeed();
	}

	@Override
	public int GetMaxSeats()
	{
		return vehicle.GetMaxSeats();
	}

	@Override
	public float GetTotalDistance()
	{
		return vehicle.GetTotalDistance();
	}

	@Override
	public void ResetTravelDistance()
	{
		vehicle.ResetTravelDistance();
	}
}
