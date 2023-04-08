package Transportation;

/*
 * Interface for vehicles being used in a commercial manner.
 */
public interface iCommercial
{
	/*
	 * Types of commercial licenses available.
	 */
	public static enum CommercialUse { MINI, LIMIT, UNLIMIT };
	
	/*
	 * Method for retrieving the vehicle's commercial license.
	 * 
	 * @return string containing the name of the used license.
	 */
	public String GetCommercialUsage();
}
