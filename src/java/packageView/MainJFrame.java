package packageView;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import packageController.ApplicationController;
import packageException.DeconnectionErreur;

/**
 * Fenetre principale
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class MainJFrame extends javax.swing.JFrame {

    private AccueilPanel aP;
    private InsertArticle insArt;
    private InsertReappro reapAdd;
    private ModifArticleJPanel modifArt;
    private ListingReapproJPanel listReap;
    private SuppressionRJPanel suppArt;
    private ListingArticle listArt;
    private RechReapproJPanel rechReap;
    private RechercheCategorie rechCat;
    private RechercheFournisseur rechFourn;
    private Dimension dim;

    /**
     *
     */
    public MainJFrame() {
        Toolkit t = this.getToolkit();
        dim = t.getScreenSize();

        initComponents();
        //Affichage pannel accueil
        this.itemMenuAccueil.doClick();

        //Affichage directement plein �cran
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuApplication = new javax.swing.JMenu();
        itemMenuAccueil = new javax.swing.JMenuItem();
        itemQuitter = new javax.swing.JMenuItem();
        menuAjout = new javax.swing.JMenu();
        itemArticleAjout = new javax.swing.JMenuItem();
        itemAjoutReappro = new javax.swing.JMenuItem();
        menuModifier = new javax.swing.JMenu();
        itemModifAjout = new javax.swing.JMenuItem();
        menuSupprimer = new javax.swing.JMenu();
        itemSuppReap = new javax.swing.JMenuItem();
        menuListing = new javax.swing.JMenu();
        itemListReappro = new javax.swing.JMenuItem();
        itemListingArticle = new javax.swing.JMenuItem();
        menuRecherche = new javax.swing.JMenu();
        itemRechFourn = new javax.swing.JMenuItem();
        itemRechCategorie = new javax.swing.JMenuItem();
        itemRechReappro = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Stock Brasserie");
        setPreferredSize(dim);

        jLabel1.setText("jLabel1");

        menuApplication.setText("Application |");

        itemMenuAccueil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuAccueil.setText("Accueil");
        itemMenuAccueil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAccueilActionPerformed(evt);
            }
        });
        menuApplication.add(itemMenuAccueil);

        itemQuitter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        itemQuitter.setText("Quitter");
        itemQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuitterActionPerformed(evt);
            }
        });
        menuApplication.add(itemQuitter);

        menuBar.add(menuApplication);

        menuAjout.setText("Nouveau |");

        itemArticleAjout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemArticleAjout.setText("Article");
        itemArticleAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemArticleAjoutActionPerformed(evt);
            }
        });
        menuAjout.add(itemArticleAjout);

        itemAjoutReappro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemAjoutReappro.setText("Commande fournisseur");
        itemAjoutReappro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAjoutReapproActionPerformed(evt);
            }
        });
        menuAjout.add(itemAjoutReappro);

        menuBar.add(menuAjout);

        menuModifier.setText("Modifier |");

        itemModifAjout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        itemModifAjout.setText("Article");
        itemModifAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemModifAjoutActionPerformed(evt);
            }
        });
        menuModifier.add(itemModifAjout);

        menuBar.add(menuModifier);

        menuSupprimer.setText("Supprimer |");

        itemSuppReap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        itemSuppReap.setText("Commande fournisseur");
        itemSuppReap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSuppReapActionPerformed(evt);
            }
        });
        menuSupprimer.add(itemSuppReap);

        menuBar.add(menuSupprimer);

        menuListing.setText("Listing |");

        itemListReappro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemListReappro.setText("Commande fournisseur");
        itemListReappro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListReapproActionPerformed(evt);
            }
        });
        menuListing.add(itemListReappro);

        itemListingArticle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        itemListingArticle.setText("Article");
        itemListingArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemListingArticleActionPerformed(evt);
            }
        });
        menuListing.add(itemListingArticle);

        menuBar.add(menuListing);

        menuRecherche.setText("Recherche");

        itemRechFourn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        itemRechFourn.setText("Fournisseur");
        itemRechFourn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechFournActionPerformed(evt);
            }
        });
        menuRecherche.add(itemRechFourn);

        itemRechCategorie.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itemRechCategorie.setText("Categorie");
        itemRechCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechCategorieActionPerformed(evt);
            }
        });
        menuRecherche.add(itemRechCategorie);

        itemRechReappro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        itemRechReappro.setText("Commande fournisseur");
        itemRechReappro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechReapproActionPerformed(evt);
            }
        });
        menuRecherche.add(itemRechReappro);

        menuBar.add(menuRecherche);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 939, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Fermer fenetre avec la croix rouge et deconnection BD
    public class MyWindowsListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            try {
                new ApplicationController().deconnection();
            } catch (DeconnectionErreur ex) {
                JOptionPane.showMessageDialog(null, ex, "Erreur deconnection", JOptionPane.ERROR_MESSAGE);
            } finally {
                System.exit(0);
            }
        }
    }

    //Fermer application et deconnection BD
    private void itemQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuitterActionPerformed
        try {
            new ApplicationController().deconnection();
        } catch (DeconnectionErreur ex) {
            JOptionPane.showMessageDialog(null, ex, "Erreur deconnection", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }
    }//GEN-LAST:event_itemQuitterActionPerformed

    //Afficher pannel ajout article
    private void itemArticleAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemArticleAjoutActionPerformed
        insArt = new InsertArticle();
        insArt.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(insArt);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemArticleAjoutActionPerformed

    //Afficher pannel ajout reappro
    private void itemAjoutReapproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAjoutReapproActionPerformed
        reapAdd = new InsertReappro();
        reapAdd.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(reapAdd);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemAjoutReapproActionPerformed

    //Afficher pannel accueil
    private void itemMenuAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAccueilActionPerformed
        aP = new AccueilPanel();
        aP.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(aP);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemMenuAccueilActionPerformed

    //Afficher pannel modifier article
    private void itemModifAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemModifAjoutActionPerformed
        modifArt = new ModifArticleJPanel();
        modifArt.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(modifArt);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemModifAjoutActionPerformed

    //Afficher pannel lisitng reappros
    private void itemListReapproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListReapproActionPerformed
        listReap = new ListingReapproJPanel();
        listReap.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(listReap);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemListReapproActionPerformed

    //Afficher pannel supprimer reappro
    private void itemSuppReapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSuppReapActionPerformed
        suppArt = new SuppressionRJPanel();
        suppArt.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(suppArt);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemSuppReapActionPerformed

    //Afficher pannel listing articles
    private void itemListingArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListingArticleActionPerformed
        listArt = new ListingArticle();
        listArt.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(listArt);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemListingArticleActionPerformed

    //Afficher pannel recherche reappro
    private void itemRechReapproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechReapproActionPerformed
        rechReap = new RechReapproJPanel();
        rechReap.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(rechReap);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemRechReapproActionPerformed

    //Afficher pannel recherche cat�gorie
    private void itemRechCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechCategorieActionPerformed
        rechCat = new RechercheCategorie();
        rechCat.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(rechCat);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemRechCategorieActionPerformed

    //Afficher pannel recherhce fournisseur
    private void itemRechFournActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechFournActionPerformed
        rechFourn = new RechercheFournisseur();
        rechFourn.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(rechFourn);
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_itemRechFournActionPerformed

    /**
     * MAIN
     *
     * @param args argument fonction main
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAjoutReappro;
    private javax.swing.JMenuItem itemArticleAjout;
    private javax.swing.JMenuItem itemListReappro;
    private javax.swing.JMenuItem itemListingArticle;
    private javax.swing.JMenuItem itemMenuAccueil;
    private javax.swing.JMenuItem itemModifAjout;
    private javax.swing.JMenuItem itemQuitter;
    private javax.swing.JMenuItem itemRechCategorie;
    private javax.swing.JMenuItem itemRechFourn;
    private javax.swing.JMenuItem itemRechReappro;
    private javax.swing.JMenuItem itemSuppReap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu menuAjout;
    private javax.swing.JMenu menuApplication;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuListing;
    private javax.swing.JMenu menuModifier;
    private javax.swing.JMenu menuRecherche;
    private javax.swing.JMenu menuSupprimer;
    // End of variables declaration//GEN-END:variables
}
