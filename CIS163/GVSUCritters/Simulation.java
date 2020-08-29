import java.util.*;
import javax.swing.*;
import java.awt.*;

/****************************************************
 * Simulates a 2D world of critters that move around
 * and fight if they inhabit the same location.
 * 
 * @author Scott Grissom 
 * @version August 2016
 ***************************************************/
public class Simulation extends JPanel{

    /** a 2D world of critters */
    private GVcritter[][] theWorld;

    /** a collection of all live critters */
    private ArrayList <GVcritter> allCritters;

    /** control size of the world */
    private final int ROWS=50, COLUMNS=70, SIZE=10;

    /** number of Ants alive in the simulation */
    private int steps, numAnts, numBirds, numHippos, numVultures, numLakers;

    /****************************************************
    Constructor instantiates and initializes all 
    instance members.
     ****************************************************/
    public Simulation(){
        theWorld = new GVcritter[ROWS][COLUMNS];
        allCritters = new ArrayList<GVcritter>();
        steps=0;
        numAnts=0;
        numBirds=0;
        numHippos=0;
        numVultures=0;
        numLakers=0;
        setPreferredSize(new Dimension(COLUMNS*SIZE, ROWS*SIZE));
    }
    //Accessor Method - returns the stats in a string
    public String getStats()
    {
        String stats = "";
        stats = "Steps: " + steps + "\n" + "Ants: " + numAnts + "\n" + "Birds: " + numBirds + "\n" + "Hippos: " + numHippos + "\n" + "Vultures: " + numVultures + "\n" + "Lakers: " + numLakers; 
        return stats;
    }
    //Service Method - finds a random location with no critter
    private Location getOpenLocation()
    {
        int rRow = (int) (Math.random() * ROWS);
        int rCol = (int) (Math.random() * COLUMNS);
        while(theWorld[rRow][rCol]!= null)
        {
            rRow = (int) (Math.random() * ROWS);
            rCol = (int) (Math.random() * COLUMNS);
        }
        return new Location(rRow, rCol);
    }

    private void placeCritter (GVcritter c)
    {
        allCritters.add(c);
        int row = c.getLocation().getRow();
        int col = c.getLocation().getCol();
        theWorld[row][col] = c;
    }

    private Location getRelativeLocation(Location loc, GVcritter.Direction d)
    {
        if(d == GVcritter.Direction.NORTH)
        {
            int row = loc.getRow();
            int col = loc.getCol();
            if(row != 0)
            {
                return new Location(row - 1, col);
            }
            else
            {
                return new Location(ROWS - 1, col);
            }
        }
        else if(d == GVcritter.Direction.SOUTH)
        {
            int row = loc.getRow();
            int col = loc.getCol();
            if(row != ROWS - 1)
            {
                return new Location(row + 1, col);
            }
            else
            {
                return new Location(0, col);
            }
        }
        else if(d == GVcritter.Direction.EAST)
        {
            int row = loc.getRow();
            int col = loc.getCol();
            if(col != COLUMNS - 1)
            {
                return new Location(row, col + 1);
            }
            else
            {
                return new Location(row, 0);
            }
        }
        // if(d == GVcritter.Direction.WEST)
        else
        {
            int row = loc.getRow();
            int col = loc.getCol();
            if(col != 0)
            {
                return new Location(row, col - 1);
            }
            else
            {
                return new Location(row, COLUMNS - 1);
            }
        }
    }

    /****************************************************
    Add the requested number of Ants into the simulation.
    Repeatedly ask for a random location that is free.
    Increment the number of Ants in the simulation.

    @param num number of ants
     ****************************************************/ 
    public void addAnts(int num){
        numAnts += num;
        for(int i=1;i<=num;i++){
            // create a new Ant at an open location
            Location loc = getOpenLocation();
            Ant c = new Ant(loc);
            placeCritter(c);
        }
    }

    public void addBirds(int num)
    {
        numBirds += num;
        for(int i = 1; i <= num; i++){
            Location loc = getOpenLocation();
            Bird c = new Bird(loc);
            placeCritter(c);
        }
    }

    public void addHippos(int num)
    {
        numHippos += num;
        for(int i = 1; i <= num; i++){
            Location loc = getOpenLocation();
            Hippo c = new Hippo(loc);
            placeCritter(c);
        }
    }

    public void addVultures(int num)
    {
        numVultures += num;
        for(int i = 1; i <= num; i++){
            Location loc = getOpenLocation();
            Vulture c = new Vulture(loc);
            placeCritter(c);
        }
    }

    public void addLakers(int num)
    {
        numLakers += num;
        for(int i = 1; i <= num; i++){
            Location loc = getOpenLocation();
            Laker c = new Laker(loc);
            placeCritter(c);
        }
    }

    /******************************************************
    Move forward on step of the simulation
     *****************************************************/  
    public void oneStep(){

        // shuffle the arraylist of critters for better performance
        Collections.shuffle(allCritters);
        steps++;

        // step throgh all critters using traditional for loop
        for(int i=0; i<allCritters.size(); i++){
            GVcritter attacker = allCritters.get(i);

            // what location does critter want to move to?
            GVcritter.Direction dir = attacker.getMoveDirection();
            Location previousLoc = attacker.getLocation();
            Location nextLoc = getRelativeLocation(previousLoc, dir);  

            // who is at the next location?
            GVcritter defender = theWorld[nextLoc.getRow()][nextLoc.getCol()];

            // no critters here so OK for critter 1 to move
            if(defender == null){
                theWorld[nextLoc.getRow()][nextLoc.getCol()] = attacker;
                attacker.setLocation(nextLoc);
                theWorld[previousLoc.getRow()][previousLoc.getCol()] = null;

                // both critters the same species so peacefully bypass 
            }else if(attacker.getSpecies() == defender.getSpecies()){

                // update critter locations
                attacker.setLocation(nextLoc);
                defender.setLocation(previousLoc);

                // update positions in the world
                theWorld[nextLoc.getRow()][nextLoc.getCol()] = attacker;
                theWorld[previousLoc.getRow()][previousLoc.getCol()] = defender;

                //different species so they fight at location of critter 2
            }else if(attacker.getSpecies() != defender.getSpecies()){
                fight(attacker, defender);
            }
        }

        // update drawing of the world
        repaint();
    }

    public void reset()
    {
        steps = 0;
        numAnts = 0;
        numBirds = 0;
        numHippos = 0;
        numVultures = 0;
        numLakers = 0;
        allCritters.clear();
        for(int i = 0; i < theWorld.length; i++)
        {
            for(int j = 0; j < theWorld[i].length; j++)
            {
                theWorld[i][j] = null;
            }
        }
    }

    private void critterDies(GVcritter c)
    {
        if(c.getSpecies() == GVcritter.Species.ANT)
        {
            numAnts = numAnts - 1;
            allCritters.remove(c);
        }
        else if(c.getSpecies() == GVcritter.Species.BIRD)
        {
            numBirds = numBirds - 1;
            allCritters.remove(c);
        }
        else if(c.getSpecies() == GVcritter.Species.HIPPO)
        {
            numHippos = numHippos - 1;
            allCritters.remove(c);
        }
        else if(c.getSpecies() == GVcritter.Species.VULTURE)
        {
            numVultures = numVultures - 1;
            allCritters.remove(c);
        }
        else if(c.getSpecies() == GVcritter.Species.LAKER)
        {
            numLakers = numLakers - 1;
            allCritters.remove(c);
        }
    }

    private void fight(GVcritter attacker, GVcritter defender)
    {
        double rand = Math.random();

        theWorld[attacker.getLocation().getRow()][attacker.getLocation().getCol()]=null;
        //winning scenarios for defender
        if(attacker.getAttack(defender).equals(defender.getAttack(attacker)) && rand < .5)
        {
            critterDies(attacker);

        }

        else if(attacker.getAttack(defender)==GVcritter.Attack.FORFEIT)
        {
            //Defender wins code
            critterDies(attacker);
        }
        else if(attacker.getAttack(defender)==GVcritter.Attack.ROAR && defender.getAttack(attacker) == GVcritter.Attack.POUNCE)
        {
            //Defender wins code 
            critterDies(attacker);
        }
        else if(attacker.getAttack(defender)==GVcritter.Attack.SCRATCH && defender.getAttack(attacker) == GVcritter.Attack.ROAR)
        {
            //Defender wins code 
            critterDies(attacker);
        }
        else if(attacker.getAttack(defender)==GVcritter.Attack.POUNCE && defender.getAttack(attacker) == GVcritter.Attack.SCRATCH)
        {
            //Defender wins code
            critterDies(defender);
        }
        else if(attacker.getAttack(defender)==GVcritter.Attack.ROAR && defender.getAttack(attacker) == GVcritter.Attack.PUNCH)
        {
            //Defender wins code
            critterDies(attacker);
        }
        else if(attacker.getAttack(defender)==GVcritter.Attack.SCRATCH && defender.getAttack(attacker) == GVcritter.Attack.PUNCH)
        {
            //Defender wins code
            critterDies(attacker);
        }
        else if(attacker.getAttack(defender)==GVcritter.Attack.POUNCE && defender.getAttack(attacker) == GVcritter.Attack.PUNCH)
        {
            //Defender wins code
            critterDies(attacker);
        }
        else
        {
            //attacker wins code
            theWorld[attacker.getLocation().getRow()][attacker.getLocation().getCol()]= defender;
            theWorld[defender.getLocation().getRow()][defender.getLocation().getCol()]= null;
            critterDies(defender);
        }
    }

    /******************************************************
    Step through the 2D world and paint each location white
    (for no critter) or the critter's color.  The SIZE of 
    each location is constant.

    @param g graphics element used for display
     *****************************************************/      
    public void paintComponent(Graphics g){
        for(int row=0; row<ROWS; row++){
            for(int col=0; col<COLUMNS; col++){
                GVcritter c = theWorld[row][col];

                // set color to white if no critter here
                if(c == null){
                    g.setColor(Color.WHITE);
                    // set color to critter color   
                }else{    
                    g.setColor(c.getColor());
                }

                // paint the location
                g.fillRect(col*SIZE, row*SIZE, SIZE, SIZE);
            }
        }
    }
}