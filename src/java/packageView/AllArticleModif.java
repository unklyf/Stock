/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageView;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.LigneReappro;

/**
 *
 * @author Home
 */
public class AllArticleModif extends AbstractTableModel {
    
    private ArrayList<String> columnNames = new ArrayList<String>( );
    private ArrayList<Article> contents = new ArrayList<Article>( );
    
    public AllArticleModif (ArrayList<Article> modifArt){
        contents = modifArt;
        columnNames.add("Libelle");
        columnNames.add("Type");
        columnNames.add("Description");
        columnNames.add("Prix Marchandise");
        columnNames.add("Prix Consigne");
        columnNames.add("Cadeau");
        columnNames.add("Fournisseur");
        columnNames.add("Catégorie");
       
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }
    
    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Article art= contents.get(row);
        String fourn="", cat="";
        
        try {
            fourn = new ApplicationController().rechNomFourn(art.getIDFourn());
            cat= new ApplicationController().rechNomCat(art.getIDCat());
            
        }
        catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
        
        catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        
        }
        
        switch(column){ 
            case 0: return fourn;
            case 1: return cat;          
            default: return null;
    }
   
   }
}


   /* public Object getValueAt(int row, int col){
        LigneReappro reap = contents.get(row);
        String libelle="", type="";
        
        
        try {
            libelle= new ApplicationController().getRechLibArt(reap.getIDProd());
            type= new ApplicationController().getRechTypeArt(reap.getIDProd());
        }  
        
        catch(BdErreur e){
                JOptionPane.showMessageDialog(null, e, "Erreur BD", JOptionPane.ERROR_MESSAGE);
        }
        
        catch(NoIdentification e){
                JOptionPane.showMessageDialog(null, e, "Erreur identification", JOptionPane.ERROR_MESSAGE);
        
        }
        
        switch(col){ 
            case 0: return libelle;
            case 1: return type;
            case 2: return reap.getQte();          
            default: return null;
        }
    
    }
    


    public Class getColumnClass (int col){

        Class c;

        switch (col){
            case 0: c = String.class;  
            break;
            case 1: c = String.class;
            break;
            case 2: c = Integer.class;
            break;
            default: c = String.class;
        }
        return c;
    }
*/