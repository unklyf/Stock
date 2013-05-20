package packageView;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import packageController.ApplicationController;
import packageException.AddReapException;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.LigneReappro;
import packageModel.Reappro;

/**
 * Récapitulatif final de la commande (Réapprovisionnement)
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ConfirmReapproJFrame extends javax.swing.JFrame {

    private ArrayList<LigneReappro> listeLReap;
    private Reappro reapAdd;
    private ReapproJPanel pan;
    private int iDReappro = 0;
    private double prixTotal = 0;

    /**
     *
     * @param listeReap arrayList LigneReappro
     * @param reapInfo  le reappro du depart
     * @param panel     le panel precedent
     */
    public ConfirmReapproJFrame(ArrayList<LigneReappro> listeReap, Reappro reapInfo, ReapproJPanel panel) {
        initComponents();
        reapAdd = reapInfo;
        listeLReap = listeReap;
        pan = panel;

        //Calcul prix total commande
        for (LigneReappro lReap : listeLReap) {
            prixTotal += (lReap.getArt().getPrixM() + lReap.getArt().getPrixC()) * lReap.getQte();
        }

        //Remplir tableau recapitulatif
        AllLigneReapproModel model = new AllLigneReapproModel(listeLReap);
        jTableRecapFinal.setModel(model);
        jTableRecapFinal.repaint();
        jTableRecapFinal.validate();

        jTextFieldLibF.setText(reapAdd.getFourn().getNom());
        jTextFieldDateR.setText(reapInfo.getReapDate().getTime().toString());
        jTextFieldPrix.setText(String.valueOf(prixTotal));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelQuestion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRecapFinal = new javax.swing.JTable();
        jButtonOk = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jTextFieldDateR = new javax.swing.JTextField();
        jTextFieldLibF = new javax.swing.JTextField();
        jLabelDate = new javax.swing.JLabel();
        jLabelFourn = new javax.swing.JLabel();
        jTextFieldPrix = new javax.swing.JTextField();
        jLabelPrix = new javax.swing.JLabel();
        jLabelEuro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmation commande");
        setBounds(new java.awt.Rectangle(400, 100, 0, 0));

        jLabelQuestion.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelQuestion.setText("La commande est-elle correcte ?");

        jTableRecapFinal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableRecapFinal);

        jButtonOk.setText("Confirmer");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jTextFieldDateR.setEditable(false);
        jTextFieldDateR.setBackground(new java.awt.Color(204, 102, 0));
        jTextFieldDateR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldDateR.setEnabled(false);

        jTextFieldLibF.setEditable(false);
        jTextFieldLibF.setBackground(new java.awt.Color(204, 102, 0));
        jTextFieldLibF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldLibF.setEnabled(false);

        jLabelDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDate.setText("Date : ");

        jLabelFourn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFourn.setText("Fournisseur : ");

        jTextFieldPrix.setEditable(false);
        jTextFieldPrix.setBackground(new java.awt.Color(204, 102, 0));
        jTextFieldPrix.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldPrix.setEnabled(false);

        jLabelPrix.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPrix.setText("Prix à payer :");

        jLabelEuro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEuro.setText("€");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelFourn)
                            .addComponent(jLabelDate)
                            .addComponent(jLabelPrix))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldLibF, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(jTextFieldDateR)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldPrix, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelEuro)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jButtonOk)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonAnnuler))
                                .addComponent(jLabelQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLibF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFourn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDateR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrix, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrix)
                    .addComponent(jLabelEuro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonAnnuler))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Annuler et retour au panel commande
    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    //Confirmer la commande
    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed

        //Ajout Reappro
        try {
            iDReappro = new ApplicationController().addReappro(reapAdd);

        } catch (BdErreur e) {
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        } catch (NoIdentification e) {
            JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        } catch (AddReapException e) {
            JOptionPane.showMessageDialog(null, e, "Exception", JOptionPane.ERROR_MESSAGE);
        }


        //Ajout LigneReappro
        try {
            for (int i = 0; i < listeLReap.size(); i++) {
                new ApplicationController().addLigneReappro(listeLReap.get(i), iDReappro);
            }
        } catch (BdErreur e) {
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        } catch (NoIdentification e) {
            JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        } catch (AddReapException e) {
            JOptionPane.showMessageDialog(null, e, "Exception", JOptionPane.ERROR_MESSAGE);
        }

        //Retour Accueil
        this.dispose();
        AccueilPanel panel = new AccueilPanel();
        panel.setBounds(new MainJFrame().getBounds());
        pan.removeAll();
        pan.add(panel);
        pan.repaint();
        pan.validate();

    }//GEN-LAST:event_jButtonOkActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelEuro;
    private javax.swing.JLabel jLabelFourn;
    private javax.swing.JLabel jLabelPrix;
    private javax.swing.JLabel jLabelQuestion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRecapFinal;
    private javax.swing.JTextField jTextFieldDateR;
    private javax.swing.JTextField jTextFieldLibF;
    private javax.swing.JTextField jTextFieldPrix;
    // End of variables declaration//GEN-END:variables
}
