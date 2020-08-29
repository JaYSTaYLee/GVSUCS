import java.awt.*;
public class Laker extends GVcritter
{
    //Instance Variable - laker direction
    private Direction dir;
    //Constructor
    public Laker(Location loc)
    {
        super(loc);
        setColor(Color.GREEN);
        setSpecies(Species.LAKER);
        //Generate # 1-14
        steps = (int) (Math.random() * 14) + 1;
        //Set initial direction of laker
        getMoveDirection();
    }

    public Attack getAttack(GVcritter opponent)
    {
        return Attack.PUNCH;
    }

    public Direction getMoveDirection()
    {
        steps++;
        if(steps % 14 < 3)
        {
            dir = Direction.NORTH;	
        }
        else if(steps % 14 < 7)
        {
            dir = Direction.EAST;
        }
        else if(steps % 14 < 10)
        {
            dir = Direction.SOUTH;
        }
        else 
        {
            dir = Direction.WEST;
        }
        return dir;
    }
}
