package com.faust.flappy.gameobjects;

/**
 * Created by Faust on 4/9/2016.
 */
public class Ground extends Scrollable {
    public Ground(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
    }

    public void onRestart(float x, float scrollSpeed) {
        position.x = x;
        velocity.x = scrollSpeed;
    }
}
