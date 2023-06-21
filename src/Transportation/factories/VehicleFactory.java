package Transportation.factories;

import Transportation.*;
import Transportation.LandVehicle.RoadType;

public class VehicleFactory implements AbstractFactory
{
	@Override
	public AbstractBuilder Make(VehicleType type)
	{
		switch (type)
		{
		case Bicycle:
		{
			return new BicycleBuilder();
		}
		case ElectricBicycle:
		{
			return new ElectricBicycleBuilder();
		}
		case Jeep:
		{
			return new JeepBuilder();
		}
		
		case CruiseShip:
		{
			return new CruiseShipBuilder();
		}
		case Frigate:
		{
			return new FrigateBuilder();
		}
		
		case SpyGlider:
		{
			return new SpyGliderBuilder();
		}
		case ToyGlider:
		{
			return new ToyGliderBuilder();
		}
		
		case Amphibious:
		{
			return new AmphibiousBuilder();
		}
		
		case HybridPlane:
		{
			return new HybridPlaneBuilder();
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + type.name());
		}
	}
}

/*
	switch (type)
	{
	case Bicycle:
		return new Bicycle("generic model", 0, 0, RoadType.Asphalt);
		
	case ElectricBicycle:
		return new ElectricBicycle("generic model", 0, 0, RoadType.Asphalt, 0, 0);
		
	case Jeep:
		return new Jeep("generic model", 0, 0, 0);
	
	case CruiseShip:
		return new CruiseShip("generic model", 0, 0, "generic country", 0, 0);
		
	case Frigate:
		return new Frigate("generic model", 0, 0, false);
	
	case SpyGlider:
		return new SpyGlider("generic power source");
		
	case ToyGlider:
		return new ToyGlider();
	
	case Amphibious:
		return new AmphibiousVehicle("generic model", 0, 0, 0, false, "generic country", 0, 0);
	
	case HybridPlane:
		return new HybridPlane("generic model", 0, 0, 0, false, "generic country", 0, 0);
*/
