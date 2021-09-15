package fr.greg.space_invaders.utils;

public class Constants {


    /***************** WINDOW *****************/
    public final static int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600;

    /***************** SHIP ******************/
    public static final int SHIP_WIDTH = 39;
    public static final int SHIP_HEIGHT = 24;


    public static final int X_POS_INIT_SHIP = (WINDOW_WIDTH / 2 - SHIP_WIDTH / 2);
    public static final int Y_POS_INIT_SHIP = 505;
    public static final int SHIP_DELTAX = 3;


    public static final int SHIP_LEFT_WINDOW_LIMIT = 35;
    public static final int SHIP_RIGHT_WINDOW_LIMIT = 528;

    /****************** SHIPSHOT ***************/

    public static final int SHIP_SHOT_WIDTH = 10;
    public static final int SHIP_SHOT_HEIGHT = 10;
    public static final int SHIP_SHOT_DELTAY = 5;

    /****************** BRICK ****************/

    public static final int BRICK_WIDTH = 10;
    public static final int BRICK_HEIGHT = 10;

}
