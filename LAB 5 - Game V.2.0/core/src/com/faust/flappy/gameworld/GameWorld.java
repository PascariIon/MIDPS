package com.faust.flappy.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.faust.flappy.gamehelpers.AssetLoader;
import com.faust.flappy.gameobjects.IronMan;
import com.faust.flappy.gameobjects.ScrollHandler;

import java.util.Random;

/**
 * Created by Faust on 4/9/2016.
 */
public class GameWorld {


    public enum GameState {
        READY, RUNNING, GAMEOVER, HIGHSCORE
    }

    private IronMan ironMan;
    private ScrollHandler scrollHandler;
    private boolean groundCollisionHappened = false;
    private GameState currentState;
    private boolean shouldBeDrawn = false;
    private int endMottoChooser;
    private int animationChooser;
    private Random random;


    public boolean isShouldBeDrawn() {
        return shouldBeDrawn;
    }

    public int getEndMottoChooser() {
        return endMottoChooser;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    private int score = 0;

    public Rectangle getBoundGround() {
        return boundGround;
    }

    private Rectangle boundGround;

    public GameWorld(int midPointY) {
        currentState = GameState.READY;
        ironMan = new IronMan(33, 10, 20, 15);
        scrollHandler = new ScrollHandler(this, midPointY - 10);
        boundGround = new Rectangle(0, midPointY - 10, 136, 11);
        random = new Random();
    }

    public void updateRunning(float delta) {
        if (delta > .15f) {
            delta = .15f;
        }

        ironMan.update(delta);
        scrollHandler.update(delta);

        if (ironMan.isAlive() && scrollHandler.collides(ironMan)) {
            scrollHandler.stop();
            ironMan.die();
            AssetLoader.dead.play();
        }

        groundCollisionHappened = groundCollision();


    }

    public int getAnimationChooser() {
        return animationChooser;
    }

    public void update(float delta) {
        switch (currentState) {
            case READY:
                endMottoChooser = random.nextInt(6);
                animationChooser = random.nextInt(2);
                shouldBeDrawn = false;
                updateReady(delta);
                break;
            case RUNNING:
                shouldBeDrawn = false;
                updateRunning(delta);
                break;
            default:
                break;
        }
    }

    private void updateReady(float delta) {

    }

    public boolean groundCollision() {
        if (Intersector.overlaps(ironMan.getBoundingRectangle(), boundGround)) {
            scrollHandler.stop();
            ironMan.die();
            ironMan.decelerate();
            shouldBeDrawn = true;
            currentState = GameState.GAMEOVER;
            if (score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
            return true;
        } else
            return false;
    }

    public IronMan getIronMan() {
        return ironMan;
    }

    public ScrollHandler getScrollHandler() {
        return scrollHandler;
    }

    public boolean isGroundCollisionHappened() {
        return groundCollisionHappened;
    }

    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public boolean isRunning(){
        return currentState == GameState.RUNNING;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }



    public void restart() {
        currentState = GameState.READY;
        score = 0;
        ironMan.onRestart(10);
        scrollHandler.onRestart();
        currentState = GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
}
