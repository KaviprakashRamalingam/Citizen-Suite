/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.citizensuite.faker;


import com.github.javafaker.Faker;
import java.sql.*;

/**
 *
 * @author Home
 */
public class CompanyFakerData {
    
    private Connection connection;
    private int companyCount;
    
    public CompanyFakerData(Connection connection, int companyCount) {
        this.connection = connection;
        this.companyCount = companyCount;
    }
    
    public void insertCompanyFakeData() {
        
        Faker companyFaker = new Faker();
        String query = "INSERT INTO companies (name) VALUES (?)";
        
        
        for(int i=0;i<this.companyCount;i++) {
            
            String companyName = companyFaker.company().name();
            
            try ( PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, companyName);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error in adding company faker " + e.getMessage());
            }
        }
    }
    
}
