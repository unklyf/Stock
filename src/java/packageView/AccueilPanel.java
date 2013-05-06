
package packageView;


public class AccueilPanel extends javax.swing.JPanel {

    public AccueilPanel() {
        initComponents();
    }

    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titreWelcome = new javax.swing.JLabel();
        titreProg = new javax.swing.JLabel();

        titreWelcome.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        titreWelcome.setText("BIENVENUE");

        titreProg.setFont(new java.awt.Font("Tekton Pro", 0, 36)); // NOI18N
        titreProg.setText("Brasserie - Gestion Stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titreProg)
                    .addComponent(titreWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titreWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titreProg)
                .addContainerGap(287, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel titreProg;
    private javax.swing.JLabel titreWelcome;
    // End of variables declaration//GEN-END:variables
}
