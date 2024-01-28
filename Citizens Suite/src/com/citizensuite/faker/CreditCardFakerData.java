/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.citizensuite.faker;

import com.github.javafaker.Faker;
import java.sql.*;
import java.util.Random;

/**
 *
 * @author Shreeraam Ramachandran
 */
public class CreditCardFakerData {

    private Connection connection;
    private int cardCount;

    public CreditCardFakerData(Connection connection, int cardCount) {

        this.connection = connection;
        this.cardCount = cardCount;
    }

    public void insertCreditCardFakerData() {

        Faker creditCardFaker = new Faker();
        String query = "INSERT INTO credit_cards (cardnumber, pin, alimit) VALUES (?, ?,'200')";
        
        
        for(int i=0;i<this.cardCount;i++) {
            String creditCardNumber = creditCardFaker.finance().creditCard().replaceAll("-", "");
            int pinNumber = this.generateCardPinNumber();


            try ( PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, creditCardNumber);
                stmt.setInt(2, pinNumber);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Error in addCreditCard: " + e.getMessage());
            }
        }
    }

    public int generateCardPinNumber() {

        Random random = new Random();
        String generatedPassword = String.format("%04d", random.nextInt(10000));

        return Integer.valueOf(generatedPassword);
    }
    
}
