package Transportation.factories;

import Transportation.ToyGlider;
import Transportation.Vehicle;

public class ToyGliderBuilder extends AbstractBuilder
{
	@Override
	public Vehicle Build()
	{
		Vehicle product = new ToyGlider();
		product.SetColor(color);
		product.SetStatus(status);
		return product;
	}
}
