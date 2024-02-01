package com.citizensuite.ui;

import com.citizensuite.directories.UserCoordinatesDirectory;
import com.citizensuite.admin.MapJFrame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.citizensuite.model.UserCoordinates;
import java.sql.*;

/**
 *
 * @author kaviprakashramalingam
 */
public class UserProfileJPanel extends javax.swing.JPanel {

    String currentUser;
    UserCoordinates userCoordinates;
    UserCoordinatesDirectory userCoordinatesDirectory;

    public UserProfileJPanel(UserCoordinatesDirectory cord, String user) {
        initComponents();
        this.userCoordinatesDirectory = cord;
        this.currentUser = user;
        userCoordinates = cord.addNew();
        userCoordinates.setUsername(user);
        populateFields();
    }

    private void populateFields() {
        try {
            ResultSet rs = userCoordinatesDirectory.getUserData(currentUser);
            if (rs.next()) {
                Fname.setText(rs.getString("firstname"));
                Lname.setText(rs.getString("lastname"));
                EmailFld.setText(rs.getString("email"));
                Address.setText(rs.getString("address"));
                coordinates.setText(rs.getString("lat") + "," + rs.getString("lon"));
            }
        } catch (Exception e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Fname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Lname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        EmailFld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        coordinates = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SetLocation = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Update Profile!!");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));
        add(Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 284, 42));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));
        add(Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 284, 42));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, -1, -1));

        EmailFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailFldActionPerformed(evt);
            }
        });
        add(EmailFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 284, 42));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, -1, -1));

        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
        add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 284, 42));

        coordinates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coordinatesActionPerformed(evt);
            }
        });
        add(coordinates, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 284, 42));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Co-Ordinates :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, -1, -1));

        SetLocation.setText("Set on map");
        SetLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetLocationActionPerformed(evt);
            }
        });
        add(SetLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, -1, -1));

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 167, 49));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/uuu.jpeg"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1160, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void EmailFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailFldActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed

    private void coordinatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coordinatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coordinatesActionPerformed

    public void setCoordinates() {
        System.out.println("dcsdcas");
    }
    private void SetLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetLocationActionPerformed
        MapJFrame frame = new MapJFrame(userCoordinates);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                coordinates.setText(userCoordinates.getLat() + "," + userCoordinates.getLon());
            }
        });

        // TODO add your handling code here:
    }//GEN-LAST:event_SetLocationActionPerformed
    String firstName, lastName, emailAddress, address;
    double latitude, longitude;
    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed

        firstName = Fname.getText();
        lastName = Lname.getText();
        emailAddress = EmailFld.getText();
        address = Address.getText();
        latitude = userCoordinates.getLat();
        longitude = userCoordinates.getLon();
        userCoordinatesDirectory.updateProfile(firstName, lastName, emailAddress, address, latitude, longitude, currentUser);
        JOptionPane.showMessageDialog(this, "UserProfile Updated.");
        userCoordinatesDirectory.insert_purchase_university(currentUser, "", latitude, longitude, " SWEET HOME");
        populateFields();
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JTextField EmailFld;
    private javax.swing.JTextField Fname;
    private javax.swing.JTextField Lname;
    private javax.swing.JButton SetLocation;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTextField coordinates;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
