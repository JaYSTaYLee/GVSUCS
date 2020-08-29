import java.util.ArrayList;
import java.util.Random;

public class PersonProducer implements ClockListener{
	private int nextPerson = 0;//time next person will appear at eatery
	private ArrayList<Eatery> eateries = new ArrayList<Eatery>();
	private int numOfTicksNextPerson; //A static amount of time between Persons arriving at this eatery
	private int averageEateryTime;  //A randomly generated time to serve the person at the eatery, using desired mean
	private int averageCashiersTime;
	private int leaveTime;  //need this for when we instantiate Person objects to figure out when they will leave the line.
	private Random r = new Random();
//	private Cashier cashier1 = new Cashier();
//	private Cashier cashier2 = new Cashier();
	
	public PersonProducer(int numberOfEateries, int numOfTicksNextPerson,int averageEateryTime, int leaveTime, int cashierTime) 
	{
		makeEateries(numberOfEateries, cashierTime);
		this.numOfTicksNextPerson = numOfTicksNextPerson;
		this.averageEateryTime = averageEateryTime;
		this.leaveTime = leaveTime;
		//r.setSeed(13);    // This will cause the same random numbers
	}
	public void makeEateries(int numberOfEateries, int cashierTime)
	{
		for(int x =0; x< numberOfEateries; x++)
		eateries.add(new Eatery(cashierTime));
	}
	public void event(int tick) 
	{
		
		if (nextPerson <= tick) 
		{
			Random r = new Random();
			nextPerson = tick + numOfTicksNextPerson;
			//Pick a random Person type to add to Eatery Line
			Person person = pickRandomPerson();
			person.setTickTime(tick);
			addPersonToEatery(person);
			//System.out.println(person);		
		//	person.setDestination(theLocationAfterTheEatery);  // You can save off where the person should go.
		}
	}
	
	//Picks a random Person type to add to eatery Line (70% Regular, 20% LimitedTime, 10% SpecialNeeds)
	public Person pickRandomPerson()
	{
		Person p;
		int rNumber = (int)(Math.random()*10);//****CHANGE TO 10
		if(rNumber < 7)  
			{
				p = new RegularPerson(leaveTime);
			}
		else if(rNumber <9) 
			{
				p = new LimitedTimePerson(leaveTime);
			}
		else 
			{
				p = new SpecialNeedsPerson(leaveTime);
			}
		p.setEateryTime((int) Math.max(0,averageEateryTime*0.5*r.nextGaussian() + averageEateryTime +.5));
		p.setCashiersTime((int) Math.max(0,averageCashiersTime*0.5*r.nextGaussian() + averageCashiersTime +.5));
		return p;
	}
	//add a person to a random eatery
	public void addPersonToEatery(Person person)
	{
		int r = (int)(Math.random()*eateries.size());
		eateries.get(r).add(person);
	}
	public ArrayList<Eatery> getEateries()
	{
		return eateries;
	}
}
