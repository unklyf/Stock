package packageView;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableColumn;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;


public class ListingReapproJPanel extends javax.swing.JPanel {
    private ListSelectionModel listSelect, listSelectArticle;
    private AllLigneReapproModel reapL;
    private AllReapproModel  reapMod;
    
    public ListingReapproJPanel() {
        initComponents();
        //JTable Reappro et Ligne Reappro sélection
        jTableReappro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelect = jTableReappro.getSelectionModel();
        jTableLigneReappro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectArticle = jTableLigneReappro.getSelectionModel();
        
        //Panneau et boutons modifs cachés
        labelTitrePanelEncodage.setVisible(false);
        jPanelEncodageStock.setVisible(false);
        buttonModifArt.setVisible(false);
        buttonEndEncoder.setVisible(false);
        buttonAnnuler.setVisible(false);
        jLabelFacult.setVisible(false);
        jLabelNote.setVisible(false);
        jTextNote.setVisible(false);
        
        try {
            reapMod = new AllReapproModel (new ApplicationController().getAllReappro());
            jTableReappro.setModel(reapMod);
            jTableReappro.repaint();
            jTableReappro.validate();
            
            jTableReappro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            TableColumn colID = jTableReappro.getColumnModel( ).getColumn(0);
            colID.setPreferredWidth(80); 
            TableColumn colDate = jTableReappro.getColumnModel( ).getColumn(1);          
            colDate.setPreferredWidth(160); 
            TableColumn colNote = jTableReappro.getColumnModel( ).getColumn(3);
            colNote.setPreferredWidth(276);
            TableColumn colPc = jTableReappro.getColumnModel( ).getColumn(4);
            colPc.setPreferredWidth(120);
            
           
            
            }        
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        
        }
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitrePanel = new javax.swing.JLabel();
        jPanelEncodageStock = new javax.swing.JPanel();
        quantiteSpinner = new javax.swing.JSpinner();
        jLabelQte = new javax.swing.JLabel();
        jLabelLibArt = new javax.swing.JLabel();
        jTextFieldModifLib = new javax.swing.JTextField();
        jTextFieldModifType = new javax.swing.JTextField();
        jLabelTypeArt = new javax.swing.JLabel();
        buttonValiderModif = new javax.swing.JButton();
        jPanelListing = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLigneReappro = new javax.swing.JTable();
        buttonEncoderReap = new javax.swing.JButton();
        buttonListerLigneReap1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReappro = new javax.swing.JTable();
        buttonEndEncoder = new javax.swing.JButton();
        buttonModifArt = new javax.swing.JButton();
        buttonAnnuler = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextNote = new javax.swing.JTextArea();
        jLabelNote = new javax.swing.JLabel();
        jLabelFacult = new javax.swing.JLabel();
        labelTitrePanelEncodage = new javax.swing.JLabel();

        labelTitrePanel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelTitrePanel.setForeground(new java.awt.Color(153, 0, 51));
        labelTitrePanel.setText("Liste des commandes");

        jPanelEncodageStock.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEncodageStock.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        SpinnerModel modelq = new SpinnerNumberModel(0,0,1000,1);
        quantiteSpinner.setModel(modelq);

        jLabelQte.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelQte.setText("Quantité  :");

        jLabelLibArt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelLibArt.setText("Libelle Article :");

        jTextFieldModifLib.setEditable(false);
        jTextFieldModifLib.setBackground(new java.awt.Color(204, 102, 0));
        jTextFieldModifLib.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldModifLib.setAutoscrolls(false);
        jTextFieldModifLib.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldModifLib.setEnabled(false);

        jTextFieldModifType.setEditable(false);
        jTextFieldModifType.setBackground(new java.awt.Color(204, 102, 0));
        jTextFieldModifType.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldModifType.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldModifType.setEnabled(false);

        jLabelTypeArt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTypeArt.setText("Type Article :");

        buttonValiderModif.setBackground(new java.awt.Color(153, 180, 209));
        buttonValiderModif.setText("Valider modification");
        buttonValiderModif.setActionCommand("Lister les articles commandés");
        buttonValiderModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValiderModifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEncodageStockLayout = new javax.swing.GroupLayout(jPanelEncodageStock);
        jPanelEncodageStock.setLayout(jPanelEncodageStockLayout);
        jPanelEncodageStockLayout.setHorizontalGroup(
            jPanelEncodageStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncodageStockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEncodageStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTypeArt)
                    .addComponent(jLabelLibArt)
                    .addComponent(jLabelQte))
                .addGap(18, 18, 18)
                .addGroup(jPanelEncodageStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantiteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModifType, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModifLib, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonValiderModif, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanelEncodageStockLayout.setVerticalGroup(
            jPanelEncodageStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncodageStockLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelEncodageStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTypeArt)
                    .addComponent(jTextFieldModifType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelEncodageStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLibArt)
                    .addComponent(jTextFieldModifLib, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanelEncodageStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQte)
                    .addComponent(quantiteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonValiderModif, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelListing.setBackground(new java.awt.Color(255, 255, 255));

        jTableLigneReappro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(jTableLigneReappro);

        buttonEncoderReap.setText("Encoder commande dans le stock");
        buttonEncoderReap.setActionCommand("Lister les articles commandés");
        buttonEncoderReap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEncoderReapActionPerformed(evt);
            }
        });

        buttonListerLigneReap1.setBackground(new java.awt.Color(0, 255, 102));
        buttonListerLigneReap1.setText("Voir la commande");
        buttonListerLigneReap1.setActionCommand("Lister les articles commandés");
        buttonListerLigneReap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListerLigneReap1ActionPerformed(evt);
            }
        });

        jTableReappro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableReappro.getTableHeader().setResizingAllowed(false);
        jTableReappro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableReappro);

        buttonEndEncoder.setBackground(new java.awt.Color(0, 119, 0));
        buttonEndEncoder.setText("Terminer et Encoder");
        buttonEndEncoder.setActionCommand("Lister les articles commandés");
        buttonEndEncoder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEndEncoderActionPerformed(evt);
            }
        });

        buttonModifArt.setBackground(new java.awt.Color(51, 102, 255));
        buttonModifArt.setText("Modifier un article");
        buttonModifArt.setActionCommand("Lister les articles commandés");
        buttonModifArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifArtActionPerformed(evt);
            }
        });

        buttonAnnuler.setBackground(new java.awt.Color(153, 0, 0));
        buttonAnnuler.setText("Annuler");
        buttonAnnuler.setActionCommand("Lister les articles commandés");
        buttonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnnulerActionPerformed(evt);
            }
        });

        jTextNote.setColumns(20);
        jTextNote.setRows(5);
        jScrollPane3.setViewportView(jTextNote);

        jLabelNote.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNote.setText("Note :");

        jLabelFacult.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabelFacult.setText("(facultatif)");

        javax.swing.GroupLayout jPanelListingLayout = new javax.swing.GroupLayout(jPanelListing);
        jPanelListing.setLayout(jPanelListingLayout);
        jPanelListingLayout.setHorizontalGroup(
            jPanelListingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(jPanelListingLayout.createSequentialGroup()
                        .addGroup(jPanelListingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelListingLayout.createSequentialGroup()
                                .addComponent(buttonListerLigneReap1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEncoderReap, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelListingLayout.createSequentialGroup()
                                .addComponent(buttonModifArt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEndEncoder, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelListingLayout.createSequentialGroup()
                        .addGroup(jPanelListingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNote)
                            .addComponent(jLabelFacult))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelListingLayout.setVerticalGroup(
            jPanelListingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonListerLigneReap1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEncoderReap, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelListingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelListingLayout.createSequentialGroup()
                        .addComponent(jLabelNote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFacult))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelListingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModifArt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEndEncoder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        labelTitrePanelEncodage.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelTitrePanelEncodage.setForeground(new java.awt.Color(153, 0, 51));
        labelTitrePanelEncodage.setText("Erreur livraison");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(labelTitrePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanelListing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitrePanelEncodage, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelEncodageStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitrePanel)
                    .addComponent(labelTitrePanelEncodage))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelEncodageStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelListing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonListerLigneReap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListerLigneReap1ActionPerformed
       
        if(listSelect.isSelectionEmpty()){
             JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée.\nVeuillez sélectionner une ligne.");
        }
        else{
            try {
                int indLigne = listSelect.getMinSelectionIndex();
                reapL = new AllLigneReapproModel (new ApplicationController().getAllLigneReappro(Integer.parseInt(jTableReappro.getValueAt(indLigne, 0).toString())));
                jTableLigneReappro.setVisible(true);
                jTableLigneReappro.setModel(reapL);
                jTableLigneReappro.repaint();
                jTableLigneReappro.validate();
            
            }        
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_buttonListerLigneReap1ActionPerformed

    private void buttonEncoderReapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEncoderReapActionPerformed
        int indLigne = listSelect.getMinSelectionIndex(); 
        
        if(listSelect.isSelectionEmpty()){
             JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée.\nVeuillez sélectionner une ligne.");
        }
        else{
                if(jTableReappro.getValueAt(indLigne, 2).toString().equals("Terminé")){
                      JOptionPane.showMessageDialog(null, "Réapprovisionnement terminé","Encodage déjà réalisé",JOptionPane.ERROR_MESSAGE);
                }
                else{
                   //Affichage de ce qu'on a besoin
                   jLabelFacult.setVisible(true);
                   jLabelNote.setVisible(true);
                   jTextNote.setVisible(true);
                   buttonModifArt.setVisible(true);
                   buttonEndEncoder.setVisible(true);
                   buttonAnnuler.setVisible(true);
                   buttonListerLigneReap1.setVisible(false);
                   buttonEncoderReap.setVisible(false);
                   jTableReappro.setEnabled(false);
                   
                   
                   try {
                        reapL = new AllLigneReapproModel (new ApplicationController().getAllLigneReappro(Integer.parseInt(jTableReappro.getValueAt(indLigne, 0).toString())));
                        jTableLigneReappro.setVisible(true);
                        jTableLigneReappro.setModel(reapL);
                        jTableLigneReappro.repaint();
                        jTableLigneReappro.validate();

                    }        
                    catch(BdErreur e){
                        JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(NoIdentification e){
                        JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
                    }
               }
        }
      
    }//GEN-LAST:event_buttonEncoderReapActionPerformed

    
    
    private void buttonModifArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifArtActionPerformed
        
        //Récupérer ligne       
        int indice = listSelectArticle.getMinSelectionIndex(); 
        
        if(listSelectArticle.isSelectionEmpty()){
             JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée.\nVeuillez sélectionner une ligne.");
        }
        else{
             jTextFieldModifType.setText(reapL.getValueAt(indice, 1).toString());
             jTextFieldModifLib.setText(reapL.getValueAt(indice, 0).toString());
             quantiteSpinner.setValue(Integer.parseInt(reapL.getValueAt(indice, 2).toString()));
             labelTitrePanelEncodage.setVisible(true);
             jPanelEncodageStock.setVisible(true);
        }
    }//GEN-LAST:event_buttonModifArtActionPerformed

    
    
    private void buttonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulerActionPerformed
        //Affichage comme avant
        jLabelFacult.setVisible(false);
        jLabelNote.setVisible(false);
        jTextNote.setVisible(false);
        buttonEncoderReap.setVisible(true);
        buttonListerLigneReap1.setVisible(true);
        jTableReappro.setEnabled(true);
        labelTitrePanelEncodage.setVisible(false);
        jPanelEncodageStock.setVisible(false);
        buttonModifArt.setVisible(false);
        buttonEndEncoder.setVisible(false);
        buttonAnnuler.setVisible(false);
    }//GEN-LAST:event_buttonAnnulerActionPerformed

    
    private void buttonValiderModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValiderModifActionPerformed
        //Récupérer ligne       
        int indice = listSelectArticle.getMinSelectionIndex(); 
        
        //Modifier quantitée
        reapL.getContents().get(indice).setQte(Integer.parseInt(quantiteSpinner.getValue().toString()));
        
        //Reaffichage encodage et jTable
        labelTitrePanelEncodage.setVisible(false);
        jPanelEncodageStock.setVisible(false);
        jTableLigneReappro.repaint();
        jTableLigneReappro.validate();
    }//GEN-LAST:event_buttonValiderModifActionPerformed

    private void buttonEndEncoderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEndEncoderActionPerformed
        
        //Encoder les articles dans les stocks        
        int indLigne = listSelect.getMinSelectionIndex();
        reapMod.getContents().get(indLigne).setNote(this.jTextNote.getText());
        reapMod.getContents().get(indLigne).setEtat("Terminé");
        try {
                for(int i=0; i < reapL.getContents().size();i++){
                    new ApplicationController().setQteStock(reapMod.getContents().get(indLigne), reapL.getContents().get(i));
                }       
        }        
        catch(BdErreur e){
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
        catch(NoIdentification e){
            JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        }
        
        
        //Reaffichage listing
        buttonAnnuler.doClick();
        jTableReappro.setModel(reapMod);
        jTableReappro.repaint();
        jTableReappro.validate();
        jTableLigneReappro.setVisible(false);       
    }//GEN-LAST:event_buttonEndEncoderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnnuler;
    private javax.swing.JButton buttonEncoderReap;
    private javax.swing.JButton buttonEndEncoder;
    private javax.swing.JButton buttonListerLigneReap1;
    private javax.swing.JButton buttonModifArt;
    private javax.swing.JButton buttonValiderModif;
    private javax.swing.JLabel jLabelFacult;
    private javax.swing.JLabel jLabelLibArt;
    private javax.swing.JLabel jLabelNote;
    private javax.swing.JLabel jLabelQte;
    private javax.swing.JLabel jLabelTypeArt;
    private javax.swing.JPanel jPanelEncodageStock;
    private javax.swing.JPanel jPanelListing;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableLigneReappro;
    private javax.swing.JTable jTableReappro;
    private javax.swing.JTextField jTextFieldModifLib;
    private javax.swing.JTextField jTextFieldModifType;
    private javax.swing.JTextArea jTextNote;
    private javax.swing.JLabel labelTitrePanel;
    private javax.swing.JLabel labelTitrePanelEncodage;
    private javax.swing.JSpinner quantiteSpinner;
    // End of variables declaration//GEN-END:variables
}
