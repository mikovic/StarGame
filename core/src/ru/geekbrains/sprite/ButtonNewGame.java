package ru.geekbrains.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.ScaledTouchUpButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;


public class ButtonNewGame extends ScaledTouchUpButton {

    private GameScreen screan;

    public ButtonNewGame (TextureAtlas atlas, GameScreen screen) {
        super(atlas.findRegion("menu2"));
        this.screan = screen;
        setHeightProportion(0.1f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom() + 0.02f);
        setLeft(worldBounds.getLeft() + 0.02f);
    }

    @Override
    protected void action() {
        screan.action();
        ;





    }
}
