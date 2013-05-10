package packageView;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import packageModel.Article;





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
        columnNames.add("Categorie");
       
    }


    @Override
    public int getColumnCount() {
        return columnNames.size();
    }
    
    @Override
    public int getRowCount() {
        return contents.size();
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Article art= contents.get(row);
        
        switch(column){ 
            case 0: return art.getLibelle();
            case 1: return art.getType();
            case 2: return art.getDescription();
            case 3: return art.getPrixM();
            case 4: if (art.getPrixC()!= 0){
                            return art.getPrixC();
                    }
                    else{
                            return null;
                    }
            case 5: if(art.getCadeau()!= null){
                            return art.getCadeau();
                    }
                    else {
                            return null;
                    }
            
            case 6: return art.getFourn().getNom();  
            case 7: return art.getCat().getNom();
            default: return null;
        }
      }
   

    @Override
      public Class getColumnClass (int col){
            
            Class c; 
            
            switch(col){ 
            case 0: c = String.class;
                break;
            case 1: c = String.class;
                break;
            case 2: c = String.class;
                break;
            case 3: c = Double.class;
                break;
            case 4: c = Double.class;
                break;
            case 5: c = String.class;
                break;
            case 6: c = String.class;
                break;
            case 7: c = String.class;
                break;
            default: c = String.class;
          
        }
            
       return c;
   }
}
    


   