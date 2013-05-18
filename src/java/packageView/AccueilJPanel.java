package packageView;

import java.awt.Graphics;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;



public class AccueilJPanel extends javax.swing.JPanel {
    private Image image;
    private VerreThread vT;
        
            
    public AccueilJPanel() {
        initComponents();
        
        //Date du jour
        String format = "'Nous sommes le : 'dd MMMM yyyy";
        SimpleDateFormat formater = new SimpleDateFormat(format ); 
        Date date = new Date();
        labelDateAuj.setText(formater.format(date));
                
        
        //Background
        image=(new ImageIcon(getClass().getResource("/packageImage/bg.jpg"))).getImage();
                
        //Thread    
        vT = new VerreThread(jLabelThread);
        vT.start();
 
     
    }
  
   @Override
   public void paintComponent(Graphics g){
        super.paintComponent(g); 
        g.drawImage (image, 0,0, this); 
   }
 
   
  
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitre = new javax.swing.JLabel();
        labelAut = new javax.swing.JLabel();
        jLabelTitre2 = new javax.swing.JLabel();
        jLabelThread = new javax.swing.JLabel();
        labelDateAuj = new javax.swing.JLabel();

        setLayout(null);

        jLabelTitre.setFont(new java.awt.Font("Prestige Elite Std", 0, 24)); // NOI18N
        jLabelTitre.setText("-Gestion stock de la brasserie-");
        add(jLabelTitre);
        jLabelTitre.setBounds(10, 70, 440, 81);

        labelAut.setFont(new java.awt.Font("Prestige Elite Std", 0, 18)); // NOI18N
        labelAut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packageImage/auteurs.png"))); // NOI18N
        add(labelAut);
        labelAut.setBounds(0, 350, 410, 130);

        jLabelTitre2.setFont(new java.awt.Font("Prestige Elite Std", 1, 80)); // NOI18N
        jLabelTitre2.setText("BIENVENUE");
        add(jLabelTitre2);
        jLabelTitre2.setBounds(10, 30, 440, 81);
        add(jLabelThread);
        jLabelThread.setBounds(510, 40, 260, 460);

        labelDateAuj.setFont(new java.awt.Font("Prestige Elite Std", 0, 18)); // NOI18N
        labelDateAuj.setText("Date Jour");
        add(labelDateAuj);
        labelDateAuj.setBounds(20, 140, 550, 70);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelThread;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JLabel jLabelTitre2;
    private javax.swing.JLabel labelAut;
    private javax.swing.JLabel labelDateAuj;
    // End of variables declaration//GEN-END:variables
}
