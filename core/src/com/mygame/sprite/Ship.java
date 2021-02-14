package com.mygame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygame.base.Sprite;
import com.mygame.math.Rect;

public class Ship extends Sprite {
    public Ship(TextureAtlas atlas) {
        super(getRegion(atlas));
    }

    private static TextureRegion getRegion(TextureAtlas atlas) {
        TextureRegion reg = atlas.findRegion("main_ship");
        return new TextureRegion(reg, 0, 0, reg.getRegionWidth()/2, reg.getRegionHeight());
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        pos.y = -0.3f;
    }
}
