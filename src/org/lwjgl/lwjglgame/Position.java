package org.lwjgl.lwjglgame;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created with The Power of Magic.
 * User: Simon Jensen
 * Date: 23-11-13
 * Time: 21:11
 */
public class Position {
    private int mX;
    private int mY;

    public Position(int x, int y){
        mX = x;
        mY = y;
    }

    public int getX(){
        return mX;
    }

    public int getY(){
        return mY;
    }

    public void updatePosition(Vector2f movementVector, long deltaTime){
        mX =  Float.valueOf(movementVector.getX()).intValue()* Long.valueOf(deltaTime).intValue();
        mY = Float.valueOf(movementVector.getY()).intValue()* Long.valueOf(deltaTime).intValue();

    }
}
