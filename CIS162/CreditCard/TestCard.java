public class TestCard
{
    public static void main(String arg[])
{
    CreditCard cc = new CreditCard();
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
