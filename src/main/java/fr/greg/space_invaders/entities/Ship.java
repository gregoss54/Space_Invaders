package fr.greg.space_invaders.entities;

import fr.greg.space_invaders.utils.Constants;
import fr.greg.space_invaders.utils.Images;
import javafx.scene.paint.ImagePattern;

public class Ship extends Entity {

    //permet de savoir si le vaisseau tire
    private boolean shipIsShooting;

    public Ship(double x, double y, double width, double height) {
        super(x, y, width, height);
        super.setImgPattern(new ImagePattern(Images.SHIP));
        super.setFill(super.getImgPattern());
        this.shipIsShooting = false;
    }

    public double shipMoving(int shipDeltaX)  {

        //On renvoie la position bornée du vaisseau
        if(shipDeltaX < 0) {
            if(super.getX() < Constants.SHIP_LEFT_WINDOW_LIMIT) {
                super.setX(super.getX() - shipDeltaX);
            }
        } else if (shipDeltaX > 0) {
            if (super.getX() > Constants.SHIP_RIGHT_WINDOW_LIMIT) {
                super.setX(super.getX() - shipDeltaX);
            }
        }
        return super.getX();
    }

        //Getters et setters

    public boolean isShipIsShooting() {
        return shipIsShooting;
    }

    public void setShipIsShooting(boolean shipIsShooting) {
        this.shipIsShooting = shipIsShooting;
    }
}
