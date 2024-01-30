package com.citizensuite.ui;

import com.citizensuite.directories.UserAccountDirectory;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.citizensuite.main.MainJFrame;

/**
 *
 * @author srivi
 */
public class CreditCardAdminJFrame extends javax.swing.JFrame {

    UserAccountDirectory userAccountDirectory;

    public CreditCardAdminJFrame(UserAccountDirectory userdir) {
        initComponents();
        this.userAccountDirectory = userdir;
        populateApplications();
    }

    private CreditCardAdminJFrame() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void populateApplications() {
        DefaultTableModel model = (DefaultTableModel) UserCreditData.getModel();
        try {
            ResultSet rs = userAccountDirectory.getUserCreditData();
            model.setRowCount(0);
            while (rs.next()) {
                Object row[] = new Object[6];
                row[0] = rs.getString("request_id");
                row[1] = rs.getString("username");
                row[2] = rs.getString("cardnumber");
                row[3] = rs.getString("amount");
                row[4] = rs.getString("alimit");
                row[5] = rs.getString("status");
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
        UserCreditData = new javax.swing.JTable();
        StatusDropDown = new javax.swing.JComboBox<>();
        Submit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Credit Card Admin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        UserCreditData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request Id", "User", "Card Number", "Amount", "Limit", "Status"
            }
        ));
        jScrollPane1.setViewportView(UserCreditData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 88, 1066, 209));

        StatusDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Approved", "Rejected" }));
        getContentPane().add(StatusDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 352, 161, 36));

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        getContentPane().add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 436, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Status :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-logout-50.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/cccc.jpeg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        int index1 = UserCreditData.getSelectedRow();
        if (index1 < 0) {
            JOptionPane.showMessageDialog(this, "Please select a request....!");
            return;
        }
        DefaultTableModel model2 = (DefaultTableModel) UserCreditData.getModel();
        String amount = String.valueOf(model2.getValueAt(index1, 3));
        String limit = String.valueOf(model2.getValueAt(index1, 4));
        String app_status = String.valueOf(model2.getValueAt(index1, 5));
        String id = String.valueOf(model2.getValueAt(index1, 0));
        String username = String.valueOf(model2.getValueAt(index1, 1));
        String selected = String.valueOf(StatusDropDown.getSelectedItem());
        double bal = userAccountDirectory.getUserBalance(username);
        if (!app_status.equals("Pending")) {
            JOptionPane.showMessageDialog(this, "Status cannot be updated");
            return;
        }
        if (selected.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Select  a status to update");
            return;
        } else if (selected.equals("Approved")) {

            bal += Double.parseDouble(amount);
            if (bal > Double.parseDouble(limit)) {
                JOptionPane.showMessageDialog(this, "Cannot Approve limit exceeded.");
                return;
            }
            userAccountDirectory.insertCreditCardAmount(username, amount, bal + "");
            userAccountDirectory.UpdateUserBalance(username, bal);
            userAccountDirectory.updateCreditApplicationStatus("Approved", id);
            populateApplications();
        } else if (selected.equals("Rejected")) {
            userAccountDirectory.updateCreditApplicationStatus("Rejected", id);
            populateApplications();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_SubmitActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        MainJFrame frame = new MainJFrame();
        frame.setVisible(true);
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new CreditCardAdminJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> StatusDropDown;
    private javax.swing.JButton Submit;
    private javax.swing.JTable UserCreditData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
