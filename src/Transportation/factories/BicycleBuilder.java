package Transportation.factories;

import Transportation.Bicycle;
import Transportation.Vehicle;
import Transportation.LandVehicle.RoadType;

public class BicycleBuilder extends AbstractBuilder
{
	protected RoadType road_type = RoadType.Asphalt;
	
	/**
	 * Method for setting vehicle's road type.
	 * @param road_type
	 */
	public void SetRoadType(RoadType road_type)
	{
		this.road_type = road_type;
	}
	
	@Override
	public Vehicle Build()
	{
		return new Bicycle(model_name, speed, seats, road_type);
	}
}
