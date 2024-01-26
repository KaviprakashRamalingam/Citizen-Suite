/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.citizensuite.directories;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author kaviprakashramalingam
 */
public class UserAccountDirectory {

    Connection connection;

    public UserAccountDirectory(Connection connection) {
        this.connection = connection;
    }

    /**
     * Checks if a user can log in with the provided username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The 'can_login' status if credentials are correct, null
     * otherwise.
     */
    public String getCanLogin(String username, String password) {
        String query = "SELECT can_login FROM users WHERE username = ? AND passwordFld = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("can_login");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error in getCanLogin: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves all user data from the database.
     *
     * @return A ResultSet containing all user data.
     */
    public ResultSet getUserData() {
        String query = "SELECT * FROM users";
        try {
            PreparedStatement stmt = (PreparedStatement)connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getUserData: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieves data of all administrators.
     *
     * @return ResultSet containing administrators' data.
     */
    public ResultSet getAdminsData() {
        String query = "SELECT * FROM users WHERE role NOT IN ('User','SystemAdmin')";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getAdminsData: " + e.getMessage());
        }
        return null;
    }

    /**
     * Adds a new administrator to the database.
     *
     * @param fname The first name of the admin.
     * @param lname The last name of the admin.
     * @param uname The username of the admin.
     * @param password The password for the admin.
     * @param email The email address of the admin.
     * @param role The role of the admin.
     */
    public void addAdmin(String fname, String lname, String uname, String password, String email, String role) {
        String query = "INSERT INTO users (firstname, lastname, username, passwordFld, email, role, can_login) VALUES (?, ?, ?, ?, ?, ?, '1')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setString(3, uname);
            stmt.setString(4, password);
            stmt.setString(5, email);
            stmt.setString(6, role);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in addAdmin: " + e.getMessage());
        }
    }

    /**
     * Retrieves user credit data from the database.
     *
     * @return A ResultSet containing credit application data.
     */
    public ResultSet getUserCreditData() {
        String query = "SELECT * FROM credit_applications";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Error in getUserCreditData: " + e.getMessage());
        }
        return null;
    }

    /**
     * Inserts a new credit card transaction for a user.
     *
     * @param username The username of the user.
     * @param amount The transaction amount.
     * @param balance The balance after the transaction.
     */
    public void insertCreditCardAmount(String username, String amount, String balance) {
        String query = "INSERT INTO my_purchases(username, t_type, amount, balance, enterprise) VALUES (?, 'Credit', ?, ?, 'CreditCard')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, amount);
            stmt.setString(3, balance);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in insertCreditCardAmount: " + e.getMessage());
        }
    }

    /**
     * Retrieves the balance of a user.
     *
     * @param username The username of the user.
     * @return The balance of the user.
     */
    public double getUserBalance(String username) {
        String query = "SELECT balance FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("balance");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error in getUserBalance: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Updates the status of a credit application.
     *
     * @param status The new status of the application.
     * @param id The ID of the credit application.
     */
    public void updateCreditApplicationStatus(String status, String id) {
        String query = "UPDATE credit_applications SET status = ? WHERE request_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in updateCreditApplicationStatus: " + e.getMessage());
        }
    }

    /**
     * Updates the balance of a user.
     *
     * @param username The username of the user.
     * @param balance The new balance of the user.
     */
    public void UpdateUserBalance(String username, double balance) {
        String query = "UPDATE users SET balance = ? WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, balance);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in UpdateUserBalance: " + e.getMessage());
        }
    }

    /**
     * Creates a new credit application.
     *
     * @param username The username of the applicant.
     * @param card The card number.
     * @param amount The amount requested.
     * @param alimit The credit limit requested.
     */
    public void createCreditApplication(String username, String card, String amount, String alimit) {
        String query = "INSERT INTO credit_applications(username, cardnumber, amount, alimit, status) VALUES (?, ?, ?, ?, 'Pending')";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, card);
            stmt.setString(3, amount);
            stmt.setString(4, alimit);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error in createCreditApplication: " + e.getMessage());
        }
    }

    /**
     * Checks if a credit card is valid.
     *
     * @param card The card number.
     * @param pin The pin of the card.
     * @return true if the card is valid, false otherwise.
     */
    public boolean isCardValid(String card, String pin) {
        String query = "SELECT cardnumber, pin FROM credit_cards";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("cardnumber").equals(card) && rs.getString("pin").equals(pin)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error in isCardValid: " + e.getMessage());
        }
        return false;
    }

    /**
     * Retrieves the credit limit for a specific credit card.
     *
     * @param card The card number.
     * @return The credit limit of the card.
     */
    public String getCreditCardLimit(String card) {
        String query = "SELECT alimit FROM credit_cards WHERE cardnumber = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, card);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("alimit");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error in getCreditCardLimit: " + e.getMessage());
        }
        return null;
    }

}
