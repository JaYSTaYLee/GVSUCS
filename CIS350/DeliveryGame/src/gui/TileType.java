/**
 * 
 */
package gui;

/**
 * @author Joseph
 * @author Kyle
 */
public enum TileType {
	/**Tile Types.**/
	grass("grass"), dirt("dirt"), road("road"), water("water"), house("house"), truck("truck");
	
	/**Texture name.**/
	private String textureName;

	/*****************************************************************
    Constructor.
    @param textureName - name to name texture
    *****************************************************************/
	TileType(final String textureName) {
		this.textureName = textureName;
	}
	
	/*****************************************************************
    Gets texture name.
    @return textureName
    *****************************************************************/
	public String getTextureName() {
		return textureName;
	}	
}
