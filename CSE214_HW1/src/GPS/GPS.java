package hw.cse214.navigation;

public class GPS {

    private Location loc;
    private Location currentLocation, endLocation;
    private double distance;
    private double estimatedTime;

    /*
     * Accessor Methods
     */

    public void setCurrentLocation(Location loc){

        currentLocation = loc;

    }

    public void setDestination(Location loc){

        endLocation = loc;

    }

    public double getCalculatedDistance(){

        return distance;

    }

    public double getArrivalTime(){

        return estimatedTime;

    }

    /**
     * Calculates distance between two points
     * @param currentLocation   (x1,y1) point
     * @param endLocation       (x2,y2) point
     * @return                  shortest distance between two points
     */
    public void calculateDistance(Location currentLocation, Location endLocation){

        int xDist = currentLocation.getXCoordinate() - endLocation.getXCoordinate();
        int yDist = currentLocation.getYCoordinate() - endLocation.getYCoordinate();
        double dist = Math.sqrt((Math.pow(xDist, 2) + Math.pow(yDist, 2)));
        distance = dist;

    }


    /**
     * Calculates time to reach destination
     * @param speed             rate of movement
     *  <dt><b>Preconditions:</b><dd>
     *      speed is positive value
     *
     * @return                  time to reach destination
     */
    public void calculateTime(double speed){

        estimatedTime = (getCalculatedDistance() / speed);

    }


}
