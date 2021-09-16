package fr.greg.space_invaders.utils;

import fr.greg.space_invaders.entities.Alien;
import fr.greg.space_invaders.entities.Brick;
import fr.greg.space_invaders.entities.Ship;
import fr.greg.space_invaders.entities.ShipShot;
import javafx.scene.layout.Pane;

import java.util.List;

public class Initialisation {

    public static void initShip(Ship ship, Pane board){

        board.getChildren().add(ship);

        }
    public static void initShipShot(ShipShot shipShot, Pane board) {
        board.getChildren().add(shipShot);
    }

    public static void initWalls(int x, int y, int xNextLine, List<Brick> walls, Pane board) {
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <=6; j++) {
                walls.add(new Brick(x, y, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, Brick.setRandomBrick()));
                x += 10;
            }
            x = xNextLine;
            y += 10;
        }
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <=6; j++) {
                walls.add(new Brick(x +120, y - 40, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, Brick.setRandomBrick()));
                x += 10;
            }
            x = xNextLine;
            y += 10;
        }
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <=6; j++) {
                walls.add(new Brick(x +240, y - 80, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, Brick.setRandomBrick()));
                x += 10;
            }
            x = xNextLine;
            y += 10;
        }
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <=6; j++) {
                walls.add(new Brick(x + 360, y - 120, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT, Brick.setRandomBrick()));
                x += 10;
            }
            x = xNextLine;
            y += 10;
        }
        board.getChildren().addAll(walls);

    }
    public static void initAliens(Alien[][] aliens, Pane board) {
        // On remplit le tableau colonne par colonne
        for(int column = 0; column < 10; column ++) {
            aliens[0][column] = new Alien(Constants.X_POS_INIT_ALIEN + (Constants.ALIEN_WIDTH +
                    Constants.GAP_COLUMNS_ALIENS) * column,
                    Constants.Y_POS_INIT_ALIEN, Constants.ALIEN_WIDTH, Constants.ALIEN_HEIGHT, Images.ALIENHIGH1);
            for(int line = 1; line <3; line++) {
                aliens[line][column] = new Alien(Constants.X_POS_INIT_ALIEN + (Constants.ALIEN_WIDTH +
                        Constants.GAP_COLUMNS_ALIENS) * column,
                        Constants.Y_POS_INIT_ALIEN + (Constants.ALIEN_HEIGHT + Constants.GAP_LINES_ALIEN) * line,
                        Constants.ALIEN_WIDTH, Constants.ALIEN_HEIGHT, Images.ALIENMIDDLE1);
            }
            for(int line = 3; line <5; line++) {
                aliens[line][column] = new Alien (Constants.X_POS_INIT_ALIEN + (Constants.ALIEN_WIDTH +
                        Constants.GAP_COLUMNS_ALIENS) * column,
                        Constants.Y_POS_INIT_ALIEN + (Constants.ALIEN_HEIGHT + Constants.GAP_LINES_ALIEN) * line,
                        Constants.ALIEN_WIDTH, Constants.ALIEN_HEIGHT, Images.ALIENBOTTOM1);
            }
        }
        // Affichage du tableau d'aliens sur le board
        for(int i = 0; i < 5; i++) {
            for(int j =0; j < 10; j++) {
                board.getChildren().addAll(aliens[i][j]);
            }

        }

    }
}
