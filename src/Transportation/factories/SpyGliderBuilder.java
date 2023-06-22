package Transportation.factories;

import Transportation.SpyGlider;
import Transportation.Vehicle;

public class SpyGliderBuilder extends AbstractBuilder
{
	protected String power_source = "generic power source";
	
	/**
	 * Method for setting vehicle's power source.
	 * @param power_source
	 */
	public void SetPowerSource(String power_source)
	{
		this.power_source = power_source;
	}
	
	@Override
	public Vehicle Build()
	{
		Vehicle product = new SpyGlider(power_source);
		product.SetColor(color);
		product.SetStatus(status);
		return product;
	}
}
