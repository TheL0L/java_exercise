package Transportation;

public class Spyglider extends AerialVehicle implements NotMotorized
{
	private char energyScore;
	private String powerSource;
	
	
	public Spyglider(String model_name,float max_speed,int max_seats,Type_of_use type,char energyScore,String poewrSource )
	{
		super("privileged",50,1,Type_of_use.military);
		this.energyScore = 'C';
		this.powerSource = poewrSource;
	}
	public char EnergyScore()
	{
		return this.energyScore;
	}
	public String PowerSource()
	{
		return this.powerSource;
	}
	public boolean equals(Object obj)
	{
		if(!super.equals(obj))
		{
			return false; 
		}
		if(!(obj instanceof Spyglider))
		{
			return false; 
		}
		
		Spyglider other = (Spyglider)obj;
		if(this.energyScore!= other.energyScore)
		{
			return false;
		}
		if(this.powerSource != other.powerSource)
		{
			return false;
		}
		return true;
	}
	
	public String toString()
	{
		return "Spyglider: " + super.toString() + ",Enrgy score : " + this.EnergyScore()
			+ " Power source:  " + this.PowerSource() + "  type of use: " + this.GetType_of_use();
	}
	
}
