package com.vnaskos.biodictionary;

import com.vnaskos.biodictionary.search.ParseAndIndex;
import com.vnaskos.biodictionary.search.ResultWord;
import com.vnaskos.biodictionary.search.Token;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import com.vnaskos.biodictionary.translator.Translate;
import com.vnaskos.biodictionary.xmlTools.DocConstructor;
import com.vnaskos.biodictionary.xmlTools.XMLExporter;
import java.util.AbstractList;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vasilis Naskos
 */
public class CreateDictionary extends javax.swing.JFrame {

    DefaultListModel model;
    Translate tr;
    
    public CreateDictionary(Translate tr) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.tr = tr;
        this.setTitle(tr.getString("biodictionary.CreateDictionary.windowTitle"));
        model = new DefaultListModel();
        wordsList.setModel(model);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        xmlChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        wordsList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        wordLabel = new javax.swing.JLabel();
        definitionLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        wordField = new javax.swing.JTextField();
        categoryField = new javax.swing.JTextField();
        imageField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        definitionField = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        saveButon = new javax.swing.JButton();
        addLoadedButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BioDictionary Create New");

        wordsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                wordsListMousePressed(evt);
            }
        });
        wordsList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                wordsListKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(wordsList);

        addButton.setText("Add");
        addButton.setMaximumSize(new java.awt.Dimension(30, 30));
        addButton.setMinimumSize(new java.awt.Dimension(30, 30));
        addButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setMaximumSize(new java.awt.Dimension(30, 30));
        removeButton.setMinimumSize(new java.awt.Dimension(30, 30));
        removeButton.setPreferredSize(new java.awt.Dimension(30, 30));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.setMaximumSize(new java.awt.Dimension(30, 30));
        clearButton.setMinimumSize(new java.awt.Dimension(30, 30));
        clearButton.setPreferredSize(new java.awt.Dimension(30, 30));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.setMaximumSize(new java.awt.Dimension(30, 30));
        editButton.setMinimumSize(new java.awt.Dimension(30, 30));
        editButton.setPreferredSize(new java.awt.Dimension(30, 30));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, clearButton, editButton, removeButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        wordLabel.setText("Word:");

        definitionLabel.setText("Definition:");

        categoryLabel.setText("Category:");

        imageLabel.setText("Image:");

        definitionField.setColumns(20);
        definitionField.setRows(5);
        jScrollPane2.setViewportView(definitionField);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButon.setText("Save");
        saveButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButonActionPerformed(evt);
            }
        });

        addLoadedButton.setText("Add Loaded");
        addLoadedButton.setMaximumSize(new java.awt.Dimension(30, 30));
        addLoadedButton.setMinimumSize(new java.awt.Dimension(30, 30));
        addLoadedButton.setPreferredSize(new java.awt.Dimension(30, 30));
        addLoadedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLoadedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(wordField)
                    .addComponent(imageField)
                    .addComponent(categoryField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wordLabel)
                            .addComponent(definitionLabel)
                            .addComponent(imageLabel)
                            .addComponent(categoryLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(addLoadedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, saveButon});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(wordLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(definitionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButon)
                        .addComponent(cancelButton)
                        .addComponent(addLoadedButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addToken();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        for (Object selected : wordsList.getSelectedValues()){
            model.removeElement(selected);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        model.clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        editToken();
    }//GEN-LAST:event_editButtonActionPerformed

    private void wordsListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wordsListKeyPressed
        wordListClickListener();
    }//GEN-LAST:event_wordsListKeyPressed

    private void wordsListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wordsListMousePressed
        wordListClickListener();
    }//GEN-LAST:event_wordsListMousePressed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButonActionPerformed
        saveDictionary();
    }//GEN-LAST:event_saveButonActionPerformed

    private void addLoadedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLoadedButtonActionPerformed
        parseAllLoadedWords();
    }//GEN-LAST:event_addLoadedButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addLoadedButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField categoryField;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextArea definitionField;
    private javax.swing.JLabel definitionLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField imageField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButon;
    private javax.swing.JTextField wordField;
    private javax.swing.JLabel wordLabel;
    private javax.swing.JList wordsList;
    private javax.swing.JFileChooser xmlChooser;
    // End of variables declaration//GEN-END:variables

    public void updateLanguage() {
        wordLabel.setText(tr.getString("biodictionary.CreateDictionary.wordLabel"));
        definitionLabel.setText(tr.getString("biodictionary.CreateDictionary.definitionLabel"));
        categoryLabel.setText(tr.getString("biodictionary.CreateDictionary.categoryLabel"));
        imageLabel.setText(tr.getString("biodictionary.CreateDictionary.imageLabel"));
        addButton.setText(tr.getString("biodictionary.CreateDictionary.addButton"));
        addLoadedButton.setText(tr.getString("biodictionary.CreateDictionary.addLoadedButton"));
        removeButton.setText(tr.getString("biodictionary.CreateDictionary.removeButton"));
        clearButton.setText(tr.getString("biodictionary.CreateDictionary.clearButton"));
        editButton.setText(tr.getString("biodictionary.CreateDictionary.editButton"));
        saveButon.setText(tr.getString("biodictionary.CreateDictionary.saveButton"));
        cancelButton.setText(tr.getString("biodictionary.CreateDictionary.cancelButton"));
    }
    
    private void addToken() {
        if (wordField.getText().isEmpty()) {
            return;
        }
        
        Token token = Token.createNew(
                wordField.getText(),
                definitionField.getText(),
                categoryField.getText(),
                imageField.getText()
        );

        model.addElement(token);
    }
    
    private void wordListClickListener() {
        if (wordsList.getSelectedValue() == null) {
            return;
        }
        
        Token selected = (Token) wordsList.getSelectedValue();
        wordField.setText(selected.getWord());
        definitionField.setText(selected.getDefinision());
        categoryField.setText(selected.getCategory());
        imageField.setText(selected.getImage());
    }
    
    private void editToken() {
        if (wordsList.getSelectedValue() == null) {
            return;
        }
        Token selected = (Token) wordsList.getSelectedValue();
        
        selected.setWord(wordField.getText());
        selected.setDefinition(definitionField.getText());
        selected.setCategory(categoryField.getText());
        selected.setImage(imageField.getText());
        
        wordsList.updateUI();
    }
    
    public void saveDictionary() {
        try {
            if (xmlChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
                return;
            }
            
            String outputName = xmlChooser.getSelectedFile().getPath();
            List<Token> tokens = asTokenList(model);
            Document doc = DocConstructor.getDoc(tokens);

            XMLExporter.export(tr, doc, outputName);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLExporter.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorNewDictionary"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private static List<Token> asTokenList(final DefaultListModel model) {
        return new AbstractList<Token>() {
            @Override
            public Token get(int index) {
                return (Token) model.getElementAt(index);
            }

            @Override
            public int size() {
                return model.getSize();
            }
        };
    }
    
    private void parseAllLoadedWords() {
        ParseAndIndex parser = ParseAndIndex.getInstance();
        TreeSet<ResultWord> searchAll = parser.searchByFields(
                "", new String[]{"word"}, true);
        
        for (ResultWord word : searchAll) {
            Token token = parser.getToken(word.getDocId());
            model.addElement(token);
        }
    }
}
