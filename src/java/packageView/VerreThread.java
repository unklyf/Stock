package packageView;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class VerreThread extends Thread{
    
    private JLabel label;
    private ArrayList <Image> listeImg;
    
    
    public VerreThread(JLabel l){
        listeImg = new ArrayList <Image>();
        label= l;
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b0.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b1.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b2.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b3.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b4.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b6.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b7.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b8.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b9.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b10.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b11.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b12.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b13.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b14.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b15.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b16.png")).getImage());
        listeImg.add(new ImageIcon(getClass().getResource("/packageImage/b17.png")).getImage());
       
    }
    
    
    public void run (){ 
        int i;
        while (true){             
            try{ 
                label.setIcon(new ImageIcon(listeImg.get(0)));
                Thread.sleep(2000);
                for(i=0;i< listeImg.size();i++){                    
                    label.setIcon(new ImageIcon(listeImg.get(i)));
                    Thread.sleep(100);
                }
                label.setIcon(new ImageIcon(listeImg.get(16)));
                Thread.sleep(3000);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, e, "Erreur dans le thread", JOptionPane.ERROR_MESSAGE);
            }
        
       } 
    }
      
    
}

