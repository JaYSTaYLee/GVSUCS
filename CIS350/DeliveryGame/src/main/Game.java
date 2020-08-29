/**
 * 
 */
package main;

import gui.MainMenu;

/**
 * @author Joseph
 * @author Kyle
 */
public final class Game {

	/*****************************************************************
    Private Constructor.
    *****************************************************************/
	private Game() {
		
	}
	
	/*****************************************************************
    Main method to run game.
    @param args - command line arguments
    *****************************************************************/
	public static void main(final String[] args) {
		
		MainMenu mainMenu = new MainMenu();
		mainMenu.run();
		
	}
	
}
