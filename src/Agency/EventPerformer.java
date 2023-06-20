package Agency;

public class EventPerformer
{
	private EventService service;
	
	public EventPerformer(EventService service)
	{
		this.service = service;
	}
	
	public void NotifyService(int unique_id, Event event)
	{
		this.service.Update(unique_id, event);
	}
}
