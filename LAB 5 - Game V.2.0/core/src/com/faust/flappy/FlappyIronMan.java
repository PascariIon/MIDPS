package com.faust.flappy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.faust.flappy.gamehelpers.AssetLoader;
import com.faust.flappy.screens.GameScreen;

public class FlappyIronMan extends Game {

    @Override
    public void create() {
        Gdx.app.log("FlappyIronMan", "created");
        AssetLoader.load();
        setScreen(new GameScreen());
    }


    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
