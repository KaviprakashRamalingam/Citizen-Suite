/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.citizensuite.government;

import com.citizensuite.directories.EducationInstituteDirectory;
import com.citizensuite.directories.UserAccountDirectory;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kaviprakashramalingam
 */
public class CourseJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CourseJPanel
     */
    EducationInstituteDirectory educationInstituteDirectory;

    public CourseJPanel(EducationInstituteDirectory edudir) {
        initComponents();
        this.educationInstituteDirectory = edudir;
        populateApplications();
        popAsignees();
    }

    private void popAsignees() {
        asignees.removeAllItems();
        try {
            ResultSet rs = educationInstituteDirectory.getAsignees();
            while (rs.next()) {
                asignees.addItem(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void populateApplications() {
        DefaultTableModel model = (DefaultTableModel) CourseData.getModel();
        try {
            ResultSet rs = educationInstituteDirectory.getCourses();
            model.setRowCount(0);
            while (rs.next()) {
                Object row[] = new Object[8];
                row[0] = rs.getString("application_id");
                row[1] = rs.getString("coursename");
                row[2] = rs.getString("professor");
                row[3] = rs.getString("university");
                row[4] = rs.getString("dayofweek");
                row[5] = rs.getString("coursedesc");
                row[6] = rs.getString("app_status");
                row[6] = rs.getString("asignee");
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        CourseData = new javax.swing.JTable();
        asignees = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CourseData.setBackground(new java.awt.Color(204, 255, 255));
        CourseData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Course Id", "Name", "Professor", "University", "Day of Week", "Descriprtion Pdf", "Status", "Asignee"
            }
        ));
        jScrollPane1.setViewportView(CourseData);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 109, 928, 174));

        asignees.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Approved", "Rejected" }));
        add(asignees, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 336, 247, 46));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 430, 100, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course Applications");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 30, -1, -1));

        jLabel2.setText("Asignee :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 351, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/zoomRRLsummer.jpg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String asignee = String.valueOf(asignees.getSelectedItem());
        int index1 = CourseData.getSelectedRow();
        if (index1 < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Application....!");
            return;
        }
        DefaultTableModel model2 = (DefaultTableModel) CourseData.getModel();
        String id = String.valueOf(model2.getValueAt(index1, 0));
        educationInstituteDirectory.updateAssignee(id, asignee);
        JOptionPane.showMessageDialog(this, "Update Success");
        populateApplications();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CourseData;
    private javax.swing.JComboBox<String> asignees;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
