package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;;

public class Badlogic extends Sprite {
    protected Vector2 velocity;
    protected double len;

    public Badlogic(TextureRegion region) {
        super(region);
        this.velocity = new Vector2(0.001f, 0.0002f);
        len = this.velocity.len();

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() / 4);
        pos.set(worldBounds.getLeft() + getHalfWidth(), worldBounds.getBottom() + getHalfHeight());

    }

    public void update(Vector2 touch) {
        if (touch.cpy().sub(pos).len() > len || touch.cpy().sub(pos).len() == 0) {
            pos.add(velocity);
        } else {
            pos.set(touch);
            velocity.setZero();
        }

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        Vector2 dist = touch.cpy().sub(pos);
        dist.nor();
        velocity = dist.scl((float) len);
        return false;
    }

    public boolean keyDown(int keycode) {
        System.out.println("keyDown keycode = " + keycode);
        Vector2 right = new Vector2();
        Vector2 up = new Vector2();
        right.set(1, 0);
        up.set(0, 1);
        switch (keycode) {
            case 19:
                this.velocity = up.scl((float) len);
                break;
            case 20:
                this.velocity = up.scl(-1).scl((float) len);
                break;
            case 21:
                this.velocity = right.scl(-1).scl((float) len);
                break;
            case 22:
                this.velocity = right.scl((float) len);
                break;
        }
        return false;
    }


    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
        this.len = this.velocity.len();
    }
}
