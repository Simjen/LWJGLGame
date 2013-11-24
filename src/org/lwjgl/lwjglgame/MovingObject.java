package org.lwjgl.lwjglgame;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created with The Power of Magic.
 * User: Simon Jensen
 * Date: 23-11-13
 * Time: 21:05
 */
public interface MovingObject {

    public Vector2f getMovement();

    public void setMovement(Vector2f v);

    public double getDirection();

    public void updatePosition(long detaTime );
}