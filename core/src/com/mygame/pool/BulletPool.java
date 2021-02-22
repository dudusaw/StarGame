package com.mygame.pool;

import com.mygame.base.SpritesPool;
import com.mygame.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

}
