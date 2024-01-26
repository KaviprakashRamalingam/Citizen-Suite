package com.citizensuite.directories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Manages database operations related to the censor board.
 * Provides methods to retrieve, add, and update censor applications.
 */

/**
 *
 * @author srivi
 */
public class CensorBoardDirectory {

    private final Connection connection;

    /**
     * Constructor to initialize CensorBoardDirectory with a database connection.
     *
     * @param connection The database connection used for all operations.
     */
    public CensorBoardDirectory(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves all censor applications from the database.
     *
     * @return A ResultSet containing all censor applications.
     */
    public ResultSet getAllApplications() {
        String query = "SELECT * FROM censor_applications";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getAllApplications: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves next censor applications assigned to a specific user by status.
     *
     * @param user The username of the assignee.
     * @return A ResultSet containing active or pending censor applications for the user.
     */
    public ResultSet populateNextApplicationsByAsignee(String user) {
        String query = "SELECT * FROM censor_applications WHERE username = ? AND (app_status = 'Active' OR app_status = 'Pending') ORDER BY applied_date ASC";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in populateNextApplicationsByAsignee: " + e.getMessage());
        }
        return null;
    }
    
    public int getApplicationCountByStatus(String status) {
    try {
        PreparedStatement st = connection.prepareStatement("SELECT COUNT(*) FROM censor_applications WHERE app_status = ?");
        st.setString(1, status);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return 0;
}
    /**
     * Retrieves censor applications assigned to a specific user.
     *
     * @param username The username of the assignee.
     * @return A ResultSet containing censor applications assigned to the user.
     */
    public ResultSet getApplicationsByAsignee(String username) {
        String query = "SELECT * FROM censor_applications WHERE asignee = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getApplicationsByAsignee: " + e.getMessage());
        }
        return null;
    }

    /**
     * Inserts a new record into the censor applications.
     *
     * @param name         The name of the event.
     * @param dir          The organizer of the event.
     * @param prod         The production sponsor.
     * @param url          The URL for the event.
     * @param venue      The venue where the events will be shown.
     * @param applied_Date The date of application.
     * @param asignee      The assignee for the censor application.
     */
    public void insertRecord(String name, String dir, String prod, String url, String venue, String applied_Date, String asignee) {
        String query = "INSERT INTO censor_applications(venue, event_name, organizer, sponsor, app_status, event_status, applied_date, url, asignee) VALUES (?, ?, ?, ?, 'Active', 'Pending', ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, venue);
            stmt.setString(2, name);
            stmt.setString(3, dir);
            stmt.setString(4, prod);
            stmt.setString(5, applied_Date);
            stmt.setString(6, url);
            stmt.setString(7, asignee);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in insertRecord: " + e.getMessage());
        }
    }

    /**
     * Retrieves all censor administrators from the database.
     *
     * @return An ArrayList containing usernames of censor administrators.
     */
    public ArrayList<String> getAllCensorAdmins() {
        ArrayList<String> list = new ArrayList<>();
        String query = "SELECT username FROM users WHERE role = 'censoradmin'";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.err.println("Error in getAllCensorAdmins: " + e.getMessage());
        }
        return list;
    }

    /**
     * Updates the assignee of a censor application.
     *
     * @param id      The ID of the censor application.
     * @param assignee The new assignee for the application.
     */
    public void updateAssignee(String id, String assignee) {
        String query = "UPDATE censor_applications SET assignee = ? WHERE application_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, assignee);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in updateAssignee: " + e.getMessage());
        }
    }

    /**
     * Updates the status of a censor application.
     *
     * @param id     The ID of the application.
     * @param status The new status of the application.
     */
    public void updateAppStatus(String id, String status) {
        String query = "UPDATE censor_applications SET app_status = ? WHERE application_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in updateAppStatus: " + e.getMessage());
        }
    }

    /**
     * Updates the event status of a censor application.
     *
     * @param id     The ID of the application.
     * @param status The new event status.
     */
    public void updateEventStatus(String id, String status) {
        String query = "UPDATE censor_applications SET event_status = ? WHERE application_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in updateEventStatus: " + e.getMessage());
        }
    }

    /**
     * Inserts a record into the censor applications by an administrator.
     *
     * @param name         The name of the event.
     * @param dir          The organizer of the event.
     * @param prod         The production sponsor.
     * @param url          The URL for the event.
     * @param venue      The venue where the event will be shown.
     * @param applied_Date The date of application.
     */
    public void insertRecordbyAdmin(String name, String dir, String prod, String url, String venue, String applied_Date) {
        String query = "INSERT INTO censor_applications(venue, event_name, organizer, sponsor, app_status, event_status, applied_date, url) VALUES (?, ?, ?, ?, 'Approved', 'U/A', ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, venue);
            stmt.setString(2, name);
            stmt.setString(3, dir);
            stmt.setString(4, prod);
            stmt.setString(5, applied_Date);
            stmt.setString(6, url);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in insertRecordbyAdmin: " + e.getMessage());
        }
    }

    /**
     * Retrieves events from a specific venue.
     *
     * @param venue The name of the venue.
     * @return A ResultSet containing events from the specified venue.
     */
    public ResultSet getEvents(String venue) {
        String query = "SELECT * FROM censor_applications WHERE venue = ? AND app_status = 'Approved'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, venue);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getEvents: " + e.getMessage());
        }
        return null;
    }
}
