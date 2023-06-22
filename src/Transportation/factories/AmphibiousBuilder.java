package Transportation.factories;

import Transportation.AmphibiousVehicle;
import Transportation.Vehicle;

public class AmphibiousBuilder extends AbstractBuilder
{
	protected int wheels_count = 0;
	protected float fuel = 0, engine_life = 0;
	protected String flag = "generic flag";
	protected Boolean with_wind = false;
	
	/**
	 * Method for setting vehicle's fuel consumption.
	 * @param fuel
	 */
	public void SetFuelConsumption(float fuel)
	{
		this.fuel = fuel;
	}
	
	/**
	 * Method for setting vehicle's engine life expectancy.
	 * @param engine_life
	 */
	public void SetEngineLife(float engine_life)
	{
		this.engine_life = engine_life;
	}
	
	/**
	 * Method for setting vehicle's flag.
	 * @param flag
	 */
	public void SetFlag(String flag)
	{
		this.flag = flag;
	}
	
	/**
	 * Method for setting vehicle's direction.
	 * @param with_wind
	 */
	public void SetDirection(Boolean with_wind)
	{
		this.with_wind = with_wind;
	}
	
	/**
	 * Method for setting vehicle's wheels count.
	 * @param wheels_count
	 */
	public void SetWheelsCount(int wheels_count)
	{
		this.wheels_count = wheels_count;
	}
	
	@Override
	public Vehicle Build()
	{
		Vehicle product = new AmphibiousVehicle(model_name, speed, seats, wheels_count, with_wind, flag, fuel, engine_life);
		product.SetColor(color);
		product.SetStatus(status);
		return product;
	}
}
