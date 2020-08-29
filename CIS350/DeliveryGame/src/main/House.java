/**
 *
 */
package main;

import gui.Tile;
import gui.TileType;

/**
 * @author Joseph
 * @author Kyle
 */
public class House extends Tile {
	
	/**Customers ID.**/
	private char customerID;
	
	/*****************************************************************
    Constructor.
    @param x - start position of tile drawing
    @param y - start position of tile drawing
    @param width - width of House Tile
    @param height - height of House Tile
    @param tileType - type of tile
    @param id - Customers id
    *****************************************************************/
	public House(final int x, final int y, final int width, final int height, final TileType tileType, final char id) {
		
		super(x, y, width, height, tileType);
		this.customerID = id;
		
	}

	/*****************************************************************
    Gets the customer ID.
    @return char - char ID
    *****************************************************************/
	public char getID() {
		
		return customerID;
		
	}
	
}
