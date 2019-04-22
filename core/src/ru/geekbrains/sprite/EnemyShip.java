package ru.geekbrains.sprite;


import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.EnemyPool;
import ru.geekbrains.utils.Regions;

public class EnemyShip extends MainShip {

    private Rect worldBounds;
    private int damage;

    private BulletPool bulletPool;
    private Vector2 v0 = new Vector2(0.03f, 0);

    public EnemyShip(TextureRegion region) {
        super(region);
    }


    public EnemyShip() {
        regions = new TextureRegion[2];
        setTop(0.5f - 0.01f);


    }

    public EnemyShip(TextureAtlas atlas, BulletPool bulletPool) {
        super(atlas.findRegion("enemy1"), 1, 2, 2);
        setHeightProportion(0.3f);
       setTop(0.5f - 0.01f);
    }
    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;

    }

public void setRegions(TextureRegion[] regions){
        this.regions = regions;}
    public void set(
            BulletPool bulletPool,
            float height,
            Rect worldBounds


    ) {

        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        setHeightProportion(height);

    }



    @Override
    public void update(float delta) {
        pos.mulAdd(v0, delta);


    }

    public int getDamage() {
        return damage;
    }

}
