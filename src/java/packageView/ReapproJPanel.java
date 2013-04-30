package packageView;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Reappro;


public class ReapproJPanel extends JPanel {
    
    
    private ArrayList <String> tabLib;
    private String typeA, rech="";
    private Reappro ajoutReap;
    private ApplicationController app;
    private GregorianCalendar dateReap;
    private AccueilPanel panA;
    private MainJFrame fen;
        
    
    public ReapproJPanel() {
        initComponents();
        tabLib= new ArrayList <String>();
 
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        futRadioButton = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rechTextField = new javax.swing.JTextField();
        bouteilleRadioButton = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        descTexteArea = new javax.swing.JTextArea();
        comboBoxArticle = new javax.swing.JComboBox();
        quantiteeSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ajoutReapproButton1 = new javax.swing.JButton();
        casierRadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        ajoutReapproButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        buttonGroup1.add(futRadioButton);
        futRadioButton.setText("Fût");
        futRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                futRadioButtonItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel8.setText("(Première lettre en majuscule)");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packageImage/loupe.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Quantité  :");

        rechTextField.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        rechTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rechTextFieldKeyTyped(evt);
            }
        });

        buttonGroup1.add(bouteilleRadioButton);
        bouteilleRadioButton.setText("Bouteille");
        bouteilleRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bouteilleRadioButtonItemStateChanged(evt);
            }
        });

        descTexteArea.setColumns(20);
        descTexteArea.setEditable(false);
        descTexteArea.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        descTexteArea.setRows(1);
        descTexteArea.setAutoscrolls(false);
        descTexteArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        descTexteArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(descTexteArea);

        comboBoxArticle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxArticleItemStateChanged(evt);
            }
        });

        SpinnerModel modelq = new SpinnerNumberModel(0,0,1000,1);
        quantiteeSpinner.setModel(modelq);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Type Article :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Libelle Article :");

        ajoutReapproButton1.setText("Commander nouvel article");
        ajoutReapproButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutReapproButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(casierRadioButton);
        casierRadioButton.setText("Casier");
        casierRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                casierRadioButtonItemStateChanged(evt);
            }
        });
        casierRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                casierRadioButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Description :");

        ajoutReapproButton2.setText("Terminer la commande");
        ajoutReapproButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutReapproButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboBoxArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bouteilleRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(casierRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(futRadioButton))
                                    .addComponent(rechTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5))
                        .addComponent(quantiteeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ajoutReapproButton1)
                        .addGap(18, 18, 18)
                        .addComponent(ajoutReapproButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bouteilleRadioButton)
                        .addComponent(casierRadioButton)
                        .addComponent(futRadioButton)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rechTextField)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantiteeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajoutReapproButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajoutReapproButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 51));
        jLabel11.setText("Commande fournisseur");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 51));
        jLabel12.setText("Récapitulatif réappro");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jLabel11)
                    .addContainerGap(727, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jLabel11)
                    .addContainerGap(583, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Choix du type Bouteille
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
 
    //Choix du type Casier
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
 
    
    //Choix du type Fut
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

    
    //Affichage de la desrcrption de l'article en fonction du libelle choisit
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

    //Recherche libelle article 
    private void rechTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechTextFieldKeyTyped
       
        if(typeA != null){
             try {
                 
                rech=this.rechTextField.getText();
                tabLib= new ApplicationController().getLibArticle(typeA,rech);
                this.comboBoxArticle.removeAllItems();
                for (String lib : tabLib){
                    this.comboBoxArticle.addItem(lib);
                }
                this.comboBoxArticle.setBackground(Color.green);
                this.comboBoxArticle.repaint();
                this.comboBoxArticle.validate();
                this.comboBoxArticle.setPopupVisible(true);
           }
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Veuillez d'abord choisir un type.");
            this.rechTextField.setText("");
            evt.consume();
        }
    }//GEN-LAST:event_rechTextFieldKeyTyped
 
    //Boutton enregistrer et quitter
    private void ajoutReapproButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutReapproButton2ActionPerformed
      //Tests pour voir si tout est rempli
        if(this.typeA==null){ 
            JOptionPane.showMessageDialog(null, "Aucun type sélectionné.");
        }
        else{
            if(Integer.parseInt(this.quantiteeSpinner.getValue().toString())==0){ 
                 JOptionPane.showMessageDialog(null, "Veuillez indiquer une quantitée.");
            }
            else{
                
                
                app = new ApplicationController();

                 //Créer objet et ajout dans la BD 
                 try{                  
                    
                    ajoutReap = new Reappro(Integer.parseInt(this.quantiteeSpinner.getValue().toString()),app.getIDArticle(this.comboBoxArticle.getSelectedItem().toString(),this.typeA), 
                                             dateReap,null);
                    app.addReappro(ajoutReap);
                    JOptionPane.showMessageDialog(null,"Encodage réalisé avec succès !");

                    //Fermer le panneau et retour accueil.
                    panA= new AccueilPanel();
                    fen = new MainJFrame();
                    panA.setBounds(fen.getContentPaneBounds());                   
                    this.removeAll();
                    this.add(panA);
                    this.repaint();
                    this.validate();                    
                 }
                 catch(BdErreur e){
                     JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
                 }

                 catch(NoIdentification e){
                     JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
                 }

                 catch(Exception e){
                     JOptionPane.showMessageDialog(null, "Aucun article sélectionné: "+e, "Erreur JComboBox", JOptionPane.ERROR_MESSAGE);
                 }
            }
        }
    }//GEN-LAST:event_ajoutReapproButton2ActionPerformed
   
    
    //Boutton enregistrer et encoder un nouveau reappro
    private void ajoutReapproButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutReapproButton1ActionPerformed
         
        //Tests pour voir si tout est rempli
        if(this.typeA==null){ 
            JOptionPane.showMessageDialog(null, "Aucun type sélectionné.");
        }
        else{
            if(Integer.parseInt(this.quantiteeSpinner.getValue().toString())==0){ 
                 JOptionPane.showMessageDialog(null, "Veuillez indiquer une quantitée.");
            }
            else{
                
                //Obliger sinon n'insère pas null dans la BD
                String note=null;
                if(!this.noteTexteArea.getText().equals("")){
                    note=this.noteTexteArea.getText();
                }
                app = new ApplicationController();

                 //Créer objet et ajout dans la BD 
                 try{                  
                    
                    ajoutReap = new Reappro(Integer.parseInt(this.quantiteeSpinner.getValue().toString()),app.getIDArticle(this.comboBoxArticle.getSelectedItem().toString(),this.typeA), 
                                             dateReap,note);
                    app.addReappro(ajoutReap);
                    JOptionPane.showMessageDialog(null,"Encodage réalisé avec succès !");

                    //Remise à zéro du pannel pour un nouvel encodage
                    this.SpinnerDate.setModel(new SpinnerDateModel());
                    this.SpinnerDate.setEditor(new JSpinner.DateEditor(SpinnerDate, "dd-MM-yyyy"));
                    this.rechTextField.setText("");
                    this.quantiteeSpinner.setValue(0);
                    this.comboBoxArticle.removeAllItems();
                    this.descTexteArea.setText("");
                    this.noteTexteArea.removeAll();
                    this.typeA=null;
                    
                   
                    //Affichage d'une JTable pour résumer les encodages
                    
                    
                 }
                 catch(BdErreur e){
                     JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
                 }

                 catch(NoIdentification e){
                     JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
                 }

                 catch(Exception e){
                     JOptionPane.showMessageDialog(null, "Aucun article sélectionné: "+e, "Erreur JComboBox", JOptionPane.ERROR_MESSAGE);
                 }
            }
        }
    }//GEN-LAST:event_ajoutReapproButton1ActionPerformed

    private void casierRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_casierRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_casierRadioButtonActionPerformed

    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoutReapproButton1;
    private javax.swing.JButton ajoutReapproButton2;
    private javax.swing.JRadioButton bouteilleRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton casierRadioButton;
    private javax.swing.JComboBox comboBoxArticle;
    private javax.swing.JTextArea descTexteArea;
    private javax.swing.JRadioButton futRadioButton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner quantiteeSpinner;
    private javax.swing.JTextField rechTextField;
    // End of variables declaration//GEN-END:variables
}
