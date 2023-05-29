package Agency;

import Transportation.Vehicle;

public class Driver extends Thread
{
	private Vehicle reference;
	private float distance;
	
	public Driver(Vehicle reference, float distance)
	{
        this.reference = reference;
        this.distance = distance;
	}

	@Override
	public void run()
	{
		reference.Move(distance);
		
        try
        {
            long sleepTime = (long) (distance * 100);
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
	}
}
