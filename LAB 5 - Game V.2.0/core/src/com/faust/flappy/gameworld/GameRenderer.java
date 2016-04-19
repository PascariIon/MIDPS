package com.faust.flappy.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.faust.flappy.gamehelpers.AssetLoader;
import com.faust.flappy.gameobjects.Building;
import com.faust.flappy.gameobjects.Ground;
import com.faust.flappy.gameobjects.IronMan;
import com.faust.flappy.gameobjects.ScrollHandler;

import java.util.Random;

/**
 * Created by Faust on 4/9/2016.
 */
public class GameRenderer {
    private GameWorld gameWorld;
    private OrthographicCamera orthoCam;
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;
    private IronMan ironMan;
    private ScrollHandler scrollHandler;
    private Ground frontGround, backGround;
    private Building building1, building2, building3;
    private TextureRegion bg, ground;
    private Animation ironManAnimation, ironManDancing, ironManFlying;
    private TextureRegion ironManUp, ironManDown, ironManMiddle, ironManFalling, ironManOnGround;
    private TextureRegion playButton;
    private TextureRegion title;
    public static Rectangle rectPlayButton;
    private Random random;
    private int counter = 0;


    private TextureRegion buildingUp, buildingDown, building;
    private Music theme;
    private int midPointY;
    private int gameHeight;

    private int JUMP_SPACE = 35;
    private int i = -10;
    private int j = -150;
    private TextureRegion endTitle;

    public GameRenderer(GameWorld world, int midPointY, int gameHeight) {
        gameWorld = world;
        this.gameHeight = gameHeight;
        this.midPointY = midPointY;
        orthoCam = new OrthographicCamera();
        orthoCam.setToOrtho(true, 136, gameHeight);

        spriteBatch = new SpriteBatch();
        spriteBatch.setProjectionMatrix(orthoCam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(orthoCam.combined);
        rectPlayButton = new Rectangle();
        initGameObjects();
        initAssets();

    }


    public OrthographicCamera getOrthoCam() {
        return orthoCam;
    }

    private void initGameObjects() {
        ironMan = gameWorld.getIronMan();
        scrollHandler = gameWorld.getScrollHandler();
        frontGround = scrollHandler.getFrontGround();
        backGround = scrollHandler.getBackGround();
        building1 = scrollHandler.getBuilding1();
        building2 = scrollHandler.getBuilding2();
        building3 = scrollHandler.getBuilding3();

    }

    private void initAssets() {
        bg = AssetLoader.bg;
        ground = AssetLoader.ground;
        ironManAnimation = AssetLoader.ironManAnimation;
        ironManUp = AssetLoader.ironManUp;
        ironManFalling = AssetLoader.ironManFalling;
        ironManDown = AssetLoader.ironManDown;
        ironManMiddle = AssetLoader.ironManMiddle;
        buildingUp = AssetLoader.buildingUp;
        buildingDown = AssetLoader.buildingDown;
        building = AssetLoader.building;
        ironManOnGround = AssetLoader.ironManOnGround;
        theme = AssetLoader.theme;
        theme.play();
        theme.setVolume(0.06f);
        theme.setLooping(true);
        endTitle = AssetLoader.endTitle;
        playButton = AssetLoader.playButtonUp;
        ironManDancing = AssetLoader.ironManDancing;
        ironManFlying = AssetLoader.ironManFlyingAnimate;
        title = AssetLoader.gameLogo;
    }

    public void drawGround() {
        spriteBatch.draw(ground, frontGround.getX(), frontGround.getY(), frontGround.getWidth(), frontGround.getHeight());
        spriteBatch.draw(ground, backGround.getX(), backGround.getY(), backGround.getWidth(), backGround.getHeight());
    }

    private void drawBuildings() {
        spriteBatch.draw(buildingDown, building1.getX(), building1.getY(), building1.getWidth(),
                building1.getHeight());
        spriteBatch.draw(buildingUp, building1.getX(), building1.getY() + building1.getHeight() + JUMP_SPACE,
                building1.getWidth(), building1.getHeight());

        spriteBatch.draw(buildingDown, building2.getX(), building2.getY(), building2.getWidth(),
                building2.getHeight());
        spriteBatch.draw(buildingUp, building2.getX(), building2.getY() + building2.getHeight() + JUMP_SPACE,
                building2.getWidth(), building2.getHeight());

        spriteBatch.draw(buildingDown, building3.getX(), building3.getY(), building3.getWidth(),
                building3.getHeight());
        spriteBatch.draw(buildingUp, building3.getX(), building3.getY() + building3.getHeight() + JUMP_SPACE,
                building3.getWidth(), building3.getHeight());
    }

    public Color toRGB(int r, int g, int b) {
        float RED = r / 255.0f;
        float GREEN = g / 255.0f;
        float BLUE = b / 255.0f;
        return new Color(RED, GREEN, BLUE, 1);
    }

    public void render(float runTime) {
        //Gdx.app.log("GameRenderer", "render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.disableBlending();
        spriteBatch.draw(bg, 0, 0, orthoCam.viewportWidth, orthoCam.viewportHeight);
        drawBuildings();
        drawGround();

        spriteBatch.enableBlending();


        if (gameWorld.isGroundCollisionHappened()) {
            if (gameWorld.isShouldBeDrawn())
                spriteBatch.draw(ironManOnGround, ironMan.getX(), ironManMiddle.getRegionY() + 25,
                        ironManOnGround.getRegionWidth() / 3, ironManOnGround.getRegionHeight() / 3);
        } else if (gameWorld.isRunning()) {
            if (ironMan.shouldntFlap()) {
                spriteBatch.draw(ironManMiddle, ironMan.getX(), ironMan.getY(),
                        ironMan.getWidth(), ironMan.getHeight());
            } else {
                spriteBatch.draw(ironManAnimation.getKeyFrame(runTime), ironMan.getX(),
                        ironMan.getY(), ironMan.getWidth(),
                        ironMan.getHeight());
            }
        }


        if (gameWorld.isReady())
        {
            spriteBatch.draw(playButton, (136 / 2)
                    - (26), 56, playButton.getRegionWidth() / 2, playButton.getRegionHeight() / 4);
            rectPlayButton.set((136 / 2)
                    - (26), 56, playButton.getRegionWidth() / 2, playButton.getRegionHeight() / 4);

            spriteBatch.draw(title, (136 / 2)
                    - (60), 15, title.getRegionWidth() / 2, title.getRegionHeight() / 4);
            /*AssetLoader.shadow.draw(spriteBatch, "Let`s Begin!", (136 / 2)
                    - (32), 30);
            AssetLoader.font.draw(spriteBatch, "Let`s Begin!", (136 / 2)
                    - (32 - 1), 29);*/

            spriteBatch.draw(ironManDancing.getKeyFrame(runTime), i > 240 ? i = -10 : i++,
                    73, ironMan.getWidth(),
                    ironMan.getHeight() + 10);

            spriteBatch.draw(ironManFlying.getKeyFrame(runTime), j > 240 ? j = -150 : j++,
                    10, ironMan.getWidth() + 30,
                    ironMan.getHeight() - 5);
        } else

        {
            if (gameWorld.isGameOver() || gameWorld.isHighScore()) {
                if (gameWorld.isGameOver()) {
                    spriteBatch.draw(endTitle, 20, 30, endTitle.getRegionWidth() / 2, endTitle.getRegionHeight() / 3);
                    AssetLoader.shadow.draw(spriteBatch, "High Score:", 28, 60);
                    AssetLoader.font.draw(spriteBatch, "High Score:", 29, 59);

                    String highScore = AssetLoader.getHighScore() + "";

                    AssetLoader.shadow.draw(spriteBatch, highScore, 100, 60);
                    AssetLoader.font.draw(spriteBatch, highScore, 101, 59);

                } else {
                    AssetLoader.shadow.draw(spriteBatch, "High Score!", 37, 56);
                    AssetLoader.font.draw(spriteBatch, "High Score!", 36, 55);
                }

                switch (gameWorld.getEndMottoChooser()) {
                    case 0:
                        AssetLoader.shadow.draw(spriteBatch, "Try again?", 39, 76);
                        AssetLoader.font.draw(spriteBatch, "Try again?", 40, 75);
                        break;
                    case 1:
                        AssetLoader.shadow.draw(spriteBatch, gameWorld.isHighScore() ? "Good boy !!" : "Ooh, c`mon!", 35, 76);
                        AssetLoader.font.draw(spriteBatch, gameWorld.isHighScore() ? "Good boy !!" : "Ooh, c`mon!", 36, 75);
                        break;
                    case 2:
                        AssetLoader.shadow.draw(spriteBatch, gameWorld.isHighScore() ? "Not, bad ! ! !" : "Such a looser!", 30, 76);
                        AssetLoader.font.draw(spriteBatch, gameWorld.isHighScore() ? "Not, bad ! ! !" : "Such a looser!", 31, 75);
                        break;
                    case 3:
                        AssetLoader.shadow.draw(spriteBatch, gameWorld.isHighScore() ? "Master..." : "Go home!", 42, 76);
                        AssetLoader.font.draw(spriteBatch, gameWorld.isHighScore() ? "Master..." : "Go home!", 43, 75);
                        break;
                    case 4:
                        AssetLoader.shadow.draw(spriteBatch, gameWorld.isHighScore() ? "Good boy..." : "Try harder?", 35, 76);
                        AssetLoader.font.draw(spriteBatch, gameWorld.isHighScore() ? "Good boy..." : "Try harder?", 36, 75);
                        break;
                    case 5:
                        AssetLoader.shadow.draw(spriteBatch, gameWorld.isHighScore() ? "Marvelous !!!!" : "Bad, very bad...", 28, 76);
                        AssetLoader.font.draw(spriteBatch, gameWorld.isHighScore() ? "Marvelous !!!!" : "Bad, very bad...", 29, 75);
                        break;
                    case 6:
                        AssetLoader.shadow.draw(spriteBatch, gameWorld.isHighScore() ? "Mesmerizing !!!!!" : "It`s not for you!", 28, 76);
                        AssetLoader.font.draw(spriteBatch, gameWorld.isHighScore() ? "Mesmerizing !!!!!" : "It`s not for you!", 29, 75);
                        break;
                }

                String score = Integer.toString(gameWorld.getScore());
                AssetLoader.shadow.draw(spriteBatch, "" + score, (136 / 2) - (3 * score.length()), 12);
                AssetLoader.font.draw(spriteBatch, "" + score, (136 / 2) - (3 * score.length() - 1), 11);
            }

            String score = Integer.toString(gameWorld.getScore());
            AssetLoader.shadow.draw(spriteBatch, "" + score, (136 / 2) - (3 * score.length()), 12);
            AssetLoader.font.draw(spriteBatch, "" + score, (136 / 2) - (3 * score.length() - 1), 11);

        }


        spriteBatch.end();

       /* shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);

        shapeRenderer.rect(ironMan.getBoundingRectangle().x, ironMan.getBoundingRectangle().y, ironMan.getBoundingRectangle().width, ironMan.getBoundingRectangle().height);

        shapeRenderer.rect(building1.getUpBuildingBound().x, building1.getUpBuildingBound().y, building1.getUpBuildingBound().width, building1.getUpBuildingBound().height);
        shapeRenderer.rect(building2.getUpBuildingBound().x, building2.getUpBuildingBound().y, building2.getUpBuildingBound().width, building2.getUpBuildingBound().height);
        shapeRenderer.rect(building3.getUpBuildingBound().x, building3.getUpBuildingBound().y, building1.getUpBuildingBound().width, building3.getUpBuildingBound().height);

        shapeRenderer.rect(building1.getBottomBuildingBound().x, building1.getBottomBuildingBound().y, building1.getBottomBuildingBound().width, building1.getBottomBuildingBound().height);
        shapeRenderer.rect(building2.getBottomBuildingBound().x, building2.getBottomBuildingBound().y, building2.getBottomBuildingBound().width, building2.getBottomBuildingBound().height);
        shapeRenderer.rect(building3.getBottomBuildingBound().x, building3.getBottomBuildingBound().y, building1.getBottomBuildingBound().width, building3.getBottomBuildingBound().height);
        shapeRenderer.rect(gameWorld.getBoundGround().x, gameWorld.getBoundGround().y, gameWorld.getBoundGround().width, gameWorld.getBoundGround().height);

        shapeRenderer.end();*/
    }
}
