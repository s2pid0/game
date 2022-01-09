package com.s2pido.galaga.model;


import com.badlogic.gdx.graphics.Texture;
import com.s2pido.galaga.control.LaserController;
import com.s2pido.galaga.control.ShipController;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Laser extends GameObject {

    private LaserController laserController;

    public Laser(Texture textureLaser, float x, float y, float width, float height) {
        super(textureLaser, x, y, width, height);
        laserController = new LaserController(bounds);

    }



    public void draw(SpriteBatch batchLaser) {
        super.draw(batchLaser);
        if (LaserController.yl < 9f ){
            laserController.playerFire();
        } else if (LaserController.yl >= 9f) {
            LaserController.yl = ShipController.ys;
            laserController.playerFire();
            LaserController.alienShootTimer -= LaserController.timeBetweenShots;

        }

    }
}
