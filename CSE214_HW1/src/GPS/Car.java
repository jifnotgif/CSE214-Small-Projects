package hw.cse214.navigation;

public class Car {

    private double speed;
    private GPS unitGPS;

    /*
     * Accessor Methods
     */

    public void setGPS(GPS unit){

        unitGPS = unit;

    }

    public GPS getGPS(){

        return unitGPS;

    }

    public void setCurrentSpeed(double s){

        speed = s;

    }

    public double getCurrentSpeed(){

        return speed;

    }
}
