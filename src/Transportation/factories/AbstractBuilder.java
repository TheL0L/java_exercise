package Transportation.factories;

import Transportation.Vehicle;

public abstract class AbstractBuilder
{
	protected String model_name;
	protected float speed;
	protected int seats;
	
	/**
	 * Constructor for AbstractBuilder.
	 */
	public AbstractBuilder()
	{
		this.model_name = "";
		this.speed = 0;
		this.seats = 0;
	}
	
	/**
	 * Method for setting vehicle's model name.
	 * @param model_name
	 */
	public void SetModel(String model_name)
	{
		this.model_name = model_name;
	}
	
	/**
	 * Method for setting vehicle's speed.
	 * @param speed
	 */
	public void SetSpeed(float speed)
	{
		this.speed = speed;
	}
	
	/**
	 * Method for setting vehicle's seats count.
	 * @param seats
	 */
	public void SetSeats(int seats)
	{
		this.seats = seats;
	}
	
	/**
	 * Method for retrieving the final build of the vehicle.
	 * @return vehicle reference.
	 */
	public abstract Vehicle Build();
}
