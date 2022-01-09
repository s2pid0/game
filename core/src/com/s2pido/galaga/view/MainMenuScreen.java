package com.s2pido.galaga.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.s2pido.galaga.Main;

public class MainMenuScreen implements Screen {

    private OrthographicCamera camera;
    Main game;
    Texture play, exit;
    SpriteBatch batch;
    public MainMenuScreen(Main game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 240, 450 );
        play = new Texture("PLAYbutton.png");
        exit = new Texture("EXITbutton.png");

    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(exit, 72,200 , 100, 50);
        if (Gdx.input.isTouched() && Gdx.input.getX() > 72 && Gdx.input.getX() < 172 && Gdx.input.getY() > 200 && Gdx.input.getY() < 250){
            Gdx.app.exit();
        }
        batch.draw(play, 72, 245, 100, 50);
        if (Gdx.input.isTouched() && Gdx.input.getX() > 72 && Gdx.input.getX() < 172 && Gdx.input.getY() > 150 && Gdx.input.getY() < 200){
            game.setScreen(new GameScreen(game));
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
