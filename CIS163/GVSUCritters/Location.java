public class Location
{
    //Instance Variables
    private int row;
    private int column;
    //Constructor
    public Location(int r, int c)
    {
        row = r;
        column = c;
    }
    //Mutator Method - sets the row number
    public void setRow(int r)
    {
        row = r;
    }
    //Mutator Method - sets the column number
    public void setCol(int c)
    {
        column = c;
    }
    //Accessor Method - returns row number
    public int getRow()
    {
        return row;
    }
    //Accessor Method - returns column number
    public int getCol()
    {
        return column;
    }
}
