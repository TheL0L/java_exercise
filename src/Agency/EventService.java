package Agency;

import java.util.Vector;

/**
 * Class for managing chained listeners.
 */
public class EventService
{
	private Vector<iEventHandler> listeners;
	
	/**
	 * Constructor for EventService class.
	 */
	public EventService()
	{
		this.listeners = new Vector<iEventHandler>();
	}
	
	/**
	 * Copy constructor for EventService class.
	 * 
	 * @param other the copied EventService.
	 */
	public EventService(EventService other)
	{
		this.listeners = new Vector<iEventHandler>(other.listeners);
	}
	
	/**
	 * Method for subscribing a listener to the EventService.
	 * 
	 * @param listener the new listener.
	 */
	public void Subscribe(iEventHandler listener)
	{
		this.listeners.add(listener);
	}
	
	/**
	 * Method for unsubscribing a listener from the EventService.
	 * 
	 * @param listener the leaving listener.
	 */
	public void Unsubscribe(iEventHandler listener)
	{
		this.listeners.remove(listener);
	}
	
	/**
	 * Method for forwarding an event using the EventService.
	 * 
	 * @param unique_id  vehicle's unique id.
	 * @param event      the event type.
	 */
	public void Update(int unique_id, Event event)
	{
		NotifyListeners(unique_id, event);
	}
	
	/**
	 * Method for forwarding an event to each listener.
	 * 
	 * @param unique_id  vehicle's unique id.
	 * @param event      the event type.
	 */
	private void NotifyListeners(int unique_id, Event event)
	{
		for (iEventHandler listener : listeners)
		{
			listener.Update(unique_id, event);
		}
	}
}
