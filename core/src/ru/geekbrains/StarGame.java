package ru.geekbrains;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture imgBackGround;
	TextureRegion backGround;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		img = new Texture("badlogic.jpg");
		imgBackGround = new Texture("bike.png");
		backGround = new TextureRegion(imgBackGround, 0, 0, 1920, 760);
		backGround.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 1,1, 1 );
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(backGround, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(img, 100, 100);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
