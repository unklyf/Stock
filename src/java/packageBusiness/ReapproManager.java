package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.ReapproDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;


public class ReapproManager {
    
    private ReapproDBAccess rDBA = new ReapproDBAccess();
    
    public ArrayList <String> getLibArticle(String typeA) throws  BdErreur, NoIdentification{ 
            return rDBA.getLibArticle(typeA);
    }
    
    public ArrayList <String> getLibArticle(String typeA,String rech) throws  BdErreur, NoIdentification{ 
            return rDBA.getLibArticle(typeA,rech);
    }
    public String getDescArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
            return rDBA.getDescArticle(libelle,typeA);
    }
    
    
    
}
