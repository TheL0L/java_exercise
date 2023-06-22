package Transportation.factories;

import java.awt.Color;

import Transportation.Vehicle;
import Transportation.decorators.StatusDecorator.VehicleStatus;

public abstract class AbstractBuilder
{
	protected String model_name;
	protected float speed;
	protected int seats;
	
	protected Color color;
	protected VehicleStatus status;
	
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
	 * Method for setting vehicle's color.
	 * @param color
	 */
	public void SetColor(Color color)
	{
		this.color = color;
	}
	
	/**
	 * Method for setting vehicle's status.
	 * @param status
	 */
	public void SetStatus(VehicleStatus status)
	{
		this.status = status;
	}
	
	/**
	 * Method for retrieving the final build of the vehicle.
	 * @return vehicle reference.
	 */
	public abstract Vehicle Build();
}
