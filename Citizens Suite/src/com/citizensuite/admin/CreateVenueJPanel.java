/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.citizensuite.admin;

import com.citizensuite.directories.CityDirectory;
import com.citizensuite.directories.VenueDirectory;
import com.citizensuite.directories.UserCoordinatesDirectory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import com.citizensuite.model.UserCoordinates;

/**
 *
 * @author Shreeraam Ramachandran
 */
public class CreateVenueJPanel extends javax.swing.JPanel {

    VenueDirectory venueDirectory;
    Connection connection;
    UserCoordinatesDirectory userCoordinatesDirectory;
    CityDirectory cityDirectory;
    UserCoordinates userCoordinates;

    public CreateVenueJPanel(Connection connection, VenueDirectory thDir, CityDirectory cityDir, UserCoordinatesDirectory usercordDir) {
        initComponents();
        this.connection = connection;
        this.venueDirectory = thDir;
        this.cityDirectory = cityDir;
        this.userCoordinatesDirectory = usercordDir;
        userCoordinates = usercordDir.addNew();
        UsernameGreenTick.setVisible(false);
        UsernameRedTick.setVisible(false);
        populateVenues();
        UsernameListener();
        cordfld.setEditable(false);
    }

    private void populateVenues() {
        DefaultTableModel model = (DefaultTableModel) VenueData.getModel();
        try {
            ResultSet rs = cityDirectory.getApprovedBuildings();
            model.setRowCount(0);
            Object row[] = new Object[6];
            while (rs.next()) {
                if (rs.getString("type").equals("venue")) {
                    row[0] = rs.getString("application_id");
                    row[1] = rs.getString("name");
                    row[2] = rs.getString("owner");
                    row[3] = rs.getString("location");
                    row[4] = rs.getString("lat");
                    row[5] = rs.getString("lon");
                    model.addRow(row);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void UsernameListener() {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                if (VenueNameExists()) {
                    UsernameGreenTick.setVisible(true);
                    UsernameRedTick.setVisible(false);
                } else {
                    UsernameRedTick.setVisible(true);
                    UsernameGreenTick.setVisible(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {

                if (VenueNameExists()) {
                    UsernameGreenTick.setVisible(true);
                    UsernameRedTick.setVisible(false);
                } else {
                    UsernameRedTick.setVisible(true);
                    UsernameGreenTick.setVisible(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                if (VenueNameExists()) {
                    UsernameGreenTick.setVisible(true);
                    UsernameRedTick.setVisible(false);
                } else {
                    UsernameRedTick.setVisible(true);
                    UsernameGreenTick.setVisible(false);
                }
            }
        };
        namefld.getDocument().addDocumentListener(documentListener);
    }

    private boolean VenueNameExists() {
        try {
            ResultSet rs = cityDirectory.getApprovedBuildings();
            while (rs.next()) {
                if (rs.getString("name").equals(namefld.getText())) {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        VenueData = new javax.swing.JTable();
        namefld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cordfld = new javax.swing.JTextField();
        LocationLabel = new javax.swing.JLabel();
        locfld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        SetLocationLabel = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        ownerfld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        UsernameRedTick = new javax.swing.JLabel();
        UsernameGreenTick = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VenueData.setBackground(new java.awt.Color(204, 204, 204));
        VenueData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Owner", "Location", "Latitude ", "Longitude"
            }
        ));
        jScrollPane1.setViewportView(VenueData);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1030, 197));

        namefld.setBackground(new java.awt.Color(204, 204, 204));
        add(namefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 333, 225, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Venues");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 212, 47));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 336, -1, -1));

        cordfld.setBackground(new java.awt.Color(204, 204, 204));
        add(cordfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 415, 225, -1));

        LocationLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        LocationLabel.setForeground(new java.awt.Color(255, 255, 255));
        LocationLabel.setText("Location :");
        add(LocationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 377, -1, -1));

        locfld.setBackground(new java.awt.Color(204, 204, 204));
        add(locfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 374, 225, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Co-Ordinates :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 418, -1, -1));

        SetLocationLabel.setForeground(new java.awt.Color(255, 255, 255));
        SetLocationLabel.setText("Set Location");
        SetLocationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetLocationLabelMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SetLocationLabelMouseReleased(evt);
            }
        });
        add(SetLocationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 418, -1, -1));

        SubmitButton.setBackground(new java.awt.Color(204, 204, 204));
        SubmitButton.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });
        add(SubmitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 180, 50));

        ownerfld.setBackground(new java.awt.Color(204, 204, 204));
        add(ownerfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 456, 225, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Owner :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 459, -1, -1));

        UsernameRedTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-cross-mark-25.png"))); // NOI18N
        add(UsernameRedTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 331, -1, -1));

        UsernameGreenTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-approval-25.png"))); // NOI18N
        add(UsernameGreenTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 331, -1, -1));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/frame.jpeg"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 630));
    }// </editor-fold>//GEN-END:initComponents

    private void SetLocationLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetLocationLabelMouseReleased
        MapJFrame frame = new MapJFrame(userCoordinates);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                cordfld.setText(userCoordinates.getLat() + "," + userCoordinates.getLon());
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_SetLocationLabelMouseReleased

    String userName, dean, location, cord;
    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed

        userName = namefld.getText();
        dean = ownerfld.getText();
        location = locfld.getText();
        userCoordinates.setUsername(userName);
        cityDirectory.addVenueBySystemAdmin(userName, dean, location, userCoordinates.getLat(), userCoordinates.getLon());
        JOptionPane.showMessageDialog(this, "Added Successfully");
        populateVenues();

        namefld.setText("");
        ownerfld.setText("");
        locfld.setText("");
        cordfld.setText("");
        UsernameGreenTick.setVisible(false);
        UsernameRedTick.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void SetLocationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetLocationLabelMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_SetLocationLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LocationLabel;
    private javax.swing.JLabel SetLocationLabel;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel UsernameGreenTick;
    private javax.swing.JLabel UsernameRedTick;
    private javax.swing.JTable VenueData;
    private javax.swing.JTextField cordfld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locfld;
    private javax.swing.JTextField namefld;
    private javax.swing.JTextField ownerfld;
    // End of variables declaration//GEN-END:variables
}
