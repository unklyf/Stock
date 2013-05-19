package packageView;

import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.ModifArtException;
import packageException.NoIdentification;
import packageModel.Article;

/**
 * Modifier un article
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ArticleModif extends javax.swing.JPanel {

    private String tabCad[] = {"------------", "Decapsuleur", "Ballon", "Lazy Bag", "Casquette", "Parapluie", "Verre", "Clé USB"};
    private Integer iTabCad = 8;
    private ApplicationController app;
    private Article artModif;
    private String boutonRadioCadeau = "";

    /**
     *
     * @param indL indice de la ligne a modifier
     * @param art article a modifier
     * @see AllArticleModif
     */
    public ArticleModif(int indL, AllArticleModif art) {
        initComponents();

        //Recuperation vieilles donnees et preparation panel
        this.cadeauCombo.setVisible(false);
        artModif = art.getContents().get(indL);
        this.fournisseurField.setText(art.getValueAt(indL, 7).toString());
        this.fournisseurField.setEnabled(false);
        this.typeArtField.setText(art.getValueAt(indL, 1).toString());
        this.typeArtField.setEnabled(false);
        this.libelleField.setText(art.getValueAt(indL, 0).toString());
        this.libelleField.setEnabled(false);
        this.categorieField.setText(art.getValueAt(indL, 8).toString());
        this.categorieField.setEnabled(false);
        this.descriptionField.setText(art.getValueAt(indL, 2).toString());
        this.quantiteField.setText(art.getValueAt(indL, 3).toString());
        this.quantiteField.setEnabled(false);
        this.prixMarchSpinner.setValue(art.getValueAt(indL, 4));

        if (art.getValueAt(indL, 5) != null) {
            this.prixConsSpinner.setValue(art.getValueAt(indL, 5));
        }

        if (art.getValueAt(indL, 6) != null) {
            this.cadeauField.setText(art.getValueAt(indL, 6).toString());
        }
        this.cadeauField.setEnabled(false);

        for (int i = 0; i < iTabCad; i++) {
            if (art.getValueAt(indL, 6) == null
                    || (art.getValueAt(indL, 6) != null && !tabCad[i].equals(art.getValueAt(indL, 6).toString()))) {
                this.cadeauCombo.addItem(tabCad[i]);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCadeau = new javax.swing.ButtonGroup();
        labelModifArticle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelFourn = new javax.swing.JLabel();
        labelType = new javax.swing.JLabel();
        labelCat = new javax.swing.JLabel();
        labelLibelle = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();
        labelMarchandise = new javax.swing.JLabel();
        labelConsigne = new javax.swing.JLabel();
        labelQuestionCadeau = new javax.swing.JLabel();
        fournisseurField = new javax.swing.JTextField();
        categorieField = new javax.swing.JTextField();
        libelleField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        prixMarchSpinner = new javax.swing.JSpinner();
        prixConsSpinner = new javax.swing.JSpinner();
        cadeauField = new javax.swing.JTextField();
        cadeauCombo = new javax.swing.JComboBox();
        typeArtField = new javax.swing.JTextField();
        labelFacultatifCons = new javax.swing.JLabel();
        labelFacultatifCadeau = new javax.swing.JLabel();
        boutonModif = new javax.swing.JButton();
        labelCadeau = new javax.swing.JLabel();
        radioBoutonOui = new javax.swing.JRadioButton();
        radioBoutonNon = new javax.swing.JRadioButton();
        labelQuantite = new javax.swing.JLabel();
        quantiteField = new javax.swing.JTextField();

        labelModifArticle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelModifArticle.setForeground(new java.awt.Color(153, 0, 51));
        labelModifArticle.setText("Données de l'article");

        labelFourn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelFourn.setText("Fournisseur :");

        labelType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelType.setText("Type Article :");

        labelCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCat.setText("Catégorie :");

        labelLibelle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelLibelle.setText("Libellé :");

        labelDescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDescription.setText("Description :");

        labelMarchandise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMarchandise.setText("Prix Marchandise :");

        labelConsigne.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelConsigne.setText("Prix Consigne :");

        labelQuestionCadeau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelQuestionCadeau.setText("Voulez-vous changer de cadeau ?");

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        SpinnerModel modelpm = new SpinnerNumberModel(0.00,0.00,1000.00,0.01);
        prixMarchSpinner.setModel(modelpm);

        SpinnerModel modelpc = new SpinnerNumberModel(0.00,0.00,1000.00,0.01);
        prixConsSpinner.setModel(modelpc);

        labelFacultatifCons.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelFacultatifCons.setText("(Facultatif)");

        labelFacultatifCadeau.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelFacultatifCadeau.setText("(Facultatif)");

        boutonModif.setText("Modifier");
        boutonModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonModifActionPerformed(evt);
            }
        });

        labelCadeau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCadeau.setText("Cadeau :");

        buttonGroupCadeau.add(radioBoutonOui);
        radioBoutonOui.setText("Oui");
        radioBoutonOui.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioBoutonOuiItemStateChanged(evt);
            }
        });

        buttonGroupCadeau.add(radioBoutonNon);
        radioBoutonNon.setText("Non");
        radioBoutonNon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioBoutonNonItemStateChanged(evt);
            }
        });

        labelQuantite.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelQuantite.setText("Quantité :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quantiteField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelConsigne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMarchandise, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(labelFourn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelCat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelLibelle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(prixConsSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(prixMarchSpinner, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(labelFacultatifCons, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(typeArtField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(fournisseurField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(categorieField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(libelleField, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelCadeau, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cadeauField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelFacultatifCadeau, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(radioBoutonOui)
                                        .addGap(51, 51, 51)
                                        .addComponent(radioBoutonNon)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boutonModif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(cadeauCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(141, 141, 141))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(labelQuestionCadeau, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFourn)
                    .addComponent(fournisseurField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelType)
                    .addComponent(typeArtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCat)
                    .addComponent(categorieField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLibelle)
                    .addComponent(libelleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelDescription)
                        .addGap(89, 89, 89)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelQuantite)
                            .addComponent(quantiteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMarchandise)
                            .addComponent(prixMarchSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConsigne)
                    .addComponent(prixConsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFacultatifCons))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cadeauField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelFacultatifCadeau))
                    .addComponent(labelCadeau))
                .addGap(18, 18, 18)
                .addComponent(labelQuestionCadeau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBoutonOui)
                    .addComponent(radioBoutonNon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadeauCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonModif, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(labelModifArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(509, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelModifArticle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Confirmer la modification
    private void boutonModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonModifActionPerformed
        //Verification données
        if (this.descriptionField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer une description.");
        } else {
            if (Double.parseDouble(this.prixMarchSpinner.getValue().toString()) == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez indiquer le prix de la marchandise.");
            } else {
                if (boutonRadioCadeau.equals("")) {
                    JOptionPane.showMessageDialog(null, "Veuillez cochez une case à la question.");
                } else {
                    double prixCons = 0;
                    if (!(Double.parseDouble(this.prixConsSpinner.getValue().toString()) == 0)) {
                        prixCons = Double.parseDouble(this.prixConsSpinner.getValue().toString());
                    }

                    String cadeau = artModif.getCadeau();
                    if (this.radioBoutonOui.isSelected()) {
                        cadeau = (String) this.cadeauCombo.getSelectedItem();

                        if (cadeau.charAt(0) == '-') {
                            cadeau = null;
                        }
                    }

                    //Ajout dans la BD
                    app = new ApplicationController();
                    try {
                        Article art = new Article(artModif.getIdProduit(),
                                this.descriptionField.getText(),
                                Double.parseDouble(this.prixMarchSpinner.getValue().toString()),
                                prixCons,
                                cadeau);

                        app.modifArticle(art, artModif);
                        JOptionPane.showMessageDialog(null, "Modification effectuée avec succès !");

                        //Retour page d'acceuil apres modif 
                        AccueilPanel panel = new AccueilPanel();
                        panel.setBounds(new MainJFrame().getBounds());
                        this.removeAll();
                        this.add(panel);
                        this.repaint();
                        this.validate();

                    } catch (BdErreur e) {
                        JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
                    } catch (NoIdentification e) {
                        JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
                    } catch (ModifArtException e) {
                        JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_boutonModifActionPerformed

    //Choix de oui pour changer cadeau
    private void radioBoutonOuiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioBoutonOuiItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            boutonRadioCadeau = "Oui";
            this.cadeauCombo.setVisible(true);
        }
    }//GEN-LAST:event_radioBoutonOuiItemStateChanged

    //Choix de non pour changer cadeau
    private void radioBoutonNonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioBoutonNonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            boutonRadioCadeau = "Non";
            this.cadeauCombo.setVisible(false);
        }
    }//GEN-LAST:event_radioBoutonNonItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutonModif;
    private javax.swing.ButtonGroup buttonGroupCadeau;
    private javax.swing.JComboBox cadeauCombo;
    private javax.swing.JTextField cadeauField;
    private javax.swing.JTextField categorieField;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JTextField fournisseurField;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCadeau;
    private javax.swing.JLabel labelCat;
    private javax.swing.JLabel labelConsigne;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelFacultatifCadeau;
    private javax.swing.JLabel labelFacultatifCons;
    private javax.swing.JLabel labelFourn;
    private javax.swing.JLabel labelLibelle;
    private javax.swing.JLabel labelMarchandise;
    private javax.swing.JLabel labelModifArticle;
    private javax.swing.JLabel labelQuantite;
    private javax.swing.JLabel labelQuestionCadeau;
    private javax.swing.JLabel labelType;
    private javax.swing.JTextField libelleField;
    private javax.swing.JSpinner prixConsSpinner;
    private javax.swing.JSpinner prixMarchSpinner;
    private javax.swing.JTextField quantiteField;
    private javax.swing.JRadioButton radioBoutonNon;
    private javax.swing.JRadioButton radioBoutonOui;
    private javax.swing.JTextField typeArtField;
    // End of variables declaration//GEN-END:variables
}
