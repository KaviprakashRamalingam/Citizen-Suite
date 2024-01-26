/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.citizensuite.admin;

import com.citizensuite.directories.CensorBoardDirectory;
import com.citizensuite.directories.CityDirectory;
import com.citizensuite.directories.CompanysDirectory;
import com.citizensuite.directories.EducationInstituteDirectory;
import com.citizensuite.directories.VenueDirectory;
import com.citizensuite.directories.UserCoordinatesDirectory;
import com.citizensuite.directories.UserAccountDirectory;
import java.sql.*;
import com.citizensuite.main.MainJFrame;

/**
 *
 * @author Shreeraam Ramachandran
 */

public class AdminJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminJFrame
     */
    Connection conneciton;
    String currentUser;
    UserCoordinatesDirectory usercordDir;
    CensorBoardDirectory censorBoardDirectory;
    VenueDirectory venueDirectory;
    CompanysDirectory companysDirectory;
    CityDirectory cityDirectory;
    EducationInstituteDirectory educationInstituteDirectory;
    UserAccountDirectory userAccountDirectory;

    public AdminJFrame(Connection connection, String user, UserAccountDirectory userDir, VenueDirectory thDir, CityDirectory cityDir, UserCoordinatesDirectory usercordDir, CensorBoardDirectory cenDir, EducationInstituteDirectory edudir, CompanysDirectory compdir) {
        initComponents();
        this.conneciton = connection;
        this.currentUser = user;
        this.userAccountDirectory = userDir;
        this.venueDirectory = thDir;
        this.cityDirectory = cityDir;
        this.usercordDir = usercordDir;
        this.educationInstituteDirectory = edudir;
        this.companysDirectory = compdir;
        UsernameLbl.setText(user);
        SysAdminTabbedPane.add("Add venues", new CreateVenueJPanel(connection, thDir, cityDir, usercordDir));
        SysAdminTabbedPane.add("Add Events", new CreateEventJPanel(connection, cenDir, cityDir));
        SysAdminTabbedPane.add("Add Universities", new CreateUniversityPanel(connection, cityDir, usercordDir));
        SysAdminTabbedPane.add("Add Courses", new CreateUniversityCoursesJPanel(connection, edudir, cityDir));
        SysAdminTabbedPane.add("Add Companies", new CreateCompanyJPanel(connection, compdir, cityDir, usercordDir));
        SysAdminTabbedPane.add("Add Jobs", new CreateJobsPanel(connection, compdir, cityDir));
        SysAdminTabbedPane.add("Add Admins", new CreateAdminsJPanel(connection, userDir));
    }

    private AdminJFrame() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SysAdminTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        UsernameLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SysAdminTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        SysAdminTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        getContentPane().add(SysAdminTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 71, 1200, 630));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Hi!!");

        UsernameLbl.setBackground(new java.awt.Color(51, 51, 51));
        UsernameLbl.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-logout-25.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(UsernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 445, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(UsernameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        MainJFrame frame = new MainJFrame();
        frame.setVisible(true);
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new AdminJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane SysAdminTabbedPane;
    private javax.swing.JLabel UsernameLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
