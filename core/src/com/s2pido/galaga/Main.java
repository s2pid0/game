package com.s2pido.galaga;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.s2pido.galaga.view.MainMenuScreen;

public class Main extends Game {

	private Screen gameScreen, mainMenu;

	public void create() {

		mainMenu = new MainMenuScreen(this);
		this.setScreen(new MainMenuScreen(this));
		setScreen(mainMenu);



	}
}
