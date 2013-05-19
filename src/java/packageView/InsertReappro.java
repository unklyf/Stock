package packageView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;
import packageModel.Reappro;

/**
 * Panel initialisation nouvelle commande (reappro)
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class InsertReappro extends javax.swing.JPanel {

    private ArrayList<Fournisseur> tabLibF;
    private ReapproJPanel reapAddPannel;
    private GregorianCalendar dateReap;
    private Reappro reapAdd;
    private SpinnerDateModel model;

    /**
     *
     */
    public InsertReappro() {
        //Preparer jSpinner date
        model = new SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.DAY_OF_MONTH);

        initComponents();


        try {
            //Garnir comboBox de fournisseur 
            tabLibF = new ApplicationController().getFournisseur();
            this.comboBoxFourn.removeAllItems();
            for (Fournisseur lib : tabLibF) {
                this.comboBoxFourn.addItem(lib.getNom());
            }
            this.comboBoxFourn.repaint();
            this.comboBoxFourn.validate();

        } catch (BdErreur e) {
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        } catch (NoIdentification e) {
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
        jSpinnerDate = new javax.swing.JSpinner();

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

        jSpinnerDate.setModel(model);
        jSpinnerDate.setEditor(new JSpinner.DateEditor(jSpinnerDate, "dd/MM/yyyy"));
        jSpinnerDate.setMaximumSize(new java.awt.Dimension(103, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(validerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Valider et initialiser encodage
    private void validerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerButtonActionPerformed

        //Recuperation des donnees
        dateReap = new GregorianCalendar();
        dateReap.setTime(model.getDate());

        //Instance objet reappro
        reapAdd = new Reappro(dateReap, null, "En cours", new Fournisseur(comboBoxFourn.getSelectedItem().toString()));

        //Affichage de panel d'encodage des articles pour la commande (reappro)
        reapAddPannel = new ReapproJPanel(reapAdd);
        reapAddPannel.setBounds(this.getBounds());
        this.removeAll();
        this.add(reapAddPannel);
        this.repaint();
        this.validate();

    }//GEN-LAST:event_validerButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboBoxFourn;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelFourn;
    private javax.swing.JSpinner jSpinnerDate;
    private javax.swing.JLabel titrePanel;
    private javax.swing.JButton validerButton;
    // End of variables declaration//GEN-END:variables
}
