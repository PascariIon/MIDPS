package com.faust.flappy.gamehelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


/**
 * Created by Faust on 4/9/2016.
 */
public class AssetLoader {
    public static TextureRegion bg, ground;
    public static Animation ironManAnimation, ironManDancing, ironManFlyingAnimate;
    public static Texture ironMan, ironDancing, ironManFlying;
    public static TextureRegion ironManUp, ironManDown, ironManMiddle, ironManFalling, ironManOnGround;
    public static TextureRegion buildingUp, buildingDown, building;
    public static TextureRegion endTitle;
    public static Sound dead, flap, levelUp;
    public static Music theme;
    public static BitmapFont font, shadow;
    public static Preferences prefs;
    public static TextureRegion logo, gameLogo, playButtonUp, playButtonDown;
    private static Texture bla1;
    private static Texture bla2;

    public static void load() {
        bg = new TextureRegion(new Texture(Gdx.files.internal("anotherCity.png")));
        bg.flip(false, true);
        ironManFalling = new TextureRegion(new Texture(Gdx.files.internal("falling.png")));
        ironManFalling.flip(false, true);
        ground = new TextureRegion(new Texture(Gdx.files.internal("grnd.png")));
        ground.flip(false, true);
        ironMan = new Texture(Gdx.files.internal("animate.png"));
        ironMan.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ironDancing = new Texture(Gdx.files.internal("endAnimation.png"));
        ironDancing.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ironManFlying = new Texture(Gdx.files.internal("animate2.png"));
        ironManFlying.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        ironManUp = new TextureRegion(ironMan, 0, 0, 52, 60);
        ironManUp.flip(false, true);
        ironManMiddle = new TextureRegion(ironMan, 50, 0, 52, 60);
        ironManMiddle.flip(false, true);
        ironManDown = new TextureRegion(ironMan, 92, 0, 52, 60);
        ironManDown.flip(false, true);

        ironManOnGround = new TextureRegion(new Texture(Gdx.files.internal("ground.png")));
        ironManOnGround.flip(false, true);

        TextureRegion[] mainIronMans = {ironManUp, ironManMiddle, ironManDown};
        ironManAnimation = new Animation(0.16f, mainIronMans);
        ironManAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        TextureRegion[] dancingIronMans = new TextureRegion[8];
        for(int i = 0, posX = 0; i < 8; i++, posX += 40){
            dancingIronMans[i] = new TextureRegion(ironDancing, posX, 0, 41, 85);
            dancingIronMans[i].flip(false, true);
        }
        ironManDancing = new Animation(0.10f, dancingIronMans);
        ironManDancing.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        TextureRegion[] flyingIronMans = new TextureRegion[10];
        for(int i = 0, posX=0; i < 10; i++, posX += 98){
            flyingIronMans[i] = new TextureRegion(ironManFlying, posX, 0, 100, 34);
            flyingIronMans[i].flip(false, true);
        }

        ironManFlyingAnimate = new Animation(0.10f, flyingIronMans);
        ironManFlyingAnimate.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        bla1 = new Texture(Gdx.files.internal("toptube.png"));
        buildingUp = new TextureRegion(bla1);
        bla2 = new Texture(Gdx.files.internal("bottomtube.png"));
        buildingDown = new TextureRegion(bla2);

        dead = Gdx.audio.newSound(Gdx.files.internal("dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("flap.wav"));
        levelUp = Gdx.audio.newSound(Gdx.files.internal("coin.wav"));

        theme = Gdx.audio.newMusic(Gdx.files.internal("SuperBonk.mp3"));

        font = new BitmapFont(Gdx.files.internal("text.fnt"));
        font.getData().setScale(.25f, -.20f);
        font.getData().setScale(.15f, -.15f);
        shadow = new BitmapFont(Gdx.files.internal("shadow.fnt"));
        shadow.getData().setScale(.25f, -.20f);
        shadow.getData().setScale(.15f, -.15f);


        gameLogo = new TextureRegion(new Texture(Gdx.files.internal("title2.png")));
        gameLogo.flip(false, true);
        logo = new TextureRegion(new Texture(Gdx.files.internal("title2.png")));

        //gameLogo.flip(false, true);
        playButtonUp = new TextureRegion(new Texture(Gdx.files.internal("playButtonNew.png")));
        playButtonUp.flip(false, true);
        playButtonDown = new TextureRegion(new Texture(Gdx.files.internal("playButtonNewClicked.png")));
        playButtonDown.flip(false, true);

        endTitle = new TextureRegion(new Texture(Gdx.files.internal("gameOver.png")));
        endTitle.flip(false, true);
        prefs = Gdx.app.getPreferences("IronMan");

        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }
    }

    public static void setHighScore(int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    public static int getHighScore() {
        return prefs.getInteger("highScore");
    }

    public static void dispose() {
        ironMan.dispose();
        dead.dispose();
        flap.dispose();
        levelUp.dispose();
        theme.dispose();
        font.dispose();
        shadow.dispose();
        ironDancing.dispose();
        ironManFlying.dispose();
        bla1.dispose();
        bla2.dispose();

    }

}
