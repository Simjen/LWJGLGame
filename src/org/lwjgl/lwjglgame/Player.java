package org.lwjgl.lwjglgame;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created with The Power of Magic.
 * User: Simon Jensen
 * Date: 23-11-13
 * Time: 21:15
 */
public class Player implements MovingObject {
    private Vector2f mMovementVector;
    private double mDirection;
    private Sprite mPlayerSprite;
    private Position mPlayerPosition;

    public Player(Sprite playerSprite, Position playerPosition){
        mMovementVector = new Vector2f(0,0);
        mDirection = 0;
        mPlayerSprite = playerSprite;
        mPlayerPosition = playerPosition;
    }
    @Override
    public Vector2f getMovement() {
        return mMovementVector;
    }

    @Override
    public void setMovement(Vector2f movementVector) {
        mMovementVector = movementVector;
    }

    @Override
    public double getDirection() {
        return mDirection;
    }


    @Override
    public void updatePosition(long detaTime) {
        mPlayerPosition.updatePosition(mMovementVector , detaTime);
    }

    public void draw(){
        mPlayerSprite.draw(mPlayerPosition.getX(),mPlayerPosition.getY());
    }

}
