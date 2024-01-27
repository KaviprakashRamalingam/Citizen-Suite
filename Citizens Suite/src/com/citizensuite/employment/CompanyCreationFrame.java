/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.citizensuite.employment;

import com.citizensuite.directories.CityDirectory;
import com.citizensuite.directories.CompanysDirectory;
import com.citizensuite.directories.UserCoordinatesDirectory;
import com.citizensuite.admin.MapJFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import com.citizensuite.model.UserCoordinates;
import com.citizensuite.main.MainJFrame;

/**
 *
 * @author srivi
 */
public class CompanyCreationFrame extends javax.swing.JFrame {

    /**
     * Creates new form CompanyCreationFrame
     */
    CompanysDirectory companysDirectory;
    CityDirectory cityDirectory;
    UserCoordinatesDirectory userCoordinatesDirectory;

    UserCoordinates userCoordinates;
    String currentUser;

    public CompanyCreationFrame(CompanysDirectory compdir, CityDirectory citydir, UserCoordinatesDirectory corddir, String user) {
        initComponents();
        this.companysDirectory = compdir;
        this.cityDirectory = citydir;
        this.userCoordinatesDirectory = corddir;
        userCoordinates = corddir.addNew();
        cordfld.setEditable(false);
        GreenTick.setVisible(false);
        RedTick.setVisible(false);
        this.currentUser = user;
        populateCompanies();
    }

    private CompanyCreationFrame() {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean CompanyExists() {
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

    private void populateCompanies() {
        DefaultTableModel model = (DefaultTableModel) CompData.getModel();
        try {
            ResultSet rs = cityDirectory.getAllApplicationsByAsignee(currentUser);
            model.setRowCount(0);
            Object row[] = new Object[7];
            while (rs.next()) {
                if (rs.getString("type").equals("Company")) {
                    row[0] = rs.getString("application_id");
                    row[1] = rs.getString("name");
                    row[2] = rs.getString("owner");
                    row[3] = rs.getString("location");
                    row[4] = rs.getString("lat");
                    row[5] = rs.getString("lon");
                    row[6] = rs.getString("application_status");
                    model.addRow(row);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void NameListener() {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                if (CompanyExists()) {
                    GreenTick.setVisible(true);
                    RedTick.setVisible(false);
                } else {
                    RedTick.setVisible(true);
                    GreenTick.setVisible(false);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {

                if (CompanyExists()) {
                    GreenTick.setVisible(true);
                    RedTick.setVisible(false);
                } else {
                    RedTick.setVisible(true);
                    GreenTick.setVisible(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                if (CompanyExists()) {
                    GreenTick.setVisible(true);
                    RedTick.setVisible(false);
                } else {
                    RedTick.setVisible(true);
                    GreenTick.setVisible(false);
                }
            }
        };
        namefld.getDocument().addDocumentListener(documentListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CompData = new javax.swing.JTable();
        namefld = new javax.swing.JTextField();
        ownerfld = new javax.swing.JTextField();
        locfld = new javax.swing.JTextField();
        cordfld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        GreenTick = new javax.swing.JLabel();
        RedTick = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Company Applications");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/logout.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1077, 16, -1, -1));

        CompData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ApplicationId", "Name", "Location", "Owner", "Latitude", "Longitude", "Application Status"
            }
        ));
        jScrollPane1.setViewportView(CompData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 84, 1103, 233));
        getContentPane().add(namefld, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 347, 207, 33));
        getContentPane().add(ownerfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 398, 207, 33));
        getContentPane().add(locfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 449, 207, 33));
        getContentPane().add(cordfld, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 207, 33));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Owner :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Location :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Co-Ordinates :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Set Location");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 510, -1, -1));

        SaveButton.setText("File Petition");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 567, -1, -1));

        GreenTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-approval-25.png"))); // NOI18N
        getContentPane().add(GreenTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(773, 347, -1, -1));

        RedTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-cross-mark-25.png"))); // NOI18N
        getContentPane().add(RedTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 347, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/frame1.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        MainJFrame frame = new MainJFrame();
        frame.setVisible(true);
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked
    String name, dean, location, cord;
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        name = namefld.getText();
        dean = ownerfld.getText();
        location = locfld.getText();
        userCoordinates.setUsername(name);
        companysDirectory.addCompany(name, dean, location, userCoordinates.getLat(), userCoordinates.getLon(), currentUser);
        JOptionPane.showMessageDialog(this, "Added Successfully");
        populateCompanies();

        namefld.setText("");
        ownerfld.setText("");
        locfld.setText("");
        cordfld.setText("");
        GreenTick.setVisible(false);
        RedTick.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
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
    }//GEN-LAST:event_jLabel7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompanyCreationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyCreationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyCreationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyCreationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyCreationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CompData;
    private javax.swing.JLabel GreenTick;
    private javax.swing.JLabel RedTick;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField cordfld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locfld;
    private javax.swing.JTextField namefld;
    private javax.swing.JTextField ownerfld;
    // End of variables declaration//GEN-END:variables
}