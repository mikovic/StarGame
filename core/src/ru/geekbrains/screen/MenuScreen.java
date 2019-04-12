package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.base.BaseScreen;
public class MenuScreen extends BaseScreen {
    private Vector2 touch;
    private Vector2 pos;
    private Vector2 v;
    protected Texture img;
    protected double len;
    protected  Vector2 vCpyNor;

    @Override
    public void show() {
        super.show();
        touch = new Vector2();
        pos = new Vector2();
        v = new Vector2(0.5f,0.6f);
        len = v.len();
        img = new Texture("badlogic.jpg");
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        pos.add(v);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if(Math.abs(pos.x - touch.x) < Math.abs(v.x) && Math.abs(pos.y - touch.y) < Math.abs(v.y)) {
            v.setZero();
        }

    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touchDown touch.x = " + touch.x + " touch.y = " + touch.y);
        Vector2 dist = touch.cpy().sub(pos);
        dist.nor();
        v = dist.scl((float) len);
        return false;
    }
    @Override
    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);
        Vector2 right = new Vector2();
        Vector2 up = new Vector2();
        right.set(1, 0);
        up.set(0, 1);
        switch(keycode) {
            case 19:
                v = up.scl((float)len );

                break;
            case 20:
                v = up.scl(-1).scl((float)len );
                break;
            case 21:
                v = right.scl(-1).scl((float) len);
                break;
            case 22:
                v = right.scl((float) len);
                break;
        }
        return false;
    }
}
