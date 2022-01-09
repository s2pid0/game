package com.s2pido.galaga.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.s2pido.galaga.control.ShipController;



public class Ship extends GameObject{

    private ShipController shipController;



    public Ship(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        shipController = new ShipController(bounds);


    }




    @Override
    public void draw(SpriteBatch batchShip) {
        super.draw(batchShip);

        shipController.handle();


    }




}
