package Transportation.factories;

import Transportation.Frigate;
import Transportation.Vehicle;

public class FrigateBuilder extends AbstractBuilder
{
	protected Boolean with_wind = false;
	
	/**
	 * Method for setting vehicle's direction.
	 * @param with_wind
	 */
	public void SetDirection(Boolean with_wind)
	{
		this.with_wind = with_wind;
	}
	
	@Override
	public Vehicle Build()
	{
		return new Frigate(model_name, speed, seats, with_wind);
	}
}
