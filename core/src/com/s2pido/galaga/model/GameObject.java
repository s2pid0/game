package com.s2pido.galaga.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;


public abstract class GameObject {

    Rectangle bounds;
    Rectangle boundsColl;
    Sprite object;
    GameObject(Texture texture, float x, float y, float width, float height) {
        object = new Sprite(texture);
        object.setSize(width, height);
        object.setPosition(x, y);
        object.setOrigin(width/2f, height/2f);

        bounds = new Rectangle(0f, 0f, width, height);
        bounds.setPosition(x, y);

        boundsColl = new Rectangle(0f, 0f, width, height);
        boundsColl.setPosition(x, y);
    }

    public void draw(SpriteBatch batch) {
        object.setPosition(bounds.getX(), bounds.getY());

        object.draw(batch);


    }



    public Rectangle getBounds() {
        return bounds;
    }
}
