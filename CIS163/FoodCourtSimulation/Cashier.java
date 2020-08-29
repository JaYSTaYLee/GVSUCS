import java.util.ArrayList;


public class Cashier implements ClockListener{
	private int timeOfNextEvent = 0;//time until next Person is serviced
	private Person person;   // this is the person at the Cashier 
	private boolean available = true;
	private int count = 0; //This will count the seconds between servicing customers
	static private int completed = 0;
	
	public Cashier(int cashierTime)
	{
		timeOfNextEvent=cashierTime;
	}

	@Override
	public void event(int tick) {
		if(tick >= timeOfNextEvent)
		{
			available = true;
			completed++;
			if(person!=null)Eatery.updateTotalTime(person,tick);
		}
	}

	public static int getCompleted()
	{
		return completed;
	}
	public boolean isAvailable()
	{
		return available;
	}
	public void setAvailable(boolean a)
	{
		available = a;
	}
	public void setCount(int c)
	{
		count = c;
	}
	public int getCount()
	{
		return count;
	}
	public void setNextEventTime(int Time)
	{
		timeOfNextEvent=Time;
	}
	public int getNextEventTime()
	{
		return timeOfNextEvent;
	}
	public void setPerson(Person p)
	{
		person =p; 
	}
	public Person getPerson()
	{
		return person;
	}
}
