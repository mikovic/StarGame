package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
public class Ship extends Sprite {

    private Vector2 v;
    private Rect worldBounds;

    public Ship(TextureAtlas atlas, String name) {
        super(atlas.findRegion(name));
        setHeightProportion(0.2f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        float posX = 0;
        float posY = worldBounds.getBottom() + getHeight();
        this.pos.set(posX, posY);

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
        if (getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());


    }
    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);

        switch (keycode) {

            case 21:
                pos.x = pos.x - 0.01f;

                break;
            case 22:
               pos.x = pos.x + 0.01f;
        }
        return false;
    }
}
