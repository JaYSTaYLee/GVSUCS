import java.text.NumberFormat;
import java.util.Locale;

public class CreditCard
{
    //Instance variables given to me
    private String cardHolderName;
    private double previousBalance;
    private double purchase;
    private double balanceTransfer;
    private double newBalance;
    private double fee;
    private double cashAdvanceInterest;
    private double cashAdvance;
    private int numberOfPurchases;
    private final double BALANCE_ANNUAL_PERCENTAGE_RATE = 0.159;
    private final int DUE_DATE = 20;
    private final double LATE_PAYMENT_FEE = 37.0;
    private final double MINIMUM_INTEREST_AMOUNT = 0.50;
    private final double CASH_ADVANCE_ANNUAL_PERCENTAGE_RATE = 0.259;
    //Instance variables I created
    private int dayOfMonth;
    private double minimumPayment;
    private double creditCardPayment;
    private double totalPurchase; // test might delete
    private double totalCashAdvanceInterest = 0;
    private double totalInterest = 0;
    private double totalCashAdvance = 0;
    
    //Default constructor
    public CreditCard()
    {
        cardHolderName = "";
        previousBalance = 0;
        purchase = 0;
        balanceTransfer = 0;
        newBalance = 0;
        fee = 0;
        cashAdvanceInterest = 0;
        cashAdvance = 0;
        numberOfPurchases = 0;
        dayOfMonth = 0;
        minimumPayment = 0;
        creditCardPayment = 0;
    }
    
     //Overloaded constructor
    public CreditCard(String pName, double pOldBalance)
    {
        cardHolderName = pName;
        previousBalance = pOldBalance;
        purchase = 0;
        balanceTransfer = 0;
        newBalance = 0;
        fee = 0;
        cashAdvanceInterest = 0;
        cashAdvance = 0;
        numberOfPurchases = 0;
        dayOfMonth = 0;
        minimumPayment = 0;
        creditCardPayment = 0;
    }
    
    //Accessor methods
    public double getPreviousBalance()
    {
        return previousBalance;
    }
    
    public double getFee()
    {
        return fee;  
    }
    
    public double getTotalInterest()
    {
        return totalInterest;
    }
    
    public double getPurchase()
    {
        return purchase;
    }
    
    public double getBalanceTransfer()
    {
        return balanceTransfer;
    }
    
    public double getCashAdvance()
    {
        return cashAdvance;
    }
    
    public int getNumberOfPurchases()
    {
        return numberOfPurchases;
    }
    
   public String getCardHolderName()
   {
       return cardHolderName;
   }
   
   //Mutator methods
   public void applyCredit(double pApplyCredit)
   {
       NumberFormat fmt = NumberFormat.getCurrencyInstance();
       double applyCredit = 0;
       applyCredit = pApplyCredit;
       if (applyCredit < 0)
       {
           System.out.println("Request Canceled: Provide A Positive Credit Amount To Apply.");
           return;
       }
       totalPurchase = totalPurchase - applyCredit;
       System.out.println("Apply Credit Of " + applyCredit);
       System.out.println("Credit: " +  fmt.format(applyCredit));
   }
   
   public void balanceTransfer(double pBalanceTransfer)
   {
       NumberFormat fmt = NumberFormat.getCurrencyInstance();
       balanceTransfer = pBalanceTransfer;
       if (balanceTransfer < 0)
       {
           System.out.println("Request Canceled: Provide A Positive Balance Transfer Amount.");
           balanceTransfer = 0;
           fee = 0;
           return;
        }
       if (balanceTransfer == 0 || balanceTransfer * 0.03 > 5)
       {
           fee = balanceTransfer * 0.03;
        }
           else
           {
           fee = 5;
        }
       System.out.println("Balance Transfer of " + balanceTransfer);
       System.out.println("Transfer: " + fmt.format(balanceTransfer));
   }
   
   public void purchase(double pAmountPurchase)
   {
       NumberFormat fmt = NumberFormat.getCurrencyInstance();
       purchase = pAmountPurchase;
       totalPurchase = totalPurchase + purchase;
       numberOfPurchases = numberOfPurchases + 1;
       if (purchase < 0)
       {
           System.out.println("Make Purchase Of " + purchase);
           System.out.println("Request Canceled: Provide A Positive Purchase Amount.");
           numberOfPurchases = numberOfPurchases - 1;
           totalPurchase = totalPurchase - purchase;
           return;
       }
       System.out.println("Make Purchase of " + totalPurchase);
       System.out.println("Purchase Amount: " + fmt.format(totalPurchase)); 
   }
   
   public void cashAdvance(double pAmountCashAdvance, int pDayOfMonth)
   {
       NumberFormat fmt = NumberFormat.getCurrencyInstance();
       cashAdvance = pAmountCashAdvance;
       dayOfMonth = pDayOfMonth;
       totalCashAdvance = totalCashAdvance + cashAdvance;
       totalCashAdvanceInterest = totalCashAdvanceInterest + cashAdvanceInterest;
       if (dayOfMonth == 30)
       {
           cashAdvanceInterest = 0.50;
       }
       if (dayOfMonth < 30 && dayOfMonth >= 1 && cashAdvance > 0)
       {
           cashAdvanceInterest = (CASH_ADVANCE_ANNUAL_PERCENTAGE_RATE) * (30 - dayOfMonth + 1);
       }
       if (dayOfMonth > 30 || dayOfMonth < 1)
       {
           cashAdvanceInterest = cashAdvanceInterest + 0.0;
           System.out.println("Cash Advance With Illegal Day (" + cashAdvance + ", " + dayOfMonth + ")");
           System.out.println("Request Cancelled: Provide A Day 1 - 30.");
           return;
       }
       if (cashAdvance < 0)
       {
           cashAdvanceInterest = cashAdvanceInterest + 0.0;
           System.out.println("Cash Advance With Illegal Cash Advance Amount (" + cashAdvance + ", " + dayOfMonth + ")");
           System.out.println("Request Cancelled: Provide A Positive Amount.");
           return;
       }
       System.out.println("Cash Advance Of (" + cashAdvance + ", " + dayOfMonth + ")");
       System.out.println("Cash Advance On Day " + dayOfMonth + ": " + fmt.format(cashAdvance));         
   }
        
        //use instance variableeeee not 0.0015 also why am i calculating from new balance not pevious
    private double calcMinimumPayment()
    {
        if (newBalance * 0.015 > 25)
       {
           minimumPayment = newBalance * 0.015;
       }
       else
       {
            minimumPayment = 25;
       }
       return minimumPayment;
    }
    
    private void resetAmounts()
    {
       newBalance = previousBalance; 
       previousBalance = 0;
       purchase = 0;
       balanceTransfer = 0;
       newBalance = 0;
       fee = 0;
       totalInterest = 0;
       cashAdvance = 0;
       numberOfPurchases = 0;
       dayOfMonth = 0;
       minimumPayment = 0;
    }
    
    private void printStatement()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        calcMinimumPayment();
        System.out.println("Close Billing Period");
        System.out.println("Previous Balance: " + fmt.format(previousBalance));
        System.out.println(numberOfPurchases + " Purchases(s): " + fmt.format(totalPurchase));
        System.out.println("Advances: " + fmt.format(cashAdvance));
        System.out.println("Transfers: " + fmt.format(balanceTransfer));
        System.out.println("Fees: " + fmt.format(fee));
        System.out.println("Interest: " + fmt.format(totalInterest));
        System.out.println("New Balance: " + fmt.format(newBalance));
        System.out.println("Minimum Payment: " + fmt.format(minimumPayment));
    }
    
    public void makePayment(double pPaymentAmount, int pDayOfMonth)
    {
       NumberFormat fmt = NumberFormat.getCurrencyInstance();
       creditCardPayment = pPaymentAmount;
       dayOfMonth = pDayOfMonth;
       calcMinimumPayment();
       if (creditCardPayment < minimumPayment || dayOfMonth > 20)
       {
            previousBalance = previousBalance - creditCardPayment + LATE_PAYMENT_FEE;
       }
       else
       {
          previousBalance = previousBalance - creditCardPayment;
       }
       if (dayOfMonth > 30 || dayOfMonth < 1)
       {
           System.out.println("Payment On Illegal Day (" + creditCardPayment + ", " + dayOfMonth + ")");
           System.out.println("Request Cancelled: Provide A Day 1 - 30.");
           return;
       }
       if (creditCardPayment < 0)
       {
           System.out.println("Illegal Payment Amount (" + creditCardPayment + ", " + dayOfMonth + ")");
           System.out.println("Request Cancelled: Provide A Positive Amount.");
           return;
       }
       System.out.println("Make Payment Of (" + creditCardPayment + ", " + dayOfMonth + ")");
       System.out.println("Payment On Day " + dayOfMonth + ": " + fmt.format(creditCardPayment));
    }
    
    public void closeBillingPeriod()
    {
        totalInterest = totalCashAdvanceInterest + (previousBalance * BALANCE_ANNUAL_PERCENTAGE_RATE);
        newBalance = previousBalance + totalCashAdvanceInterest + balanceTransfer + totalPurchase + cashAdvance + fee;
        printStatement();
        resetAmounts();
    }
   
   
   
   
   
   
   
   
   
   

   public static void main(String arg[])
   {
       CreditCard cc = new CreditCard(); // Testtttttt
       
       cc.purchase(184.95);
       cc.cashAdvance(1000,13);
       cc.cashAdvance(1000,-1);
       cc.balanceTransfer(300);
       cc.purchase(-5);
       cc.applyCredit(45.5);
       
       cc.closeBillingPeriod();
       
       cc.makePayment(500,10);
       
       
       

       
   
    
    }
}