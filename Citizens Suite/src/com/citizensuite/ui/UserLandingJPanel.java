package com.citizensuite.ui;

import com.citizensuite.directories.CensorBoardDirectory;
import com.citizensuite.directories.CompanysDirectory;
import com.citizensuite.directories.EducationInstituteDirectory;
import com.citizensuite.directories.VenueDirectory;
import com.citizensuite.directories.UserCoordinatesDirectory;
import com.citizensuite.directories.UserAccountDirectory;
import com.citizensuite.education.UniversityPanel;
import com.citizensuite.employment.JobApplicationJPanel;
import com.citizensuite.employment.MyEmpExchangePanel;
import com.citizensuite.event_management.EventsJPanel;
import java.sql.Connection;

/**
 *
 * @author kaviprakashramalingam
 */
public class UserLandingJPanel extends javax.swing.JPanel {

    Connection connection;
    String currentUser;
    CompanysDirectory companysDirectory;
    CensorBoardDirectory censorBoardDirectory;
    UserCoordinatesDirectory userCoordinatesDirectory;
    UserAccountDirectory userAccountDirectory;
    EducationInstituteDirectory educationInstituteDirectory;
    VenueDirectory venueDirectory;

    public UserLandingJPanel(Connection connection, String user, CompanysDirectory compDir, UserCoordinatesDirectory cord, UserAccountDirectory userdir, EducationInstituteDirectory edudir, CensorBoardDirectory cendir, VenueDirectory thdir) {
        initComponents();
        this.connection = connection;
        this.currentUser = user;
        this.companysDirectory = compDir;
        this.userCoordinatesDirectory = cord;
        this.userAccountDirectory = userdir;
        this.educationInstituteDirectory = edudir;
        this.venueDirectory = thdir;
        this.censorBoardDirectory = cendir;
        UsernameLbl.setText(user);
        TabbedPane.add("Profile", new UserProfileJPanel(cord, user));
        TabbedPane.add("Finance", new UserAnalyticsDashboardJPanel(user, userdir, connection));
        TabbedPane.add("Education", new UniversityPanel(edudir, user));
        TabbedPane.add("Employement", new JobApplicationJPanel(compDir, connection, user));
        TabbedPane.add("Events", new EventsJPanel(connection, user, thdir, cendir));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        LogoutLbl = new javax.swing.JLabel();
        UsernameLbl = new javax.swing.JLabel();
        hilbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        add(TabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1200, 630));

        LogoutLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-logout-25.png"))); // NOI18N
        LogoutLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutLblMouseClicked(evt);
            }
        });
        add(LogoutLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 40, 40));

        UsernameLbl.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        add(UsernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 260, -1));

        hilbl.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        hilbl.setText("Hi..");
        add(hilbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutLblMouseClicked
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutLblMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoutLbl;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JLabel UsernameLbl;
    private javax.swing.JLabel hilbl;
    // End of variables declaration//GEN-END:variables
}
