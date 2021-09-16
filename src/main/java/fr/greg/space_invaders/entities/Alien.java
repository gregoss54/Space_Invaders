package fr.greg.space_invaders.entities;

import fr.greg.space_invaders.utils.Constants;
import fr.greg.space_invaders.utils.Utility;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Alien extends Entity {

    private static boolean goRight;
    private static boolean alienPosition = true;

    public Alien(double x, double y, double width, double height, Image image) {
        super(x, y, width, height);
        super.setImg(image);
        super.setImgPattern(new ImagePattern(super.getImg()));
        super.setFill(super.getImgPattern());
    }
    public static void aliensMoving(Alien[][] aliens, int speed) {
        if(goRight) {
            for(int column = 0; column< 10; column ++) {
                for(int line = 0; line < 5; line ++)  {
                    aliens[line][column].setX(aliens[line][column].getX() + Constants.ALIEN_DELTAX);
                }
            }
        } else {
            for(int column = 0; column< 10; column ++) {
                for(int line = 0; line < 5; line ++)  {
                    aliens[line][column].setX(aliens[line][column].getX() - Constants.ALIEN_DELTAX);
                }
            }
        }
        int imageNumber;
        if (alienPosition) {
            imageNumber = 2;
            alienPosition = false;
        }else {
            imageNumber = 1;
            alienPosition = true;
        }
        Utility.displayAlternateAlienImage(aliens, imageNumber);

        // On teste si on est arrivé a la marge du board a gauche ou a droite

        aliensMovingIntoBoard(aliens, speed);

    }

    //Methode qui change le placement des aliens et les descend d'un cran
    public static void aliensMovingIntoBoard(Alien[][] aliens, int speed) {
        if (Utility.aliensTouchRightSide(aliens)) {
            //aliens descendent ET se dirigent dans l'autre sens
            for(int column = 0; column < 10; column++) {
                for(int line = 0; line< 5; line++) {
                    aliens[line][column].setY(aliens[line][column].getY() + Constants.ALIEN_DELtTAY);
                }
            }
            goRight = false;
            if(speed < 10) {
                speed++;
            }
            speed++;
        }else if (Utility.aliensTouchLeftSide(aliens)) {
            //aliens descendent et se dirigent à gauche

            for(int column = 0; column < 10; column++) {
                for(int line = 0; line < 5; line++) {
                    aliens[line][column].setY(aliens[line][column].getY() + Constants.ALIEN_DELtTAY);

                }
            }

            goRight = true;
            if(speed < 10) {
                speed++;
            }
        }
    }
}

