package org.lwjgl.lwjglgame;

/**
 * Created with The Power of Magic.
 * User: Simon Jensen
 * Date: 15-12-13
 * Time: 15:37
 */
public interface Game {

    public long getTime();

    public void update(int deltaTime);
}
