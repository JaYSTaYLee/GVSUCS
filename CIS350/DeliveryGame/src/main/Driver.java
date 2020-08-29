/**
 * 
 */
package main;

import java.util.ArrayList;
import org.newdawn.slick.opengl.Texture;

import gui.Statistics;
import gui.Tile;
import gui.TileGrid;

/**
 * @author Joseph
 * @author Kyle
 */
public class Driver {
	
	/**Texture of driver Tile.**/
	private Texture texture;
	
	/**X position driver will start at.**/
	private int x;
	
	/**Y position driver will start at.**/
	private int y;
	
	/**Width of driver Tile.**/
	private int width;
	
	/**Height of driver Tile.**/
	private int height;
	
	/**Map object that contains integer representation of map.**/
	private TileGrid intMap;
	
	/**Statistics object.**/
	private Statistics statistics;

	/*****************************************************************
    Constructor.
    @param texture - texture of driver
    @param startTile - starting tile of driver
    @param width - width of driver tile
    @param height - height of driver tile
    @param statistics - statistics object
    @param level - level
    *****************************************************************/
	public Driver(final Texture texture, final Tile startTile, final int width, final int height, final Statistics statistics, final int[][] level) {
		
		this.texture = texture;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = width;
		this.height = height;
		this.statistics = statistics;
		this.intMap = new TileGrid(level);
		
	}

	/*****************************************************************
    Moves the delivery driver up.
    Checks for and handles collisions.
    Delivers customer packages.
    @param tileGrid - tile grid gameboard
    @param deliveries - arraylist of deliveries
    *****************************************************************/
	public void moveUp(final TileGrid tileGrid, final ArrayList<Delivery> deliveries) {
		
		int yAxis = x / 64;
		int xAxis = y / 64;

		if (y - 64 == -64) {
			
			return;
			
		}
		
		if (intMap.getMapTileNum(xAxis - 1, yAxis) == 0) {
			
			return;
			
		} else if (intMap.getMapTileNum(xAxis - 1, yAxis) == 4) {
			
			House h = (House) tileGrid.getTile(yAxis, xAxis - 1);
			
			for (int i = deliveries.size() - 1; i >= 0; --i) {
				
				if (h.getID() == deliveries.get(i).getID()) {
					
					Delivery.updateTotNumPkgsDelivered(deliveries.get(i).getNumPkgs());
				    statistics.updateStatistics(h.getID(), deliveries.get(i).getNumPkgs(), Delivery.getTotNumPkgsDelivered());
					deliveries.remove(i);
					
				}
				
			}
			
		} else {
			
			if (y - 64 == -64) {
				
				return;
				
			}
			
			y += -64;
			
		}
		
	}

	/*****************************************************************
    Moves the delivery driver left.
    Checks for and handles collisions.
    Delivers customer packages.
    @param tileGrid - tile grid gameboard
    @param deliveries - arraylist of deliveries
    *****************************************************************/
	public void moveLeft(final TileGrid tileGrid, final ArrayList<Delivery> deliveries) {
		
		int yAxis = x / 64;
		int xAxis = y / 64;

		if (x - 64 == -64) {
			
			return;
			
		}
		
		if (intMap.getMapTileNum(xAxis, yAxis - 1) == 0) {
			
			return;
			
		} else if (intMap.getMapTileNum(xAxis, yAxis - 1) == 4) {
			
			House h = (House) tileGrid.getTile(yAxis - 1, xAxis);
			
			for (int i = deliveries.size() - 1; i >= 0; --i) {
				
				if (h.getID() == deliveries.get(i).getID()) {
					
					Delivery.updateTotNumPkgsDelivered(deliveries.get(i).getNumPkgs());
					statistics.updateStatistics(h.getID(), deliveries.get(i).getNumPkgs(), Delivery.getTotNumPkgsDelivered());
					deliveries.remove(i);
					
				}
				
			}
			
		} else {
			
			if (x - 64 == -64) {
				
				return;
				
			}
			
			x += -64;
			
		}
		
	}

	/*****************************************************************
    Moves the delivery driver down.
    Checks for and handles collisions.
    Delivers customer packages.
    @param tileGrid - tile grid gameboard
    @param deliveries - arraylist of deliveries
    *****************************************************************/
	public void moveDown(final TileGrid tileGrid, final ArrayList<Delivery> deliveries) {
		
		int yAxis = x / 64;
		int xAxis = y / 64;

		if (y + 64 == 960) {
			
			return;
			
		}
		
		if (intMap.getMapTileNum(xAxis + 1, yAxis) == 0) {
			
			return;
			
		} else if (intMap.getMapTileNum(xAxis + 1, yAxis) == 4) {
			
			House h = (House) tileGrid.getTile(yAxis, xAxis + 1);
			
			for (int i = deliveries.size() - 1; i >= 0; --i) {
				
				if (h.getID() == deliveries.get(i).getID()) {
					
					Delivery.updateTotNumPkgsDelivered(deliveries.get(i).getNumPkgs());
					statistics.updateStatistics(h.getID(), deliveries.get(i).getNumPkgs(), Delivery.getTotNumPkgsDelivered());
					deliveries.remove(i);
					
				}
				
			}
			
		} else {
			
			if (y + 64 == 960) {
				
				return;
				
			}
			
			y += 64;
			
		}
		
	}

	/*****************************************************************
    Moves the delivery driver right.
    Checks for and handles collisions.
    Delivers customer packages.
    @param tileGrid - tile grid gameboard
    @param deliveries - arraylist of deliveries
    *****************************************************************/
	public void moveRight(final TileGrid tileGrid, final ArrayList<Delivery> deliveries) {
		
		int yAxis = x / 64;
		int xAxis = y / 64;

		if (x + 64 == 1280) {
			
			return;
			
		}
		
		if (intMap.getMapTileNum(xAxis, yAxis + 1) == 0) {
			
			return;
			
		} else if (intMap.getMapTileNum(xAxis, yAxis + 1) == 4) {
			
			House h = (House) tileGrid.getTile(yAxis + 1, xAxis);
			
			for (int i = deliveries.size() - 1; i >= 0; --i) {
				
				if (h.getID() == deliveries.get(i).getID()) {
					
					Delivery.updateTotNumPkgsDelivered(deliveries.get(i).getNumPkgs());
					statistics.updateStatistics(h.getID(), deliveries.get(i).getNumPkgs(), Delivery.getTotNumPkgsDelivered());
					deliveries.remove(i);
					
				}
				
			}
			
		} else {
			
			if (x + 64 == 1280) {
				
				return;
				
			}
			
			x += 64;
			
		}
		
	}

	/*****************************************************************
    Draws the delivery truck on to the tile board.
    *****************************************************************/
	public void drawDriver() {
		
		helper.Artist.drawQuadTexture(texture, x, y, width, height);
		
	}
	
}
