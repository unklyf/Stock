package packageView;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.*;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.*;


public class ReapproJPanel extends JPanel {
    
    
    private ArrayList <Article> listeArtCombo;
    private ArrayList <LigneReappro> listeLReap;
    private Article art;
    private Reappro reapAdd;
    private LigneReappro lReap;
    private ListSelectionModel listSelect;
    
    public ReapproJPanel(Reappro rA) {
        initComponents();
        
        //Objets
        listeArtCombo= new ArrayList <Article>();
        listeLReap = new ArrayList <LigneReappro> ();
        
        //JTable
        jTableRecap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelect = jTableRecap.getSelectionModel();
        
        //Remplir ce qu'on reçoit avec le constructeur
        reapAdd = rA;
    
        
        //Boutons modifications
        confirmModifButton.setVisible(false);
        jTextFieldModifLib.setVisible(false);
        jTextFieldModifType.setVisible(false);
        
        this.comboBoxArticle.setEnabled(false);
    }
    
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelEncodage = new javax.swing.JPanel();
        futRadioButton = new javax.swing.JRadioButton();
        jLabelQte = new javax.swing.JLabel();
        bouteilleRadioButton = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        descTexteArea = new javax.swing.JTextArea();
        comboBoxArticle = new javax.swing.JComboBox();
        quantiteSpinner = new javax.swing.JSpinner();
        jLabelTypeArt = new javax.swing.JLabel();
        jLabelLibArt = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        casierRadioButton = new javax.swing.JRadioButton();
        jLabelDesc = new javax.swing.JLabel();
        endButton = new javax.swing.JButton();
        annulerButton = new javax.swing.JButton();
        confirmModifButton = new javax.swing.JButton();
        jTextFieldModifType = new javax.swing.JTextField();
        jTextFieldModifLib = new javax.swing.JTextField();
        titrePanelEncodage = new javax.swing.JLabel();
        titrePanelTableau = new javax.swing.JLabel();
        jPanelTableau = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRecap = new javax.swing.JTable();
        modifButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        buttonGroup1.add(futRadioButton);
        futRadioButton.setText("Fût");
        futRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                futRadioButtonItemStateChanged(evt);
            }
        });

        jLabelQte.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelQte.setText("Quantité  :");

        buttonGroup1.add(bouteilleRadioButton);
        bouteilleRadioButton.setText("Bouteille");
        bouteilleRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bouteilleRadioButtonItemStateChanged(evt);
            }
        });

        descTexteArea.setEditable(false);
        descTexteArea.setColumns(20);
        descTexteArea.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        descTexteArea.setRows(1);
        descTexteArea.setAutoscrolls(false);
        descTexteArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        descTexteArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        descTexteArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        descTexteArea.setEnabled(false);
        jScrollPane2.setViewportView(descTexteArea);

        comboBoxArticle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxArticleItemStateChanged(evt);
            }
        });

        SpinnerModel modelq = new SpinnerNumberModel(0,0,1000,1);
        quantiteSpinner.setModel(modelq);

        jLabelTypeArt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTypeArt.setText("Type Article :");

        jLabelLibArt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelLibArt.setText("Libelle Article :");

        addButton.setBackground(new java.awt.Color(51, 102, 255));
        addButton.setText("Commander nouvel article");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(casierRadioButton);
        casierRadioButton.setText("Casier");
        casierRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                casierRadioButtonItemStateChanged(evt);
            }
        });

        jLabelDesc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelDesc.setText("Description :");

        endButton.setBackground(new java.awt.Color(0, 153, 0));
        endButton.setText("Terminer la commande");
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        annulerButton.setBackground(new java.awt.Color(255, 0, 0));
        annulerButton.setText("Annuler");
        annulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerButtonActionPerformed(evt);
            }
        });

        confirmModifButton.setBackground(new java.awt.Color(51, 102, 255));
        confirmModifButton.setText("Confirmer modification");
        confirmModifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmModifButtonActionPerformed(evt);
            }
        });

        jTextFieldModifType.setEditable(false);
        jTextFieldModifType.setBackground(new java.awt.Color(204, 102, 0));
        jTextFieldModifType.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldModifType.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldModifType.setEnabled(false);

        jTextFieldModifLib.setEditable(false);
        jTextFieldModifLib.setBackground(new java.awt.Color(204, 102, 0));
        jTextFieldModifLib.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldModifLib.setAutoscrolls(false);
        jTextFieldModifLib.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldModifLib.setEnabled(false);

        javax.swing.GroupLayout jPanelEncodageLayout = new javax.swing.GroupLayout(jPanelEncodage);
        jPanelEncodage.setLayout(jPanelEncodageLayout);
        jPanelEncodageLayout.setHorizontalGroup(
            jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncodageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTypeArt)
                    .addComponent(jLabelLibArt)
                    .addComponent(jLabelDesc)
                    .addComponent(jLabelQte))
                .addGap(18, 18, 18)
                .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEncodageLayout.createSequentialGroup()
                        .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelEncodageLayout.createSequentialGroup()
                                .addComponent(bouteilleRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(casierRadioButton)
                                .addGap(29, 29, 29)
                                .addComponent(futRadioButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldModifLib, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldModifType, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(quantiteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEncodageLayout.createSequentialGroup()
                        .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(endButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEncodageLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(annulerButton))
                            .addGroup(jPanelEncodageLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(confirmModifButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEncodageLayout.setVerticalGroup(
            jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncodageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTypeArt)
                    .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bouteilleRadioButton)
                        .addComponent(casierRadioButton)
                        .addComponent(futRadioButton)
                        .addComponent(jTextFieldModifType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLibArt)
                    .addComponent(comboBoxArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModifLib, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDesc)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQte)
                    .addComponent(quantiteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmModifButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEncodageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annulerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        titrePanelEncodage.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        titrePanelEncodage.setForeground(new java.awt.Color(153, 0, 51));
        titrePanelEncodage.setText("Commande fournisseur");

        titrePanelTableau.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        titrePanelTableau.setForeground(new java.awt.Color(153, 0, 51));
        titrePanelTableau.setText("Récapitulatif réappro");

        jTableRecap.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTableRecap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableRecap);

        modifButton.setForeground(new java.awt.Color(204, 102, 0));
        modifButton.setText("Modifier un article");
        modifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifButtonActionPerformed(evt);
            }
        });

        deleteButton.setForeground(new java.awt.Color(204, 0, 0));
        deleteButton.setText("Supprimer un article");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTableauLayout = new javax.swing.GroupLayout(jPanelTableau);
        jPanelTableau.setLayout(jPanelTableauLayout);
        jPanelTableauLayout.setHorizontalGroup(
            jPanelTableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableauLayout.createSequentialGroup()
                .addGroup(jPanelTableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTableauLayout.createSequentialGroup()
                        .addComponent(modifButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanelTableauLayout.setVerticalGroup(
            jPanelTableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanelTableauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanelEncodage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titrePanelTableau)
                    .addComponent(jPanelTableau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(titrePanelEncodage)
                    .addContainerGap(742, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(titrePanelTableau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTableau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jPanelEncodage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(titrePanelEncodage)
                    .addContainerGap(583, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    //Choix du type Bouteille
    private void bouteilleRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bouteilleRadioButtonItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            try {
                art=new Article();
                art.setTypeA("Bouteille");
                listeArtCombo= new ApplicationController().getArticleReappro(art,reapAdd);
                this.comboBoxArticle.removeAllItems();
                for (Article lib : listeArtCombo){
                    this.comboBoxArticle.addItem(lib.getLibelle());
                }
                this.comboBoxArticle.setEnabled(true);
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
 
    //Choix du type Casier
    private void casierRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_casierRadioButtonItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            try {
                art=new Article();
                art.setTypeA("Casier");                
                listeArtCombo= new ApplicationController().getArticleReappro(art,reapAdd);
                this.comboBoxArticle.removeAllItems();
                for (Article lib : listeArtCombo){
                    this.comboBoxArticle.addItem(lib.getLibelle());
                }
                this.comboBoxArticle.setEnabled(true);
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
 
    
    //Choix du type Fut
    private void futRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_futRadioButtonItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            try {
                art=new Article();
                art.setTypeA("Fût");
                listeArtCombo= new ApplicationController().getArticleReappro(art,reapAdd);
                this.comboBoxArticle.removeAllItems();
                for (Article lib : listeArtCombo){
                    this.comboBoxArticle.addItem(lib.getLibelle());
                }
                this.comboBoxArticle.setEnabled(true);
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

    
    //Affichage de la description de l'article en fonction du libelle choisit
    private void comboBoxArticleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxArticleItemStateChanged
       if(evt.getStateChange()== ItemEvent.SELECTED){
                descTexteArea.setText(listeArtCombo.get(this.comboBoxArticle.getSelectedIndex()).getDescription());    
        }
    }//GEN-LAST:event_comboBoxArticleItemStateChanged

    
    
    //Ajout article a l'arrayListe et mis à jour jTableReap
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        boolean existe=false;
        int choix,indice=0,qte;
        
        if (bouteilleRadioButton.isSelected()==false && futRadioButton.isSelected()==false && casierRadioButton.isSelected()==false) {
              JOptionPane.showMessageDialog(null, "Aucun type sélectionné.\nVeuillez sélectionner un type");      
        }
        else{            
            if(Integer.parseInt(quantiteSpinner.getValue().toString())==0) {
               JOptionPane.showMessageDialog(null, "La quantité est égale à 0.\nVeuillez entrer une quantité.");
            }
            else {
                  
                 //Creation ligne reappro
                 art.setLibelle(listeArtCombo.get(comboBoxArticle.getSelectedIndex()).getLibelle());
                 lReap = new LigneReappro(Integer.parseInt(quantiteSpinner.getValue().toString()),art);                      
                 
                
      
                 //Verification doublon d'articles
                 for (int i=0;i<listeLReap.size();i++){
                     if(listeLReap.get(i).getArt().getLibelle().equals(art.getLibelle()) && listeLReap.get(i).getArt().getType().equals(art.getType())){
                        existe=true;
                        indice = i;
                    }
                 }
                 
                 if(existe == false){
                     //Ajout dans les arrayList
                     listeLReap.add(lReap);
                 }
                 else{
                    choix= JOptionPane.showConfirmDialog(null, "L'article existe déjà !\nVoulez-vous ajouter cette quantité à la précédente ?","Double article", JOptionPane.YES_NO_OPTION);
                    if(choix==JOptionPane.YES_OPTION){
                        qte= listeLReap.get(indice).getQte();
                        qte+= Integer.parseInt(quantiteSpinner.getValue().toString());
                        listeLReap.get(indice).setQte(qte);
                    }
                 }
                 
                 //Remplir jTable
                 AllLigneReapproModel model = new AllLigneReapproModel(listeLReap);
                 jTableRecap.setModel(model);
                 jTableRecap.repaint();
                 jTableRecap.validate();

                 //Vider les champs
                 buttonGroup1.clearSelection();
                 comboBoxArticle.setSelectedItem(null);
                 comboBoxArticle.removeAll();
                 comboBoxArticle.setEnabled(false);
                 descTexteArea.setText("");
                 quantiteSpinner.setValue(0);

            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    
    //Supprimer article de la commande (jTable)
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        
        if(listSelect.isSelectionEmpty()==false){
            int indLigne= listSelect.getMinSelectionIndex();
            listeLReap.remove(indLigne);
        
            //Raffraichir jTable
            AllLigneReapproModel model = new AllLigneReapproModel(listeLReap);
            jTableRecap.setModel(model);
            jTableRecap.repaint();
            jTableRecap.validate();
        }
        else{
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau récapitulatif sélectionnée");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    
    //Modifier article de la commande (jTable)--Affichage
    private void modifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifButtonActionPerformed
  
       if(listSelect.isSelectionEmpty()==false){
            int indLigne= listSelect.getMinSelectionIndex();
        
            //Afficher nouveaux champs avec valeurs et boutton
            confirmModifButton.setVisible(true);
            jTextFieldModifLib.setVisible(true);
            jTextFieldModifType.setVisible(true);


            //Cacher les autres bouttons et boutons
            comboBoxArticle.setVisible(false);
            futRadioButton.setVisible(false);
            bouteilleRadioButton.setVisible(false);
            casierRadioButton.setVisible(false);

            addButton.setVisible(false);
            annulerButton.setVisible(false);
            endButton.setVisible(false);
            modifButton.setVisible(false);
            deleteButton.setVisible(false);
            descTexteArea.setVisible(false);
            jLabelDesc.setVisible(false);

  
            quantiteSpinner.setValue(listeLReap.get(indLigne).getQte());   
            jTextFieldModifLib.setText(listeLReap.get(indLigne).getArt().getLibelle());
            jTextFieldModifType.setText(listeLReap.get(indLigne).getArt().getType());
        }
        else{
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau récapitulatif sélectionnée");
        }
    }//GEN-LAST:event_modifButtonActionPerformed

    
    //Enregistrer/Confirmer la modification de l'article dans la commande
    private void confirmModifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmModifButtonActionPerformed
        
       if(listSelect.isSelectionEmpty()==false){
                int indLigne= listSelect.getMinSelectionIndex();
            
                //Encoder les changements
                lReap = new LigneReappro(Integer.parseInt(quantiteSpinner.getValue().toString()),art);
                listeLReap.set(indLigne, lReap);


                //Reaffichage des champs
                addButton.setVisible(true);
                annulerButton.setVisible(true);
                endButton.setVisible(true);
                modifButton.setVisible(true);
                deleteButton.setVisible(true);

                comboBoxArticle.setVisible(true);
                futRadioButton.setVisible(true);
                bouteilleRadioButton.setVisible(true);
                casierRadioButton.setVisible(true);
                descTexteArea.setVisible(true);
                jLabelDesc.setVisible(true);

                //Cacher les autres
                confirmModifButton.setVisible(false);
                jTextFieldModifLib.setVisible(false);
                jTextFieldModifType.setVisible(false);

                //Raffraichir jTable
                AllLigneReapproModel model = new AllLigneReapproModel(listeLReap);
                jTableRecap.setModel(model);
                jTableRecap.repaint();
                jTableRecap.validate();       
        }
        else{
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau récapitulatif sélectionnée");
        }
    }//GEN-LAST:event_confirmModifButtonActionPerformed

    private void annulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerButtonActionPerformed
        int choix= JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir annuler la commande ?","Annuler la commande", JOptionPane.YES_NO_OPTION);
        
        //Retour accueil
        if(choix==JOptionPane.YES_OPTION){
            AccueilPanel panel= new AccueilPanel();
            panel.setBounds(new MainJFrame().getContentPaneBounds());
            this.removeAll();
            this.add(panel);
            this.repaint();
            this.validate();
       }
    }//GEN-LAST:event_annulerButtonActionPerformed

    
    //Terminer la commande
    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
       if(listeLReap.isEmpty()){
           JOptionPane.showMessageDialog(null, "Aucun article dans la commande. \nMerci d'en ajouter.");
       }
            else{             
              ConfirmReapproJFrame confF = new ConfirmReapproJFrame(listeLReap,reapAdd,this);     
              confF.setVisible(true);
       }
    }//GEN-LAST:event_endButtonActionPerformed
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton annulerButton;
    private javax.swing.JRadioButton bouteilleRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton casierRadioButton;
    private javax.swing.JComboBox comboBoxArticle;
    private javax.swing.JButton confirmModifButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea descTexteArea;
    private javax.swing.JButton endButton;
    private javax.swing.JRadioButton futRadioButton;
    private javax.swing.JLabel jLabelDesc;
    private javax.swing.JLabel jLabelLibArt;
    private javax.swing.JLabel jLabelQte;
    private javax.swing.JLabel jLabelTypeArt;
    private javax.swing.JPanel jPanelEncodage;
    private javax.swing.JPanel jPanelTableau;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRecap;
    private javax.swing.JTextField jTextFieldModifLib;
    private javax.swing.JTextField jTextFieldModifType;
    private javax.swing.JButton modifButton;
    private javax.swing.JSpinner quantiteSpinner;
    private javax.swing.JLabel titrePanelEncodage;
    private javax.swing.JLabel titrePanelTableau;
    // End of variables declaration//GEN-END:variables
}
