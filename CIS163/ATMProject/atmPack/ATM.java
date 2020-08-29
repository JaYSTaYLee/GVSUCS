/*****************************************************************
ATM

@author Programmer
@version Winter 2017
*****************************************************************/
package atmPack;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ATM 
{
	 /** current value of hundreds */
	private int hundreds;
	
	/** current value of fifties */
	private int fifties;
	
	/** current value of twenties */
	private int twenties;
	
	/** boolean variable that stores if suspend is true or false */
	private static boolean suspended = false;
	
	/*****************************************************************
    Constructor sets fields to 0
    *****************************************************************/
	
	public ATM()
	{
		if(hundreds < 0 || fifties < 0 || twenties < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		hundreds = 0;
		fifties = 0;
		twenties = 0;
		}
	}
	
	/*****************************************************************
    Overloaded constructor sets fields to parameters h,f,t
    @param h amount hundreds to add
    @param f amount fifties to add
    @param t amount twenties to add
    *****************************************************************/
	
	public ATM(int h, int f, int t)
	{
		if(h < 0 || f < 0 || t < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		hundreds = h;
		fifties = f;
		twenties = t;
		}
	}
	
	/*****************************************************************
    Overloaded constructor sets fields to another ATM objects hundreds, fifties, and twenties
    @param other ATM object
    *****************************************************************/
	
	public ATM(ATM other)
	{
		if(other.getHundreds() < 0 || other.getFifties() < 0 || other.getTwenties() < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		hundreds = other.getHundreds();
		fifties = other.getFifties();
		twenties = other.getTwenties();
		}
	}
	
	/*****************************************************************
    returns hundreds
    @return hundreds
    *****************************************************************/
	
	public int getHundreds()
	{
		return hundreds;
	}
	
	/*****************************************************************
    returns fifties
    @return fifties
    *****************************************************************/
	
	public int getFifties()
	{
		return fifties;
	}
	
	/*****************************************************************
    returns twenties
    @return twenties
    *****************************************************************/
	
	public int getTwenties()
	{
		return twenties;
	}
	
	/*****************************************************************
    sets field hundreds to h
    @param h amount of hundreds
    @return hundreds
    *****************************************************************/
	
	public int setHundreds(int h)
	{
		if(h < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		hundreds = h;
		return hundreds;
		}
	}
	
	/*****************************************************************
    sets field fifties to f
    @param f amount of fifties
    @return fifties
    *****************************************************************/
	
	public int setFifties(int f)
	{
		if(f < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		fifties = f;
		return fifties;
		}
	}
	
	/*****************************************************************
    sets field twenties to t
    @param t amount of twenties
    @return twenties
    *****************************************************************/
	
	public int setTwenties(int t)
	{
		if(t < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		twenties = t;
		return twenties;
		}
	}
	
	/*****************************************************************
    checks if an object (other) is equal to a ATM object
    @param other ATM object
    @return true or false
    *****************************************************************/
	
	public boolean equals(Object other)
	{
		ATM helper = (ATM) other;
		if(helper.getHundreds() == hundreds && helper.getFifties() == fifties && helper.getTwenties() == twenties)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*****************************************************************
    checks if ATM object (object) is equal to another ATM object
    @param other ATM object
    @return true or false
    *****************************************************************/
	
	public boolean equals(ATM other)
	{
		if(other.getHundreds() == hundreds && other.getFifties() == fifties && other.getTwenties() == twenties)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/*****************************************************************
    checks if ATM object other1 is equal to another ATM object other 2
    @param other1 ATM object, other2 ATM object
    @return true or false
    *****************************************************************/
	
	public static boolean equals(ATM other1, ATM other2)
	{
		if(other1.getHundreds() == other2.getHundreds() && other1.getFifties() == other2.getFifties() && other1.getTwenties() == other2.getTwenties())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*****************************************************************
    checks if ATM object (other) is equal,less than, or greater than another ATM object
    @param other ATM object
    @return 1,-1,0
    *****************************************************************/
	
	public int compareTo(ATM other)
	{
		if(hundreds*100 + fifties *50 + twenties*20 > other.getHundreds()*100 + other.getFifties()*50 + other.getTwenties()*20)
		{
			return 1;
		}
		else if(hundreds*100 + fifties *50 + twenties*20 < other.getHundreds()*100 + other.getFifties()*50 + other.getTwenties()*20)
		{
			return -1;
		}
		else
		{
			return 0;
		}
		
	}
	
	/*****************************************************************
    checks if ATM object other1 is equal,less than, or greater than another ATM object other2
    @param other1, other2 ATM object
    @return 1,-1,0
    *****************************************************************/
	
	public static int compareTo(ATM other1, ATM other2)
	{
		if(other1.getHundreds()*100 + other1.getFifties()*50 + other1.getTwenties()*20 > other2.getHundreds()*100 + other2.getFifties()*50 + other2.getTwenties()*20)
		{
			return 1;
		}
		else if(other1.getHundreds()*100 + other1.getFifties()*50 + other1.getTwenties()*20 < other2.getHundreds()*100 + other2.getFifties()*50 + other2.getTwenties()*20)
		{
			return -1;
		}
		else
		{
			return 0;
		}
		
	}
	
	/*****************************************************************
    puts h,f,t amounts of currency in ATM
    @param h,f,t amounts of currency
    @return none
    *****************************************************************/
	
	public void putIn(int h, int f, int t)
	{
		if(!suspended)
		{
			if(h < 0 || f < 0 || t < 0)
			{
				throw new IllegalArgumentException();
			}
			else
			{
			hundreds = hundreds + h;
			fifties = fifties + f;
			twenties = twenties + t;
			}
		}
	}
	
	/*****************************************************************
    sets another ATM objects fields into this ATM objects fields amounts of currency in ATM
    @param other ATM object
    @return none
    *****************************************************************/
	
	public void putIn(ATM other)
	{
		if(!suspended)
		{
			if(other.getHundreds() < 0 || other.getFifties() < 0 || other.getTwenties() < 0)
			{
				throw new IllegalArgumentException();
			}
			else
			{
			hundreds = hundreds + other.getHundreds();
			fifties = fifties + other.getFifties();
			twenties = twenties + other.getTwenties();
			}
		}
	}
	
	/*****************************************************************
    withdraws h,f,t amounts of currency in ATM
    @param h,f,t amounts of currency
    @return none
    *****************************************************************/
	
	public void takeOut(int h, int f, int t)
	{
		if(!suspended)
		{
			if(h < 0 || f < 0 || t < 0)
			{
				throw new IllegalArgumentException();
			}
			else
			{
			hundreds = hundreds - h;
			fifties = fifties - f;
			twenties = twenties - t;
			}
		}
	}
	
	/*****************************************************************
    withdraws other ATM objects amounts of currency in ATM
    @param other ATM object
    @return none
    *****************************************************************/
	
	public void takeOut(ATM other)
	{
		if(!suspended)
		{
			if(other.getHundreds() < 0 || other.getFifties() < 0 || other.getTwenties() < 0)
			{
				throw new IllegalArgumentException();
			}
			else
			{
			hundreds = hundreds - other.getHundreds();
			fifties = fifties - other.getFifties();
			twenties = twenties - other.getTwenties();
			}
		}
	}
	
	/*****************************************************************
    optional method
    *****************************************************************/
	
	public void takeOut(double amount)
	{
	
	}
	
	/*****************************************************************
    takes instance varaibles and combines them with strings to output amount of currency in ATM
    @param none
    @return String hTFOutput
    *****************************************************************/
	
	public String toString()
	{
		String hOutput = "";
		String fOutput = "";
		String tOutput = "";
		String hTFOutput = "";
		if(getHundreds() > 1 || getHundreds() == 0)
		{
			hOutput = getHundreds() + " hundred dollar bills, ";
		}
		else
		{
			hOutput = getHundreds() + " hundred dollar bill, ";
		}
		if(getFifties() > 1 || getFifties() == 0)
		{
			fOutput = getFifties() + " fifty dollar bills, ";
		}
		else
		{
			fOutput = getFifties() + " fifty dollar bill, ";
		}
		if(getTwenties() > 1 || getTwenties() == 0)
		{
			tOutput = getTwenties() + " twenty dollar bills.";
		}
		else
		{
			tOutput = getTwenties() + " twenty dollar bill.";
		}
		hTFOutput = hOutput + fOutput + tOutput;
		return hTFOutput;
	}
	
	/*****************************************************************
    saves file
    @param fileName name of file to save
    @return none
    *****************************************************************/
	
	public void save(String fileName)
	{
		PrintWriter out = null;
		try 
		{
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		out.println(hundreds+" "+fifties+" "+twenties);
		out.close();
	}
	
	/*****************************************************************
    loads file
    @param fileName name of file to load
    @return none
    *****************************************************************/
	
	public void load(String fileName)
	{
		try
		{
			// open the data file
			Scanner fileReader = new Scanner(new File(fileName));
			// read one String in of data and an int
			hundreds = fileReader.nextInt();
			fifties = fileReader.nextInt();
			twenties = fileReader.nextInt();
			fileReader.close();
		}
		// could not find file
		catch(Exception error) 
		{
			System.out.println("File not found ");
		}
	}
	
	/*****************************************************************
    prevents ATM transactions if true
    @param on true or false
    @return none
    *****************************************************************/
	
	public static void suspend(Boolean on)
	{
		suspended = on;
	}
	
	/*****************************************************************
    returns the total amount of hundreds fifties and twenties
    @param none
    @return amount
    *****************************************************************/
	
	public int getAmount()
	{
		int amount = getHundreds()*100 + getFifties()*50 + getTwenties()*20;
		return amount;
	}
	
	/*****************************************************************
    main method
    @param args
    @return none
    *****************************************************************/
	
	public static void main(String[] args) 
	{
		/*ATM testLoadSave = new ATM(1,2,3);
		testLoadSave.save("xyz.txt");
		
		ATM testLoadSavePart2  = new ATM();
		testLoadSavePart2.load("xyz.txt");
		System.out.println("After reading: "+testLoadSavePart2.getHundreds()+" "+
		                                     testLoadSavePart2.getFifties());*/
		/*ATM a = new ATM(); //Default constructor all fields set to 0 
		System.out.println("testing for 0 hundreds, 0 fifties, 0 twenties"); //Testing for these outputs
		System.out.println("hundreds: " + a.getHundreds()); //Test getHundreds() method
		System.out.println("fifties: " + a.getFifties()); //Test getFifties() method
		System.out.println("twenties: " + a.getTwenties()); //Test getTwenties() method
		
		System.out.println("testing for 1 hundreds, 2 fifties, 3 twenties"); //Testing for these outputs
		a.setHundreds(1); //Testing setHundreds() method
		a.setFifties(2); //Testing setFifties() method
		a.setTwenties(3); //Testing setTwenties() method
		System.out.println("hundreds: " + a.getHundreds()); //Test getHundreds() method
		System.out.println("fifties: " + a.getFifties()); //Test getFifties() method
		System.out.println("twenties: " + a.getTwenties()); //Test getTwenties() method
		System.out.println(a.toString()); //Test toString method*/
		
		/*ATM b = new ATM(5,10,15); //Overloaded constructor
		System.out.println("should have 5 hundreds 10 fifties 15 twenties"); //Testing for these outputs
		System.out.println(b.toString()); //Test toString method and looking for parameters passed properly*/
		
		/*ATM c = new ATM(10,20,30); //Testing ATM(ATM other) method
		ATM c1 = new ATM(c); //Testing to see if c1 takes on c's values
		System.out.println(c1.toString());*/
		
		/*
		//Testing the equal(object other) method
		ATM d = new ATM();
		d.hundreds = 5;
		d.fifties = 5;
		d.twenties = 5;
		ATM d1 = new ATM(5,5,5);
		ATM d2 = new ATM(6,6,6);
		if(d.equals(d1))
		{
			System.out.println("d equals d1");
		}
		else
		{
			System.out.println("d does not equal d1");
		}
		if(d.equals(d2))
		{
			System.out.println("d equals d2");
		}
		else
		{
			System.out.println("d does not equal d2");
		}
		*/
		
		/*
		//Test equals(ATM other1, ATM other2) method
		ATM e = new ATM(10,10,10);
		ATM e1 = new ATM(10,10,10);
		ATM e2 = new ATM(11,11,11);
		if(e.equals(e1))
		{
			System.out.println("e equals e1");
		}
		else
		{
			System.out.println("e does not equal e1");
		}
		if(e.equals(e2))
		{
			System.out.println("e equals e2");
		}
		else
		{
			System.out.println("e does not equal e2");
		}
		*/
		
		/*
		//ASK ABOUT HOW THIS WORKS!!!!!!!!!!!!
		ATM a = new ATM();
		System.out.println(a);
		*/
		
		/*
		//Testing compareTo(ATM other) method
		ATM f = new ATM(50,50,50);
		ATM f1 = new ATM(51,51,51);
		ATM f2 = new ATM(50,50,50);
		ATM f3 = new ATM(49,49,49);
		System.out.println("f is less than f1 should return: -1:" + f.compareTo(f1));
		System.out.println("f is equal to f2 should return: 0:" + f.compareTo(f2));
		System.out.println("f is greater than f3 should return: 1:" + f.compareTo(f3));
		*/
		
		/*
		//Testing compareTo(ATM other1, ATM other2) method
		ATM g = new ATM(50,50,50);
		ATM g1 = new ATM(51,51,51);
		ATM g2 = new ATM(50,50,50);
		ATM g3 = new ATM(49,49,49);
		System.out.println("g is less than g1 should return: -1:" + compareTo(g,g1));
		System.out.println("g is equal to g2 should return: 0:" + compareTo(g,g2));
		System.out.println("g is greater than g3 should return: 1:" + compareTo(g,g3));
		*/
		
		/*
		//Testing putIn(int h, int f, int t) method
		ATM h = new ATM();
		h.putIn(10,20,30);
		System.out.println("should output 10 hundreds 20 fifties 30 twenties.");
		System.out.println(h);
		*/
		
		/*
		//Testing putIn(ATM other) method
		ATM i = new ATM(1,1,1);
		ATM i1 = new ATM(10,20,30);
		i.putIn(i1);
		System.out.println("should output 11 hundreds 21 fifties 31 twenties.");
		System.out.println(i);
		*/
		
		/*
		//Testing takeOut(int h, int f, int t) method
		ATM j = new ATM(5,5,5);
		j.takeOut(1,1,1);
		System.out.println("should output 4 hundreds 4 fifties 4 twenties.");
		System.out.println(j);
		*/
		
		/*
		//Testing takeOut(ATM other) method
		ATM k = new ATM(5,5,5);
		ATM k1 = new ATM(3,3,3);
		k.takeOut(k1);
		System.out.println("should output 2 hundreds 2 fifties 2 twenties.");
		System.out.println(k);
		*/
		
		/*
		//Test getAmount() method
		ATM l = new ATM(1,1,1);
		System.out.println("Amount in ATM 170: " + l.getAmount());
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//ATM s = new ATM(10,2,3);
		//System.out.println("Created ChangeJar:$1160, result: " + s.getAmount());
		//ATM s1 = new ATM();
		//System.out.println("\nCreated ChangeJar:$0, result: " + s1.getAmount());
		//s1.putIn(10,2,3);
		//System.out.println("\nAdded ChangeJar:$1160, result: " + s1.getAmount());
		//ATM s2 = new ATM(10,2,3);
		//s2.putIn(0,0,0);
		//System.out.println("\nAdded ChangeJar:$1160, result: " + s2.getAmount());
		//s2 = new ATM(2,1,3);
		//ATM temp = s2.takeOut(250);
		//System.out.println ("\nTake out the following:\n" + temp);
		//System.out.println("Remaining ChangeJar:$60, result: " + s2.getAmount());
		//s2 = new ATM (5, 4, 3);
		//s2.save("pizza");
		//s2 = new ATM();
		//s2.load("pizza");
		//if (s2.equals(new ATM(5,4,3)))
		//System.out.println ("\nLoad and Save and Equals works!");
		//System.out.println (s2);
		// Create many more test cases in this driver method to
		// prove the class is functioning correctly.
		}
}