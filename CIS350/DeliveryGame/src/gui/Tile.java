/**
 * 
 */
package gui;

import static helper.Artist.quickLoadTexture;
import static helper.Artist.drawQuadTexture;
import org.newdawn.slick.opengl.Texture;

/**
 * @author Joseph
 * @author Kyle
 */                        
public class Tile {
	
	/**X coordinate to begin drawing.**/
	private int x;
	
	/**Y coordinate to begin drawing.**/
	private int y;
	
	/**Width of tile.**/
	private int width;
	
	/**Height of tile.**/
	private int height;
	
	/**Type of tile.**/
	private TileType tileType;
	
	/**Texture of tile.**/
	private Texture texture;

	/*****************************************************************
    Constructor.
    @param x - coordinate of tile
    @param y - coordinate of tile
    @param width - width of tile
    @param height - height of tile
    @param tileType - type of tile
    *****************************************************************/
	public Tile(final int x, final int y, final int width, final int height, final TileType tileType) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.tileType = tileType;
		this.texture = quickLoadTexture(tileType.getTextureName());
		
	}
	
	/*****************************************************************
    Draws a tile.
    *****************************************************************/
	public void drawTile() {
		
		drawQuadTexture(texture, x, y, width, height);
		
	}
	
	/*****************************************************************
    Gets x coordinate.
    @return - x coordinate
    *****************************************************************/
	public int getX() {
		
		return x;
		
	}

	/*****************************************************************
    Gets y coordinate.
    @return - y coordinate
    *****************************************************************/
	public int getY() {
		
		return y;
		
	}
	
	/*****************************************************************
    Gets tileType.
    @return - tileType
    *****************************************************************/
	public TileType getTileType() {
		
		return tileType;
		
	}
	
}
