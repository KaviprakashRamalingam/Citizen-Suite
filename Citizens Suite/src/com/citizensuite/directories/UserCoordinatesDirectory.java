package com.citizensuite.directories;

import java.util.ArrayList;
import com.citizensuite.model.UserCoordinates;
import java.sql.*;
/**
 *
 * @author kaviprakashramalingam
 */
public class UserCoordinatesDirectory {

    ArrayList<UserCoordinates> list;
    Connection connection;

    public UserCoordinatesDirectory(Connection connection) {
        this.list = new ArrayList<>();
        this.connection = connection;
    }

    public ArrayList<UserCoordinates> getList() {
        return list;
    }

    public void setList(ArrayList<UserCoordinates> list) {
        this.list = list;
    }

   /**
     * Adds a new UserCoordinates object to the list.
     *
     * @return The newly added UserCoordinates object.
     */
    public UserCoordinates addNew() {
        UserCoordinates temp = new UserCoordinates();
        list.add(temp);
        return temp;
    }

 /**
     * Updates the user profile in the database with the provided details.
     *
     * @param fname    The first name of the user.
     * @param lname    The last name of the user.
     * @param email    The email address of the user.
     * @param address  The physical address of the user.
     * @param lat      The latitude coordinate of the user.
     * @param lon      The longitude coordinate of the user.
     * @param username The username of the user.
     */
    public void updateProfile(String fname, String lname, String email, String address, double lat, double lon, String username) {
        String query = "UPDATE users SET firstname = ?, lastname = ?, email = ?, address = ?, lat = ?, lon = ? WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setString(3, email);
            stmt.setString(4, address);
            stmt.setDouble(5, lat);
            stmt.setDouble(6, lon);
            stmt.setString(7, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in updateProfile: " + e.getMessage());
        }
    }

   /**
     * Retrieves user data from the database based on the username.
     *
     * @param name The username of the user to retrieve data for.
     * @return A ResultSet containing the user's data.
     */
    public ResultSet getUserData(String name) {
        String query = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getUserData: " + e.getMessage());
        }
        return null;
    }

      /**
     * Inserts a purchase record for a user associated with a university.
     *
     * @param username The username of the user making the purchase.
     * @param enter    The name of the enterprise associated with the purchase.
     * @param lat      The latitude coordinate of the purchase location.
     * @param lon      The longitude coordinate of the purchase location.
     * @param message  An additional message or note about the purchase.
     */
    public void insert_purchase_university(String username, String enter, double lat, double lon, String message) {
        String query = "INSERT INTO my_applications(username, enterprise, lat, lon, message) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, enter);
            stmt.setDouble(3, lat);
            stmt.setDouble(4, lon);
            stmt.setString(5, message);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in insert_purchase_university: " + e.getMessage());
        }
    }
}
