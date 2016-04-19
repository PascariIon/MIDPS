package com.faust.flappy.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.faust.flappy.FlappyIronMan;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Flappy Iron-Man";
        config.width = 480;
        config.height = 800;
        config.addIcon("ironHead.png", Files.FileType.Internal);

        new LwjglApplication(new FlappyIronMan(), config);
    }
}
