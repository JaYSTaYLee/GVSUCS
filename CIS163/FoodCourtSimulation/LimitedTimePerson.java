
public class LimitedTimePerson extends Person{
	
	public LimitedTimePerson(int leaveTime)
	{
		this.leaveTime = leaveTime/2;
		eateryTime /=2;
		finishTime = tickTime+eateryTime;
	}
	@Override
	public void setCashiersTime(int Time) {
		cashiersTime = Time;
		
	}

	@Override
	public void setLeaveTime(int Time) {
		leaveTime = Time;
	}

	@Override
	public void setEateryTime(int Time) {
		eateryTime = Time;
	}

	@Override
	public int getEateryTime() {
		// TODO Auto-generated method stub
		return eateryTime;
	}

	@Override
	public int getLeaveTime() {
		// TODO Auto-generated method stub
		return leaveTime;
	}

	@Override
	public int getCashiersTime() {
		// TODO Auto-generated method stub
		return cashiersTime;
	}

	@Override
	public void setTickTime(int Time) {
		// TODO Auto-generated method stub
		tickTime = Time;
	}

	@Override
	public void setFinishTime(int Time) {
		// TODO Auto-generated method stub
		finishTime=Time;
	}

	@Override
	public int getTickTime() {
		// TODO Auto-generated method stub
		return tickTime;
	}

	@Override
	public int getFinishTime() {
		// TODO Auto-generated method stub
		return finishTime;
	}
	/*public String toString()
	{
		return "Another limited time person arrives at the eatery at " + tickTime +". He will it will spend " + eateryTime + " seconds at the eatery.";
	}*/
}
