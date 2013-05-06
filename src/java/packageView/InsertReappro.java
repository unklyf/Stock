package packageView;


import java.awt.Color;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Reappro;


public class InsertReappro extends javax.swing.JPanel {

    private ArrayList <String> tabLibF;
    private ReapproJPanel reapAddPannel; 
    private GregorianCalendar dateReap;
    private Reappro reapAdd;
    
    public InsertReappro() {
        initComponents();
        jCalendarReappro.setLocale(new Locale("fr", "FR"));
        
        //Garnir comboBox de fournisseur
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

        titrePanel = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        comboBoxFourn = new javax.swing.JComboBox();
        jLabelFourn = new javax.swing.JLabel();
        validerButton = new javax.swing.JButton();
        jCalendarReappro = new com.toedter.calendar.JCalendar();

        titrePanel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        titrePanel.setForeground(new java.awt.Color(153, 0, 51));
        titrePanel.setText("Commande fournisseur");

        jLabelDate.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelDate.setText("Sélectionnez la date pour laquelle la commande est souhaitée :");

        jLabelFourn.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelFourn.setText("Sélectionnez un fournisseur chez qui passer la commande :");

        validerButton.setText("Initialiser nouvelle commande");
        validerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerButtonActionPerformed(evt);
            }
        });

        jCalendarReappro.setMinSelectableDate(new java.util.Date());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalendarReappro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validerButton)
                    .addComponent(jLabelDate)
                    .addComponent(jLabelFourn)
                    .addComponent(titrePanel)
                    .addComponent(comboBoxFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(389, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(titrePanel)
                .addGap(45, 45, 45)
                .addComponent(jLabelFourn)
                .addGap(18, 18, 18)
                .addComponent(comboBoxFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCalendarReappro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void validerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerButtonActionPerformed
        
        //Recuperation des donnees
        dateReap=new GregorianCalendar();
        dateReap.setTime(jCalendarReappro.getDate());
        
        //Instance objet reappro
        reapAdd = new Reappro (dateReap,null,"En cours");
        
        //Affichage de panel d'encodage des articles pour la commande (reappro)
        reapAddPannel=new ReapproJPanel(reapAdd,comboBoxFourn.getSelectedItem().toString());
        reapAddPannel.setBounds(this.getBounds());
        this.removeAll();
        this.add(reapAddPannel);
        this.repaint();
        this.validate();
       
    }//GEN-LAST:event_validerButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxFourn;
    private com.toedter.calendar.JCalendar jCalendarReappro;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelFourn;
    private javax.swing.JLabel titrePanel;
    private javax.swing.JButton validerButton;
    // End of variables declaration//GEN-END:variables
}
