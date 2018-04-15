package edu.neu.genetic.algorithm;

public class City {

    private double longitude;
    private double latitude;
    private String name;
    private int id;

    public City(String name, double latitude, double longitude, int id) {
        this.longitude = Math.toRadians(longitude);
        this.latitude = Math.toRadians(latitude);
        this.name = name;
        this.id = id;
    }

    //return the distance between two latitude/longitude points im kilometres - uses Haversine
    public double distanceTo(City city) {

        double deltaLongitude = city.getLongitude() - this.getLongitude();
        double deltaLatitude = city.getLatitude() - this.getLatitude();

        if (this == city) {
            return 0;//same city
        }
        //implementation of haversin formula
        return (2 * 6371 * Math.asin(Math.sqrt(Math.pow(Math.sin((deltaLatitude) / 2.0), 2) + (Math.cos(this.getLatitude()) * Math.cos(city.getLatitude()) * Math.pow(Math.sin((deltaLongitude) / 2.0), 2)))));
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
