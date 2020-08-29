
public abstract class Person {
	protected int cashiersTime;  //Time to be serviced by the cashier (random desired mean)
	protected int leaveTime;  //time at which the person leaves the eatery and isn't served
	protected int finishTime;
	protected int eateryTime;  //time it takes to order food at the eatery (random desired mean)
	protected int tickTime;  // master clock time when person arrives at eatery
	protected static int averageTime=0;
	protected static int numPersons=0;
	
	public abstract void setCashiersTime(int Time);
	public abstract void setLeaveTime(int Time);
	public abstract void setEateryTime(int Time);
	public abstract int getEateryTime();
	public abstract int getLeaveTime();
	public abstract int getCashiersTime();
	public abstract void setTickTime(int Time);
	public abstract void setFinishTime(int Time);
	public abstract int getTickTime();
	public abstract int getFinishTime();
}
