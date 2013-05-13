
package packageView;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;

public class RechReapproJPanel extends javax.swing.JPanel {

    private ArrayList <Fournisseur> listeLib;
    
    public RechReapproJPanel() {
        initComponents();
        listeLib= new ArrayList <Fournisseur>();
        //Garnir comboBox de fournisseur   
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
        jSpinnerDate = new javax.swing.JSpinner();
        jLabelDateR = new javax.swing.JLabel();
        jLabelFourn = new javax.swing.JLabel();
        jComboBoxFournisseur = new javax.swing.JComboBox();
        jButtonRecherche = new javax.swing.JButton();

        labelTitrePanel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelTitrePanel.setForeground(new java.awt.Color(153, 0, 51));
        labelTitrePanel.setText("Recherche Reappro");

        jSpinnerDate.setModel(new javax.swing.SpinnerDateModel());

        jLabelDateR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDateR.setText("Date réapprovisionnement :");

        jLabelFourn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFourn.setText("Fournisseur :");

        jComboBoxFournisseur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonRecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packageImage/loupe.png"))); // NOI18N
        jButtonRecherche.setText("Rechercher");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitrePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSpinnerDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDateR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFourn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButtonRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelTitrePanel)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDateR)
                    .addComponent(jLabelFourn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerDate, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButtonRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jComboBoxFournisseur))
                .addGap(371, 371, 371))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRecherche;
    private javax.swing.JComboBox jComboBoxFournisseur;
    private javax.swing.JLabel jLabelDateR;
    private javax.swing.JLabel jLabelFourn;
    private javax.swing.JSpinner jSpinnerDate;
    private javax.swing.JLabel labelTitrePanel;
    // End of variables declaration//GEN-END:variables
}
