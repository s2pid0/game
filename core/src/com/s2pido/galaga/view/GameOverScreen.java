package com.s2pido.galaga.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.s2pido.galaga.Main;



public class GameOverScreen implements Screen {

    private OrthographicCamera camera;
    Main game;
    static Texture gameOver;
    static Texture exit;
    SpriteBatch batch;
    BitmapFont font;
    public GameOverScreen(Main game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 240, 450 );
        gameOver = new Texture("GAMEOVER.png");
        exit = new Texture("EXITbutton.png");
        font = new BitmapFont();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(0.7f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(exit, 85, 215, 70, 35);
        if (Gdx.input.isTouched() && Gdx.input.getX() > 85 && Gdx.input.getX() < 155 && Gdx.input.getY() > 200 && Gdx.input.getY() < 230){
            Gdx.app.exit();
        }
        batch.draw(gameOver,  75, 260, 90, 70);
        font.draw(batch, "Your score: "+ String.valueOf(GameScreen.score), 80, 200);
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
