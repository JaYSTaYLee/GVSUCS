import java.util.ArrayList;

public class Eatery implements ClockListener{
	static int numEateries = 0;
	private ArrayList<Person> Q = new ArrayList<Person>();
	private int timeOfNextEvent = 0;//time until next Person is serviced
	private int maxQlength = 0;  //Largest number of people in line at one time
	private Person person;   // this is the person at the Eatery. 
	private Person cPerson, cPerson2; //this is the person at Cashiers 1 and 2
	private int completed = 0;  //how many people were served aka Throughput
	static private Cashier cashier1; //two cashiers will service all eateries, thus they are shared (static)
	static private Cashier cashier2;
	static ArrayList<Person> cashierQ = new ArrayList<Person>();//one cashierQ to be shared amongst all eateries
	static private int maxCashierQ=0; //Tracks maximum number of people in the CAshierQ over course of simulation
	private int numLeavers = 0;
	private boolean flip = true;  //This variable will be used to alternate between cashiers so that in the end each cashier will have serviced 50% of the customers
	static double totalCustomerTime=0;
	

public Eatery(int cashierTime)
{
	numEateries++;
	cashier1 = new Cashier(cashierTime);
	cashier2 = new Cashier(cashierTime);
}
public void add (Person person)
{
	Q.add(person);
	if (Q.size() > maxQlength)
		maxQlength = Q.size();
}

public void event (int tick){
//	System.out.println("At time " + tick + ", there are currently " + Q.size() + " customers waiting in line.");

	if (tick >= timeOfNextEvent) {  //Time for next Person to be serviced at eatery
		
		//if there currently is someone being serviced, finish them up and send them to the cashier
		if (person != null) 
		{
			cashierQ.add(person);  //add this person to the CashierQ
			if(maxCashierQ < cashierQ.size()) maxCashierQ = cashierQ.size();
			person=null; //get rid of this person so next person will be added at next tick
		}
		if (Q.size() >= 1)//if the Q of people has at least 1 person 
		{
			//System.out.println("Next customer approaches eatery and will take " +Q.get(0).getEateryTime() + "seconds to service." );
			person = Q.remove(0);		// do not send this person as of yet, make them wait. 
			timeOfNextEvent = tick + (int) (person.getEateryTime() + 1);//figure out when this person will be done
			//System.out.println("This customer will be place in cashierQ at " + timeOfNextEvent);
			completed++;
		}	
	}
	else 
	{ 
		//check to see if anyone in the Q or the current person has waited longer than their leave time
		
		if (person != null && tick >= person.getTickTime() + person.getLeaveTime()) 
			{
				person = null;
				//System.out.println("Someone decided to leave the line because things were taking too long.");
				//get a new customer for the one that took long to be serviced.
				if (Q.size() >= 1)//if the Q of people has at least 1 person 
				{
					//System.out.println("Next customer approaches eatery and will take " +Q.get(0).getEateryTime() + "seconds to service." );
					person = Q.remove(0);		// do not send this person as of yet, make them wait. 
					timeOfNextEvent = tick + (int) (person.getEateryTime() + 1);//figure out when this person will be done
					//System.out.println("This customer will be done at " + timeOfNextEvent);
					numLeavers++;	//chalk up one more customer serviced
				}	
			}
		//now check the rest of the people in Q
		for(int x =Q.size()-1; x >=0; x--)
		{
			if(tick >= Q.get(x).getTickTime() + Q.get(x).getLeaveTime())
			{
				//System.out.println("Someone in line got tired of waiting and leaves the line");
				numLeavers++;
				Q.remove(x);
			}
		}
			
	}
	//Now Cashiers
	if(cashierQ.size()> 0 && cashier1.isAvailable() && flip)
	{
		cashier1.setPerson(cashierQ.remove(0));
		cashier1.setAvailable(false);
		cashier1.setNextEventTime(tick+ cashier1.getPerson().getCashiersTime());
		flip=!flip;
	}
	if(cashierQ.size()> 0 && cashier2.isAvailable() && flip)
	{
		cashier2.setPerson(cashierQ.remove(0));
		cashier2.setAvailable(false);
		cashier2.setNextEventTime(tick+ cashier2.getPerson().getCashiersTime());
		flip=!flip;
	}
	
	//check to see if Person being serviced by cashier1 or cashier2 have waited too long and need to get out of line
	if (cashier1.getPerson()!=null && tick >=cashier1.getPerson().getTickTime() + cashier1.getPerson().getLeaveTime())
	{
		cashier1.setPerson(null);
		//System.out.println("Someone left the cashier's line because things were taking too long");
		cashier1.setAvailable(true);
	}
	if (cashier2.getPerson()!=null && tick >=cashier2.getPerson().getTickTime() + cashier2.getPerson().getLeaveTime())
	{
		cashier2.setPerson(null);
		//System.out.println("Someone left the cashier's line because things were taking too long");
		cashier2.setAvailable(true);
	}
	//check to see if anyone needs to leave the cashierQ due to too much time
	for(int x =cashierQ.size()-1; x >=0; x--)
	{
		if(tick >= cashierQ.get(x).getTickTime() + cashierQ.get(x).getLeaveTime())
		{
			//System.out.println("Someone in line got tired of waiting in the cashierQ and leaves the line");
			numLeavers++;
			cashierQ.remove(x);
		}
	}
		
}
public static void updateTotalTime(Person person, int tick)
{
	totalCustomerTime += tick - person.getTickTime();
}
public static double getAverageCustomerTime()
{
	return totalCustomerTime / Cashier.getCompleted();
}
public static Cashier getCashier1()
{
	return cashier1;
}
public static Cashier getCashier2()
{
	return cashier2;
}
public int getLeft() {
	return Q.size();
}

public int getMaxQlength() {
	return maxQlength;
}

public int getThroughPut() {
	return completed;
}
public int getNumLeavers()
{
	return numLeavers;
}
public static int getMaxCashierQ()
{
	return maxCashierQ;
}
}
