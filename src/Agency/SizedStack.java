package Agency;

import java.util.Stack;

/**
 * Generic Stack with a size cap.
 * 
 * @param <Type> Type of stored objects.
 */
public class SizedStack<Type> extends Stack<Type>
{
	int max_size;
	
	/**
	 * Constructor for SizedStack class.
	 * 
	 * @param max_size the size cap.
	 */
	public SizedStack(int max_size)
	{
		super();
		this.max_size = max_size;
	}
	
	@Override
	public Type push(Type item)
	{
		while (this.size() >= max_size)
			this.remove(0);
		
		return super.push(item);
	}
}
