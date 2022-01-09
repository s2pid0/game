package com.s2pido.galaga.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.s2pido.galaga.view.GameScreen;

public class ShipController {

    public static float ys, xs, xsBuf;
    public static Rectangle shipBounds;
    public static float velocity = 9f;
    private float rotationSpeed = 20f;


    public ShipController(Rectangle shipBounds) {
        this.shipBounds = shipBounds;


    }


    public void handle() {

        if (Gdx.input.isKeyPressed(Input.Keys.W) && ys <= 7f) {

            ys += velocity * GameScreen.deltaC;
            shipBounds.setPosition(xs, ys);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S) && ys >= -7f) {
            ys -= velocity * GameScreen.deltaC;
            shipBounds.setPosition(xs, ys);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && xs <= 2.7f) {
            xs += velocity * GameScreen.deltaC;
            shipBounds.setPosition(xs, ys);

        } else if (Gdx.input.isKeyPressed(Input.Keys.A) && xs >= -5f) {
            xs -= velocity * GameScreen.deltaC;
            shipBounds.setPosition(xs, ys);

        }


    }
}
