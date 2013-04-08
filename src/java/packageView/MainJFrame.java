package packageView;



public class MainJFrame extends javax.swing.JFrame {

    
    public MainJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuApplication = new javax.swing.JMenu();
        accueilMenuItem = new javax.swing.JMenuItem();
        itemQuitter = new javax.swing.JMenuItem();
        menuAjout = new javax.swing.JMenu();
        itemArticleAjout = new javax.swing.JMenuItem();
        itemAjoutReappro = new javax.swing.JMenuItem();
        menuModifier = new javax.swing.JMenu();
        itemModifAjout = new javax.swing.JMenuItem();
        itemModifReappro = new javax.swing.JMenuItem();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        jLabel1.setText("BIENVENUE");

        jLabel2.setFont(new java.awt.Font("Tekton Pro", 0, 36)); // NOI18N
        jLabel2.setText("Brasserie - Gestion Stock");

        menuApplication.setText("Application |");

        accueilMenuItem.setText("Accueil");
        menuApplication.add(accueilMenuItem);

        itemQuitter.setText("Quitter");
        itemQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuitterActionPerformed(evt);
            }
        });
        menuApplication.add(itemQuitter);

        menuBar.add(menuApplication);

        menuAjout.setText("Nouvel Ajout |");

        itemArticleAjout.setText("Article");
        itemArticleAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemArticleAjoutActionPerformed(evt);
            }
        });
        menuAjout.add(itemArticleAjout);

        itemAjoutReappro.setText("Réapprovisionnement");
        itemAjoutReappro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAjoutReapproActionPerformed(evt);
            }
        });
        menuAjout.add(itemAjoutReappro);

        menuBar.add(menuAjout);

        menuModifier.setText("Modifier |");

        itemModifAjout.setText("Article");
        menuModifier.add(itemModifAjout);

        itemModifReappro.setText("Réapprovisionnement");
        menuModifier.add(itemModifReappro);

        menuBar.add(menuModifier);

        menuSupprimer.setText("Supprimer |");

        itemSuppArticle.setText("Article");
        menuSupprimer.add(itemSuppArticle);

        itemSuppReappro.setText("Réapprovisionnement");
        menuSupprimer.add(itemSuppReappro);

        menuBar.add(menuSupprimer);

        menuListing.setText("Listing |");

        itemListArticle.setText("Article");
        menuListing.add(itemListArticle);

        itemListReappro.setText("Réapprovisionnement");
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
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(527, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuitterActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_itemQuitterActionPerformed

    private void itemArticleAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemArticleAjoutActionPerformed
        InsertArticle insArt=new InsertArticle();
        insArt.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(insArt);
        this.getContentPane().validate(); 
        this.getContentPane().repaint(); 
    }//GEN-LAST:event_itemArticleAjoutActionPerformed

    private void itemAjoutReapproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAjoutReapproActionPerformed
        ReapproJPanel reapAdd=new ReapproJPanel();
        reapAdd.setBounds(this.getBounds());
        this.getContentPane().removeAll();
        this.getContentPane().add(reapAdd);
        this.getContentPane().validate(); 
        this.getContentPane().repaint();        
    }//GEN-LAST:event_itemAjoutReapproActionPerformed
   
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem accueilMenuItem;
    private javax.swing.JMenuItem itemAjoutReappro;
    private javax.swing.JMenuItem itemArticleAjout;
    private javax.swing.JMenuItem itemListArticle;
    private javax.swing.JMenuItem itemListReappro;
    private javax.swing.JMenuItem itemModifAjout;
    private javax.swing.JMenuItem itemModifReappro;
    private javax.swing.JMenuItem itemQuitter;
    private javax.swing.JMenuItem itemRechCat;
    private javax.swing.JMenuItem itemRechFourn;
    private javax.swing.JMenuItem itemRechReappro;
    private javax.swing.JMenuItem itemSuppArticle;
    private javax.swing.JMenuItem itemSuppReappro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu menuAjout;
    private javax.swing.JMenu menuApplication;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuListing;
    private javax.swing.JMenu menuModifier;
    private javax.swing.JMenu menuRecherche;
    private javax.swing.JMenu menuSupprimer;
    // End of variables declaration//GEN-END:variables
}
