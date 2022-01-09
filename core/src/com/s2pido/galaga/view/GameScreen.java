package com.s2pido.galaga.view;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.s2pido.galaga.Main;
import com.s2pido.galaga.control.*;
import com.s2pido.galaga.model.AlienShip;
import com.s2pido.galaga.model.Laser;
import com.s2pido.galaga.model.Ship;

import java.util.LinkedList;
import java.util.ListIterator;




public class GameScreen extends Game implements Screen{

    private final Main game;
    private Texture shipTexture;
    public static Texture alienshipTexture;
    private Texture laserTexture;
    SpriteBatch batch, batchExit;
    private Ship ship;
    private Laser laser;
    private BitmapFont font;
    private int alienLives;

    private OrthographicCamera camera;
    public static LinkedList<AlienShip> alienShipsList;

    private float timeBetweenSpawns = 3f;
    private float alienSpawnTimer = 0;
    public static float deltaC;
    private float timeBetweenShots;
    private int shipLives = 3;
    public static int score = 0;
    private String scoreText;
    private float alienLaserTimer;

    public GameScreen(Main game) {
        this.game = game;
        alienShipsList = new LinkedList<>();
        font = new BitmapFont();
        scoreText = "score: ";
        font.getData().setScale(0.13f, 0.0556f);

    }



    private void spawnAlien( float deltaC){
        alienSpawnTimer += deltaC;
        if (alienSpawnTimer > timeBetweenSpawns) {
            alienShipsList.add(new AlienShip(alienshipTexture, 0, 5.5f, 2.5f, 2.5f * 1.20f));
            alienSpawnTimer -= timeBetweenSpawns;
        }
    }




    @Override
    public void show() {
        batch = new SpriteBatch();
        batchExit = new SpriteBatch();

        shipTexture = new Texture(Gdx.files.internal("eva.png"));
        shipTexture.setFilter( Texture.TextureFilter.Linear , Texture.TextureFilter.Linear);

        alienshipTexture = new Texture(Gdx.files.internal("ALIEN.png"));
        alienshipTexture.setFilter( Texture.TextureFilter.Linear , Texture.TextureFilter.Linear);

        laserTexture = new Texture(Gdx.files.internal("spear2.png"));
        laserTexture.setFilter( Texture.TextureFilter.Linear , Texture.TextureFilter.Linear);


        ship = new Ship(shipTexture, 0, 0, 2.5f, 2.5f * 1.20f);

        laser = new Laser(laserTexture, 0, 0, 0.7f, 1.4f);

    }


    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        deltaC = delta;

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        spawnAlien(deltaC);
        font.draw(batch, " " + shipLives, -5, 8f);
        ListIterator<AlienShip> alienShipsListIterator = alienShipsList.listIterator();
        while (alienShipsListIterator.hasNext()) {
            AlienShip alienShip = alienShipsListIterator.next();
            AlienShipController.move(alienShip);

            alienShip.draw(batch);







            while (AlienShipController.ys <= -7f) {
                alienShipsListIterator.remove();
                if (alienSpawnTimer > timeBetweenSpawns ) {
                    alienShipsListIterator.remove();
                    AlienShipController.ys = 7;
                }
                AlienShipController.ys = 7;
                alienLives = 0;
            }
            if (AlienShipController.AlienCollide()){
                LaserController.yl = ShipController.ys;
                LaserController.alienShootTimer -= LaserController.timeBetweenShots;
                alienLives += 1;
                if (Collision.collidesShip(ShipController.shipBounds, AlienShipController.AlienShipBounds)){
                    alienLives +=2;
                    shipLives -= 1;
                    if (shipLives < 0){
                        game.setScreen(new GameOverScreen(game));
                    }
                }
                if ( alienLives >=2 ) {
                    alienShipsListIterator.remove();
                    score += 1;
                    if (score % 10 == 0 )
                        shipLives +=1;
                    AlienShipController.ys = 10;
                    alienLives = 0;
                }
                break;
            }

        }



        laser.draw(batch);
        ship.draw(batch);
        font.draw(batch, scoreText + score, -5, -8f);


        batch.end();
        camera.update();
    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        camera = new OrthographicCamera(20f, 20f * aspectRatio);
        camera.zoom = 0.5f;
        camera.update();
    }


    public void pause() {

    }

    public void resume() {

    }

    public void hide() {

    }

    public void dispose() {

        shipTexture.dispose();
        batch.dispose();
    }
}
