/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.citizensuite.admin;

import com.citizensuite.directories.CensorBoardDirectory;
import com.citizensuite.directories.CityDirectory;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Shreeraam Ramachandran
 */

public class CreateEventJPanel extends javax.swing.JPanel {

    Connection connection;
    CensorBoardDirectory censorBoardDirectory;
    CityDirectory cityDirectory;

    public CreateEventJPanel(Connection connection, CensorBoardDirectory cenDir, CityDirectory cityDir) {
        initComponents();
        this.connection = connection;
        this.cityDirectory = cityDir;
        this.censorBoardDirectory = cenDir;
        populateVenues();
        populateApplications();
    }

    private void populateApplications() {
        DefaultTableModel model = (DefaultTableModel) CinemaData.getModel();
        try {
            ResultSet rs = censorBoardDirectory.getAllApplications();
            model.setRowCount(0);
            while (rs.next()) {
                Object row[] = new Object[7];
                row[0] = rs.getString("application_id");
                row[1] = rs.getString("venue");
                row[2] = rs.getString("event_name");
                row[3] = rs.getString("organizer");
                row[4] = rs.getString("sponsor");
                row[5] = rs.getString("url");
                row[6] = rs.getString("event_status");
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void populateVenues() {
        thdropdown.removeAllItems();
        try {
            ResultSet rs = cityDirectory.getApprovedBuildings();
            while (rs.next()) {
                if (rs.getString("type").equals("venue")) {
                    thdropdown.addItem(rs.getString("name"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CinemaData = new javax.swing.JTable();
        thdropdown = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        namefld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        dirfld = new javax.swing.JTextField();
        prodfld = new javax.swing.JTextField();
        urlfld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Event");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        CinemaData.setBackground(new java.awt.Color(204, 204, 204));
        CinemaData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Event Id", "venue", "Name", "Event Organizer", "Sponsor", "Url", "Event Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CinemaData.setFocusTraversalPolicyProvider(true);
        jScrollPane1.setViewportView(CinemaData);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 1030, 198));

        thdropdown.setBackground(new java.awt.Color(204, 204, 204));
        thdropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(thdropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 328, 252, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Venue :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 331, -1, -1));

        namefld.setBackground(new java.awt.Color(204, 204, 204));
        add(namefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 371, 252, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 374, -1, -1));

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 535, 137, 35));

        dirfld.setBackground(new java.awt.Color(204, 204, 204));
        add(dirfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 412, 252, -1));

        prodfld.setBackground(new java.awt.Color(204, 204, 204));
        add(prodfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 453, 252, -1));

        urlfld.setBackground(new java.awt.Color(204, 204, 204));
        add(urlfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 494, 252, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Organizer :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Sponsor :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Url :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 497, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-repeat-25.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 328, -1, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/event.jpg"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 630));
    }// </editor-fold>//GEN-END:initComponents
String name, venue, dir, sponsor, url;
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        venue = String.valueOf(thdropdown.getSelectedItem());
        name = namefld.getText();
        dir = dirfld.getText();
        sponsor = prodfld.getText();
        url = urlfld.getText();
        java.util.Date dNow = new java.util.Date();
        SimpleDateFormat ft
                = new SimpleDateFormat(" yyyy-MM-dd");
        String applied_date = ft.format(dNow);
        censorBoardDirectory.insertRecordbyAdmin(name, dir, sponsor, url, venue, applied_date);
        JOptionPane.showMessageDialog(this, "Event Added");
        populateApplications();
        namefld.setText("");
        dirfld.setText("");
        prodfld.setText("");
        urlfld.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        populateVenues();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CinemaData;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField dirfld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namefld;
    private javax.swing.JTextField prodfld;
    private javax.swing.JComboBox<String> thdropdown;
    private javax.swing.JTextField urlfld;
    // End of variables declaration//GEN-END:variables
}
