package packageBusiness;

import javax.swing.JComboBox;
import packageDataAccess.ReapproDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;


public class ReapproManager {
    
    private ReapproDBAccess rDBA = new ReapproDBAccess();
    
    public JComboBox getLibArticle(String typeA) throws  BdErreur, NoIdentification{ 
            return rDBA.getLibArticle(typeA);
    }
}
