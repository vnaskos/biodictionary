package com.vnaskos.biodictionary;

import com.vnaskos.biodictionary.search.SearchOptions;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import com.vnaskos.biodictionary.translator.Translate;

/**
 *
 * @author Vasilis Naskos
 */
public class AdvancedSearch extends javax.swing.JFrame {
    
    SearchOptions searchOptions;
    ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    
    Translate tr;
    
    public AdvancedSearch(Translate tr) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.tr = tr;
        this.setTitle(tr.getString("biodictionary.AdvancedSearch.windowTitle"));
        searchOptions = SearchOptions.getInstance();
        addCheckBoxes();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchByLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        moreOptionsLabel = new javax.swing.JLabel();
        fuzzySearchCheckBox = new javax.swing.JCheckBox();
        fuzzyHelpButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        wordCheckBox = new javax.swing.JCheckBox();
        definitionCheckBox = new javax.swing.JCheckBox();
        categoryCheckBox = new javax.swing.JCheckBox();
        imageCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BioDictionary Advanced Search");

        searchByLabel.setText("Search by:");

        moreOptionsLabel.setText("More Options:");

        fuzzySearchCheckBox.setSelected(true);
        fuzzySearchCheckBox.setText("Fuzzy Search");

        fuzzyHelpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/info_1.png"))); // NOI18N
        fuzzyHelpButton.setToolTipText("info");
        fuzzyHelpButton.setBorder(null);
        fuzzyHelpButton.setBorderPainted(false);
        fuzzyHelpButton.setContentAreaFilled(false);
        fuzzyHelpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuzzyHelpButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        wordCheckBox.setSelected(true);
        wordCheckBox.setText("word");

        definitionCheckBox.setSelected(true);
        definitionCheckBox.setText("definition");

        categoryCheckBox.setSelected(true);
        categoryCheckBox.setText("category");

        imageCheckBox.setText("image");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 149, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(wordCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(definitionCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(imageCheckBox)
                        .addContainerGap(118, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchByLabel)
                            .addComponent(categoryCheckBox)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(moreOptionsLabel)
                                    .addComponent(fuzzySearchCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fuzzyHelpButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchByLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordCheckBox)
                    .addComponent(imageCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(definitionCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryCheckBox)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(moreOptionsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fuzzySearchCheckBox))
                    .addComponent(fuzzyHelpButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void fuzzyHelpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuzzyHelpButtonActionPerformed
        JOptionPane.showMessageDialog(null,
                tr.getString("biodictionary.AdvancedSearch.fuzzyHelpButtonInfo"),
                tr.getString("biodictionary.AdvancedSearch.fuzzySearchCheckBox"),
                JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_fuzzyHelpButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        okListener();
    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox categoryCheckBox;
    private javax.swing.JCheckBox definitionCheckBox;
    private javax.swing.JButton fuzzyHelpButton;
    private javax.swing.JCheckBox fuzzySearchCheckBox;
    private javax.swing.JCheckBox imageCheckBox;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel moreOptionsLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel searchByLabel;
    private javax.swing.JCheckBox wordCheckBox;
    // End of variables declaration//GEN-END:variables
    
    public void updateLanguage() {
        searchByLabel.setText(tr.getString("biodictionary.AdvancedSearch.searchByLabel"));
        wordCheckBox.setText(tr.getString("biodictionary.AdvancedSearch.wordCheckBox"));
        definitionCheckBox.setText(tr.getString("biodictionary.AdvancedSearch.definitionCheckBox"));
        categoryCheckBox.setText(tr.getString("biodictionary.AdvancedSearch.categoryCheckBox"));
        imageCheckBox.setText(tr.getString("biodictionary.AdvancedSearch.imageCheckBox"));
        moreOptionsLabel.setText(tr.getString("biodictionary.AdvancedSearch.moreOptionsLabel"));
        fuzzySearchCheckBox.setText(tr.getString("biodictionary.AdvancedSearch.fuzzySearchCheckBox"));
        fuzzyHelpButton.setToolTipText(tr.getString("biodictionary.AdvancedSearch.fuzzyHelpButton"));
        okButton.setText(tr.getString("biodictionary.AdvancedSearch.okButton"));
        cancelButton.setText(tr.getString("biodictionary.AdvancedSearch.cancelButton"));
    }
    
    public final void addCheckBoxes() {
        checkboxes.add(wordCheckBox);
        checkboxes.add(definitionCheckBox);
        checkboxes.add(categoryCheckBox);
        checkboxes.add(imageCheckBox);
    }
    
    public void okListener() {
        ArrayList<String> fields = new ArrayList<String>();
        for (int i = 0; i <= 3; i++) {
            if (checkboxes.get(i).isSelected()) {
                fields.add(checkboxes.get(i).getText());
            }
        }
        if (fields.isEmpty()) {
            return;
        }
        searchOptions.setSearchFields(fields.toArray(new String[]{}));
        searchOptions.setFuzzySearch(fuzzySearchCheckBox.isSelected());
        dispose();
    }
}