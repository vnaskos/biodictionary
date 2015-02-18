package com.vnaskos.biodictionary;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.lucene.queryParser.ParseException;
import org.xml.sax.SAXException;
import com.vnaskos.biodictionary.search.ParseAndIndex;
import com.vnaskos.biodictionary.search.ResultWord;
import com.vnaskos.biodictionary.search.SearchOptions;
import com.vnaskos.biodictionary.search.Token;
import com.vnaskos.biodictionary.translator.Translate;
import com.vnaskos.biodictionary.utils.DictionaryAction;
import com.vnaskos.biodictionary.utils.TokenDisplayFormatter;
import com.vnaskos.biodictionary.utils.TokenHTMLExporter;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Vasilis Naskos
 */
public class Main extends javax.swing.JFrame {
    
    private static final String DEFAULT_IMAGE = "http://new-twinspace.etwinning.net/web/guest";
    
    private final Translate tr;
    private final ParseAndIndex parser;
    private final AdvancedSearch advanced;
    private final CreateDictionary newDictionary;
    private final ProgramPreferences preferencesWindow;
    private final XMLMerge merger;
    
    private final DefaultListModel model;
    private final SearchOptions searchOptions;
    
    /** Creates new form main */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        tr = new Translate() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateAllLanguage();
            }
        };
        
        this.setTitle(tr.getString("biodictionary.Main.windowTitle"));
        
        model = new DefaultListModel();
        wordList.setModel(model);
        
        searchOptions = SearchOptions.getInstance();
        
        //setup file chooser
        openFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("only .xml files","XML");
        openFileChooser.setFileFilter(filter);
        openFileChooser.setDialogTitle("Select Dictionary File");
        
        parser = ParseAndIndex.getInstance();
        
        newDictionary = new CreateDictionary(tr);
        preferencesWindow = new ProgramPreferences(tr);
        merger = new XMLMerge(tr);
        advanced = new AdvancedSearch(tr);
        
        setWordList(DictionaryAction.SET_DEFAULT);
        updateAllLanguage();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openFileChooser = new javax.swing.JFileChooser();
        saveFileChooser = new javax.swing.JFileChooser();
        buttonsPanel = new javax.swing.JPanel();
        helpButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        showAllButton = new javax.swing.JButton();
        imageButton = new javax.swing.JButton();
        mainTabbedPane = new javax.swing.JSplitPane();
        searchPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        wordList = new javax.swing.JList();
        searchLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        advancedSearchButton = new javax.swing.JButton();
        resultPane = new javax.swing.JScrollPane();
        contentPane = new javax.swing.JTextPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        selectFileMenuItem = new javax.swing.JMenuItem();
        includeFileMenuItem = new javax.swing.JMenuItem();
        fileMenuSeparator1 = new javax.swing.JPopupMenu.Separator();
        saveFileMenuItem = new javax.swing.JMenuItem();
        fileMenuSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitFileMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        showAllEditMenuItem = new javax.swing.JMenuItem();
        editMenuSeparator1 = new javax.swing.JPopupMenu.Separator();
        prefsEditMenuItem = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        newToolsMenuItem = new javax.swing.JMenuItem();
        saveToolsMenuItem = new javax.swing.JMenuItem();
        mergeToolsMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        helpMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BioDictionary");
        setMinimumSize(new java.awt.Dimension(676, 594));

        helpButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        helpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/Help-Info-icon.png"))); // NOI18N
        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        aboutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aboutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/Finder-1-icon.png"))); // NOI18N
        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        showAllButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        showAllButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/Customize-ControlPanel-icon.png"))); // NOI18N
        showAllButton.setText("Show all words");
        showAllButton.setToolTipText("Show all words");
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        imageButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main/Photo-icon.png"))); // NOI18N
        imageButton.setText("Image");
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(imageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton)
                .addContainerGap())
        );

        buttonsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {aboutButton, helpButton});

        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                .addComponent(showAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        buttonsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {aboutButton, helpButton, showAllButton});

        mainTabbedPane.setDividerLocation(270);

        searchPanel.setMinimumSize(new java.awt.Dimension(270, 435));

        wordList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        wordList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                wordListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(wordList);

        searchLabel.setText("Search:");

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        advancedSearchButton.setText("Advanced");
        advancedSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedSearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(advancedSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(advancedSearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );

        mainTabbedPane.setLeftComponent(searchPanel);

        contentPane.setEditable(false);
        contentPane.setContentType("text/html"); // NOI18N
        contentPane.setMinimumSize(new java.awt.Dimension(600, 6));
        resultPane.setViewportView(contentPane);

        mainTabbedPane.setRightComponent(resultPane);

        fileMenu.setText("File");

        selectFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        selectFileMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/select.png"))); // NOI18N
        selectFileMenuItem.setText("Select Dictionary File");
        selectFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(selectFileMenuItem);

        includeFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        includeFileMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/include.png"))); // NOI18N
        includeFileMenuItem.setText("Include Dictionary File");
        includeFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                includeFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(includeFileMenuItem);
        fileMenu.add(fileMenuSeparator1);

        saveFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFileMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/save def.png"))); // NOI18N
        saveFileMenuItem.setText("Save Definition to File");
        saveFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveFileMenuItem);
        fileMenu.add(fileMenuSeparator2);

        exitFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitFileMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/close.png"))); // NOI18N
        exitFileMenuItem.setText("Close");
        exitFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitFileMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        showAllEditMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        showAllEditMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/list words.png"))); // NOI18N
        showAllEditMenuItem.setText("Show All Words");
        showAllEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllEditMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(showAllEditMenuItem);
        editMenu.add(editMenuSeparator1);

        prefsEditMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        prefsEditMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/preferenes.png"))); // NOI18N
        prefsEditMenuItem.setText("Preferences");
        prefsEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prefsEditMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(prefsEditMenuItem);

        menuBar.add(editMenu);

        toolsMenu.setText("Tools");

        newToolsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newToolsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/new.png"))); // NOI18N
        newToolsMenuItem.setText("New Dictionary");
        newToolsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newToolsMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(newToolsMenuItem);

        saveToolsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveToolsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/save.png"))); // NOI18N
        saveToolsMenuItem.setText("Save Dictionary");
        saveToolsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToolsMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(saveToolsMenuItem);

        mergeToolsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mergeToolsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/merge.png"))); // NOI18N
        mergeToolsMenuItem.setText("Merge Dictionaries");
        mergeToolsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeToolsMenuItemActionPerformed(evt);
            }
        });
        toolsMenu.add(mergeToolsMenuItem);

        menuBar.add(toolsMenu);

        helpMenu.setText("Help");

        helpMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        helpMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/help.png"))); // NOI18N
        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/about.png"))); // NOI18N
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainTabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        new Help(tr).setVisible(true);
    }//GEN-LAST:event_helpButtonActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        new About(tr).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        new About(tr).setVisible(true);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        new Help(tr).setVisible(true);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
        searchForToken();
    }//GEN-LAST:event_searchFieldKeyTyped

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        searchForToken();
    }//GEN-LAST:event_searchFieldKeyReleased

    private void selectFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileMenuItemActionPerformed
        model.clear();
        setWordList(DictionaryAction.SET_NEW);
    }//GEN-LAST:event_selectFileMenuItemActionPerformed

    private void includeFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_includeFileMenuItemActionPerformed
        setWordList(DictionaryAction.INCLUDE);
    }//GEN-LAST:event_includeFileMenuItemActionPerformed

    private void exitFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFileMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitFileMenuItemActionPerformed

    private void advancedSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedSearchButtonActionPerformed
        advanced.setVisible(true);
    }//GEN-LAST:event_advancedSearchButtonActionPerformed

    private void saveFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenuItemActionPerformed
        exportHTML();
    }//GEN-LAST:event_saveFileMenuItemActionPerformed

    private void newToolsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newToolsMenuItemActionPerformed
        newDictionary.setVisible(true);
    }//GEN-LAST:event_newToolsMenuItemActionPerformed

    private void mergeToolsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeToolsMenuItemActionPerformed
        merger.setVisible(true);
    }//GEN-LAST:event_mergeToolsMenuItemActionPerformed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        showAll();
    }//GEN-LAST:event_showAllButtonActionPerformed

    private void showAllEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllEditMenuItemActionPerformed
        showAll();
    }//GEN-LAST:event_showAllEditMenuItemActionPerformed

    private void saveToolsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToolsMenuItemActionPerformed
        newDictionary.saveDictionary();
    }//GEN-LAST:event_saveToolsMenuItemActionPerformed

    private void prefsEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prefsEditMenuItemActionPerformed
        preferencesWindow.setVisible(true);
    }//GEN-LAST:event_prefsEditMenuItemActionPerformed

    private void imageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageButtonActionPerformed
        openImage();
    }//GEN-LAST:event_imageButtonActionPerformed

    private void wordListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_wordListValueChanged
        updateWordSelection();
    }//GEN-LAST:event_wordListValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the QuaQua look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            try {
                //System.setProperty("Quaqua.design", "panther");
                //UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton advancedSearchButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JTextPane contentPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JPopupMenu.Separator editMenuSeparator1;
    private javax.swing.JMenuItem exitFileMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator1;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator2;
    private javax.swing.JButton helpButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JButton imageButton;
    private javax.swing.JMenuItem includeFileMenuItem;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane mainTabbedPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mergeToolsMenuItem;
    private javax.swing.JMenuItem newToolsMenuItem;
    private javax.swing.JFileChooser openFileChooser;
    private javax.swing.JMenuItem prefsEditMenuItem;
    private javax.swing.JScrollPane resultPane;
    private javax.swing.JFileChooser saveFileChooser;
    private javax.swing.JMenuItem saveFileMenuItem;
    private javax.swing.JMenuItem saveToolsMenuItem;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JMenuItem selectFileMenuItem;
    private javax.swing.JButton showAllButton;
    private javax.swing.JMenuItem showAllEditMenuItem;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JList wordList;
    // End of variables declaration//GEN-END:variables
    
    private void updateAllLanguage() {
        updateLanguage();
        advanced.updateLanguage();
        newDictionary.updateLanguage();
        merger.updateLanguage();
        preferencesWindow.updateLanguage();
    }
    
    private void updateLanguage() {
        searchLabel.setText(tr.getString("biodictionary.Main.searchLabel"));
        advancedSearchButton.setText(tr.getString("biodictionary.Main.advancedSearchButton"));
        showAllButton.setText(tr.getString("biodictionary.Main.showAllButton"));
        imageButton.setText(tr.getString("biodictionary.Main.imageButton"));
        aboutButton.setText(tr.getString("biodictionary.Main.aboutButton"));
        helpButton.setText(tr.getString("biodictionary.Main.helpButton"));
        fileMenu.setText(tr.getString("biodictionary.Main.fileMenu"));
        editMenu.setText(tr.getString("biodictionary.Main.editMenu"));
        toolsMenu.setText(tr.getString("biodictionary.Main.toolsMenu"));
        helpMenu.setText(tr.getString("biodictionary.Main.helpMenu"));
        selectFileMenuItem.setText(tr.getString("biodictionary.Main.selectFileMenuItem"));
        includeFileMenuItem.setText(tr.getString("biodictionary.Main.includeFileMenuItem"));
        saveFileMenuItem.setText(tr.getString("biodictionary.Main.saveFileMenuItem"));
        exitFileMenuItem.setText(tr.getString("biodictionary.Main.exitFileMenuItem"));
        showAllEditMenuItem.setText(tr.getString("biodictionary.Main.showAllEditMenuItem"));
        prefsEditMenuItem.setText(tr.getString("biodictionary.Main.prefsEditMenuItem"));
        newToolsMenuItem.setText(tr.getString("biodictionary.Main.newToolsMenuItem"));
        saveToolsMenuItem.setText(tr.getString("biodictionary.Main.saveToolsMenuItem"));
        mergeToolsMenuItem.setText(tr.getString("biodictionary.Main.mergeToolsMenuItem"));
        helpMenuItem.setText(tr.getString("biodictionary.Main.helpMenuItem"));
        aboutMenuItem.setText(tr.getString("biodictionary.Main.aboutMenuItem"));
        openFileChooser.setDialogTitle(tr.getString("biodictionary.Main.openFileChooser"));
        openFileChooser.setDialogTitle(tr.getString("biodictionary.Main.saveFileChooser"));
    }
    
    private void searchForToken() {
        try {
            search(searchField.getText(), false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorNoDictionary"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setWordList(DictionaryAction acion) {
        try {
            switch(acion) {
                case SET_NEW:
                    setNewWordList();
                    break;
                case INCLUDE:
                    includeWordList();
                    break;
                default:
                    setDefaultWordList();
                    break;
            }
        } catch (IOException ex) {
            handleError(ex);
        } catch (SAXException ex) {
            handleError(ex);
        } catch (ParseException ex) {
            handleError(ex);
        }
    }
    
    private void setDefaultWordList() throws IOException, SAXException, ParseException {
        File dictFile = new File("dictionary.xml");
        
        if (dictFile.exists()) {
            parser.createIndex("dictionary.xml");
        }
    }
    
    private void setNewWordList() throws IOException, SAXException, ParseException {
        if (openFileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String filepath = openFileChooser.getSelectedFile().toString();
        parser.createIndex(filepath);
    }
    
    private void includeWordList() throws IOException, SAXException, ParseException {
        if (openFileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String filepath = openFileChooser.getSelectedFile().toString();
        parser.addDict(filepath);
    }
    
    private void handleError(Exception ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,
                tr.getString("biodictionary.errorUnexpected"),
                tr.getString("biodictionary.errorTitle"),
                JOptionPane.ERROR_MESSAGE);
    }
    
    private void openImage() {
        String image = DEFAULT_IMAGE;

        ResultWord selected = (ResultWord) wordList.getSelectedValue();
        if (selected != null) {
            int docId = selected.getDocId();
            Token selectedToken = parser.getToken(docId);

            if (!selectedToken.getImage().isEmpty()) {
                image = selectedToken.getImage();
            }
        }

        openImage(image);
    }
    
    private void showAll() {
        try {
            search("", true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorNoDictionary"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void search(String searchWord, boolean showAll) {
        if (searchWord.length() == 0 && !showAll) {
            return;
        }
        model.clear();
        TreeSet<ResultWord> searchAll = parser.searchByFields(
                searchWord, searchOptions.getSearchFields(),
                searchOptions.isFuzzySearch());
        
        for (ResultWord word : searchAll) {
            model.addElement(word);
        }

    }
    
    private void updateWordSelection() {
        if (model.isEmpty() || wordList.getSelectedIndices().length == 0) {
            return;
        }
        try {
            ResultWord selected = (ResultWord) wordList.getSelectedValue();
            Token token = parser.getToken(selected.getDocId());
            String text = TokenDisplayFormatter.format(tr, token);
            contentPane.setText(text);
            contentPane.setCaretPosition(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorUnexpected"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void openImage(String imageUrl) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(imageUrl));
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exportHTML() {
        ResultWord selected = (ResultWord) wordList.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(null,
                    tr.getString("biodictionary.errorHTMLExport"),
                    tr.getString("biodictionary.errorTitle"),
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Token token = parser.getToken(selected.getDocId());

        if (saveFileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        String output = saveFileChooser.getSelectedFile().getPath();
        if (!output.endsWith(".html")) {
            output += ".html";
        }

        TokenHTMLExporter.export(tr, token, output);
    }
}
