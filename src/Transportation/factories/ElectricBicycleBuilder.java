package Transportation.factories;

import Transportation.ElectricBicycle;
import Transportation.Vehicle;
import Transportation.LandVehicle.RoadType;

public class ElectricBicycleBuilder extends AbstractBuilder
{
	protected float fuel = 0, engine_life = 0;
	protected RoadType road_type = RoadType.Asphalt;
	
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
		Vehicle product = new ElectricBicycle(model_name, speed, seats, road_type, fuel, engine_life);
		product.SetColor(color);
		product.SetStatus(status);
		return product;
	}
}
