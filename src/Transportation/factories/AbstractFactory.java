package Transportation.factories;

//import Transportation.Vehicle;

public interface AbstractFactory
{
	public static enum VehicleType {
		Amphibious, Bicycle, CruiseShip, ElectricBicycle,
		Frigate, HybridPlane, Jeep, SpyGlider, ToyGlider
	};
	
	public AbstractBuilder Make(VehicleType type);
	//public Vehicle Make(VehicleType type);
}
