package packageView;


import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import packageModel.Reappro;



public class AllReapproModel extends AbstractTableModel {
    
    private ArrayList<String> columnNames = new ArrayList<String>( );
    private ArrayList<Reappro> contents = new ArrayList<Reappro>( );
   
    
    public AllReapproModel (ArrayList<Reappro> listReap){
        contents = listReap;
        columnNames.add("IDReappro");
        columnNames.add("Date réapprovisionnement");
        columnNames.add("Etat");
        columnNames.add("Note"); 
        columnNames.add("Fournisseur");
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
        Reappro reap= contents.get(row);
        
        switch(column){ 
            case 0: return reap.getiDReappro();
            case 1: return reap.getReapDate().getTime();
            case 2: return reap.getEtat();
            case 3: if (reap.getNote()!= null){
                         return reap.getNote();
                    }
                    else{
                         return null;
                    }
            case 4: return reap.getFourn().getNom();
            default: return null;
        }
      }
   

    @Override
      public Class getColumnClass (int col){
            
            Class c; 
            
            switch(col){ 
            case 0: c = Integer.class;
                break;
            case 1: c = Date.class;
                break;
            case 2: c = String.class;
                break;
            case 3: c = String.class;
                break;
            case 4: c = String.class;
                 break;
            default: c = String.class;
          
        }
            
       return c;
   }
    
}
