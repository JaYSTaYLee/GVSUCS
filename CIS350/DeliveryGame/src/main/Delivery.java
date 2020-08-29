/**
 * 
 */
package main;

/**
 * @author Joseph
 * @author Kyle
 */
public class Delivery {
	
	/**Customer ID character.**/
	private char customerID;
	
	/**Number of packages.**/
	private int numPkgs;
	
	/**Total number of packages.**/
	private static int totPkgsDelivered = 0;

	/*****************************************************************
    Constructor.
    @param customer - char to respresent customer
    @param numPkgs - number of packages to deliver to a customer
    *****************************************************************/
	public Delivery(final char customer, final int numPkgs) {
		
		this.customerID = customer;
		this.numPkgs = numPkgs;
		
	}

	/*****************************************************************
    Gets a customer ID.
    @return - customers char ID
    *****************************************************************/
	public char getID() {
		
		return this.customerID;
		
	}

	/*****************************************************************
    Gets number of packages to deliver to customer.
    @return - number of packages to deliver to customer
    *****************************************************************/
	public int getNumPkgs() {
		
		return this.numPkgs;
		
	}	
	
	/*****************************************************************
    Updates total packages delivered.
    @param numPkgs - number of packages delivered to a customer
    *****************************************************************/
	public static void updateTotNumPkgsDelivered(final int numPkgs) {
		
		Delivery.totPkgsDelivered += numPkgs;
		
	}
	
	/*****************************************************************
    Gets total packages delivered.
    @return - total number of packages delivered
    *****************************************************************/
	public static int getTotNumPkgsDelivered() {
		
		return Delivery.totPkgsDelivered;
		
	}
	
}
