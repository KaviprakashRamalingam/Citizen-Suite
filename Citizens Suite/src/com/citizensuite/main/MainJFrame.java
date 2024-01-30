/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.citizensuite.main;

import com.citizensuite.directories.CensorBoardDirectory;
import com.citizensuite.directories.CityDirectory;
import com.citizensuite.directories.CompanysDirectory;
import com.citizensuite.directories.EducationInstituteDirectory;
import com.citizensuite.directories.VenueDirectory;
import com.citizensuite.directories.UserCoordinatesDirectory;
import com.citizensuite.directories.UserAccountDirectory;
import com.citizensuite.education.CourseCreatorFrame;
import com.citizensuite.education.UniversityCreatorJFrame;
import com.citizensuite.employment.CompanyCreationFrame;
import com.citizensuite.employment.JobCreationJFrame;
import com.citizensuite.event_management.EventCreationJFrame;
import com.citizensuite.event_management.VenueCreationJFrame;
import com.citizensuite.government.CensorBoardAdminJFrame;
import com.citizensuite.government.CityCommisionerJFrame;
import com.citizensuite.government.UniversityCourseRegistrationAdminJFrame;
import com.citizensuite.government.LandingPageJFrame;
import com.citizensuite.admin.AdminJFrame;
import com.citizensuite.commonUtil.CommonUtil;
import com.citizensuite.faker.CompanyFakerData;
import com.citizensuite.faker.CreditCardFakerData;
import com.citizensuite.faker.UserFakerData;
import com.citizensuite.ui.CreditCardAdminJFrame;
import com.citizensuite.ui.SignUpJFrame;
import com.citizensuite.ui.UserLandingJPanel;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

import java.sql.*;

/**
 *
 * @author srivi
 */
public class MainJFrame extends javax.swing.JFrame {
    
    CompanysDirectory companysDirectory;
    Connection connection;
    CityDirectory cityDirectory;
    EducationInstituteDirectory educationInstituteDirectory;
    CensorBoardDirectory censorBoardDirectory;
    UserAccountDirectory userAccountDirectory;
    UserCoordinatesDirectory userCoordinatesDirectory;
    VenueDirectory venueDirectory;

    public MainJFrame() {
        connectDatabase();
        companysDirectory = new CompanysDirectory(connection);
        userAccountDirectory = new UserAccountDirectory(connection);
        censorBoardDirectory = new CensorBoardDirectory(connection);
        userCoordinatesDirectory = new UserCoordinatesDirectory(connection);
        cityDirectory = new CityDirectory(connection);
        this.venueDirectory = new VenueDirectory(connection);
        this.educationInstituteDirectory = new EducationInstituteDirectory(connection);
        generateFakeData();
        initComponents();

    }

    public final void connectDatabase() {
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        } catch (SQLException e) {
            System.out.println("Unable to connect to Database");
        }
    }
    
     public void generateFakeData() {
        
        //User Fake Data
        UserFakerData userFakerData = new UserFakerData(userAccountDirectory, 2);
        userFakerData.insertUserFakerTestData();
        
        //Credit fake data
        CreditCardFakerData creditCardFakerData = new CreditCardFakerData(connection, 5);
        creditCardFakerData.insertCreditCardFakerData();
        
        //company fake data
        CompanyFakerData companyFakerData = new CompanyFakerData(connection, 2);
        companyFakerData.insertCompanyFakeData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        MainJPanel = new javax.swing.JPanel();
        UsernameFld = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        PasswordImage = new javax.swing.JLabel();
        UserNameImage = new javax.swing.JLabel();
        TitleImage = new javax.swing.JLabel();
        PasswordFld = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        container.setLayout(new java.awt.CardLayout());

        MainJPanel.setBackground(new java.awt.Color(252, 245, 243));
        MainJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UsernameFld.setBackground(new java.awt.Color(252, 245, 243));
        UsernameFld.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        UsernameFld.setText("Username");
        UsernameFld.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        MainJPanel.add(UsernameFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 240, 260, 40));

        RegisterButton.setBackground(new java.awt.Color(252, 245, 243));
        RegisterButton.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        RegisterButton.setText("Register");
        RegisterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });
        MainJPanel.add(RegisterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 400, 120, 40));

        LoginButton.setBackground(new java.awt.Color(252, 245, 243));
        LoginButton.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(51, 51, 51));
        LoginButton.setText("Login");
        LoginButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        MainJPanel.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, 120, 40));

        PasswordImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-unlock-private-20.png"))); // NOI18N
        MainJPanel.add(PasswordImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, 20, 30));

        UserNameImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-user-20.png"))); // NOI18N
        MainJPanel.add(UserNameImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 20, 30));

        TitleImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-smart-city-64.png"))); // NOI18N
        MainJPanel.add(TitleImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 70, 90));

        PasswordFld.setBackground(new java.awt.Color(252, 245, 243));
        PasswordFld.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        PasswordFld.setText("password");
        PasswordFld.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        PasswordFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFldActionPerformed(evt);
            }
        });
        MainJPanel.add(PasswordFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, 260, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/Cities-1280x800-c-center.jpg"))); // NOI18N
        MainJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 700));

        container.add(MainJPanel, "card2");

        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFldActionPerformed
    String username;
    String pwd;

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        username = UsernameFld.getText();
        pwd = CommonUtil.getHashedString(String.valueOf(PasswordFld.getPassword()));
        System.out.println(username + pwd);
        try {

            ResultSet rs = userAccountDirectory.getUserData();
            while (rs.next()) {
                if (rs.getString(4).equals(username) && rs.getString(6).equals(pwd)) {
                    flag = false;
                    if (rs.getString(8).equals("1")) {
                        System.out.println(rs.getString("role"));
                        if (rs.getString("role").equals("User")) {
                            flag = true;
                            UserLandingJPanel panel2 = new UserLandingJPanel(connection, username, companysDirectory, userCoordinatesDirectory, userAccountDirectory, educationInstituteDirectory, censorBoardDirectory, venueDirectory);
                            container.add("UserLandingJPanel", panel2);
                            CardLayout layout = (CardLayout) container.getLayout();
                            layout.next(container);
                        }
                        if (rs.getString("role").equals("SystemAdmin")) {
                            flag = true;
                            AdminJFrame frame = new AdminJFrame(connection, username, userAccountDirectory, venueDirectory, cityDirectory, userCoordinatesDirectory, censorBoardDirectory, educationInstituteDirectory, companysDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString("role").equals("gadmin")) {
                            flag = true;
                            LandingPageJFrame frame = new LandingPageJFrame(censorBoardDirectory, username, cityDirectory, educationInstituteDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString("role").equals("censoradmin")) {
                            flag = true;
                            CensorBoardAdminJFrame frame = new CensorBoardAdminJFrame(connection, censorBoardDirectory, username);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString("role").equals("eventcreator")) {
                            flag = true;
                            EventCreationJFrame frame = new EventCreationJFrame(connection, username, censorBoardDirectory, cityDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString("role").equals("citycomm")) {
                            flag = true;
                            CityCommisionerJFrame frame = new CityCommisionerJFrame(connection, username, cityDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString(9).equals("ccadmin")) {
                            flag = true;
                            CreditCardAdminJFrame frame = new CreditCardAdminJFrame(userAccountDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString(9).equals("compadmin")) {
                            flag = true;
                            CompanyCreationFrame frame = new CompanyCreationFrame(companysDirectory, cityDirectory, userCoordinatesDirectory, username);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString(9).equals("jobscreator")) {
                            flag = true;
                            JobCreationJFrame frame = new JobCreationJFrame(companysDirectory, cityDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString(9).equals("venuecreator")) {
                            flag = true;
                            VenueCreationJFrame frame = new VenueCreationJFrame(cityDirectory, username, userCoordinatesDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString(9).equals("ucreator")) {
                            flag = true;
                            UniversityCreatorJFrame frame = new UniversityCreatorJFrame(username, connection, cityDirectory, userCoordinatesDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString(9).equals("coursecreator")) {
                            flag = true;
                            CourseCreatorFrame frame = new CourseCreatorFrame(username, educationInstituteDirectory, cityDirectory);
                            frame.setVisible(true);
                            dispose();
                        }
                        if (rs.getString(9).equals("courseregadmin")) {
                            flag = true;
                            UniversityCourseRegistrationAdminJFrame frame = new UniversityCourseRegistrationAdminJFrame();
                            frame.setVisible(true);
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Email not Verified.");
                    }
                }
            }
            if (!flag) {
                JOptionPane.showMessageDialog(this, "Username Not Found.");
            }
        } catch (HeadlessException | SQLException sqlException) {
            sqlException.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        SignUpJFrame frame = new SignUpJFrame(connection);
        frame.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed
    boolean flag = false;

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel MainJPanel;
    private javax.swing.JPasswordField PasswordFld;
    private javax.swing.JLabel PasswordImage;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JLabel UserNameImage;
    private javax.swing.JTextField UsernameFld;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
