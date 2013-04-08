package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.ReapproDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Reappro;


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
    
    public Integer getIDArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
            return rDBA.getIDArticle(libelle,typeA);
    }
    
    public  void  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification{
        rDBA.addReappro(reappro);
    }
    
    
    
}
