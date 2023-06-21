package Transportation.factories;

import Transportation.ToyGlider;
import Transportation.Vehicle;

public class ToyGliderBuilder extends AbstractBuilder
{
	@Override
	public Vehicle Build()
	{
		return new ToyGlider();
	}
}
