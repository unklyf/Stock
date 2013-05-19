package packageView;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;

/**
 * Panel recherche fournisseur
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class RechercheFournisseur extends javax.swing.JPanel {

    private ArrayList<Fournisseur> tabFourn;
    private AllArticleModif allArt;

    /**
     *
     */
    public RechercheFournisseur() {
        initComponents();
        tabFourn = new ArrayList<Fournisseur>();

        //Remplir liste fournisseur
        try {
            this.jTableRechFourn.setVisible(false);
            tabFourn = new ApplicationController().getFournisseur();
            this.comboFourn.removeAllItems();
            for (Fournisseur f : tabFourn) {
                this.comboFourn.addItem(f.getNom());
            }
            this.comboFourn.repaint();
            this.comboFourn.validate();

        } catch (BdErreur e) {
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        } catch (NoIdentification e) {
            JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelRechArtFourn = new javax.swing.JLabel();
        labelFourn = new javax.swing.JLabel();
        comboFourn = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRechFourn = new javax.swing.JTable();

        labelRechArtFourn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelRechArtFourn.setForeground(new java.awt.Color(153, 0, 51));
        labelRechArtFourn.setText("Recherche article via fournisseur");

        labelFourn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelFourn.setText("Fournisseur :");

        comboFourn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFournItemStateChanged(evt);
            }
        });

        jTableRechFourn.setRowSelectionAllowed(false);
        jTableRechFourn.getTableHeader().setResizingAllowed(false);
        jTableRechFourn.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableRechFourn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelRechArtFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelRechArtFourn)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFourn)
                    .addComponent(comboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Choix fournisseur
    private void comboFournItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFournItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            try {

                //Remplir table
                this.jTableRechFourn.setVisible(true);
                allArt = new AllArticleModif(new ApplicationController().getAllArticleRechFourn(tabFourn.get(comboFourn.getSelectedIndex())));
                jTableRechFourn.setModel(allArt);
                jTableRechFourn.repaint();
                jTableRechFourn.validate();

                //Redimensionner colonnes
                jTableRechFourn.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                TableColumn colLib = jTableRechFourn.getColumnModel().getColumn(0);
                colLib.setPreferredWidth(150);
                TableColumn colDesc = jTableRechFourn.getColumnModel().getColumn(2);
                colDesc.setPreferredWidth(420);
                TableColumn colPm = jTableRechFourn.getColumnModel().getColumn(4);
                colPm.setPreferredWidth(120);
                TableColumn colPc = jTableRechFourn.getColumnModel().getColumn(5);
                colPc.setPreferredWidth(120);
                TableColumn colCad = jTableRechFourn.getColumnModel().getColumn(6);
                colCad.setPreferredWidth(100);
                TableColumn colFourn = jTableRechFourn.getColumnModel().getColumn(7);
                colFourn.setPreferredWidth(150);
                TableColumn colCat = jTableRechFourn.getColumnModel().getColumn(8);
                colCat.setPreferredWidth(150);

            } catch (BdErreur e) {
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            } catch (NoIdentification e) {
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_comboFournItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboFourn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRechFourn;
    private javax.swing.JLabel labelFourn;
    private javax.swing.JLabel labelRechArtFourn;
    // End of variables declaration//GEN-END:variables
}
