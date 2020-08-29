/**
 * 
 */
package main;

import static helper.Artist.quickLoadTexture;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import gui.Statistics;
import gui.TileGrid;

/**
 * @author Joseph
 * @author Kyle
 */  
public class Launcher {
	
	/**Statistics for game.**/
	private Statistics statistics;
	
	/*****************************************************************
    Draws the game window.
    creates the gameboard.
    Creates deliveries to deliver to houses on the map.
    Creates delivery driver.
    Handles keyboard inputs.
    Launcher to the game.
    @param level - game level
    *****************************************************************/
	public void run(final int[][] level) {
		
		helper.Artist.gameWindow();
		
		this.statistics = new Statistics();
		statistics.run();

		TileGrid tileGrid = new TileGrid(level);

		Driver driver = new Driver(quickLoadTexture("truck"), tileGrid.getTile(1, 1), 64, 64, statistics, level);

		///////////////////////////////////////////////////////////////////////////////////////
		ArrayList<Delivery> deliveries = new ArrayList<Delivery>();
		//26 Deliveries, 26 Houses
		deliveries.add(new Delivery('A', 5));
		deliveries.add(new Delivery('B', 4));
		deliveries.add(new Delivery('C', 3));
		deliveries.add(new Delivery('D', 10));
		deliveries.add(new Delivery('E', 15));
		deliveries.add(new Delivery('F', 20));
		deliveries.add(new Delivery('G', 3));
		deliveries.add(new Delivery('H', 7));
		deliveries.add(new Delivery('I', 9));
		deliveries.add(new Delivery('J', 12));
		deliveries.add(new Delivery('K', 14));
		deliveries.add(new Delivery('L', 16));
		deliveries.add(new Delivery('M', 1));
		deliveries.add(new Delivery('N', 2));
		deliveries.add(new Delivery('O', 3));
		deliveries.add(new Delivery('P', 4));
		deliveries.add(new Delivery('Q', 5));
		deliveries.add(new Delivery('R', 7));
		deliveries.add(new Delivery('S', 9));
		deliveries.add(new Delivery('T', 4));
		deliveries.add(new Delivery('U', 4));
		deliveries.add(new Delivery('V', 5));
		deliveries.add(new Delivery('W', 6));
		deliveries.add(new Delivery('X', 6));
		deliveries.add(new Delivery('Y', 1));
		deliveries.add(new Delivery('Z', 2));
		///////////////////////////////////////////////////////////////////////////////////////

		while (!Display.isCloseRequested()) {
			
			tileGrid.drawMap();
			driver.drawDriver();

			while (Keyboard.next()) {
				
				if (Keyboard.getEventKeyState()) {
					
					if (Keyboard.getEventKey() == Keyboard.KEY_W) {
						
						driver.moveUp(tileGrid, deliveries);
						
					} else if (Keyboard.getEventKey() == Keyboard.KEY_A) {
						
						driver.moveLeft(tileGrid, deliveries);
						
					} else if (Keyboard.getEventKey() == Keyboard.KEY_S) {
						
						driver.moveDown(tileGrid, deliveries);
						
					} else if (Keyboard.getEventKey() == Keyboard.KEY_D) {
						
						driver.moveRight(tileGrid, deliveries);
						
					}
					
				}
				
			}
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
	}
	
}
