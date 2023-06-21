package Transportation.factories;

import Transportation.Jeep;
import Transportation.Vehicle;

public class JeepBuilder extends AbstractBuilder
{
	protected float fuel = 0, engine_life = 0;
	
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
	
	@Override
	public Vehicle Build()
	{
		return new Jeep(model_name, fuel, speed, engine_life);
	}
}
