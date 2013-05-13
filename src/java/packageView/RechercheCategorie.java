
package packageView;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;

public class RechercheCategorie extends javax.swing.JPanel {

    private ArrayList <Categorie> tabCat;
    private ArrayList <Article> listeArtCombo;
    private String typeArt;
    
    public RechercheCategorie() {
        initComponents();
        tabCat= new ArrayList <Categorie>();
        listeArtCombo= new ArrayList <Article>();
        try {
             tabCat= new ApplicationController().getCatArticle();
             this.comboCat.removeAllItems();
             this.comboCat.addItem(new String("---------------------------"));
             for (Categorie cat : tabCat){
                 this.comboCat.addItem(cat.getNom());
             }
             this.comboCat.repaint();
             this.comboCat.validate();
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
        LabelListing = new javax.swing.JLabel();
        labelCat = new javax.swing.JLabel();
        labelType = new javax.swing.JLabel();
        labelLibelle = new javax.swing.JLabel();
        comboCat = new javax.swing.JComboBox();
        ButtonBouteille = new javax.swing.JRadioButton();
        ButtonCasier = new javax.swing.JRadioButton();
        ButtonFut = new javax.swing.JRadioButton();
        comboLib = new javax.swing.JComboBox();

        LabelListing.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        LabelListing.setForeground(new java.awt.Color(153, 0, 51));
        LabelListing.setText("Recherche article via cat�gorie");

        labelCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCat.setText("Cat�gorie :");

        labelType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelType.setText("Type Article :");

        labelLibelle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelLibelle.setText("Libell� :");

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
        ButtonFut.setText("F�t");
        ButtonFut.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ButtonFutItemStateChanged(evt);
            }
        });

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
                            .addComponent(labelLibelle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ButtonBouteille)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonCasier)
                                .addGap(18, 18, 18)
                                .addComponent(ButtonFut))
                            .addComponent(comboCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboLib, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(168, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLibelle)
                    .addComponent(comboLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBouteilleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonBouteilleItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            
        try {
            typeArt = "Bouteille";
            listeArtCombo= new ApplicationController().getArticleCat(typeArt,tabCat.get(comboCat.getSelectedIndex()));
                for (Article lib : listeArtCombo){
                    this.comboLib.addItem(lib.getLibelle());
                }
                this.comboLib.setBackground(Color.blue);
                this.comboLib.repaint();
                this.comboLib.validate();
        }
        catch(BdErreur e){
             JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
        catch(NoIdentification e){
             JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_ButtonBouteilleItemStateChanged

    private void ButtonCasierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonCasierItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            typeArt = "Casier";
        }
    }//GEN-LAST:event_ButtonCasierItemStateChanged

    private void ButtonFutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ButtonFutItemStateChanged
        if(evt.getStateChange()== ItemEvent.SELECTED){
            typeArt ="F�t";
        }
    }//GEN-LAST:event_ButtonFutItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ButtonBouteille;
    private javax.swing.JRadioButton ButtonCasier;
    private javax.swing.JRadioButton ButtonFut;
    private javax.swing.JLabel LabelListing;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboCat;
    private javax.swing.JComboBox comboLib;
    private javax.swing.JLabel labelCat;
    private javax.swing.JLabel labelLibelle;
    private javax.swing.JLabel labelType;
    // End of variables declaration//GEN-END:variables
}
