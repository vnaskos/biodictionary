package com.vnaskos.biodictionary;

import com.vnaskos.biodictionary.translator.Translate;

/**
 *
 * @author Vasilis Naskos
 */
public class About extends javax.swing.JFrame {
    
    Translate tr;
    
    public About(Translate tr) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.tr = tr;
        updateLanguage();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        aboutTextPane = new javax.swing.JTextPane();
        logoLyceum = new javax.swing.JLabel();
        logoEtwinning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About BioDictionary");
        setAlwaysOnTop(true);
        setResizable(false);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        aboutTextPane.setEditable(false);
        aboutTextPane.setContentType("text/html"); // NOI18N
        aboutTextPane.setText("<html>\n  <head>\n\n  </head>\n  <body>\n      <h2 style=\"text-align:center;\">BioDictionary</h2>\n      <p>BioDictionary is licensed under GNU General Public License 3!</p>\n      <p>This program is created for Biodiversity project of Etwinning 2012</p>\n      <p>Developed by nask00s<br />A big thank you to KoulisEle for his contribution!<br />\n  </body>\n</html>\n");
        aboutTextPane.setMaximumSize(new java.awt.Dimension(403, 165));
        aboutTextPane.setMinimumSize(new java.awt.Dimension(403, 165));
        aboutTextPane.setPreferredSize(new java.awt.Dimension(403, 165));
        jScrollPane1.setViewportView(aboutTextPane);

        logoLyceum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        logoLyceum.setToolTipText("4th Lyceum Stavroupolis");

        logoEtwinning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eTwinLogo.png"))); // NOI18N
        logoEtwinning.setToolTipText("Etwinning 2012");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoLyceum)
                        .addGap(18, 18, 18)
                        .addComponent(logoEtwinning, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(logoEtwinning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoLyceum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(okButton))
                .addContainerGap())
        );

        logoLyceum.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane aboutTextPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoEtwinning;
    private javax.swing.JLabel logoLyceum;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
    
    private void updateLanguage() {
        setTitle(tr.getString("biodictionary.About.windowTitle"));
        aboutTextPane.setText(tr.getString("biodictionary.About.aboutTextPane"));
        logoLyceum.setToolTipText(tr.getString("biodictionary.About.logoLyceumInfo"));
        logoEtwinning.setToolTipText(tr.getString("biodictionary.About.logoEtwinningInfo"));
        okButton.setText(tr.getString("biodictionary.About.okButton"));
    }
}