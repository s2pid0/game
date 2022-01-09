package com.s2pido.galaga.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.s2pido.galaga.view.GameScreen;


public class LaserController  {

    public static float yl, xl;
    public static float alienShootTimer = 0.8f;
    public static float timeBetweenShots = 0.8f;
    public static float velocityL = 30f;
    public static boolean isLaserFlying = true;


    public static Rectangle laserBounds;


    public LaserController(Rectangle laserBounds) {
        this.laserBounds = laserBounds;

    }

    public static boolean playerCanShoot(float deltaC){
        alienShootTimer += deltaC;
        return (alienShootTimer >= timeBetweenShots);
    }



    public void playerFire() {
        if ( yl == ShipController.ys){
            ShipController.xsBuf = ShipController.xs;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && playerCanShoot(GameScreen.deltaC)) {
            yl += velocityL * GameScreen.deltaC;
            laserBounds.setPosition(ShipController.xsBuf+1f, yl+ 0.3f);
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
                LaserController.alienShootTimer -= LaserController.timeBetweenShots;
        } else if (!Gdx.input.isKeyPressed(Input.Keys.SPACE) || !playerCanShoot(GameScreen.deltaC)) {
            yl = ShipController.ys;
            laserBounds.setPosition(ShipController.xs+1f, yl+ 0.3f);

        }
    }

}
