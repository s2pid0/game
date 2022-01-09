package com.s2pido.galaga.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.s2pido.galaga.model.AlienShip;
import com.s2pido.galaga.view.GameScreen;
import java.util.Random;


public class AlienShipController  {

    public static float xs;
    public static float ys = 8f;
    private static float velocity = 9f;

    public static Rectangle AlienShipBounds;


    public AlienShipController(Rectangle AlienShipBounds) {
        this.AlienShipBounds = AlienShipBounds;
    }

    public static Random random = new Random();

    public float RandX(){
        xs = (float) random.nextInt(4 - (-4)) -4;
        return xs;
    }

    public static void move(AlienShip alienShip) {

        if (!Gdx.input.isKeyPressed(Input.Keys.L) ) {
                ys -= velocity* GameScreen.deltaC;
                AlienShipBounds.setPosition(xs, ys);


        }
    }


    public static boolean AlienCollide() {
        if (Collision.collidesLaser(AlienShipBounds, LaserController.laserBounds)){
            LaserController.alienShootTimer -= LaserController.timeBetweenShots;
        }
        return (Collision.collidesLaser(AlienShipBounds, LaserController.laserBounds));
    }





}