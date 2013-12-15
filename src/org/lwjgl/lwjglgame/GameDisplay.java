/**
 * Created with IntelliJ IDEA.
 * User: B
 * Date: 14-11-13
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */

package org.lwjgl.lwjglgame;
import org.dyn4j.collision.AxisAlignedBounds;
import org.dyn4j.dynamics.Capacity;
import org.dyn4j.dynamics.Settings;
import org.dyn4j.dynamics.World;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class GameDisplay {


    private static long timerTicksPerSecond = Sys.getTimerResolution();
    private long mLastUpdateTime = getTime();
    private static boolean isStarted = true;
    private World mWorld;
    private Player simjen;


    public static long getTime(){
        //get Time in miliseconds
        return (Sys.getTime() *1000) / timerTicksPerSecond;
    }

    public void start(){
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();

        } catch (LWJGLException e) {

            e.printStackTrace();

        }
        simjen = new Player();
        setupDyn4J();
        initOpenGL();
        gameLoop();
    }

    private void gameLoop() {
        while(!Display.isCloseRequested()){
            long time = getTime();
            int deltaTime = (int)(time - mLastUpdateTime);
            mLastUpdateTime = time;

            // Clear the screen and depth buffer
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            mWorld.update(deltaTime);
            simjen.draw();
            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }

    private void initOpenGL() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        // enable textures since we're going to use these for our sprites
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        // disable the OpenGL depth test since we're rendering 2D graphics
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glOrtho(0, 800, 0, 600, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    private void setupDyn4J() {
        mWorld = new World(Capacity.DEFAULT_CAPACITY, new AxisAlignedBounds(800,600));
        mWorld.addBody(simjen.getPlayerBody());
    }

    public static void main(String[] args){
        GameDisplay gameDisplay = new GameDisplay();
        gameDisplay.start();

    }

}