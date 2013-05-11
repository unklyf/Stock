package packageView;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import packageModel.LigneReappro;

public class AllLigneReapproModel extends AbstractTableModel{ 
    
    private ArrayList<String> columnNames = new ArrayList<String>( );
    private ArrayList<LigneReappro> contents = new ArrayList<LigneReappro>();

    
    public AllLigneReapproModel (ArrayList<LigneReappro> lReappro){
        contents = lReappro;
        columnNames.add("Libelle");
        columnNames.add("Type");
        columnNames.add("Quantité");
    }
    
    
    public void setQte(Integer qte,int row){
        contents.get(row).setQte(qte);
    }
    
    public ArrayList<LigneReappro> getContents() {
        return contents;
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
          

        switch(col){ 
            case 0: return reap.getArt().getLibelle();
            case 1: return reap.getArt().getType();
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
    

