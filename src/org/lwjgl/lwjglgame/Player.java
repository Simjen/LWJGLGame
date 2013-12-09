package org.lwjgl.lwjglgame;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Convex;
import org.dyn4j.geometry.Ellipse;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created with The Power of Magic.
 * User: Simon Jensen
 * Date: 23-11-13
 * Time: 21:15
 */
public class Player implements MovingObject {
    private int mX;
    private int mY;
    private double mDx;
    private double mDy;
    private double mDirection;
    private Sprite mPlayerSprite;
    private TextureLoader textureLoader = new TextureLoader();
    private Convex mPlayerShape;
    private Body mPlayerBody;

    public Player(int x, int y){
        mDirection = 0;
        mPlayerSprite = new Sprite(textureLoader, "ball.jpg");
        mPlayerShape = new Ellipse(mPlayerSprite.getWidth(),mPlayerSprite.getHeight());
        mPlayerBody = new Body(1);
        mPlayerBody.addFixture(mPlayerShape);

    }
    @Override
    public Vector2f getMovement() {
        return null;
    }

    @Override
    public void setMovement(double dx, double dy) {
        mDx = dx;
        mDy = dy;
    }

    @Override
    public double getDirection() {
        return mDirection;
    }


    @Override
    public void updatePosition(double deltaTime) {
        mX += (int)(mDx * deltaTime)/1000;
        mY += (int)(mDy * deltaTime)/1000;
    }

    @Override
    public Body getBody() {
        return mPlayerBody;
    }

    public void draw(){
        mPlayerSprite.draw(mX,mY);
    }

}
