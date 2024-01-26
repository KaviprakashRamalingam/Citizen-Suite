package com.citizensuite.commonUtil;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author srivi
 */
public class CommonUtil {
    public static String getHashedString(String password){
        MessageDigest md;
        String base64EncodedValue = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            
            base64EncodedValue = Base64.getEncoder().encodeToString(hash);
            }catch (NoSuchAlgorithmException ex) {
            System.out.println("Could not find the algorithm mentioned");
        }
        return base64EncodedValue;
    }
}
