
package packageView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableColumn;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;
import packageModel.Reappro;

public class RechReapproJPanel extends javax.swing.JPanel {

    private ArrayList <Fournisseur> listeLib;
    private ListSelectionModel listSelect;
    private AllLigneReapproModel reapL;
    private AllReapproModel  reapMod;
    private SpinnerDateModel model =new SpinnerDateModel();
    
    public RechReapproJPanel() {
        initComponents();
        //Cacher
        jPanelTable.setVisible(false);      
        jLabelNone.setVisible(false);
        jButtonVoir.setVisible(false);
        jPanelArticle.setVisible(false);
        
        //Récuperer ligne
        jTableRechReap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelect= jTableRechReap.getSelectionModel();
       
        //Garnir comboBox de fournisseur  
        listeLib= new ArrayList <Fournisseur>();
        try {
                listeLib = new ApplicationController().getFournisseur();
                this.jComboBoxFournisseur.removeAllItems();
                for (Fournisseur lib : listeLib){                   
                    jComboBoxFournisseur.addItem(lib.getNom());
                }                              
                jComboBoxFournisseur.repaint();
                jComboBoxFournisseur.validate();

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

        labelTitrePanel = new javax.swing.JLabel();
        jPanelRech = new javax.swing.JPanel();
        jSpinnerDate = new javax.swing.JSpinner();
        jComboBoxFournisseur = new javax.swing.JComboBox();
        jButtonRecherche = new javax.swing.JButton();
        jPanelDate = new javax.swing.JPanel();
        jLabelDateR = new javax.swing.JLabel();
        jPanelFourn = new javax.swing.JPanel();
        jLabelFourn = new javax.swing.JLabel();
        jPanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRechReap = new javax.swing.JTable();
        jLabelNone = new javax.swing.JLabel();
        jButtonVoir = new javax.swing.JButton();
        jPanelArticle = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRechReapArt = new javax.swing.JTable();

        labelTitrePanel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelTitrePanel.setForeground(new java.awt.Color(153, 0, 51));
        labelTitrePanel.setText("Recherche Reappro");

        jSpinnerDate.setModel(model);
        jSpinnerDate.setEditor(new JSpinner.DateEditor(jSpinnerDate, "dd/MM/yyyy"));
        jSpinnerDate.setMaximumSize(new java.awt.Dimension(103, 20));

        jComboBoxFournisseur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFournisseur.setMaximumSize(new java.awt.Dimension(103, 20));
        jComboBoxFournisseur.setMinimumSize(new java.awt.Dimension(103, 20));

        jButtonRecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packageImage/loupe.png"))); // NOI18N
        jButtonRecherche.setText("Rechercher");
        jButtonRecherche.setMaximumSize(new java.awt.Dimension(103, 20));
        jButtonRecherche.setMinimumSize(new java.awt.Dimension(103, 20));
        jButtonRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRechercheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRechLayout = new javax.swing.GroupLayout(jPanelRech);
        jPanelRech.setLayout(jPanelRechLayout);
        jPanelRechLayout.setHorizontalGroup(
            jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRechLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jComboBoxFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelRechLayout.setVerticalGroup(
            jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRechLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jSpinnerDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxFournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabelDateR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDateR.setText("Date réapprovisionnement :");

        javax.swing.GroupLayout jPanelDateLayout = new javax.swing.GroupLayout(jPanelDate);
        jPanelDate.setLayout(jPanelDateLayout);
        jPanelDateLayout.setHorizontalGroup(
            jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDateR)
                .addContainerGap())
        );
        jPanelDateLayout.setVerticalGroup(
            jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDateR)
                .addContainerGap())
        );

        jLabelFourn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFourn.setText("Fournisseur :");

        javax.swing.GroupLayout jPanelFournLayout = new javax.swing.GroupLayout(jPanelFourn);
        jPanelFourn.setLayout(jPanelFournLayout);
        jPanelFournLayout.setHorizontalGroup(
            jPanelFournLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFournLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFourn, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelFournLayout.setVerticalGroup(
            jPanelFournLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFournLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFourn)
                .addContainerGap())
        );

        jTableRechReap.getTableHeader().setResizingAllowed(false);
        jTableRechReap.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableRechReap);

        javax.swing.GroupLayout jPanelTableLayout = new javax.swing.GroupLayout(jPanelTable);
        jPanelTable.setLayout(jPanelTableLayout);
        jPanelTableLayout.setHorizontalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelTableLayout.setVerticalGroup(
            jPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabelNone.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelNone.setForeground(new java.awt.Color(255, 0, 51));
        jLabelNone.setText("Aucun réapprovisionnement prévu à cette date ! ");

        jButtonVoir.setText("Voir articles");
        jButtonVoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoirActionPerformed(evt);
            }
        });

        jTableRechReapArt.getTableHeader().setResizingAllowed(false);
        jTableRechReapArt.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableRechReapArt);

        javax.swing.GroupLayout jPanelArticleLayout = new javax.swing.GroupLayout(jPanelArticle);
        jPanelArticle.setLayout(jPanelArticleLayout);
        jPanelArticleLayout.setHorizontalGroup(
            jPanelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanelArticleLayout.setVerticalGroup(
            jPanelArticleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArticleLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitrePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanelFourn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(201, 201, 201))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelArticle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVoir)))
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelTitrePanel)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelFourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNone)
                    .addComponent(jButtonVoir))
                .addGap(18, 18, 18)
                .addComponent(jPanelArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    //Lancer la recherche
    private void jButtonRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRechercheActionPerformed
        
        ArrayList <Reappro> listReap = new ArrayList <Reappro>() ;
                
        //Récupération données
        GregorianCalendar dateR= new GregorianCalendar();
        dateR.setTime(model.getDate());
        Fournisseur fourn = new Fournisseur(jComboBoxFournisseur.getSelectedItem().toString());

 
        //Chercher dans la BD
        try {
              listReap = new ApplicationController().getRechReappro(dateR, fourn);
              reapMod = new AllReapproModel (listReap);             

         }
         catch(BdErreur e){
             JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
         }
         catch(NoIdentification e){
             JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
         }
        
        if(listReap.isEmpty()){
              jLabelNone.setVisible(true);
              jPanelTable.setVisible(false);
              jButtonVoir.setVisible(false);
              jPanelArticle.setVisible(false);
        }
        else{
              jButtonVoir.setVisible(true);
              jLabelNone.setVisible(false);
              jPanelTable.setVisible(true);
              jTableRechReap.setModel(reapMod);
              jTableRechReap.repaint();
              jTableRechReap.validate();
              
              jTableRechReap.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
              TableColumn colID = jTableRechReap.getColumnModel( ).getColumn(0);
              colID.setPreferredWidth(80); 
              TableColumn colDate = jTableRechReap.getColumnModel( ).getColumn(1);          
              colDate.setPreferredWidth(160); 
              TableColumn colNote = jTableRechReap.getColumnModel( ).getColumn(3);
              colNote.setPreferredWidth(276);
              TableColumn colPc = jTableRechReap.getColumnModel( ).getColumn(4);
              colPc.setPreferredWidth(120);
        }
    }//GEN-LAST:event_jButtonRechercheActionPerformed

    
    //Afficher articles du reappro
    private void jButtonVoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoirActionPerformed
        if(listSelect.isSelectionEmpty()){
             JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée.\nVeuillez sélectionner une ligne.");
        }
        else{
            try {
                int indLigne = listSelect.getMinSelectionIndex();
                reapL = new AllLigneReapproModel (new ApplicationController().getAllLigneReappro(Integer.parseInt(jTableRechReap.getValueAt(indLigne, 0).toString())));           
            }        
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
            
            jPanelArticle.setVisible(true);
            jTableRechReapArt.setModel(reapL);
            jTableRechReapArt.repaint();
            jTableRechReapArt.validate();
            
        }
    }//GEN-LAST:event_jButtonVoirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRecherche;
    private javax.swing.JButton jButtonVoir;
    private javax.swing.JComboBox jComboBoxFournisseur;
    private javax.swing.JLabel jLabelDateR;
    private javax.swing.JLabel jLabelFourn;
    private javax.swing.JLabel jLabelNone;
    private javax.swing.JPanel jPanelArticle;
    private javax.swing.JPanel jPanelDate;
    private javax.swing.JPanel jPanelFourn;
    private javax.swing.JPanel jPanelRech;
    private javax.swing.JPanel jPanelTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerDate;
    private javax.swing.JTable jTableRechReap;
    private javax.swing.JTable jTableRechReapArt;
    private javax.swing.JLabel labelTitrePanel;
    // End of variables declaration//GEN-END:variables
}
