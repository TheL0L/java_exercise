import Transportation.*;

public class Prog
{
	public static void main(String[] args)
	{
		System.out.println("Hello World!");
	}
	
	public static void test_prints()
	{
		Vehicle car = new Vehicle("car", 10, 10);
		
		System.out.println(car.GetModelName());
		System.out.println(car.GetMaxSpeed());
		System.out.println(car.GetMaxSeats());
		System.out.println(car.GetTotalDistance());
		
		System.out.println(car.toString());
		
		Vehicle car2 = new Vehicle("car", 11, 10);
		
		System.out.println(car.equals(car2));
	}
}
