/**
 * 
 */
package helper;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import java.io.IOException;
import java.io.InputStream;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * @author Joseph
 * @author Kyle
 */
public final class Artist {
	
	/**Width of game window.**/
	public static final int GAME_WINDOW_WIDTH = 1280;
	
	/**Height of game window.**/
	public static final int GAME_WINDOW_HEIGHT = 960;
	
	/*****************************************************************
    Creates window for game.
    *****************************************************************/
	public static void gameWindow() {
		
		Display.setTitle("Delivery Game");

		try {
			
			Display.setDisplayMode(new DisplayMode(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT));
			Display.create();
			
		} catch (LWJGLException e) {
			
			e.printStackTrace();
			
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
	}
	
	/*****************************************************************
    Private Constructor.
    *****************************************************************/
	private Artist() { 
		
	}

	/*****************************************************************
    Draws a quadrilateral texture.
    @param texture - texture to draw
    @param x - coordinate to begin drawing
    @param y - coordinate to begin drawing
    @param width - width of quadrilateral texture to draw
    @param height - height of quadrilateral texture to draw
    *****************************************************************/
	public static void drawQuadTexture(final Texture texture, final int x, final int y, final int width, final int height) {
		
		texture.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glEnd();
		glLoadIdentity();
		
	}

	/*****************************************************************
    Loads a texture from a picture file.
    @param filePath - path to file to load
    @param fileType - type of file to load
    @return - texture loaded from picture file
    *****************************************************************/
	public static Texture loadTexture(final String filePath, final String fileType) {
		
		Texture texture = null;
		InputStream in = ResourceLoader.getResourceAsStream(filePath);

		try {
			
			texture = TextureLoader.getTexture(fileType, in);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}

		return texture;
		
	}

	/*****************************************************************
    Quickloads a texture.
    @param name - name of file
    @return - texture loaded from picture file
    *****************************************************************/
	public static Texture quickLoadTexture(final String name) {
		
		Texture texture = null;
		texture = loadTexture("res/" + name + ".PNG", ".PNG");
		return texture;
		
	}
	
}
