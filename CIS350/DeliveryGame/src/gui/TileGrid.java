/**
 * 
 */
package gui;
import main.House;

/**
 * @author Joseph
 * @author Kyle
 */
public class TileGrid {
	
	/**2D int Tile map.**/
	private int[][] intMap;
	
	/**2D Tile map.**/
	private Tile[][] map;
	
	/**Customer Name.**/
	private char id = 'A';
	
	/*****************************************************************
    Constructor to create a Tile map.
    @param level - user selected level
    *****************************************************************/
	public TileGrid(final int[][] level) {
		
		intMap = new int[15][20];
		
		setMap(level);
		
		map = new Tile[20][15];

		for (int i = 0; i < map.length; ++i) {
			
			for (int j = 0; j < map[i].length; ++j) {
				
				switch (intMap[j][i]) {
				
				case 0:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.grass);
					break;
				case 1:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.road);
					break;
				case 2:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.dirt);
					break;
				case 3:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.water);
					break;
				case 4:
					map[i][j] = new House(i * 64, j * 64, 64, 64, TileType.house, id);
					id++;
					break;
				default:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.grass);
					break;
				}
				
			}
			
		}
		
	}

	/*****************************************************************
    Draws the Tile map.
    *****************************************************************/
	public void drawMap() {
		
		for (int i = 0; i < map.length; ++i) {
			
			for (int j = 0; j < map[i].length; ++j) {
				
				map[i][j].drawTile();
				
			}
			
		}
		
	}

	/*****************************************************************
    Gets a tile at specific index.
    @param xCoord - x coordinate
    @param yCoord - y coordinate
    @return Tile
    *****************************************************************/
	public Tile getTile(final int xCoord, final int yCoord) {
		
		return map[xCoord][yCoord];
		
	}
	
    /*****************************************************************
    Gets a specific map tile number.
    @param x row number
    @param y column number
    @return int at map index
    *****************************************************************/
	public int getMapTileNum(final int x, final int y) {
		
		return intMap[x][y];
		
	}
	
    /*****************************************************************
    Sets map.
    @param map - sets map
    *****************************************************************/
	public void setMap(final int[][] map) {
		
		for (int i = 0; i < intMap.length; ++i) {
			
			for (int j = 0; j < intMap[i].length; ++j) {
				
				intMap[i][j] = map[i][j];
				
			}
			
		}
		
	}
	
}
