package packageView;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;

/**
 * Modifier un article
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ModifArticleJPanel extends javax.swing.JPanel {

    private ListSelectionModel listSelect;
    private ArticleModif panModif;
    private AllArticleModif artMod;

    /**
     *
     */
    public ModifArticleJPanel() {

        try {
            initComponents();

            //Remplir tableau
            artMod = new AllArticleModif(new ApplicationController().getAllArticle());
            JTableModif.setModel(artMod);
            JTableModif.repaint();
            JTableModif.validate();

            //Redimensionner colonnes
            JTableModif.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            TableColumn colLib = JTableModif.getColumnModel( ).getColumn(0);
            colLib.setPreferredWidth(150); 
            TableColumn colDesc = JTableModif.getColumnModel( ).getColumn(2);          
            colDesc.setPreferredWidth(420); 
            TableColumn colPm = JTableModif.getColumnModel( ).getColumn(4);
            colPm.setPreferredWidth(120);
            TableColumn colPc = JTableModif.getColumnModel( ).getColumn(5);
            colPc.setPreferredWidth(120);
            TableColumn colCad = JTableModif.getColumnModel( ).getColumn(6);
            colCad.setPreferredWidth(100);
            TableColumn col18ans = JTableModif.getColumnModel( ).getColumn(7);
            col18ans.setPreferredWidth(50);
            TableColumn colFourn = JTableModif.getColumnModel( ).getColumn(8);
            colFourn.setPreferredWidth(150);
            TableColumn colCat = JTableModif.getColumnModel( ).getColumn(9);
            colCat.setPreferredWidth(150);

            //Selection ligne du tableau
            JTableModif.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = JTableModif.getSelectionModel();

        } catch (BdErreur e) {
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        } catch (NoIdentification e) {
            JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelModif = new javax.swing.JLabel();
        jScrollPaneModif = new javax.swing.JScrollPane();
        JTableModif = new javax.swing.JTable();
        boutonModif = new javax.swing.JButton();

        labelModif.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelModif.setForeground(new java.awt.Color(153, 0, 51));
        labelModif.setText("Modification article ");

        JTableModif.getTableHeader().setResizingAllowed(false);
        JTableModif.getTableHeader().setReorderingAllowed(false);
        jScrollPaneModif.setViewportView(JTableModif);

        boutonModif.setText("Modifier");
        boutonModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonModifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonModif, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelModif, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneModif, javax.swing.GroupLayout.PREFERRED_SIZE, 1293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelModif)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneModif, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonModif, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Modifier article
    private void boutonModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonModifActionPerformed
        if (listSelect.isSelectionEmpty() == false) {

            //Recuperation indice ligne tableau
            int indLigne = listSelect.getMinSelectionIndex();

            //Affichage panel de modification
            panModif = new ArticleModif(indLigne, artMod);
            panModif.setBounds(this.getBounds());
            this.removeAll();
            this.add(panModif);
            this.repaint();
            this.validate();
        } else {
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau récapitulatif sélectionnée");
        }
    }//GEN-LAST:event_boutonModifActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableModif;
    private javax.swing.JButton boutonModif;
    private javax.swing.JScrollPane jScrollPaneModif;
    private javax.swing.JLabel labelModif;
    // End of variables declaration//GEN-END:variables
}
