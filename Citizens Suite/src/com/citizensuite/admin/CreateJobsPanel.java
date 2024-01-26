/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.citizensuite.admin;

/**
 *
 * @author Shreeraam Ramachandran
 */
import com.citizensuite.directories.CityDirectory;
import com.citizensuite.directories.CompanysDirectory;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CreateJobsPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateJobsPanel
     */
    Connection connection;
    String currentUser;
    CityDirectory cityDirectory;
    CompanysDirectory companysDirectory;

    public CreateJobsPanel(Connection connection, CompanysDirectory compdir, CityDirectory citydir) {
        initComponents();
        this.connection = connection;
        this.companysDirectory = compdir;
        this.cityDirectory = citydir;
        populateUni();
        populateApplications();
    }

    private void populateUni() {
        CompanyDropDown.removeAllItems();
        try {
            ResultSet rs = cityDirectory.getApprovedBuildings();
            while (rs.next()) {
                if (rs.getString("type").equals("Company")) {
                    CompanyDropDown.addItem(rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void populateApplications() {
        DefaultTableModel model = (DefaultTableModel) JobsData.getModel();
        try {
            ResultSet rs = companysDirectory.getAllJobsByAppliedPerson("sysadmin");
            model.setRowCount(0);
            while (rs.next()) {
                Object row[] = new Object[8];
                row[0] = rs.getString("job_id");
                row[1] = rs.getString("company");
                row[2] = rs.getString("role");
                row[3] = rs.getString("roledesc");
                row[4] = rs.getString("app_status");
                model.addRow(row);
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
        JobsData = new javax.swing.JTable();
        Role = new javax.swing.JTextField();
        CompanyDropDown = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        SaveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Jobs");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 31, 164, -1));

        JobsData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Job Id", "Company", "Role", "Description", "Status"
            }
        ));
        jScrollPane1.setViewportView(JobsData);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 92, 966, 173));
        add(Role, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 342, 247, 34));

        CompanyDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(CompanyDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 300, 247, 30));

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane2.setViewportView(desc);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 396, 247, -1));

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 521, 110, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Company :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 307, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Role :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 350, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descrption :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 396, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-repeat-25.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 305, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/verificacion-antecedentes.jpg"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 620));
    }// </editor-fold>//GEN-END:initComponents

    String comp, role, descr;
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        comp = String.valueOf(CompanyDropDown.getSelectedItem());
        role = Role.getText();
        descr = desc.getText();
        java.util.Date dNow = new java.util.Date();
        SimpleDateFormat ft
                = new SimpleDateFormat(" yyyy-MM-dd");
        String applied_date = ft.format(dNow);
        companysDirectory.addNewJobByAdmin(comp, role, descr, applied_date);
        JOptionPane.showMessageDialog(this, "Added Successfully");
        populateApplications();
        Role.setText("");
        desc.setText("");
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        populateUni();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CompanyDropDown;
    private javax.swing.JTable JobsData;
    private javax.swing.JTextField Role;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextArea desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
