package Transportation.factories;

import Transportation.CruiseShip;
import Transportation.Vehicle;

public class CruiseShipBuilder extends AbstractBuilder
{
	protected float fuel = 0, engine_life = 0;
	protected String flag = "generic flag";
	
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
	
	@Override
	public Vehicle Build()
	{
		return new CruiseShip(model_name, speed, seats, flag, fuel, engine_life);
	}
}
