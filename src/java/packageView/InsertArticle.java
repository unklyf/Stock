package packageView;

import java.awt.event.ItemEvent;
import java.util.*;
import javax.swing.*;
import packageController.ApplicationController;
import packageException.AddArtException;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;

/**
 * Panel insertion nouvel article
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class InsertArticle extends JPanel {

    private ArrayList<Fournisseur> tabFourn;
    private ArrayList<Categorie> tabCat;
    private String typeArt;
    private ApplicationController app;
    private Article nouvArt;
    private Fournisseur fourn;
    private Categorie cat;

    /**
     *
     */
    public InsertArticle() {
        initComponents();
        typeArt = "";
        tabFourn = new ArrayList<Fournisseur>();
        tabCat = new ArrayList<Categorie>();


        try {
            //Remplir liste fournisseur
            tabFourn = new ApplicationController().getFournisseur();
            this.comboFourn.removeAllItems();
            this.comboFourn.addItem("------------------------------------------------");
            for (Fournisseur f : tabFourn) {
                this.comboFourn.addItem(f.getNom());
            }
            this.comboFourn.repaint();
            this.comboFourn.validate();

            //Remplir liste categorie
            tabCat = new ApplicationController().getCatArticle();
            this.jComboCat.removeAllItems();
            this.jComboCat.addItem("------------------------------------------------");
            for (Categorie categ : tabCat) {
                this.jComboCat.addItem(categ.getNom());
            }
            this.jComboCat.repaint();
            this.jComboCat.validate();


        } catch (BdErreur e) {
            JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        } catch (NoIdentification e) {
            JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        labelInsArt = new javax.swing.JLabel();
        panelChamp = new javax.swing.JPanel();
        labelConsigne = new javax.swing.JLabel();
        prixMarchSpinner = new javax.swing.JSpinner();
        labelMarchandise = new javax.swing.JLabel();
        cadeauComboBox = new javax.swing.JComboBox();
        buttonAjout = new javax.swing.JButton();
        prixConsSpinner = new javax.swing.JSpinner();
        labelCadeau = new javax.swing.JLabel();
        labelFacultatifCad = new javax.swing.JLabel();
        jTextFieldLibelle = new javax.swing.JTextField();
        labelFacultatifCons = new javax.swing.JLabel();
        labelLibelle = new javax.swing.JLabel();
        labelFourn = new javax.swing.JLabel();
        buttonBouteille = new javax.swing.JRadioButton();
        labelType = new javax.swing.JLabel();
        buttonFut = new javax.swing.JRadioButton();
        buttonCasier = new javax.swing.JRadioButton();
        labelDescription = new javax.swing.JLabel();
        comboFourn = new javax.swing.JComboBox();
        jScrollPaneDesc = new javax.swing.JScrollPane();
        JTextAreaDesc = new javax.swing.JTextArea();
        labelMajuscule = new javax.swing.JLabel();
        labelCat = new javax.swing.JLabel();
        jComboCat = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(800, 700));

        labelInsArt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelInsArt.setForeground(new java.awt.Color(153, 0, 51));
        labelInsArt.setText("Inserer nouvel article");

        labelConsigne.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelConsigne.setText("Prix Consigne :");

        SpinnerModel modelpm = new SpinnerNumberModel(0.00,0.00,1000.00,0.01);
        prixMarchSpinner.setModel(modelpm);
        prixMarchSpinner.setCursor(null);

        labelMarchandise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMarchandise.setText("Prix Marchandise :");

        cadeauComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------------------", "Decapsuleur", "Ballon", "Lazy Bag", "Casquette", "Parapluie", "Verre", "Clé USB" }));

        buttonAjout.setText("Ajouter ");
        buttonAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAjoutActionPerformed(evt);
            }
        });

        SpinnerModel modelpc = new SpinnerNumberModel(0.00,0.00,1000.00,0.01);
        prixConsSpinner.setModel(modelpc);

        labelCadeau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCadeau.setText("Cadeau :");

        labelFacultatifCad.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelFacultatifCad.setText("(Facultatif)");

        labelFacultatifCons.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labelFacultatifCons.setText("(Facultatif)");

        labelLibelle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelLibelle.setText("Libellé :");

        labelFourn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelFourn.setText("Fournisseur :");

        buttonGroup1.add(buttonBouteille);
        buttonBouteille.setText("Bouteille");
        buttonBouteille.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                buttonBouteilleItemStateChanged(evt);
            }
        });

        labelType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelType.setText("Type Article :");

        buttonGroup1.add(buttonFut);
        buttonFut.setText("Fût");
        buttonFut.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                buttonFutItemStateChanged(evt);
            }
        });

        buttonGroup1.add(buttonCasier);
        buttonCasier.setText("Casier");
        buttonCasier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                buttonCasierItemStateChanged(evt);
            }
        });

        labelDescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDescription.setText("Description :");

        JTextAreaDesc.setColumns(20);
        JTextAreaDesc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        JTextAreaDesc.setRows(1);
        jScrollPaneDesc.setViewportView(JTextAreaDesc);

        labelMajuscule.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        labelMajuscule.setText("(Première lettre en majuscule)");

        labelCat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCat.setText("Catégorie :");

        javax.swing.GroupLayout panelChampLayout = new javax.swing.GroupLayout(panelChamp);
        panelChamp.setLayout(panelChampLayout);
        panelChampLayout.setHorizontalGroup(
            panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChampLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelChampLayout.createSequentialGroup()
                        .addComponent(labelCat, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelChampLayout.createSequentialGroup()
                        .addComponent(labelFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelChampLayout.createSequentialGroup()
                        .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelCadeau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelConsigne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelMarchandise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelLibelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelType, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelChampLayout.createSequentialGroup()
                                .addComponent(buttonBouteille)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCasier)
                                .addGap(18, 18, 18)
                                .addComponent(buttonFut))
                            .addComponent(jTextFieldLibelle)
                            .addComponent(labelMajuscule, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPaneDesc)
                            .addComponent(prixConsSpinner)
                            .addComponent(prixMarchSpinner)
                            .addComponent(cadeauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFacultatifCons, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFacultatifCad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52))
        );
        panelChampLayout.setVerticalGroup(
            panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChampLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFourn)
                    .addComponent(comboFourn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelType)
                    .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonBouteille)
                        .addComponent(buttonCasier)
                        .addComponent(buttonFut)))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCat)
                    .addComponent(jComboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelMajuscule)
                .addGap(2, 2, 2)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLibelle)
                    .addComponent(jTextFieldLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescription)
                    .addComponent(jScrollPaneDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMarchandise)
                    .addComponent(prixMarchSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelConsigne)
                    .addComponent(prixConsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFacultatifCons))
                .addGap(18, 18, 18)
                .addGroup(panelChampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCadeau)
                    .addComponent(cadeauComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFacultatifCad))
                .addGap(30, 30, 30)
                .addComponent(buttonAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelChamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelInsArt, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelInsArt)
                .addGap(18, 18, 18)
                .addComponent(panelChamp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Ajouter dans la BD
    private void buttonAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAjoutActionPerformed


        //Verification données entrées
        if (comboFourn.getSelectedItem().toString().charAt(0) == '-') {
            JOptionPane.showMessageDialog(null, "Aucun fournisseur sélectionné.");
        } else {
            if (typeArt.equals("")) {
                JOptionPane.showMessageDialog(null, "Aucun type sélectionné.");
            } else {
                if (jComboCat.getSelectedItem().toString().charAt(0) == '-') {
                    JOptionPane.showMessageDialog(null, "Aucune catégorie sélectionné.");
                } else {
                    if (this.jTextFieldLibelle.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Veuillez entrer un libellé.");
                    } else {
                        if (this.JTextAreaDesc.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Veuillez entrer une description.");
                        } else {
                            if (Double.parseDouble(this.prixMarchSpinner.getValue().toString()) == 0) {
                                JOptionPane.showMessageDialog(null, "Veuillez indiquer le prix de la marchandise.");
                            } else {
                                double prixCons = 0;
                                if (!(Double.parseDouble(this.prixConsSpinner.getValue().toString()) == 0)) {
                                    prixCons = Double.parseDouble(this.prixConsSpinner.getValue().toString());
                                }

                                String cadeau = cadeauComboBox.getSelectedItem().toString();
                                if (cadeau.charAt(0) == '-') {
                                    cadeau = null;
                                }

                                //Ajout nouvel article
                                app = new ApplicationController();
                                try {
                                    nouvArt = new Article(this.jTextFieldLibelle.getText(),
                                            typeArt,
                                            this.JTextAreaDesc.getText(),
                                            cadeau,
                                            Double.parseDouble(this.prixMarchSpinner.getValue().toString()),
                                            prixCons);
                                    fourn = new Fournisseur(comboFourn.getSelectedItem().toString());
                                    cat = new Categorie(jComboCat.getSelectedItem().toString());
                                    app.addArticle(nouvArt, fourn, cat);


                                    JOptionPane.showMessageDialog(null, "Encodage réalisé avec succès !");

                                    // Retour page d'acceuil apres ajout 
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
                                } catch (AddArtException e) {
                                    JOptionPane.showMessageDialog(null, e, "Exception", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                        }

                    }
                }
            }
        }

    }//GEN-LAST:event_buttonAjoutActionPerformed

    //Choix type article bouteille
    private void buttonBouteilleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_buttonBouteilleItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            typeArt = "Bouteille";
        }
    }//GEN-LAST:event_buttonBouteilleItemStateChanged

    //Choix type article casier
    private void buttonCasierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_buttonCasierItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            typeArt = "Casier";
        }
    }//GEN-LAST:event_buttonCasierItemStateChanged

    //Choix type article fut
    private void buttonFutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_buttonFutItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            typeArt = "Fût";
        }
    }//GEN-LAST:event_buttonFutItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTextAreaDesc;
    private javax.swing.JButton buttonAjout;
    private javax.swing.JRadioButton buttonBouteille;
    private javax.swing.JRadioButton buttonCasier;
    private javax.swing.JRadioButton buttonFut;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cadeauComboBox;
    private javax.swing.JComboBox comboFourn;
    private javax.swing.JComboBox jComboCat;
    private javax.swing.JScrollPane jScrollPaneDesc;
    private javax.swing.JTextField jTextFieldLibelle;
    private javax.swing.JLabel labelCadeau;
    private javax.swing.JLabel labelCat;
    private javax.swing.JLabel labelConsigne;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelFacultatifCad;
    private javax.swing.JLabel labelFacultatifCons;
    private javax.swing.JLabel labelFourn;
    private javax.swing.JLabel labelInsArt;
    private javax.swing.JLabel labelLibelle;
    private javax.swing.JLabel labelMajuscule;
    private javax.swing.JLabel labelMarchandise;
    private javax.swing.JLabel labelType;
    private javax.swing.JPanel panelChamp;
    private javax.swing.JSpinner prixConsSpinner;
    private javax.swing.JSpinner prixMarchSpinner;
    // End of variables declaration//GEN-END:variables
}
