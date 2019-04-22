package ru.geekbrains.pool;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Bullet;
import ru.geekbrains.sprite.EnemyShip;
import ru.geekbrains.sprite.MainShip;
import ru.geekbrains.utils.Regions;

public class EnemyPool extends SpritesPool<Sprite> {

    private float reloadInterval = 0.2f;
    private float reloadTimer;
    TextureRegion[] regions;
    BulletPool bulletPool;
    Rect worldBounds;

    public EnemyPool(TextureAtlas atlas, BulletPool bulletPool, Rect worldBounds) {
        this.regions = Regions.split(atlas.findRegion("enemy1"), 1, 2, 2);
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
    }

    public void update(float delta) {
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
            EnemyShip enemyShip = (EnemyShip) this.obtain();
            enemyShip.setRegions(this.regions);
            enemyShip.set(bulletPool, 0.3f, worldBounds);

        }


    }

    @Override
    public void updateActiveSprites(float delta) {


        for (Sprite sprite : activeObjects) {
            if (!sprite.isDestroyed()) {
                sprite.update(delta);
            }
        }
    }


    @Override
    protected EnemyShip newObject() {
        return new EnemyShip();
    }
}


