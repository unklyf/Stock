package packageView;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;

/**
 * Listing des articles
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ListingArticle extends javax.swing.JPanel {

    private AllArticleModif allArt;

    /**
     *
     */
    public ListingArticle() {
        try {
            initComponents();

            //Remplir table
            allArt = new AllArticleModif(new ApplicationController().getAllArticle());
            jTableListing.setModel(allArt);
            jTableListing.repaint();
            jTableListing.validate();

            //Redimensionnement cellules
             jTableListing.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            TableColumn colLib = jTableListing.getColumnModel( ).getColumn(0);
            colLib.setPreferredWidth(150); 
            TableColumn colDesc = jTableListing.getColumnModel( ).getColumn(2);          
            colDesc.setPreferredWidth(420); 
            TableColumn colPm = jTableListing.getColumnModel( ).getColumn(4);
            colPm.setPreferredWidth(120);
            TableColumn colPc = jTableListing.getColumnModel( ).getColumn(5);
            colPc.setPreferredWidth(120);
            TableColumn colCad = jTableListing.getColumnModel( ).getColumn(6);
            colCad.setPreferredWidth(100);
            TableColumn col18ans = jTableListing.getColumnModel( ).getColumn(7);
            col18ans.setPreferredWidth(50);
            TableColumn colFourn = jTableListing.getColumnModel( ).getColumn(8);
            colFourn.setPreferredWidth(150);
            TableColumn colCat = jTableListing.getColumnModel( ).getColumn(9);
            colCat.setPreferredWidth(150);

            //Changement background cellule pour quantit�
            TableColumn col = jTableListing.getColumnModel().getColumn(3);
            col.setCellRenderer(new JTableRender());

        } catch (BdErreur e) {
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        } catch (NoIdentification e) {
            JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelListing = new javax.swing.JLabel();
        jScrollPaneListing = new javax.swing.JScrollPane();
        jTableListing = new javax.swing.JTable();

        labelListing.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelListing.setForeground(new java.awt.Color(153, 0, 51));
        labelListing.setText("Listing article ");

        jTableListing.setDragEnabled(true);
        jTableListing.setRowSelectionAllowed(false);
        jTableListing.getTableHeader().setResizingAllowed(false);
        jTableListing.getTableHeader().setReorderingAllowed(false);
        jScrollPaneListing.setViewportView(jTableListing);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelListing, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneListing, javax.swing.GroupLayout.PREFERRED_SIZE, 1296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelListing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneListing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPaneListing;
    private javax.swing.JTable jTableListing;
    private javax.swing.JLabel labelListing;
    // End of variables declaration//GEN-END:variables
}
