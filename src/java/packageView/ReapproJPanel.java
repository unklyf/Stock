package packageView;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;


public class ReapproJPanel extends JPanel {
    
    private ArrayList <String> tabLib;
    private String typeA;
    
    public ReapproJPanel() {
        initComponents();
        tabLib= new ArrayList <String>(); 
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxArticle = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bouteilleRadioButton = new javax.swing.JRadioButton();
        casierRadioButton = new javax.swing.JRadioButton();
        futRadioButton = new javax.swing.JRadioButton();
        rechTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descTexteArea = new javax.swing.JTextArea();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Encoder réapprovisionnement");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Libelle Article :");

        comboBoxArticle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxArticleItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Quantitée :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Type Article :");

        buttonGroup1.add(bouteilleRadioButton);
        bouteilleRadioButton.setText("Bouteille");
        bouteilleRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bouteilleRadioButtonItemStateChanged(evt);
            }
        });

        buttonGroup1.add(casierRadioButton);
        casierRadioButton.setText("Casier");
        casierRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                casierRadioButtonItemStateChanged(evt);
            }
        });

        buttonGroup1.add(futRadioButton);
        futRadioButton.setText("Fût");
        futRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                futRadioButtonItemStateChanged(evt);
            }
        });

        rechTextField.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        rechTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Description :");

        descTexteArea.setColumns(20);
        descTexteArea.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        descTexteArea.setRows(5);
        descTexteArea.setAutoscrolls(false);
        descTexteArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        descTexteArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(descTexteArea);
        descTexteArea.setEditable(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packageImage/loupe.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bouteilleRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(casierRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(futRadioButton))
                                    .addComponent(rechTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addComponent(comboBoxArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bouteilleRadioButton)
                        .addComponent(casierRadioButton)
                        .addComponent(futRadioButton)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rechTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(comboBoxArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(168, 168, 168))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bouteilleRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bouteilleRadioButtonItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            try {
                typeA="Bouteille";
                tabLib= new ApplicationController().getLibArticle(typeA);
                this.comboBoxArticle.removeAllItems();
                for (String lib : tabLib){
                    this.comboBoxArticle.addItem(lib);
                }
                this.comboBoxArticle.setBackground(Color.blue);
                this.comboBoxArticle.repaint();
                this.comboBoxArticle.validate();
           }
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bouteilleRadioButtonItemStateChanged

    private void casierRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_casierRadioButtonItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            try {
                typeA="Casier";
                tabLib= new ApplicationController().getLibArticle(typeA);
                this.comboBoxArticle.removeAllItems();
                for (String lib : tabLib){
                    this.comboBoxArticle.addItem(lib);
                }
                this.comboBoxArticle.setBackground(Color.blue);
                this.comboBoxArticle.repaint();
                this.comboBoxArticle.validate();
           }
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_casierRadioButtonItemStateChanged

    private void futRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_futRadioButtonItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            try {
                typeA="Fût";
                tabLib= new ApplicationController().getLibArticle(typeA);
                this.comboBoxArticle.removeAllItems();
                for (String lib : tabLib){
                    this.comboBoxArticle.addItem(lib);
                }
                this.comboBoxArticle.setBackground(Color.blue);
                this.comboBoxArticle.repaint();
                this.comboBoxArticle.validate();
           }
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_futRadioButtonItemStateChanged

    private void rechTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechTextFieldActionPerformed

    private void comboBoxArticleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxArticleItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            try {
                this.descTexteArea.setText( new ApplicationController().getDescArticle(this.comboBoxArticle.getSelectedItem().toString(),this.typeA));
            }
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
          }
    }//GEN-LAST:event_comboBoxArticleItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bouteilleRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JRadioButton casierRadioButton;
    private javax.swing.JComboBox comboBoxArticle;
    private javax.swing.JTextArea descTexteArea;
    private javax.swing.JRadioButton futRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField rechTextField;
    // End of variables declaration//GEN-END:variables
}
