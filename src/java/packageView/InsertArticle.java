/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageView;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.*;
import javax.swing.*;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;

public class InsertArticle extends JPanel {
    
    private ArrayList <String> tabFourn;
    private String typeArt;
    private ApplicationController app;
    private Article nouvArt;
    
            
            
            
    public InsertArticle() {
        initComponents();
        typeArt = "";
        tabFourn= new ArrayList <String>();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ButtonBouteille = new javax.swing.JRadioButton();
        ButtonCasier = new javax.swing.JRadioButton();
        ButtonFut = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        JTextFieldLibelle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextAreaDesc = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        SpinnerQuantite = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PrixMarchSpinner = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        PrixConsSpinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        CadeauComboBox = new javax.swing.JComboBox();
        ButtonAjout = new javax.swing.JButton();
        ButtonQuitter = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SpinnerDate = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        ComboFourn = new javax.swing.JComboBox();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Inserer nouvel article");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Type Article :");

        buttonGroup1.add(ButtonBouteille);
        ButtonBouteille.setText("Bouteille");
        ButtonBouteille.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ButtonBouteilleItemStateChanged(evt);
            }
        });

        buttonGroup1.add(ButtonCasier);
        ButtonCasier.setText("Casier");
        ButtonCasier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ButtonCasierItemStateChanged(evt);
            }
        });

        buttonGroup1.add(ButtonFut);
        ButtonFut.setText("Fût");
        ButtonFut.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ButtonFutItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Libellé :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel4.setText("(Première lettre en majuscule)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Description :");

        JTextAreaDesc.setColumns(20);
        JTextAreaDesc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        JTextAreaDesc.setRows(1);
        jScrollPane1.setViewportView(JTextAreaDesc);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Quantité :");

        SpinnerModel modelq = new SpinnerNumberModel(0,0,1000,1);
        SpinnerQuantite.setModel(modelq);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Date de peremption : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Prix Marchandise :");

        SpinnerModel modelpm = new SpinnerNumberModel(0,0,1000,1);
        PrixMarchSpinner.setModel(modelpm);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Prix Consigne :");

        SpinnerModel modelpc = new SpinnerNumberModel(0,0,1000,1);
        PrixConsSpinner.setModel(modelpc);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Cadeau :");

        CadeauComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------------------", "Decapsuleur", "Ballon", "Lazy Bag", "Casquette", "Parapluie", "Verre", "Clé USB" }));

        ButtonAjout.setText("Enregistrer et encoder nouveau");
        ButtonAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAjoutActionPerformed(evt);
            }
        });

        ButtonQuitter.setText("Enregistrer et quitter ");
        ButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQuitterActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setText("(Facultatif)");

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel12.setText("(Facultatif)");

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setText("(Facultatif)");

        SpinnerDateModel dateModel =new SpinnerDateModel();
        SpinnerDate.setModel(dateModel);
        SpinnerDate.setEditor(new JSpinner.DateEditor(SpinnerDate, "dd-MM-yyyy"));
        SpinnerDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1365951508485L), null, null, java.util.Calendar.DAY_OF_MONTH));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Fournisseur :");

        ComboFourn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboFournItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ButtonBouteille)
                                        .addGap(18, 18, 18)
                                        .addComponent(ButtonCasier)
                                        .addGap(18, 18, 18)
                                        .addComponent(ButtonFut))
                                    .addComponent(JTextFieldLibelle)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(PrixConsSpinner)
                                    .addComponent(PrixMarchSpinner)
                                    .addComponent(SpinnerQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CadeauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ButtonAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonQuitter)))))
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ComboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonBouteille)
                        .addComponent(ButtonCasier)
                        .addComponent(ButtonFut)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTextFieldLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SpinnerQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(PrixMarchSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(PrixConsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(CadeauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAjoutActionPerformed
        String Fourn = (String)ComboFourn.getSelectedItem();
        if (Fourn.charAt(0) == '-'){
            JOptionPane.showMessageDialog(null, "Aucun fournisseur sélectionné.");
        }
        else{
            if (typeArt.equals("")) {
                JOptionPane.showMessageDialog(null, "Aucun type sélectionné.");      
            }      
            else {
                if (this.JTextFieldLibelle.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer un libellé.");
                }
                else {
                    if(this.JTextAreaDesc.getText().equals("")) { 
                    JOptionPane.showMessageDialog(null, "Veuillez entrer une description.");
                    }
                    else {
                        if(Integer.parseInt(this.SpinnerQuantite.getValue().toString())==0) {
                        JOptionPane.showMessageDialog(null, "Veuillez indiquer une quantité.");
                        }
                        else {
                            if(Double.parseDouble(this.PrixMarchSpinner.getValue().toString())==0) {
                            JOptionPane.showMessageDialog(null, "Veuillez indiquer le prix de la marchandise.");
                            }
                            else {
                                double prixCons=0;
                                if (!(Double.parseDouble(this.PrixConsSpinner.getValue().toString())==0)) {
                                    prixCons = Double.parseDouble(this.PrixConsSpinner.getValue().toString());
                                }
                            
                                GregorianCalendar dateP = new GregorianCalendar();
                                Date datePeremp = ((SpinnerDateModel)SpinnerDate.getModel()).getDate();
                                if(!(datePeremp.toString().equals(""))){
                                    dateP.set(datePeremp.getDay(),datePeremp.getMonth(),datePeremp.getYear());
                                 }
                     
                                String cadeau = (String)CadeauComboBox.getSelectedItem();
                                if (cadeau.charAt(0) == '-'){
                                     cadeau = null; 
                                }
                   
                                app = new ApplicationController ();         
                                try{
                                    nouvArt = new Article (this.JTextFieldLibelle.getText(),
                                                           typeArt,
                                                           this.JTextAreaDesc.getText(),
                                                           cadeau,
                                                           Double.parseDouble(this.SpinnerQuantite.getValue().toString()),
                                                           Double.parseDouble(this.PrixMarchSpinner.getValue().toString()),
                                                           prixCons,
                                                           dateP); 
                                    app.addArticle(nouvArt);
                                    JOptionPane.showMessageDialog(null,"Encodage réalisé avec succès !");
                                }   
                            
                                catch(BdErreur e){
                                     JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
                                }

                                catch(NoIdentification e){
                                     JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
                                }
                            
                                }           
                        }
   
                    }
                }
            }
        }
    }//GEN-LAST:event_ButtonAjoutActionPerformed

    private void ButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonQuitterActionPerformed

    private void ButtonBouteilleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonBouteilleItemStateChanged
       if(evt.getStateChange()== ItemEvent.SELECTED){
           typeArt = "Bouteille";  
        }
    }//GEN-LAST:event_ButtonBouteilleItemStateChanged

    private void ButtonCasierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonCasierItemStateChanged
       if(evt.getStateChange()== ItemEvent.SELECTED){
           typeArt = "Casier";
       }
    }//GEN-LAST:event_ButtonCasierItemStateChanged

    private void ButtonFutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonFutItemStateChanged
       if(evt.getStateChange()== ItemEvent.SELECTED){
           typeArt ="Fût";
       }
    }//GEN-LAST:event_ButtonFutItemStateChanged

    private void ComboFournItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboFournItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
         try {
                tabFourn= new ApplicationController().getFournArticle();
                this.ComboFourn.removeAllItems();
                for (String lib : tabFourn){
                    this.ComboFourn.addItem(lib);
                }
                this.ComboFourn.setBackground(Color.blue);
                this.ComboFourn.repaint();
                this.ComboFourn.validate();
             
         }   
         catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
         catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ComboFournItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAjout;
    private javax.swing.JRadioButton ButtonBouteille;
    private javax.swing.JRadioButton ButtonCasier;
    private javax.swing.JRadioButton ButtonFut;
    private javax.swing.JButton ButtonQuitter;
    private javax.swing.JComboBox CadeauComboBox;
    private javax.swing.JComboBox ComboFourn;
    private javax.swing.JTextArea JTextAreaDesc;
    private javax.swing.JTextField JTextFieldLibelle;
    private javax.swing.JSpinner PrixConsSpinner;
    private javax.swing.JSpinner PrixMarchSpinner;
    private javax.swing.JSpinner SpinnerDate;
    private javax.swing.JSpinner SpinnerQuantite;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
