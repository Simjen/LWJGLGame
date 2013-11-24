/**
 * Created with IntelliJ IDEA.
 * User: B
 * Date: 14-11-13
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */

package org.lwjgl.lwjglgame;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;


public class GameDisplay {

    private TextureLoader textureLoader = new TextureLoader();
    private long mLastUpdateTime = System.currentTimeMillis();

    public void start(){
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();

        } catch (LWJGLException e) {

            e.printStackTrace();

        }
        Player simjen = new Player(new Sprite(textureLoader, "ball.jpg"),new Position(100,100));
        simjen.setMovement(new Vector2f(100,100));
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        // enable textures since we're going to use these for our sprites
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        // disable the OpenGL depth test since we're rendering 2D graphics
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glOrtho(0, 800, 0, 600, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        while(!Display.isCloseRequested()){
            long deltaTime = (System.currentTimeMillis() - mLastUpdateTime)/1000;

            // Clear the screen and depth buffer
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glLoadIdentity();
            simjen.draw();
            simjen.updatePosition(deltaTime);
            Display.update();
        }
        Display.destroy();
    }

    public static void main(String[] args){
        GameDisplay gameDisplay = new GameDisplay();
        gameDisplay.start();
    }

}