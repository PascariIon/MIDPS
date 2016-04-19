package com.faust.flappy.gameobjects;

import com.faust.flappy.gamehelpers.AssetLoader;
import com.faust.flappy.gameworld.GameWorld;

/**
 * Created by Faust on 4/9/2016.
 */
public class ScrollHandler {
    private Ground frontGround, backGround;
    private Building building1, building2, building3;
    private GameWorld gameWorld;

    public static final int SCROLL_SPEED = -59;
    public static final int BUILDING_GAP = 70;

    public ScrollHandler(GameWorld gameWorld, float yPos) {
        this.gameWorld = gameWorld;
        frontGround = new Ground(0, yPos, 143, 20, SCROLL_SPEED);
        backGround = new Ground(frontGround.getTailX(), yPos, 143, 20, SCROLL_SPEED);

        building1 = new Building(210, 0, 35, 60, SCROLL_SPEED);
        building2 = new Building(building1.getTailX() + BUILDING_GAP, 0, 35, 60, SCROLL_SPEED);
        building3 = new Building(building2.getTailX() + BUILDING_GAP, 0, 35, 60, SCROLL_SPEED);
    }

    public void onRestart() {
        frontGround.onRestart(0, SCROLL_SPEED);
        backGround.onRestart(frontGround.getTailX(), SCROLL_SPEED);
        building1.onRestart(210, SCROLL_SPEED);
        building2.onRestart(building1.getTailX() + BUILDING_GAP, SCROLL_SPEED);
        building3.onRestart(building2.getTailX() + BUILDING_GAP, SCROLL_SPEED);
    }

    public void update(float delta) {
        frontGround.update(delta);
        backGround.update(delta);
        building1.update(delta);
        building2.update(delta);
        building3.update(delta);

        if (building1.isScrolledLeft()) {
            building1.reset(building3.getTailX() + BUILDING_GAP);
        } else if (building2.isScrolledLeft()) {
            building2.reset(building1.getTailX() + BUILDING_GAP);
        } else if (building3.isScrolledLeft()) {
            building3.reset(building2.getTailX() + BUILDING_GAP);
        }

        if (frontGround.isScrolledLeft()) {
            frontGround.reset(backGround.getTailX());
        } else if (backGround.isScrolledLeft()) {
            backGround.reset(frontGround.getTailX());
        }
    }

    public void stop() {
        frontGround.stop();
        backGround.stop();
        building1.stop();
        building2.stop();
        building3.stop();
    }

    private void addScore(int increment) {
        gameWorld.addScore(increment);
    }

    public boolean collides(IronMan ironMan) {
        if (!building1.isScored()
                && building1.getX() + (building1.getWidth() / 2) < ironMan.getX()
                + ironMan.getWidth()) {
            addScore(1);
            building1.setScored(true);
            AssetLoader.levelUp.play();
        } else if (!building2.isScored()
                && building2.getX() + (building2.getWidth() / 2) < ironMan.getX()
                + ironMan.getWidth()) {
            addScore(1);
            building2.setScored(true);
            AssetLoader.levelUp.play();

        } else if (!building3.isScored()
                && building3.getX() + (building3.getWidth() / 2) < ironMan.getX()
                + ironMan.getWidth()) {
            addScore(1);
            building3.setScored(true);
            AssetLoader.levelUp.play();

        }

        return building1.collides(ironMan) || building2.collides(ironMan) || building3.collides(ironMan);
    }

    public Ground getFrontGround() {
        return frontGround;
    }

    public Ground getBackGround() {
        return backGround;
    }

    public Building getBuilding1() {
        return building1;
    }

    public Building getBuilding2() {
        return building2;
    }

    public Building getBuilding3() {
        return building3;
    }

}
