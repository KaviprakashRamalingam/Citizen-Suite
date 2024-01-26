/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.citizensuite.admin;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import javax.swing.JOptionPane;
import com.citizensuite.model.UserCoordinates;

/**
 *
 * @author Shreeraam Ramachandran
 */

public class MapJFrame extends javax.swing.JFrame {

    UserCoordinates userCoordinates;
    Browser externalBrowserObj;

    public MapJFrame(UserCoordinates temp) {
        initComponents();
        this.userCoordinates = temp;
        open_site();
    }

    private MapJFrame() {

    }

    private void open_site() {
        try {
            EngineOptions options
                    = EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("6P830J66YCFDW4CCJM8T4BHMCYGT8VYVXXXSC3Z2D76O3NBHIWCMKZ6HH0CFDWPM1MEF").build();
            Engine engine = Engine.newInstance(options);
            externalBrowserObj = engine.newBrowser();
            BrowserView view = BrowserView.newInstance(externalBrowserObj);
            externalBrowserObj.navigation().loadUrl("https://www.google.com/maps/@42.3366959,-71.0951561,16.43z");
            MapsPanel.add(view);
        } catch (Exception e) {
            System.out.println(e + "");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MapsPanel = new javax.swing.JPanel();
        SetLocationButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MapsPanel.setLayout(new java.awt.CardLayout());

        SetLocationButton.setFont(new java.awt.Font("SimSun", 0, 36)); // NOI18N
        SetLocationButton.setText("Set Location");
        SetLocationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetLocationButtonMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-google-maps-old-100.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MapsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(SetLocationButton)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(SetLocationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(MapsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SetLocationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetLocationButtonMouseClicked
        if (externalBrowserObj.url() != null) {
            String[] split1 = externalBrowserObj.url().split("/place/");
            String[] split2 = split1[1].split("/@");
            String[] placeName = split2[0].split("\\+");
            String[] longLat = split2[1].split(",");
            String place = "";
            int size = placeName.length;
            for (int i = 0; i < size; i++) {
                place += placeName[i];
            }
            userCoordinates.setLat(Double.parseDouble(longLat[0]));
            userCoordinates.setLon(Double.parseDouble(longLat[1]));
            JOptionPane.showMessageDialog(this, "Location Selected.");
        }
    }//GEN-LAST:event_SetLocationButtonMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MapJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MapsPanel;
    private javax.swing.JLabel SetLocationButton;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
