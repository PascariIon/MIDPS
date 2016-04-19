package com.faust.flappy.gamehelpers;

import com.badlogic.gdx.InputProcessor;
import com.faust.flappy.gameobjects.IronMan;
import com.faust.flappy.gameworld.GameWorld;

/**
 * Created by Faust on 4/9/2016.
 */
public class InputHandler implements InputProcessor {
    private IronMan ironMan;
    private GameWorld gameWorld;

    public InputHandler(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        ironMan = gameWorld.getIronMan();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (gameWorld.isReady()) {
            gameWorld.start();
        }

        ironMan.onClick();

        if (gameWorld.isGameOver() || gameWorld.isHighScore()) {
            gameWorld.restart();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
