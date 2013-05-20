package packageView;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Categorie;

/**
 * Panel recherche par categorie
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class RechercheCategorie extends javax.swing.JPanel {

    private ArrayList<Categorie> tabCat;
    private String typeArt;
    private AllArticleModif allArt;

    /**
     *
     */
    public RechercheCategorie() {
        initComponents();
        this.jTableRechCat.setVisible(false);
        tabCat = new ArrayList<Categorie>();

        //Remplir liste catégorie
        try {
            tabCat = new ApplicationController().getCatArticle();
            this.comboCat.removeAllItems();
            for (Categorie cat : tabCat) {
                this.comboCat.addItem(cat.getNom());
            }
            this.comboCat.repaint();
            this.comboCat.validate();

        } catch (BdErreur e) {
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        } catch (NoIdentification e) {
            JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        LabelListing = new javax.swing.JLabel();
        labelCat = new javax.swing.JLabel();
        labelType = new javax.swing.JLabel();
        comboCat = new javax.swing.JComboBox();
        ButtonBouteille = new javax.swing.JRadioButton();
        ButtonCasier = new javax.swing.JRadioButton();
        ButtonFut = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRechCat = new javax.swing.JTable();

        LabelListing.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        LabelListing.setForeground(new java.awt.Color(153, 0, 51));
        LabelListing.setText("Recherche article via catégorie");

        labelCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCat.setText("Catégorie :");

        labelType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelType.setText("Type Article :");

        comboCat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCatItemStateChanged(evt);
            }
        });

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

        jTableRechCat.setRowSelectionAllowed(false);
        jTableRechCat.getTableHeader().setResizingAllowed(false);
        jTableRechCat.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableRechCat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelListing, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ButtonBouteille)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonCasier)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonFut))
                            .addComponent(comboCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelListing)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCat)
                            .addComponent(comboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labelType))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonBouteille)
                        .addComponent(ButtonCasier)
                        .addComponent(ButtonFut)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Choix type article bouteille
    private void ButtonBouteilleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonBouteilleItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            try {
                typeArt = "Bouteille";

                //Remplir tableau
                this.jTableRechCat.setVisible(true);
                allArt = new AllArticleModif(new ApplicationController().getAllArticleRechCat(typeArt, tabCat.get(comboCat.getSelectedIndex())));
                jTableRechCat.setModel(allArt);
                jTableRechCat.repaint();
                jTableRechCat.validate();

                //Redimensionnement cellules
                jTableRechCat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TableColumn colLib = jTableRechCat.getColumnModel( ).getColumn(0);
                colLib.setPreferredWidth(150); 
                TableColumn colDesc = jTableRechCat.getColumnModel( ).getColumn(2);          
                colDesc.setPreferredWidth(420); 
                TableColumn colPm = jTableRechCat.getColumnModel( ).getColumn(4);
                colPm.setPreferredWidth(120);
                TableColumn colPc = jTableRechCat.getColumnModel( ).getColumn(5);
                colPc.setPreferredWidth(120);
                TableColumn colCad = jTableRechCat.getColumnModel( ).getColumn(6);
                colCad.setPreferredWidth(100);
                TableColumn col18ans = jTableRechCat.getColumnModel( ).getColumn(7);
                col18ans.setPreferredWidth(50);
                TableColumn colFourn = jTableRechCat.getColumnModel( ).getColumn(8);
                colFourn.setPreferredWidth(150);
                TableColumn colCat = jTableRechCat.getColumnModel( ).getColumn(9);
                colCat.setPreferredWidth(150);

            } catch (BdErreur e) {
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            } catch (NoIdentification e) {
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ButtonBouteilleItemStateChanged

    //Choix type article casier
    private void ButtonCasierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonCasierItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            try {
                typeArt = "Casier";
                //Remplir tableau
                this.jTableRechCat.setVisible(true);
                allArt = new AllArticleModif(new ApplicationController().getAllArticleRechCat(typeArt, tabCat.get(comboCat.getSelectedIndex())));
                jTableRechCat.setModel(allArt);
                jTableRechCat.repaint();
                jTableRechCat.validate();

                //Redimensionnement cellules
                jTableRechCat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TableColumn colLib = jTableRechCat.getColumnModel( ).getColumn(0);
                colLib.setPreferredWidth(150); 
                TableColumn colDesc = jTableRechCat.getColumnModel( ).getColumn(2);          
                colDesc.setPreferredWidth(420); 
                TableColumn colPm = jTableRechCat.getColumnModel( ).getColumn(4);
                colPm.setPreferredWidth(120);
                TableColumn colPc = jTableRechCat.getColumnModel( ).getColumn(5);
                colPc.setPreferredWidth(120);
                TableColumn colCad = jTableRechCat.getColumnModel( ).getColumn(6);
                colCad.setPreferredWidth(100);
                TableColumn col18ans = jTableRechCat.getColumnModel( ).getColumn(7);
                col18ans.setPreferredWidth(50);
                TableColumn colFourn = jTableRechCat.getColumnModel( ).getColumn(8);
                colFourn.setPreferredWidth(150);
                TableColumn colCat = jTableRechCat.getColumnModel( ).getColumn(9);
                colCat.setPreferredWidth(150);

            } catch (BdErreur e) {
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            } catch (NoIdentification e) {
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ButtonCasierItemStateChanged

    //Choix type article fut
    private void ButtonFutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonFutItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            try {
                typeArt = "Fût";
                //Remplir tableau
                this.jTableRechCat.setVisible(true);
                allArt = new AllArticleModif(new ApplicationController().getAllArticleRechCat(typeArt, tabCat.get(comboCat.getSelectedIndex())));
                jTableRechCat.setModel(allArt);
                jTableRechCat.repaint();
                jTableRechCat.validate();

                //Redimensionnement cellules
                jTableRechCat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TableColumn colLib = jTableRechCat.getColumnModel( ).getColumn(0);
                colLib.setPreferredWidth(150); 
                TableColumn colDesc = jTableRechCat.getColumnModel( ).getColumn(2);          
                colDesc.setPreferredWidth(420); 
                TableColumn colPm = jTableRechCat.getColumnModel( ).getColumn(4);
                colPm.setPreferredWidth(120);
                TableColumn colPc = jTableRechCat.getColumnModel( ).getColumn(5);
                colPc.setPreferredWidth(120);
                TableColumn colCad = jTableRechCat.getColumnModel( ).getColumn(6);
                colCad.setPreferredWidth(100);
                TableColumn col18ans = jTableRechCat.getColumnModel( ).getColumn(7);
                col18ans.setPreferredWidth(50);
                TableColumn colFourn = jTableRechCat.getColumnModel( ).getColumn(8);
                colFourn.setPreferredWidth(150);
                TableColumn colCat = jTableRechCat.getColumnModel( ).getColumn(9);
                colCat.setPreferredWidth(150);

            } catch (BdErreur e) {
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            } catch (NoIdentification e) {
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_ButtonFutItemStateChanged

    //Quand choix catégorie change
    private void comboCatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCatItemStateChanged
        //Reinitialise
        this.buttonGroup1.clearSelection();
        this.jTableRechCat.setVisible(false);
    }//GEN-LAST:event_comboCatItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ButtonBouteille;
    private javax.swing.JRadioButton ButtonCasier;
    private javax.swing.JRadioButton ButtonFut;
    private javax.swing.JLabel LabelListing;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboCat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRechCat;
    private javax.swing.JLabel labelCat;
    private javax.swing.JLabel labelType;
    // End of variables declaration//GEN-END:variables
}
