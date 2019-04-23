package ru.geekbrains.sprite;


import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Message extends Sprite {

    public Message(TextureRegion region) {
        super(region);
    }

    @Override
    public void setHeightProportion(float height) {
        super.setHeightProportion(height);
    }

}
