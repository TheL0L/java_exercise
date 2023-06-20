package Transportation.decorators;

import Transportation.Vehicle;
import java.awt.Color;

/**
 * Color decorator class for Vehicle types.
 */
public class ColorDecorator extends VehicleDecorator
{
	private Color color;

	/**
	 * Constructor for ColorDecorator class.
	 * 
	 * @param vehicle  the vehicle to be decorated.
	 * @param color    the intended vehicle color.
	 */
    public ColorDecorator(Vehicle vehicle, Color color)
    {
        super(vehicle);
        this.color = color;
    }
    
    /**
	 * Method for retrieving vehicle's color.
	 * 
	 * @return java.awt.color value of the color.
	 */
    public Color GetColor()
    {
    	return this.color;
    }
    
    /**
	 * Method for changing vehicle's color.
	 * 
	 * @param color java.awt.color value of the color.
	 */
    public void SetColor(Color color)
    {
    	this.color = color;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Color: " + color;
    }
}
