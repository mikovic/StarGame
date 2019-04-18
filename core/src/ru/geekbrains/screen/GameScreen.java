package ru.geekbrains.screen;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.ButtonExit;
import ru.geekbrains.sprite.ButtonMenu;
import ru.geekbrains.sprite.ButtonPlay;
import ru.geekbrains.sprite.Ship;
import ru.geekbrains.sprite.Star;

import ru.geekbrains.base.BaseScreen;

public class GameScreen extends BaseScreen {

    private Game game;

    private Texture bg;
    private Background background;
    private TextureAtlas atlas;
    private TextureAtlas atlasMain;
    private Star starList[];

    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;
    private ButtonMenu buttonMenu;
    private Ship ship;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/sky.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        atlasMain = new TextureAtlas("textures/mainAtlas.tpack");
        buttonExit = new ButtonExit(atlas);
        buttonMenu = new ButtonMenu(atlas, game);
        ship = new Ship(atlasMain, "ship");

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        ship.resize(worldBounds);
        buttonExit.resize(worldBounds);
        buttonMenu.resize(worldBounds);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }


    private void draw() {
        batch.begin();
        background.draw(batch);
        ship.draw(batch);
        buttonMenu.draw(batch);
        buttonExit.draw(batch);
        batch.end();
    }

    private void update(float delta) {
        ship.update(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlas.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        buttonExit.touchDown(touch, pointer);
        buttonMenu.touchDown(touch, pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        buttonExit.touchUp(touch, pointer);
        buttonMenu.touchUp(touch, pointer);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        ship.keyDown(keycode);
        return false;
    }
}
