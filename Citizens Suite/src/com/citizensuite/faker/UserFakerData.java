/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.citizensuite.faker;

import com.citizensuite.commonUtil.CommonUtil;
import com.citizensuite.directories.UserAccountDirectory;
import com.github.javafaker.Faker;
import java.sql.*;

/**
 *
 * @author Shreeraam Ramachandran
 */
public class UserFakerData {
    
    private UserAccountDirectory userAccountDirectory; 
    
    private int userCount;
    
    public UserFakerData(UserAccountDirectory userAccountDirectory, int userCount) {
        
        this.userAccountDirectory = userAccountDirectory;
        this.userCount = userCount;
    }
    
    
    public void insertUserFakerTestData() {
         
        Faker userFaker = new Faker();
        
        for(int i=0;i< this.userCount;i++) {
            
            String email = userFaker.internet().emailAddress();
            String firstName = userFaker.name().firstName(); 
            String lastName = userFaker.name().lastName();
            String userName = userFaker.name().username();
            String password = CommonUtil.getHashedString("password");
            String role = "User";

            userAccountDirectory.addAdmin(firstName, lastName, userName, password, email, role);
        }
    }
    
}
