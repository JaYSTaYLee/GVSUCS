import java.util.*;
public class Eruption
{
    //Instance Variables
    private int month;
    private int day;
    private int year;
    private int hour;
    private int minute;
    private String geyserName;
    //Constructor
    public Eruption(String info)
    {
        Scanner scan = new Scanner(info);
        scan.useDelimiter("/|,|:");
        month = scan.nextInt();
        day = scan.nextInt();
        year = scan.nextInt();
        geyserName = scan.next();
        hour = scan.nextInt();
        minute = scan.nextInt();
    }
    //Accessor Methods
    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public int getYear()
    {
        return year;
    }

    public int getHour()
    {
        return hour;
    }

    public int getMinute()
    {
        return minute;
    }

    public String getGeyserName()
    {
        return geyserName;
    }
    //Mutator Methods
    public int setMonth()
    {
        month = 0;
        return month;
    }

    public int setDay()
    {
        day = 0;
        return day;
    }

    public int setYear()
    {
        year = 0;
        return year;
    }

    public int setHour()
    {
        hour = 0;
        return hour;
    }

    public int setMinute()
    {
        minute = 0;
        return minute;
    }

    public String setGeyserName()
    {
        geyserName = "null";
        return geyserName;
    }

    public String toString()
    {
        String sentence = "";
        sentence = getGeyserName() + " on " + getMonth() + "/" + getDay() + "/" + getYear() + " at " + getHour() + ":" + getMinute();;
        return sentence;
    }
    //Main Method
    public static void main(String [] args)
    {
        Eruption e = new Eruption("1/15/2010,Old Faithful,16:43");
        System.out.println(e.getMonth());
        System.out.println(e.getDay());
        System.out.println(e.getYear());
        System.out.println(e.getHour());
        System.out.println(e.getMinute());
        System.out.println(e.getGeyserName());
        System.out.println(e.setMonth());
        System.out.println(e.setDay());
        System.out.println(e.setYear());
        System.out.println(e.setHour());
        System.out.println(e.setMinute());
        System.out.println(e.setGeyserName());
        System.out.println(e.toString());
    }
}
