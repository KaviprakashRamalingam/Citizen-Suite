package com.citizensuite.model;


/**
 *
 * @author Shreeraam Ramachandran
 */
public class UserCoordinates {

    String username;
    double latitude, longitude;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLat() {
        return latitude;
    }

    public void setLat(double lat) {
        this.latitude = lat;
    }

    public double getLon() {
        return longitude;
    }

    public void setLon(double lon) {
        this.longitude = lon;
    }

}
