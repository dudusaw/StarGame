package com.mygame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import com.mygame.base.BaseScreen;
import com.mygame.math.Rect;
import com.mygame.sprite.Background;
import com.mygame.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        logo = new Logo(bg);
    }

    @Override
    public void render(float delta) {
        logo.update(delta);
        Gdx.gl.glClearColor(0.3f, 0.6f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        logo.draw(batch);
        //background.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        logo.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch, pointer, button);
        return false;
    }
}
