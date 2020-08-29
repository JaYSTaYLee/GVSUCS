import java.util.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class GeyserDatabase
{
    //Instance Variables
    private ArrayList<Eruption> eruptionArrayList;
    private ArrayList<Geyser> geyserArrayList;
    //Constructor
    public GeyserDatabase()
    {
        eruptionArrayList = new ArrayList<Eruption>();
        geyserArrayList = new ArrayList<Geyser>();
    }
    //Mutator Methods
    public void readGeyserData(String filename)
    {
        // FIX ME: add a line of code to instantiate a new ArrayList
        //ArrayList readGeyserData = new ArrayList();
        // Attempt to read the complete set of data from a text file
        try
        {
            // open the text file and use a Scanner to read the text
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            String text;
            // keep reading as long as there is more data
            while(sc.hasNext()) 
            {
                text = sc.nextLine();
                // FIX ME: remove this print statement after method works
                //System.out.println(text);
                // FIX ME: instantiate a new Eruption and add to database
                Eruption eruptionList = new Eruption(text);
                //readGeyserData.add(eruptionList);
                eruptionArrayList.add(eruptionList);
                // this should take two lines of code
            }
            sc.close();
        }
        catch(IOException e) 
        {
            System.out.println("Failed to read the data file: " + filename);
        }
        createGeyserList();
        //System.out.println(eruptionArrayList);
        //System.out.println(geyserArrayList);
    }

    public void addEruption(Eruption e)
    {
        eruptionArrayList.add(e);   
    }
    //Accessor Methods
    public ArrayList<Eruption> getEruptionList()
    {
        return eruptionArrayList;
    }

    public ArrayList<Geyser> getGeyserList()
    {
        return geyserArrayList;
    }

    public int getNumEruptions()
    {
        return eruptionArrayList.size();
    }

    public int getNumEruptions(int m, int d, int y)
    {
        int eruptionCount = 0;
        for(int i = 0; i < eruptionArrayList.size(); i++)
        {
            if((eruptionArrayList.get(i).getMonth() == m) && (eruptionArrayList.get(i).getDay() == d) && (eruptionArrayList.get(i).getYear() == y))
            {
                eruptionCount++;
            }
        }
        return eruptionCount;
    }
    
    public Eruption getLateNightEruption()
    {
        int latestHour = 0;
        int latestMinute = 0;
        Eruption latestEruption = new Eruption("1/1/2010,A,10:10");
        for(int i = 0; i < eruptionArrayList.size(); i++)
        {
            if(eruptionArrayList.get(i).getHour() > latestHour)
            {
                latestHour = eruptionArrayList.get(i).getHour();
                latestMinute = eruptionArrayList.get(i).getMinute();
                latestEruption = eruptionArrayList.get(i);
            }
            else if(eruptionArrayList.get(i).getHour() == latestHour)
            {
                if(eruptionArrayList.get(i).getMinute() > latestMinute)
                {
                    latestHour = eruptionArrayList.get(i).getHour();
                    latestMinute = eruptionArrayList.get(i).getMinute();
                    latestEruption = eruptionArrayList.get(i);
                }
            }
        }
        return latestEruption;
    }
    
    public ArrayList<Eruption> getEruptions(String geyser)
    {
        ArrayList<Eruption> matchEruption = new ArrayList<Eruption>();
        for(int i = 0; i < eruptionArrayList.size(); i++)
        {
            if(eruptionArrayList.get(i).getGeyserName().equals(geyser))
            {
                matchEruption.add(eruptionArrayList.get(i));
            }
            else if(eruptionArrayList.get(i).getGeyserName().startsWith(geyser))
            {
                matchEruption.add(eruptionArrayList.get(i));
            }
        }
        return matchEruption;
    }
    
    public String findDayWithMostEruptions(int y)
    {
        int month = 0;
        int day = 0;
        int year = 0;
        int mostEruptions = 0;
        String dayMostEruptions = month + "/" + day + "/" + year + " eruptions: " + mostEruptions;
        for(int m = 1; m <= 12; m++)
        {
            for(int d=1; d <= 31; d++)
            {
                int count = getNumEruptions(m,d,y);
                if(count > mostEruptions)
                {
                    mostEruptions = count;
                    month = m;
                    day = d;
                    year = y;
                }
            }
        }
        dayMostEruptions = month + "/" + day + "/" + year + " eruptions: " + mostEruptions;
        return dayMostEruptions;
    }
    //REVIEW
    private void createGeyserList()
    {
        ArrayList<String>nameList = new ArrayList<String>();
        // create temporary list of unique geyser names
        for(Eruption e : eruptionArrayList)
        {
            if(!nameList.contains(e.getGeyserName()))
            {
                nameList.add(e.getGeyserName());
            }
        }

        // create a list of geysers
        //geyserList = new ArrayList<Geyser>();
        for(String s : nameList)
        {
            Geyser geyserList = new Geyser(s);
            //Eruption eruptionList = new Eruption(text);
            // count number of eruptions for current geyser name
            for(Eruption e: eruptionArrayList)
            {
                if(e.getGeyserName().equals(geyserList.getName()))
                {
                    geyserList.increment();
                }
            }
            geyserArrayList.add(geyserList);
        }
    }

    public int getNumGeysers()
    {
        return geyserArrayList.size();
    }

    public Geyser findMostActiveGeyser()
    {
        Geyser geyserMostEruptions = geyserArrayList.get(0);
        for(Geyser g : geyserArrayList)
        {
            if(g.getNumEruptions() > geyserMostEruptions.getNumEruptions())
            {
                geyserMostEruptions = g;
            }
        }
        return geyserMostEruptions;
    }

    public Geyser findLeastActiveGeyser()
    {
        Geyser geyserLeastEruptions = geyserArrayList.get(0);
        for(Geyser g : geyserArrayList)
        {
            if(g.getNumEruptions() < geyserLeastEruptions.getNumEruptions())
            {
                geyserLeastEruptions = g;
            }
        }
        return geyserLeastEruptions;
    }
}
