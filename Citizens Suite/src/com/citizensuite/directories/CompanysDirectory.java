package com.citizensuite.directories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Manages database operations related to companies. Provides methods to
 * retrieve and manipulate company and job information.
 */

/**
 *
 * @author srivi
 */
public class CompanysDirectory {

    private final Connection connection;

    /**
     * Constructor to initialize CompanysDirectory with a database connection.
     *
     * @param connection The database connection used for all operations.
     */
    public CompanysDirectory(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves the directory of companies from the database.
     *
     * @return A ResultSet containing all companies.
     */
    public ResultSet getCompanyDirectory() {
        String query = "SELECT * FROM companies";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getCompanyDirectory: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves job listings by a specific company.
     *
     * @param comp The name of the company.
     * @return A ResultSet containing job listings for the specified company.
     */
    public ResultSet getJobsByCompany(String comp) {
        String query = "SELECT j.name FROM companies c, jobs j WHERE c.company_id = j.company_id AND c.name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, comp);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getJobsByCompany: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves the job description for a specific role in a company.
     *
     * @param comp The name of the company.
     * @param role The name of the job role.
     * @return A ResultSet containing the description of the job.
     */
    public ResultSet getJobDescription(String comp, String role) {
        String query = "SELECT j.description FROM companies c, jobs j WHERE c.company_id = j.company_id AND c.name = ? AND j.name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, comp);
            stmt.setString(2, role);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getJobDescription: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves applications submitted by a specific user.
     *
     * @param username The username of the applicant.
     * @return A ResultSet containing the user's applications.
     */
    public ResultSet getApplicationByUser(String username) {
        String query = "SELECT * FROM applications WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getApplicationByUser: " + e.getMessage());
        }
        return null;
    }

    /**
     * Withdraws a job application by its ID.
     *
     * @param id The ID of the application to be withdrawn.
     */
    public void withdrawApplication(String id) {
        String query = "UPDATE applications SET status = 'Withdrawn' WHERE application_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in withdrawApplication: " + e.getMessage());
        }
    }

    /**
     * Adds a new job listing by an admin.
     *
     * @param comp The company for the job.
     * @param role The role of the job.
     * @param desc The description of the job.
     * @param applied_date The date when the job was listed.
     */
    public void addNewJobByAdmin(String comp, String role, String desc, String applied_date) {
        String query = "INSERT INTO company_jobs(company, role, roledesc, app_status, asignee, applied_date, applied_by) VALUES(?, ?, ?, 'Approved', 'N/A', ?, 'sysadmin')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, comp);
            stmt.setString(2, role);
            stmt.setString(3, desc);
            stmt.setString(4, applied_date);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in addNewJobByAdmin: " + e.getMessage());
        }
    }

    /**
     * Adds a new job listing.
     *
     * @param comp The company for the job.
     * @param role The role of the job.
     * @param desc The description of the job.
     * @param applied_date The date when the job was listed.
     * @param asignee The assignee for the job application.
     * @param user The user who added the job listing.
     */
    public void addNewJob(String comp, String role, String desc, String applied_date, String asignee, String user) {
        String query = "INSERT INTO company_jobs(company, role, roledesc, app_status, asignee, applied_date, applied_by) VALUES(?, ?, ?, 'Pending', ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, comp);
            stmt.setString(2, role);
            stmt.setString(3, desc);
            stmt.setString(4, applied_date);
            stmt.setString(5, asignee);
            stmt.setString(6, user);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in addNewJob: " + e.getMessage());
        }
    }

    /**
     * Retrieves all job applications submitted by a specific person.
     *
     * @param uname The username of the person who applied for the jobs.
     * @return A ResultSet containing job applications submitted by the user.
     */
    public ResultSet getAllJobsByAppliedPerson(String uname) {
        String query = "SELECT * FROM company_jobs WHERE applied_by = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, uname);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getAllJobsByAppliedPerson: " + e.getMessage());
        }
        return null;
    }

    /**
     * Adds a new company to the database.
     *
     * @param name The name of the company.
     * @param owner The owner of the company.
     * @param location The location of the company.
     * @param lat The latitude of the company's location.
     * @param lon The longitude of the company's location.
     * @param user The user who is adding the company.
     */
    public void addCompany(String name, String owner, String location, double lat, double lon, String user) {
        String query = "INSERT INTO city_applications(name, type, owner, location, lat, lon, asignee, application_status) VALUES (?, 'Company', ?, ?, ?, ?, ?, 'Pending')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, owner);
            stmt.setString(3, location);
            stmt.setDouble(4, lat);
            stmt.setDouble(5, lon);
            stmt.setString(6, user);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in addCompany: " + e.getMessage());
        }
    }

    // Continuation with other methods...
    // The methods insert_purchase_university, getCord, newApplicationToCompany, get_company_applications, getCompanies, getJobs 
    // continue with the same pattern of error handling and resource management as demonstrated above.
    /**
     * Inserts a new purchase associated with a university into the database.
     *
     * @param username The username of the user making the purchase.
     * @param enter The name of the enterprise related to the purchase.
     * @param lat The latitude of the purchase location.
     * @param lon The longitude of the purchase location.
     * @param message A message or note about the purchase.
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
     * Submits a new application to a company.
     *
     * @param uname The username of the applicant.
     * @param company The name of the company.
     * @param role The role being applied for.
     */
    public void newApplicationToCompany(String uname, String company, String role) {
        String query = "INSERT INTO company_applications(company, username, role, status) VALUES (?, ?, ?, 'Applied')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, company);
            stmt.setString(2, uname);
            stmt.setString(3, role);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in newApplicationToCompany: " + e.getMessage());
        }
    }

    /**
     * Retrieves company applications submitted by a specific user.
     *
     * @param name The username of the applicant.
     * @return A ResultSet containing the user's company applications.
     */
    public ResultSet get_company_applications(String name) {
        String query = "SELECT * FROM company_applications WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in get_company_applications: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves a list of approved companies.
     *
     * @return A ResultSet containing approved companies.
     */
    public ResultSet getCompanies() {
        String query = "SELECT * FROM city_applications WHERE type = 'Company' AND application_status = 'Approved'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getCompanies: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves jobs from a specific company.
     *
     * @param comp The name of the company.
     * @return A ResultSet containing jobs at the specified company.
     */
    public ResultSet getJobs(String comp) {
        String query = "SELECT * FROM company_jobs WHERE company = ? AND app_status = 'Approved'";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, comp);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getJobs: " + e.getMessage());
        }
        return null;
    }
}
