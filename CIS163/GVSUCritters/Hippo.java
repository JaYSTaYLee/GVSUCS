import java.awt.*;
import java.util.Random;
public class Hippo extends GVcritter
{
    //Instance Variable - hippo current direction
    private Direction dir;
    private int hippoAge;
    private Random rand = new Random();
    //Constructor
    public Hippo(Location loc)
    {
        super(loc); 
        setColor(Color.GRAY);
        setSpecies(Species.HIPPO);
        //determine age
        hippoAge = 300 + (int)(Math.random() * ((500 - 300) + 1));
        //Generate # 1-14
        steps = 0;
        //Set initial direction of vulture
        getMoveDirection();
    }

    public Attack getAttack(GVcritter opponent)
    {
        if(steps >= hippoAge)
        {
            return Attack.FORFEIT;
        }
        else
        {
            return Attack.POUNCE;
        }
    }

    public Direction getMoveDirection()
    {
        steps++;
        if(steps % 5 == 0)
        {
            int rDir = rand.nextInt(4) + 1;
            if(rDir == 1)
            {
                dir = Direction.NORTH;	
            }
            else if(rDir == 2)
            {
                dir = Direction.SOUTH;	
            }
            else if(rDir == 3)
            {
                dir = Direction.EAST;	
            }
            else
            {
                dir = Direction.WEST;	
            }
        }
        return dir;
    }
}
