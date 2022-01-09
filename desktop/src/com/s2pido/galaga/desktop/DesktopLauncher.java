package com.s2pido.galaga.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.s2pido.galaga.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 240;
		config.height = 450;
		config.resizable = false;
		new LwjglApplication(new Main(), config);
	}
}
