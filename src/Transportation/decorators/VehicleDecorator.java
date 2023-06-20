package Transportation.decorators;

import Transportation.Vehicle;

/**
 * Base decorator class for Vehicle types.
 */
public abstract class VehicleDecorator extends Vehicle
{
	private Vehicle vehicle;

	/**
	 * Constructor for VehicleDecorator class.
	 * 
	 * @param vehicle  the vehicle to be decorated.
	 */
    public VehicleDecorator(Vehicle vehicle)
    {
        super(vehicle.GetModelName(), vehicle.GetMaxSpeed(), vehicle.GetMaxSeats());
        this.vehicle = vehicle;
    }

    @Override
    public String toString()
    {
        return vehicle.toString();
    }
}
