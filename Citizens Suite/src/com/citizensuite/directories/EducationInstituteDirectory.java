package com.citizensuite.directories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handles the database operations related to educational institutes. This
 * includes operations for courses, university applications, and other related
 * data.
 */
/**
 *
 * @author kaviprakashramalingam
 */
public class EducationInstituteDirectory {

    private final Connection connection;

    /**
     * Initializes a new instance of the EducationInstituteDirectory with a
     * database connection.
     *
     * @param connection The database connection to be used for all operations.
     */
    public EducationInstituteDirectory(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves all course applications from the database.
     *
     * @return A ResultSet containing all course applications.
     */
    public ResultSet getCourses() {
        String query = "SELECT * FROM course_applications";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getCourses: " + e.getMessage());
        }
        return null;
    }
    
        public ResultSet getCoursesByDay() {
    try {
        String query = "SELECT dayofweek, COUNT(*) AS course_count FROM course_applications GROUP BY dayofweek";
        PreparedStatement st = connection.prepareStatement(query);
        return st.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    /**
     * Adds a course to the database by an administrator.
     *
     * @param uni The university offering the course.
     * @param name The name of the course.
     * @param prof The professor teaching the course.
     * @param dow The days of the week the course is held.
     * @param fileurl The URL for the course description.
     * @param applied_date The date when the course was added.
     */
    public void AddCourseByAdmin(String uni, String name, String prof, String dow, String fileurl, String applied_date) {
        String query = "INSERT INTO course_applications(coursename, university, professor, coursedesc, app_status, applied_date, asignee, dayofweek) VALUES (?, ?, ?, ?, 'Approved', ?, 'N/A', ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, uni);
            stmt.setString(3, prof);
            stmt.setString(4, fileurl);
            stmt.setString(5, applied_date);
            stmt.setString(6, dow);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in AddCourseByAdmin: " + e.getMessage());
        }
    }

    /**
     * Adds a course to the database.
     *
     * @param uni The university offering the course.
     * @param name The name of the course.
     * @param prof The professor teaching the course.
     * @param dow The days of the week the course is held.
     * @param fileurl The URL for the course description.
     * @param applied_date The date when the course was added.
     * @param user The user who added the course.
     */
    public void AddCourse(String uni, String name, String prof, String dow, String fileurl, String applied_date, String user) {
        String query = "INSERT INTO course_applications(coursename, university, professor, coursedesc, app_status, applied_date, asignee, dayofweek) VALUES (?, ?, ?, ?, 'Pending', ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, uni);
            stmt.setString(3, prof);
            stmt.setString(4, fileurl);
            stmt.setString(5, applied_date);
            stmt.setString(6, user);
            stmt.setString(7, dow);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in AddCourse: " + e.getMessage());
        }
    }

    /**
     * Retrieves course applications by assignee from the database.
     *
     * @param user The username of the assignee.
     * @return A ResultSet containing the course applications assigned to the
     * user.
     */
    public ResultSet getCoursesByAsignee(String user) {
        String query = "SELECT * FROM course_applications WHERE asignee = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getCoursesByAsignee: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves users with the role of course registration admin.
     *
     * @return A ResultSet containing the users with the role of course
     * registration admin.
     */
    public ResultSet getAsignees() {
        String query = "SELECT * FROM users WHERE role = 'courseregadmin'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getAsignees: " + e.getMessage());
        }
        return null;
    }

    /**
     * Updates the assignee for a course application.
     *
     * @param name The name of the new assignee.
     * @param id The ID of the course application.
     */
    public void updateAssignee(String name, String id) {
        String query = "UPDATE course_applications SET asignee = ? WHERE application_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in updateAssignee: " + e.getMessage());
        }
    }

    /**
     * Retrieves a list of universities from the database.
     *
     * @return A ResultSet containing approved university applications.
     */
    public ResultSet getUniversities() {
        String query = "SELECT * FROM city_applications WHERE type = 'University' AND application_status = 'Approved'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getUniversities: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves courses from a specific university.
     *
     * @param uni The name of the university.
     * @return A ResultSet containing approved courses from the specified
     * university.
     */
    public ResultSet getCourses(String uni) {
        String query = "SELECT * FROM course_applications WHERE university = ? AND app_status = 'Approved'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, uni);
            stmt.executeQuery();
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getCourses: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves the file URL for a specific course at a university.
     *
     * @param name The name of the course.
     * @param Uni The name of the university.
     * @return The file URL of the course description.
     */
    public String getCourseFile(String name, String Uni) {
        String query = "SELECT coursedesc FROM course_applications WHERE university = ? AND coursename = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, Uni);
            stmt.setString(2, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("coursedesc");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error in getCourseFile: " + e.getMessage());
        }
        return "";
    }

    /**
     * Inserts a university application into the database.
     *
     * @param uni The name of the university.
     * @param course The name of the course applied for.
     * @param user The username of the applicant.
     */
    public void insert_university_application(String uni, String course, String user) {
        String query = "INSERT INTO university_applications(university, username, course, status) VALUES (?, ?, ?, 'Applied')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, uni);
            stmt.setString(2, user);
            stmt.setString(3, course);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in insert_university_application: " + e.getMessage());
        }
    }

    /**
     * Inserts a purchase record associated with a university into the database.
     *
     * @param username The username of the user making the purchase.
     * @param enter The name of the enterprise associated with the purchase.
     * @param lat The latitude of the purchase location.
     * @param lon The longitude of the purchase location.
     * @param message Additional message or note about the purchase.
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

    /**
     * Retrieves coordinates for a given city application.
     *
     * @param name The name of the city.
     * @return A ResultSet containing coordinate data for the specified city.
     */
    public ResultSet getCord(String name) {
        String query = "SELECT * FROM city_applications WHERE name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getCord: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves university applications for a specific user.
     *
     * @param name The username for which to retrieve applications.
     * @return A ResultSet containing the user's university applications.
     */
    public ResultSet get_university_applications(String name) {
        String query = "SELECT * FROM university_applications WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in get_university_applications: " + e.getMessage());
        }
        return null;
    }
}
