package hw.cse214.navigation;

public class NavigationTest {

    public static void main(String[] args){
        Location myCurrentLocation = new Location(354, 538);
        Location myDestination = new Location(108, 25);

        Car myCar = new Car();

        /*
         * Initializing GPS object and setting current and destination locations
         */
        GPS myGPS = new GPS();

        myGPS.setCurrentLocation(myCurrentLocation);
        myGPS.setDestination(myDestination);
        myCar.setGPS(myGPS);

        /*
         * Start the car and set current speed
         */
        myCar.setCurrentSpeed(35.0);
        /*
         * Calculates and shows distance between two points
         */
        myGPS.calculateDistance(myCurrentLocation, myDestination);
        System.out.println("Distance: " + ((GPS) myCar.getGPS()).getCalculatedDistance());
        /*
         * Calculates and shows estimated time to reach destination at given speed
         */

        myGPS.calculateTime(myCar.getCurrentSpeed());
        System.out.println("Arrival : " + ((GPS) myCar.getGPS()).getArrivalTime());
    }
}
