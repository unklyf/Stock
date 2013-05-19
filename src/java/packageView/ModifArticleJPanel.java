package packageView;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;



public class ModifArticleJPanel extends javax.swing.JPanel {

  private ListSelectionModel listSelect;
  private ArticleModif panModif;
  private AllArticleModif artMod;

  
  
   public ModifArticleJPanel() {
       
        
       
        try {
            initComponents();
            artMod = new AllArticleModif (new ApplicationController().getAllArticle());
            JTableModif.setModel(artMod);
            JTableModif.repaint();
            JTableModif.validate();
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
             
            JTableModif.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = JTableModif.getSelectionModel();
            
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

        LabelModif = new javax.swing.JLabel();
        jScrollPaneModif = new javax.swing.JScrollPane();
        JTableModif = new javax.swing.JTable();
        BoutonModif = new javax.swing.JButton();

        LabelModif.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        LabelModif.setForeground(new java.awt.Color(153, 0, 51));
        LabelModif.setText("Modification article ");

        JTableModif.setModel(new javax.swing.table.DefaultTableModel(
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
        JTableModif.getTableHeader().setResizingAllowed(false);
        JTableModif.getTableHeader().setReorderingAllowed(false);
        jScrollPaneModif.setViewportView(JTableModif);

        BoutonModif.setText("Modifier");
        BoutonModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonModifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BoutonModif, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelModif, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneModif, javax.swing.GroupLayout.PREFERRED_SIZE, 1293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(LabelModif)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneModif, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonModif, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonModifActionPerformed
        if(listSelect.isSelectionEmpty()==false){
            
            int indLigne= listSelect.getMinSelectionIndex();
            
            panModif=new ArticleModif(indLigne, artMod);
            panModif.setBounds(this.getBounds());
            this.removeAll();
            this.add(panModif);
            this.repaint();
            this.validate();     
        }
        else{
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau récapitulatif sélectionnée");
        }
    }//GEN-LAST:event_BoutonModifActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonModif;
    private javax.swing.JTable JTableModif;
    private javax.swing.JLabel LabelModif;
    private javax.swing.JScrollPane jScrollPaneModif;
    // End of variables declaration//GEN-END:variables
}
