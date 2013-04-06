package packageBusiness;

import javax.swing.JComboBox;
import packageDataAccess.ReapproDBAccess;
import packageException.SqlException;
import packageException.NoIdentification;


public class ReapproManager {
    
    private ReapproDBAccess rDBA = new ReapproDBAccess();
    public JComboBox getLibArticle() throws  SqlException, NoIdentification{ 
            return rDBA.getLibArticle();
    }
}
