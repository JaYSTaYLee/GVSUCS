public class Geyser
{
    //Instance variables
    private String geyserName;
    private int numberOfEruptions;
    //Constructor
    public Geyser(String name)
    {
        geyserName = name;
        numberOfEruptions = 0;
    }
    //Mutator Method
    public void increment()
    {
        numberOfEruptions++;
    }
    //Accsessor Methods
    public String getName()
    {
        return geyserName;
    }

    public int getNumEruptions()
    {
        return numberOfEruptions;
    }
    //Main Method
    public static void main(String [] args)
    {
        Geyser g = new Geyser("Gucci");
        System.out.println(g.getName());
        System.out.println(g.getNumEruptions());
        g.increment();
        System.out.println(g.getName());
        System.out.println(g.getNumEruptions());
    }
}