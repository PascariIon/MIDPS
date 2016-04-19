package com.faust.flappy.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.faust.flappy.gamehelpers.AssetLoader;

/**
 * Created by Faust on 4/9/2016.
 */
public class IronMan {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;

    private boolean isAlive;

    private Rectangle boundingRectangle;

    public IronMan(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 350);
        boundingRectangle = new Rectangle();
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }

        if (position.y < -5) {
            position.y = -5;
            velocity.y = 0;
        }

        position.add(velocity.cpy().scl(delta));

        boundingRectangle.set(position.x + 1, position.y + 1, width - 4, height - 2);
    }

    public boolean isFalling() {
        return velocity.y > 110;
    }

    public boolean shouldntFlap() {
        return velocity.y > 70 || !isAlive;
    }


    public void onClick() {
        if (isAlive) {
            AssetLoader.flap.play();
            velocity.y = -100;
        }

    }

    public void die() {
        isAlive = false;
        velocity.y = 0;
    }

    public void decelerate() {
        acceleration.y = 0;
    }


    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public void onRestart(int y) {
        position.y = y;
        velocity.x = 0;
        velocity.y = 0;
        acceleration.x = 0;
        acceleration.y = 350;
        isAlive = true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }
}
