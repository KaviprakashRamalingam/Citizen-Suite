package com.citizensuite.government;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.view.swing.BrowserView;
/**
 *
 * @author kaviprakashramalingam
 */
public class VideoPanel extends javax.swing.JFrame {

    static String vedioUrl;
    Browser externalBrowserObj;

    public VideoPanel(String url) {
        initComponents();
        this.vedioUrl = url;
        PlayEvent();
    }

    private void PlayEvent() {

        try {
//            EngineOptions options = Engimovie_status neOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1G4NNJSWIB7FX6CBOWWCX8MKR14WNT2DH9XV6YW9EOWTXHCOQSIKV88D6J65JS").build();
//            Engine engine = Engine.newInstance(options);
//            externalBrowserObj = engine.newBrowser();
//            BrowserView view = BrowserView.newInstance(externalBrowserObj);
//            externalBrowserObj.navigation().loadUrl(vedioUrl);
//            VideoPanel.add(view);
        } catch (Exception e) {
            System.out.println(e + "");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VideoPanel = new javax.swing.JPanel();
        CloseButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        VideoPanel.setLayout(new java.awt.CardLayout());

        CloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/citizensuite/assets/icons8-close-window-48.png"))); // NOI18N
        CloseButton.setText("Close");
        CloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButtonMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel2.setText("Playing :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VideoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(CloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CloseButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(VideoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseClicked
        externalBrowserObj.navigation().loadUrl("https://www.google.com/");
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_CloseButtonMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VideoPanel(vedioUrl).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseButton;
    private javax.swing.JPanel VideoPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
