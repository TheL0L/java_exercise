package Agency;

import java.util.Vector;

public class EventService
{
	private Vector<iEventHandler> listeners;
	
	public EventService()
	{
		this.listeners = new Vector<iEventHandler>();
	}
	
	public void Subscribe(iEventHandler listener)
	{
		this.listeners.add(listener);
	}
	
	public void Unsubscribe(iEventHandler listener)
	{
		this.listeners.add(listener);
	}
	
	public void Update(int unique_id, Event event)
	{
		NotifyListeners(unique_id, event);
	}
	
	private void NotifyListeners(int unique_id, Event event)
	{
		for (iEventHandler listener : listeners)
		{
			listener.Update(unique_id, event);
		}
	}
}
