package ru.geekbrains.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Badlogic;
import ru.geekbrains.sprite.Badlogic;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture blg;
    private Background background;
    private Badlogic badlogic;




    @Override
    public void show() {
        super.show();
        bg = new Texture("sky.png");
        blg = new Texture("badlogic.jpg");
        background = new Background(new TextureRegion(bg));
        badlogic = new Badlogic(new TextureRegion(blg));

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        badlogic.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        badlogic.update(getTouch());
        badlogic.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        blg.dispose();
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touchDown(getTouch(), pointer);
        return false;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        super.touchDown(touch, pointer);
        badlogic.touchDown(touch, pointer);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        badlogic.keyDown(keycode);
        return false;
    }

    public void update(Vector2 touch) {
        badlogic.update(touch);
    }

}