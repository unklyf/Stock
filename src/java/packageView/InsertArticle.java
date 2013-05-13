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
        labelInsArt = new javax.swing.JLabel();
        panelChamp = new javax.swing.JPanel();
        labelConsigne = new javax.swing.JLabel();
        PrixMarchSpinner = new javax.swing.JSpinner();
        labelMarchandise = new javax.swing.JLabel();
        CadeauComboBox = new javax.swing.JComboBox();
        ButtonAjout = new javax.swing.JButton();
        PrixConsSpinner = new javax.swing.JSpinner();
        labelCadeau = new javax.swing.JLabel();
        labelFacultatifCad = new javax.swing.JLabel();
        JTextFieldLibelle = new javax.swing.JTextField();
        labelFacultatifCons = new javax.swing.JLabel();
        labelLibelle = new javax.swing.JLabel();
        labelFourn = new javax.swing.JLabel();
        ButtonBouteille = new javax.swing.JRadioButton();
        labelType = new javax.swing.JLabel();
        ButtonFut = new javax.swing.JRadioButton();
        ButtonCasier = new javax.swing.JRadioButton();
        labelDescription = new javax.swing.JLabel();
        ComboFourn = new javax.swing.JComboBox();
        jScrollPaneDesc = new javax.swing.JScrollPane();
        JTextAreaDesc = new javax.swing.JTextArea();
        labelMajuscule = new javax.swing.JLabel();
        labelCat = new javax.swing.JLabel();
        JComboCat = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(800, 700));

        labelInsArt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelInsArt.setForeground(new java.awt.Color(153, 0, 51));
        labelInsArt.setText("Inserer nouvel article");

        labelConsigne.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelConsigne.setText("Prix Consigne :");

        SpinnerModel modelpm = new SpinnerNumberModel(0.00,0.00,1000.00,0.01);
        PrixMarchSpinner.setModel(modelpm);
        PrixMarchSpinner.setCursor(null);

        labelMarchandise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMarchandise.setText("Prix Marchandise :");

        CadeauComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------------------", "Decapsuleur", "Ballon", "Lazy Bag", "Casquette", "Parapluie", "Verre", "Clé USB" }));

        ButtonAjout.setText("Ajouter ");
        ButtonAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAjoutActionPerformed(evt);
            }
        });

        SpinnerModel modelpc = new SpinnerNumberModel(0.00,0.00,1000.00,0.01);
        PrixConsSpinner.setModel(modelpc);

        labelCadeau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCadeau.setText("Cadeau :");

        labelFacultatifCad.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelFacultatifCad.setText("(Facultatif)");

        labelFacultatifCons.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelFacultatifCons.setText("(Facultatif)");

        labelLibelle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelLibelle.setText("Libellé :");

        labelFourn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelFourn.setText("Fournisseur :");

        buttonGroup1.add(ButtonBouteille);
        ButtonBouteille.setText("Bouteille");
        ButtonBouteille.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ButtonBouteilleItemStateChanged(evt);
            }
        });

        labelType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelType.setText("Type Article :");

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

        labelDescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDescription.setText("Description :");

        JTextAreaDesc.setColumns(20);
        JTextAreaDesc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        JTextAreaDesc.setRows(1);
        jScrollPaneDesc.setViewportView(JTextAreaDesc);

        labelMajuscule.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        labelMajuscule.setText("(Première lettre en majuscule)");

        labelCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCat.setText("Catégorie :");

        javax.swing.GroupLayout panelChampLayout = new javax.swing.GroupLayout(panelChamp);
        panelChamp.setLayout(panelChampLayout);
        panelChampLayout.setHorizontalGroup(
            panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChampLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChampLayout.createSequentialGroup()
                        .addComponent(labelCat, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JComboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelChampLayout.createSequentialGroup()
                        .addComponent(labelFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelChampLayout.createSequentialGroup()
                        .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelCadeau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelConsigne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMarchandise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelLibelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelType, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelChampLayout.createSequentialGroup()
                                .addComponent(ButtonBouteille)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonCasier)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonFut))
                            .addComponent(JTextFieldLibelle)
                            .addComponent(labelMajuscule, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPaneDesc)
                            .addComponent(PrixConsSpinner)
                            .addComponent(PrixMarchSpinner)
                            .addComponent(CadeauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFacultatifCons, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFacultatifCad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );
        panelChampLayout.setVerticalGroup(
            panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChampLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFourn)
                    .addComponent(ComboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelType)
                    .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonBouteille)
                        .addComponent(ButtonCasier)
                        .addComponent(ButtonFut)))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCat)
                    .addComponent(JComboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelMajuscule)
                .addGap(2, 2, 2)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLibelle)
                    .addComponent(JTextFieldLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescription)
                    .addComponent(jScrollPaneDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMarchandise)
                    .addComponent(PrixMarchSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConsigne)
                    .addComponent(PrixConsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFacultatifCons))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCadeau)
                    .addComponent(CadeauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFacultatifCad))
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
                        .addComponent(labelInsArt, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(panelChamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelInsArt)
                .addGap(18, 18, 18)
                .addComponent(panelChamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JScrollPane jScrollPaneDesc;
    private javax.swing.JLabel labelCadeau;
    private javax.swing.JLabel labelCat;
    private javax.swing.JLabel labelConsigne;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelFacultatifCad;
    private javax.swing.JLabel labelFacultatifCons;
    private javax.swing.JLabel labelFourn;
    private javax.swing.JLabel labelInsArt;
    private javax.swing.JLabel labelLibelle;
    private javax.swing.JLabel labelMajuscule;
    private javax.swing.JLabel labelMarchandise;
    private javax.swing.JLabel labelType;
    private javax.swing.JPanel panelChamp;
    // End of variables declaration//GEN-END:variables
}
