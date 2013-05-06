package packageView;

import java.awt.Rectangle;


public class MainJFrame extends javax.swing.JFrame {

    private AccueilPanel aP;
    private InsertArticle insArt;
    private InsertReappro reapAdd;
            
    public MainJFrame() {
        initComponents();
        this.itemMenuAccueil.doClick(); 
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);          
    }

   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        itemSuppArticle = new javax.swing.JMenuItem();
        itemSuppReappro = new javax.swing.JMenuItem();
        menuListing = new javax.swing.JMenu();
        itemListArticle = new javax.swing.JMenuItem();
        itemListReappro = new javax.swing.JMenuItem();
        menuRecherche = new javax.swing.JMenu();
        itemRechFourn = new javax.swing.JMenuItem();
        itemRechCat = new javax.swing.JMenuItem();
        itemRechReappro = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion Stock Brasserie");

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
        menuModifier.add(itemModifAjout);

        menuBar.add(menuModifier);

        menuSupprimer.setText("Supprimer |");

        itemSuppArticle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        itemSuppArticle.setText("Article");
        menuSupprimer.add(itemSuppArticle);

        itemSuppReappro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        itemSuppReappro.setText("Commande fournisseur");
        menuSupprimer.add(itemSuppReappro);

        menuBar.add(menuSupprimer);

        menuListing.setText("Listing |");

        itemListArticle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itemListArticle.setText("Article");
        menuListing.add(itemListArticle);

        itemListReappro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemListReappro.setText("Commande fournisseur");
        menuListing.add(itemListReappro);

        menuBar.add(menuListing);

        menuRecherche.setText("Recherche");

        itemRechFourn.setText("Fournisseur");
        menuRecherche.add(itemRechFourn);

        itemRechCat.setText("Catégorie");
        menuRecherche.add(itemRechCat);

        itemRechReappro.setText("Réapprovisionnement");
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

    private void itemQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuitterActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_itemQuitterActionPerformed

    private void itemArticleAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemArticleAjoutActionPerformed
        insArt=new InsertArticle();
        insArt.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(insArt);
        this.getContentPane().validate(); 
        this.getContentPane().repaint(); 
    }//GEN-LAST:event_itemArticleAjoutActionPerformed

    private void itemAjoutReapproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAjoutReapproActionPerformed
        reapAdd=new InsertReappro();
        reapAdd.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(reapAdd);
        this.getContentPane().validate(); 
        this.getContentPane().repaint();        
    }//GEN-LAST:event_itemAjoutReapproActionPerformed

    private void itemMenuAccueilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAccueilActionPerformed
        aP = new AccueilPanel();
        aP.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(aP);
        this.getContentPane().validate(); 
        this.getContentPane().repaint(); 
    }//GEN-LAST:event_itemMenuAccueilActionPerformed
       
    
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
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    
    public Rectangle getContentPaneBounds() {                                            
        return this.getContentPane().getBounds(); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAjoutReappro;
    private javax.swing.JMenuItem itemArticleAjout;
    private javax.swing.JMenuItem itemListArticle;
    private javax.swing.JMenuItem itemListReappro;
    private javax.swing.JMenuItem itemMenuAccueil;
    private javax.swing.JMenuItem itemModifAjout;
    private javax.swing.JMenuItem itemQuitter;
    private javax.swing.JMenuItem itemRechCat;
    private javax.swing.JMenuItem itemRechFourn;
    private javax.swing.JMenuItem itemRechReappro;
    private javax.swing.JMenuItem itemSuppArticle;
    private javax.swing.JMenuItem itemSuppReappro;
    private javax.swing.JMenu menuAjout;
    private javax.swing.JMenu menuApplication;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuListing;
    private javax.swing.JMenu menuModifier;
    private javax.swing.JMenu menuRecherche;
    private javax.swing.JMenu menuSupprimer;
    // End of variables declaration//GEN-END:variables
}
