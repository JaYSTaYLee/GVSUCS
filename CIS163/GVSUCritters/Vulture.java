import java.awt.*;
public class Vulture extends GVcritter
{
    //Instance Variable - vulture direction
    private Direction dir;
    //Constructor
    public Vulture(Location loc)
    {
        super(loc); 
        setColor(Color.BLACK);
        setSpecies(Species.VULTURE);
        //Generate # 1-14
        steps = (int) (Math.random() * 14) + 1;
        //Set initial direction of vulture
        getMoveDirection();
    }
    
    public Attack getAttack(GVcritter opponent)
    {
        if(opponent.getSpecies() == GVcritter.Species.HIPPO)
        {
            return Attack.SCRATCH;
        }
        else
        {
            return Attack.ROAR;
        }
    }
    
    public Direction getMoveDirection()
    {
        steps++;
        if(steps % 14 < 4)
        {
            dir = Direction.NORTH;	
        }
        else if(steps % 14 < 7)
        {
            dir = Direction.WEST;
        }
        else if(steps % 14 < 11)
        {
            dir = Direction.SOUTH;
        }
        else 
        {
            dir = Direction.EAST;
        }
        return dir;
    }
}
