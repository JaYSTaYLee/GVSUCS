import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {
	
	
	
	public static void main(String[] args) {
		
		//inputs
		Scanner s = new Scanner(System.in);
		System.out.println("Time in between people arriving:");
		int numTicksTilNextPerson=s.nextInt();
		System.out.println("Average time people spent at eatery:");
		int ticksPerPerson=s.nextInt();
		System.out.println("Enter number of Eateries");
		int numEateries = s.nextInt();  //Eateries will be stored in the PersonProducer
		System.out.println("How long before a person leaves the line?");
		int leaveTime = s.nextInt();
		System.out.println("How long at each cashier?");
		int cashierTime = s.nextInt();
		//Create PersonProducer
		PersonProducer pp = new PersonProducer(numEateries, numTicksTilNextPerson , ticksPerPerson, leaveTime, cashierTime); //going to create 1 PersonProducer that handles feeding people to all eateries
		//Create clock and add PersonProducer and Eateries to it
		Clock clk = new Clock();
		clk.add(pp);
		//add all of the Eateries, which are stored in the PersonProducer object, pp
		for(int x=0; x< pp.getEateries().size(); x++)
		{
			clk.add(pp.getEateries().get(x));
		}
		//now add the two cashiers to the clock
		clk.add(Eatery.getCashier1());
		clk.add(Eatery.getCashier2());
		System.out.println("How long do you want your simulation to run?  (ticks)");
		int numTicks = s.nextInt();
		clk.run(numTicks);
		
		//Output
		System.out.println("\nThroughput Totals = " + getThroughputTotals(pp));
		System.out.println("\nTotal people left in eatery queues at end of simulation = " + getPeopleLeftInQueues(pp));
		System.out.println("\nNumber of people that left line without being serviced = "+ getNumLeftLine(pp));
		System.out.println("\nMaximum number of people in Cashier Line = " + Eatery.getMaxCashierQ());
		System.out.println("\nAverage time per person from start to finish = " + Eatery.getAverageCustomerTime());
		
		
	}
	public static int getNumLeftLine(PersonProducer pp)
	{
		int total = 0;
		for(int x =0; x < pp.getEateries().size();x++)
		{
			//System.out.println("Number of people that left the line at  Eatery # " + (x+1)+ " is " + pp.getEateries().get(x).getNumLeavers());
			total += pp.getEateries().get(x).getNumLeavers();
		}
		return total;
	}
	public static int getPeopleLeftInQueues(PersonProducer pp)
	{
		int total =0;
		for(int x=0; x< pp.getEateries().size(); x++)
		{
			//System.out.println("Number of people left in Eatery # " + (x+1)+ " is " + pp.getEateries().get(x).getLeft());
			total += pp.getEateries().get(x).getLeft();
		}
		return total;
	}
public static int getThroughputTotals(PersonProducer pp)
{
	int total =0;
	for(int x=0; x< pp.getEateries().size(); x++)
	{
		//System.out.println("Number of people serviced at  Eatery # " + (x+1)+ " is " + pp.getEateries().get(x).getThroughPut());
		total += pp.getEateries().get(x).getThroughPut();
	}
	return total;
}
}
