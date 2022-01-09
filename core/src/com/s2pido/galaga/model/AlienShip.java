package com.s2pido.galaga.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.s2pido.galaga.control.AlienShipController;
import com.s2pido.galaga.view.GameScreen;


public class AlienShip extends GameObject{

    public static com.s2pido.galaga.control.AlienShipController AlienShipController;
    public float timeBetween = 10f;
    public float lastTime = 2f;
    public float currentX,currentXColl;
    private static float alienLastShoot;
    private static float timeBetweenShots;
    private Texture laserTexture;

    public AlienShip(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        AlienShipController = new AlienShipController(bounds);

        currentX = updateX(GameScreen.deltaC);
        currentXColl = currentX;
    }


    public static boolean alienCanShoot(float deltaC){
        alienLastShoot += deltaC;
        return (alienLastShoot - timeBetweenShots >= 0);
    }






    public float updateX(float deltaC) {
        timeBetween += deltaC;
        float currentX = 0;
        if (timeBetween > lastTime) {
            currentX = AlienShipController.RandX();
            timeBetween -= lastTime;
        }
        return currentX;
    }

    @Override
    public void draw(SpriteBatch batchAlienShip) {
        super.draw(batchAlienShip);

    }
}
