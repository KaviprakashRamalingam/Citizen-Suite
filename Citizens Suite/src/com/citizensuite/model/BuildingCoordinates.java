package com.citizensuite.model;

/**
 *
 * @author Shreeraam Ramachandran
 */
public class BuildingCoordinates {

    String building;
    int id;
    double latitude, longitude;

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
