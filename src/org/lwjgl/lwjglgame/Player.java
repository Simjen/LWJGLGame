package org.lwjgl.lwjglgame;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Convex;
import org.dyn4j.geometry.Ellipse;
import org.dyn4j.geometry.Mass;
import org.dyn4j.geometry.Vector2;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created with The Power of Magic.
 * User: Simon Jensen
 * Date: 23-11-13
 * Time: 21:15
 */
public class Player implements MovingObject {
    private int mDisplayWidthOffset = Display.getWidth()/2;
    private int mDisplayHeightOffset = Display.getHeight()/2;
    private int mX;
    private int mY;
    private double mDx;
    private double mDy;
    private double mDirection;
    private Sprite mPlayerSprite;
    private TextureLoader textureLoader = new TextureLoader();
    private Convex mPlayerShape;
    private Body mPlayerBody = new Body();

    public Player(){
        mPlayerSprite = new Sprite(textureLoader, "ball.jpg");
        mPlayerShape = new Ellipse(mPlayerSprite.getWidth(),mPlayerSprite.getHeight());
        mPlayerBody.addFixture(new BodyFixture(mPlayerShape));
        mPlayerBody.translate(-mDisplayWidthOffset,-mDisplayHeightOffset);
        mPlayerBody.setMass(Mass.Type.NORMAL);
    }

    @Override
    public Vector2f getMovement() {
        return null;
    }

    @Override
    public double getDirection() {
        return mDirection;
    }

    @Override
    public void setMovement(int x, int y){
        mPlayerBody.setLinearVelocity(x,y);
    }

    public Body getPlayerBody(){
        return mPlayerBody;
    }


    public void draw(){
        int x = (int)mPlayerBody.getTransform().getTranslationX() + mDisplayWidthOffset;
        int y = (int)mPlayerBody.getTransform().getTranslationY() + mDisplayHeightOffset;
        mPlayerSprite.draw(x,y);
    }

}
