package fr.greg.space_invaders;

import fr.greg.space_invaders.entities.Brick;
import fr.greg.space_invaders.entities.Ship;
import fr.greg.space_invaders.entities.ShipShot;
import fr.greg.space_invaders.utils.Constants;
import fr.greg.space_invaders.utils.Initialisation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

public class SpaceController {

    private Ship ship;
    private ShipShot shipShot;
    private AnimationTimer timer;
    private int shipDeltaX;
    private List<Brick>  walls;


    @FXML
    private Pane board;

    @FXML
    private Label lblEndGame, lblScore;

    public SpaceController() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                handleShip();

                if(ship.isShipIsShooting()) {
                    handleShipShot();

                }
                shipShotCollisions();



            }
        };

    }

    public void initGame() {
        ship = new Ship(Constants.X_POS_INIT_SHIP,Constants.Y_POS_INIT_SHIP,
                Constants.SHIP_WIDTH, Constants.SHIP_HEIGHT);
        shipShot = new ShipShot(0 - Constants.SHIP_SHOT_WIDTH, 0 - Constants.SHIP_SHOT_HEIGHT,
                Constants.SHIP_SHOT_WIDTH, Constants.SHIP_SHOT_HEIGHT);
        walls = new LinkedList<>();

        lblEndGame.setText("");
    }

    @FXML
    void onStartAction() {
        board.requestFocus();
        initGame();
        Initialisation.initShip(ship, board);
        Initialisation.initShipShot(shipShot, board);
        Initialisation.initWalls(80, 400, 80, walls, board);

        timer.start();
    }

    @FXML
    public void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case LEFT:
                shipDeltaX = - Constants.SHIP_DELTAX;
                handleShip();
                break;
            case RIGHT:
                shipDeltaX = Constants.SHIP_DELTAX;
                handleShip();
                break;
            case SPACE:
                if (!ship.isShipIsShooting()) {
                    ship.setShipIsShooting(true);
                    ShipShot.shipShotPlacement(shipShot, ship);
                }
                break;
        }
    }
    private void handleShip() {
            shipMoveHorizontal(shipDeltaX);
    }

    private void handleShipShot() {
        //Pas de rafale de tir
        if (shipShot.getY() <= -20) {
            ship.setShipIsShooting(false);
        } else if(shipShot.getY() >= -20) {
            shipShot.setY(shipShot.getY() - Constants.SHIP_SHOT_DELTAY);
        }

    }
    private void shipMoveHorizontal(int shipDeltaX) {
        ship.setX(ship.shipMoving(shipDeltaX) + shipDeltaX);
    }


    private void shipShotCollisions() {
        //Colisions avec l'objet Bricks
        try {
        for (Brick brick : walls) {
            if (brick.getBoundsInParent().intersects(shipShot.getBoundsInParent())) {
                //On replace le tir hors du board
                shipShot.setX(-10);
                shipShot.setY(-10);
                //On réautorise à tirer en appuyant sur space
                ship.setShipIsShooting(false);
                //On retire la brick du mur
                walls.removeIf(thisBrick -> thisBrick.equals(brick));
                board.getChildren().remove(brick);
            }
        }
            } catch (ConcurrentModificationException e) {
                System.out.println("Concurrent exception Ship -> Brick");
            }
        }

        
    @FXML
    public void onKeyReleased(KeyEvent keyEvent) {
        shipDeltaX = 0;

    }

    @FXML
    void onStopAction() {
        timer.stop();

    }

}
