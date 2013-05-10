/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageView;


import java.awt.event.ItemEvent;
import java.util.*;
import javax.swing.*;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;

public class InsertArticle extends JPanel {
    
    private ArrayList <Fournisseur> tabFourn;
    private ArrayList <Categorie> tabCat;
    private String typeArt;
    private ApplicationController app;
    private Article nouvArt;
    private Fournisseur fourn;
    private Categorie cat;
   
    
            
            
            
    public InsertArticle() {
        initComponents();
        typeArt = "";
        tabFourn= new ArrayList <Fournisseur>();
        tabCat= new ArrayList <Categorie>();
        try {
                tabFourn= new ApplicationController().getFournArticle();
                this.ComboFourn.removeAllItems();
                this.ComboFourn.addItem(new String("------------------------------------------------"));
                for (Fournisseur f : tabFourn){
                    this.ComboFourn.addItem(f.getNom());
                }
                this.ComboFourn.repaint();
                this.ComboFourn.validate();
                
                tabCat= new ApplicationController().getCatArticle();
                this.JComboCat.removeAllItems();
                this.JComboCat.addItem(new String("------------------------------------------------"));
                for (Categorie cat : tabCat){
                    this.JComboCat.addItem(cat.getNom());
                }
                this.JComboCat.repaint();
                this.JComboCat.validate();
                

         }   
         catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
         catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        PrixMarchSpinner = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        CadeauComboBox = new javax.swing.JComboBox();
        ButtonAjout = new javax.swing.JButton();
        PrixConsSpinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JTextFieldLibelle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ButtonBouteille = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        ButtonFut = new javax.swing.JRadioButton();
        ButtonCasier = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        ComboFourn = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextAreaDesc = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        JComboCat = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Inserer nouvel article");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Prix Consigne :");

        SpinnerModel modelpm = new SpinnerNumberModel(0.00,0.00,1000.00,0.01);
        PrixMarchSpinner.setModel(modelpm);
        PrixMarchSpinner.setCursor(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Prix Marchandise :");

        CadeauComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------------------", "Decapsuleur", "Ballon", "Lazy Bag", "Casquette", "Parapluie", "Verre", "Clé USB" }));

        ButtonAjout.setText("Ajouter ");
        ButtonAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAjoutActionPerformed(evt);
            }
        });

        SpinnerModel modelpc = new SpinnerNumberModel(0.00,0.00,1000.00,0.01);
        PrixConsSpinner.setModel(modelpc);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Cadeau :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setText("(Facultatif)");

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel12.setText("(Facultatif)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Libellé :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Fournisseur :");

        buttonGroup1.add(ButtonBouteille);
        ButtonBouteille.setText("Bouteille");
        ButtonBouteille.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ButtonBouteilleItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Type Article :");

        buttonGroup1.add(ButtonFut);
        ButtonFut.setText("Fût");
        ButtonFut.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ButtonFutItemStateChanged(evt);
            }
        });

        buttonGroup1.add(ButtonCasier);
        ButtonCasier.setText("Casier");
        ButtonCasier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ButtonCasierItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Description :");

        JTextAreaDesc.setColumns(20);
        JTextAreaDesc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        JTextAreaDesc.setRows(1);
        jScrollPane1.setViewportView(JTextAreaDesc);

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel4.setText("(Première lettre en majuscule)");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Catégorie :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JComboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addComponent(CadeauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ComboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonBouteille)
                        .addComponent(ButtonCasier)
                        .addComponent(ButtonFut)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(JComboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTextFieldLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(PrixMarchSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(PrixConsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(CadeauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(30, 30, 30)
                .addComponent(ButtonAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
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
                String Cat = (String)JComboCat.getSelectedItem();
                if (Cat.charAt(0) == '-'){
                    JOptionPane.showMessageDialog(null, "Aucune catégorie sélectionné.");
                }
                else{
                    if (this.JTextFieldLibelle.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Veuillez entrer un libellé.");
                    }
                    else {
                        if(this.JTextAreaDesc.getText().equals("")) { 
                            JOptionPane.showMessageDialog(null, "Veuillez entrer une description.");
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

                                   String cadeau = (String)CadeauComboBox.getSelectedItem();
                                   if (cadeau.charAt(0) == '-'){
                                        cadeau = null; 
                                   }
                                    
                                   app = new ApplicationController ();         
                                   try{
                                        nouvArt = new Article ( this.JTextFieldLibelle.getText(),
                                                                typeArt,
                                                                this.JTextAreaDesc.getText(),
                                                                cadeau,                                                               
                                                                Double.parseDouble(this.PrixMarchSpinner.getValue().toString()),
                                                                prixCons); 
                                        fourn = new Fournisseur(ComboFourn.getSelectedItem().toString());
                                        cat = new Categorie (JComboCat.getSelectedItem().toString());
                                        app.addArticle(nouvArt, fourn, cat);
                                        
                                        
                                        JOptionPane.showMessageDialog(null,"Encodage réalisé avec succès !");
                                       // Retour page d'acceuil apres ajout 
                                        AccueilPanel panel= new AccueilPanel();
                                        panel.setBounds(new MainJFrame().getContentPaneBounds());
                                        this.removeAll();
                                        this.add(panel);
                                        this.repaint();
                                        this.validate();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAjout;
    private javax.swing.JRadioButton ButtonBouteille;
    private javax.swing.JRadioButton ButtonCasier;
    private javax.swing.JRadioButton ButtonFut;
    private javax.swing.JComboBox CadeauComboBox;
    private javax.swing.JComboBox ComboFourn;
    private javax.swing.JComboBox JComboCat;
    private javax.swing.JTextArea JTextAreaDesc;
    private javax.swing.JTextField JTextFieldLibelle;
    private javax.swing.JSpinner PrixConsSpinner;
    private javax.swing.JSpinner PrixMarchSpinner;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
