package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Message extends Sprite {

    public Message(TextureRegion region) {
        super(region);

    }


    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.05f);
        setBottom(worldBounds.getBottom() + 0.5f);
    }

}
