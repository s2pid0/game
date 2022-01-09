package com.s2pido.galaga.control;

import com.s2pido.galaga.model.AlienShip;
import com.badlogic.gdx.math.Rectangle;

import java.util.ListIterator;

import static com.s2pido.galaga.view.GameScreen.alienShipsList;


public class Collision{

    private static int k;

    public static boolean collidesLaser(Rectangle alienShip, Rectangle laser) {
        com.badlogic.gdx.math.Rectangle laserB = LaserController.laserBounds;
        ListIterator<AlienShip> alienShipListIterator = alienShipsList.listIterator();

        return (alienShip.overlaps(LaserController.laserBounds));
    }


    public static boolean collidesShip(Rectangle ship, Rectangle alienShip) {
        com.badlogic.gdx.math.Rectangle shipB = ShipController.shipBounds;
        ListIterator<AlienShip> alienShipListIterator = alienShipsList.listIterator();

        return (alienShip.overlaps(ShipController.shipBounds));
    }
}




