package com.citizensuite.directories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Manages database operations related to city applications.
 * Provides methods to retrieve, add, and update city applications including universities, venues, and companies.
 */

/**
 *
 * @author srivi
 */
public class CityDirectory {

    private final Connection connection;

    /**
     * Constructor to initialize CityDirectory with a database connection.
     *
     * @param connection The database connection used for all operations.
     */
    public CityDirectory(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves all city applications from the database.
     *
     * @return A ResultSet containing all city applications.
     */
    public ResultSet getAllApplications() {
        String query = "SELECT * FROM city_applications";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getAllApplications: " + e.getMessage());
        }
        return null;
    }

    public int getApprovedApplicationsCount() {
    try {
        PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT COUNT(*) FROM city_applications WHERE application_status = 'Approved'");
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return 0;
}

public int getInReviewApplicationsCount() {
    try {
        PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT COUNT(*) FROM city_applications WHERE application_status = 'In-review'");
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return 0;
}

public int getRejectedApplicationsCount() {
    try {
        PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT COUNT(*) FROM city_applications WHERE application_status = 'Rejected'");
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
     * Retrieves city applications assigned to a specific user.
     *
     * @param username The username of the assignee.
     * @return A ResultSet containing city applications assigned to the user.
     */
    public ResultSet getAllApplicationsByAsignee(String username) {
        String query = "SELECT * FROM city_applications WHERE asignee = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getAllApplicationsByAsignee: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Adds a university to the database, initiated by a system administrator.
     *
     * @param name     The name of the university.
     * @param owner    The owner of the university.
     * @param location The location of the university.
     * @param lat      The latitude of the university.
     * @param lon      The longitude of the university.
     */
    public void addUniversityBySystemAdmin(String name, String owner, String location, double lat, double lon) {
        String query = "INSERT INTO city_applications(name, type, owner, location, lat, lon, asignee, application_status) VALUES (?, 'University', ?, ?, ?, ?, 'N/A', 'Approved')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, owner);
            stmt.setString(3, location);
            stmt.setDouble(4, lat);
            stmt.setDouble(5, lon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in addUniversityBySystemAdmin: " + e.getMessage());
        }
    }

    /**
     * Adds a venue to the database, initiated by a system administrator.
     *
     * @param name     The name of the venue.
     * @param owner    The owner of the venue.
     * @param location The location of the venue.
     * @param lat      The latitude of the venue.
     * @param lon      The longitude of the venue.
     */
    public void addVenueBySystemAdmin(String name, String owner, String location, double lat, double lon) {
        String query = "INSERT INTO city_applications(name, type, owner, location, lat, lon, asignee, application_status) VALUES (?, 'venue', ?, ?, ?, ?, 'N/A', 'Approved')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, owner);
            stmt.setString(3, location);
            stmt.setDouble(4, lat);
            stmt.setDouble(5, lon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in addVenueBySystemAdmin: " + e.getMessage());
        }
    }

 
    /**
     * Adds a company to the database, initiated by a system administrator.
     *
     * @param name     The name of the company.
     * @param owner    The owner of the company.
     * @param location The location of the company.
     * @param lat      The latitude of the company.
     * @param lon      The longitude of the company.
     */
    public void addCompanyBySystemAdmin(String name, String owner, String location, double lat, double lon) {
        String query = "INSERT INTO city_applications(name, type, owner, location, lat, lon, asignee, application_status) VALUES (?, 'Company', ?, ?, ?, ?, 'N/A', 'Approved')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, owner);
            stmt.setString(3, location);
            stmt.setDouble(4, lat);
            stmt.setDouble(5, lon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in addCompanyBySystemAdmin: " + e.getMessage());
        }
    }

    /**
     * Retrieves approved buildings from the database.
     *
     * @return A ResultSet containing approved buildings.
     */
    public ResultSet getApprovedBuildings() {
        String query = "SELECT * FROM city_applications WHERE application_status = 'Approved'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getApprovedBuildings: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves user data including username and role from the database.
     *
     * @return A ResultSet containing user data.
     */
    public ResultSet getUserData() {
        String query = "SELECT username, role FROM users";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getUserData: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Adds a new venue to the database.
     *
     * @param name     The name of the venue.
     * @param owner    The owner of the venue.
     * @param location The location of the venue.
     * @param lat      The latitude of the venue.
     * @param lon      The longitude of the venue.
     * @param user     The username of the person adding the venue.
     */
    public void addVenue(String name, String owner, String location, double lat, double lon, String user) {
        String query = "INSERT INTO city_applications(name, type, owner, location, lat, lon, asignee, application_status) VALUES (?, 'venue', ?, ?, ?, ?, ?, 'Pending')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, owner);
            stmt.setString(3, location);
            stmt.setDouble(4, lat);
            stmt.setDouble(5, lon);
            stmt.setString(6, user);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in add venue: " + e.getMessage());
        }
    }

    /**
     * Retrieves venue data assigned to a specific user.
     *
     * @param user The username of the user.
     * @return A ResultSet containing venue data assigned to the user.
     */
    public ResultSet getVenueData(String user) {
        String query = "SELECT * FROM city_applications WHERE asignee = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getVenueData: " + e.getMessage());
        }
        return null;
    }

    /**
     * Updates the status of a city application.
     *
     * @param id     The ID of the application.
     * @param status The new status of the application.
     */
    public void UpdateStatus(String id, String status) {
        String query = "UPDATE city_applications SET application_status = ? WHERE application_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in UpdateStatus: " + e.getMessage());
        }
    }

    /**
     * Adds a new university to the database.
     *
     * @param name     The name of the university.
     * @param owner    The owner of the university.
     * @param location The location of the university.
     * @param lat      The latitude of the university.
     * @param lon      The longitude of the university.
     * @param user     The username of the person adding the university.
     */
    public void addUniversity(String name, String owner, String location, double lat, double lon, String user) {
        String query = "INSERT INTO city_applications(name, type, owner, location, lat, lon, asignee, application_status) VALUES (?, 'University', ?, ?, ?, ?, ?, 'Pending')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, owner);
            stmt.setString(3, location);
            stmt.setDouble(4, lat);
            stmt.setDouble(5, lon);
            stmt.setString(6, user);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in addUniversity: " + e.getMessage());
        }
    }
}


