package com.mygame;

import com.badlogic.gdx.Game;

import com.mygame.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen());
	}

}
