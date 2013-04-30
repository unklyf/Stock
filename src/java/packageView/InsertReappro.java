package packageView;

import java.awt.Color;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;


public class InsertReappro extends javax.swing.JPanel {

    private ArrayList <String> tabLibF;
    private GregorianCalendar dateReap;
        
    public InsertReappro() {
        initComponents();
        tabLibF= new ArrayList <String>();
        try {

                tabLibF= new ApplicationController().getNomFourn();
                this.comboBoxFourn.removeAllItems();
                for (String lib : tabLibF){                   
                    this.comboBoxFourn.addItem(lib);
                }
                this.comboBoxFourn.repaint();
                this.comboBoxFourn.validate();

           }
            catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
            }
            catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
            }
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxFourn = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        SpinnerDate = new javax.swing.JSpinner();

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 51));
        jLabel11.setText("Commande fournisseur");

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel1.setText("Sélectionnez la date pour laquelle la commande est souhaitée :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setText("Sélectionnez un fournisseur chez qui passer la commande :");

        SpinnerDate.setModel(dateModel);
        SpinnerDate.setEditor(new JSpinner.DateEditor(SpinnerDate, "dd-MM-yyyy"));
        dateReap= new GregorianCalendar();
        dateReap.setTime(dateModel.getDate());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(comboBoxFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboBoxFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerDate;
    private javax.swing.JComboBox comboBoxFourn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
