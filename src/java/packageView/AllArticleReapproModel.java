
package packageView;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import packageModel.Article;
import packageModel.LigneReappro;

public class AllArticleReapproModel extends AbstractTableModel{ 
    
    private ArrayList<String> columnNames = new ArrayList<String>( );
    private ArrayList<LigneReappro> contentsR = new ArrayList<LigneReappro>();
    private ArrayList<Article> contentsA = new ArrayList<Article>();
    
    public AllArticleReapproModel (ArrayList<Article> lArt,ArrayList<LigneReappro> lReappro){
        contentsR = lReappro;
        contentsA = lArt;
        columnNames.add("Libelle");
        columnNames.add("Type");
        columnNames.add("Quantité");
    }
    
    
    public int getColumnCount() {
        return columnNames.size();
    }
    
    public int getRowCount() {
        return contentsA.size();
    }
    
    public String getColumnName(int col) {
        return columnNames.get(col);
    }



    public Object getValueAt(int row, int col){
        LigneReappro reap = contentsR.get(row);
        Article art = contentsA.get(row);
        
        switch(col){ 
            case 0: return art.getLibelle();
            case 1: return art.getType();
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
    

