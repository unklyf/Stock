package packageView;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;



public class SuppressionRJPanel extends javax.swing.JPanel {

    private AllReapproModel allReap;
    private ListSelectionModel listSelect;
    private ApplicationController app;
    
    public SuppressionRJPanel() {
    
        try {
            initComponents();
            allReap = new AllReapproModel (new ApplicationController().getAllReappro());
            jTableSupp.setModel(allReap);
            jTableSupp.repaint();
            jTableSupp.validate();
            
            jTableSupp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listSelect = jTableSupp.getSelectionModel();
            
            
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

        labelSupp = new javax.swing.JLabel();
        jPanelSupp = new javax.swing.JPanel();
        jScrollPaneSupp = new javax.swing.JScrollPane();
        jTableSupp = new javax.swing.JTable();
        boutonSupp = new javax.swing.JButton();

        labelSupp.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelSupp.setForeground(new java.awt.Color(153, 0, 51));
        labelSupp.setText("Suppression article ");

        jTableSupp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneSupp.setViewportView(jTableSupp);

        boutonSupp.setText("Supprimer");
        boutonSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonSuppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSuppLayout = new javax.swing.GroupLayout(jPanelSupp);
        jPanelSupp.setLayout(jPanelSuppLayout);
        jPanelSuppLayout.setHorizontalGroup(
            jPanelSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuppLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanelSuppLayout.setVerticalGroup(
            jPanelSuppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuppLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(labelSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanelSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(757, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelSupp)
                .addGap(18, 18, 18)
                .addComponent(jPanelSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boutonSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonSuppActionPerformed
          if(listSelect.isSelectionEmpty()==false){
            
            int indLigne= listSelect.getMinSelectionIndex();
            app = new ApplicationController();
            
            
            try { 
                app.suppArticle(allReap.getContents().get(indLigne).getiDReappro());
                JOptionPane.showMessageDialog(null,"Suppression effectuée avec succès !");
                allReap = new AllReapproModel (new ApplicationController().getAllReappro());
            }  
            
            catch(BdErreur e){
                  JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }

            catch(NoIdentification e){
                  JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
            
            jTableSupp.setModel(allReap);
            jTableSupp.repaint();
            jTableSupp.validate();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau récapitulatif sélectionnée");
        }
    }//GEN-LAST:event_boutonSuppActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonSupp;
    private javax.swing.JPanel jPanelSupp;
    private javax.swing.JScrollPane jScrollPaneSupp;
    private javax.swing.JTable jTableSupp;
    private javax.swing.JLabel labelSupp;
    // End of variables declaration//GEN-END:variables
}
