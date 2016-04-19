package com.faust.flappy.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by Faust on 4/9/2016.
 */
public class Building extends Scrollable {

    private Random randGenerator;
    public static final int VERTICAL_GAP = 35;
    private boolean isScored = false;

    public Rectangle getUpBuildingBound() {
        return upBuildingBound;
    }

    public Rectangle getBottomBuildingBound() {
        return bottomBuildingBound;
    }

    private Rectangle upBuildingBound, bottomBuildingBound;


    public Building(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        randGenerator = new Random();
        upBuildingBound = new Rectangle();
        bottomBuildingBound = new Rectangle();
    }

    public void onRestart(float x, float scrollSpeed) {
        velocity.x = scrollSpeed;
        reset(x);
    }

    public boolean collides(IronMan ironMan) {
        if (position.x < ironMan.getX() + ironMan.getWidth()) {
            return (Intersector.overlaps(ironMan.getBoundingRectangle(), upBuildingBound))
                    || (Intersector.overlaps(ironMan.getBoundingRectangle(), bottomBuildingBound));
        }
        return false;
    }

    public boolean isScored() {
        return isScored;
    }

    public void setScored(boolean value) {
        isScored = value;
    }

    @Override
    public void reset(float newX) {
        // Call the reset method in the superclass (Scrollable)
        super.reset(newX);
        // Change the height to a random number
        position.y = (float) ((randGenerator.nextInt(60)) * -1.0);
        height = 70;
        isScored = false;
    }

    @Override
    public void update(float delta) {
        // Call the update method in the superclass (Scrollable)
        super.update(delta);

        upBuildingBound.set(position.x, position.y, width, height);
        bottomBuildingBound.set(position.x, position.y + height + VERTICAL_GAP, width,
                height);


    }
}
