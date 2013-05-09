
package packageView;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import packageController.ApplicationController;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.LigneReappro;

public class AllArticleReapproModel extends AbstractTableModel{ 
    
    private ArrayList<String> columnNames = new ArrayList<String>( );
    private ArrayList<LigneReappro> contents = new ArrayList<LigneReappro>( );
    
    public AllArticleReapproModel (ArrayList<LigneReappro> lReappro){
        contents = lReappro;
        columnNames.add("Libelle");
        columnNames.add("Type");
        columnNames.add("Quantité");
    }
    
    
    public int getColumnCount() {
        return columnNames.size();
    }
    
    public int getRowCount() {
        return contents.size();
    }
    
    public String getColumnName(int col) {
        return columnNames.get(col);
    }



    public Object getValueAt(int row, int col){
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
}
    

