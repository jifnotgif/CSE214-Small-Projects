package hw.cse214.navigation;

public class Location {

    private int xCoord, yCoord;

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Location(int x, int y){

        xCoord = x;
        yCoord = y;

    }

    /*
     * Accessor Methods
     */
    public int getXCoordinate(){

        return xCoord;

    }

    public int getYCoordinate(){

        return yCoord;

    }

}
