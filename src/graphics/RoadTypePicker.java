package graphics;

import javax.swing.JComboBox;
import Transportation.LandVehicle.RoadType;

/**
 * Preset extension class from JComboBox that contains all existing LandVehicle.RoadType values.
 */
public class RoadTypePicker extends JComboBox
{
	/**
	 * Constructor for class RoadTypePicker.
	 */
	public RoadTypePicker()
	{
		super();
		
		for (RoadType roadtype : RoadType.values())
		{
			this.addItem(roadtype.toString());
		}
	}
}
