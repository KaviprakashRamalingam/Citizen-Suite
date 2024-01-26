package com.citizensuite.directories;

import java.util.ArrayList;
import com.citizensuite.model.BuildingCoordinates;

/**
 * Manages a directory of building coordinates.
 * Provides methods to manipulate and access the list of building coordinates.
 */

/**
 *
 * @author srivi
 */
public class BuildingsDirectory {

    private ArrayList<BuildingCoordinates> list;

    /**
     * Constructor to initialize BuildingsDirectory.
     */
    public BuildingsDirectory() {
        this.list = new ArrayList<>();
    }

    /**
     * Gets the list of BuildingCoordinates.
     *
     * @return The list of BuildingCoordinates.
     */
    public ArrayList<BuildingCoordinates> getList() {
        return list;
    }

    /**
     * Sets the list of BuildingCoordinates.
     *
     * @param list The new list of BuildingCoordinates to be set.
     */
    public void setList(ArrayList<BuildingCoordinates> list) {
        this.list = list;
    }

    /**
     * Adds a new BuildingCoordinates object to the list.
     *
     * @return The newly added BuildingCoordinates object.
     */
    public BuildingCoordinates addNew() {
        BuildingCoordinates temp = new BuildingCoordinates();
        list.add(temp);
        return temp;
    }
}
