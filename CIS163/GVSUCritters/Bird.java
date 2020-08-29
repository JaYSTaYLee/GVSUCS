import java.awt.*;
public class Bird extends GVcritter
{
    //Instance Variable - bird direction
    private Direction dir;
    //Constructor
    public Bird(Location loc)
    {
        super(loc);
        setColor(Color.BLUE);
        setSpecies(Species.BIRD);
        //Generate # 1-14
        steps = (int) (Math.random() * 14) + 1;
        //Set initial direction of bird
        getMoveDirection();
    }

    public Attack getAttack(GVcritter opponent)
    {
        return Attack.ROAR;
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
