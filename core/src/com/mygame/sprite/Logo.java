package com.mygame.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.mygame.base.Sprite;
import com.mygame.math.Rect;

public class Logo extends Sprite {

    private Vector2 touch;
    private Vector2 v;
    private Vector2 tmp;

    private static final float height = 0.5f;
    private static final float length = 0.01f;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        touch = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(height);
    }

    @Override
    public void update(float delta) {
        tmp.set(touch);
        if (tmp.sub(pos).len() > length) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(this.touch.cpy().sub(pos)).setLength(length);
        return false;
    }
}