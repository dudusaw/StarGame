package com.mygame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import com.mygame.base.Sprite;
import com.mygame.math.Rect;
import com.mygame.math.Rnd;

public class Star extends Sprite {

    protected final Vector2 v;
    private Rect worldBounds;

    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        setHeightProportion(Rnd.nextFloat(0.005f, 0.015f));
        v = new Vector2(Rnd.nextFloat(-0.005f, 0.005f), getHeight() * -10);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        checkBounds();
    }

    public void checkBounds() {
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        if (getTop() < worldBounds.getBottom()) {
            setBottom(worldBounds.getTop());
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        float x = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float y = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(x, y);
    }
}
