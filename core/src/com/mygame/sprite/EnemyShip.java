package com.mygame.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.mygame.base.Ship;
import com.mygame.math.Rect;
import com.mygame.pool.BulletPool;

public class EnemyShip extends Ship {

    public EnemyShip(BulletPool bulletPool, Rect worldBounds, Sound sound) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.sound = sound;
        v = new Vector2(0, -0.5f);
        v0 = new Vector2();
        bulletPos = new Vector2();
        bulletV = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        bulletPos.set(pos.x, pos.y - getHalfHeight());
        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
        if (pos.y <= worldBounds.getTop() - getHalfHeight()) {
            v.set(v0);
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            Vector2 bulletV,
            int damage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(bulletV);
        this.damage = damage;
        this.reloadInterval = reloadInterval;
        setHeightProportion(height);
        this.hp = hp;
    }
}
