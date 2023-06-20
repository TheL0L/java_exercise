package Agency;

public class Driver extends Thread
{
	private int vehicle_id;
	private float distance;
	
	public Driver(int vehicle_id, float distance)
	{
        this.vehicle_id = vehicle_id;
        this.distance = distance;
	}

	@Override
	public void run()
	{
        try
        {
            long sleepTime = (long) (distance * 100);
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
        	distance = 0;
            e.printStackTrace();
        }
        finally
        {
        	AgencyManager.GetInstance().EndTestDrive(vehicle_id, distance);
        }
	}
}
