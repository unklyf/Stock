package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.InsertReapproDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.*;


public class InsertReapproManager {
    
    private InsertReapproDBAccess rDBA = new InsertReapproDBAccess();
    
    
    //AJOUT REAPPRO
    public ArrayList <String> getLibArticle(String typeA, String nomF) throws  BdErreur, NoIdentification{ 
            return rDBA.getLibArticle(typeA, nomF);
    }  
    
    public String getDescArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
            return rDBA.getDescArticle(libelle,typeA);
    }
    
    public Integer getIDArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
            return rDBA.getIDArticle(libelle,typeA);
    }
        
    public ArrayList <String> getLibFourn()throws  BdErreur, NoIdentification{
        return rDBA.getNomFourn();
    }
    
    public String getRechLibArt(Integer iDArt) throws  BdErreur,NoIdentification{
        return rDBA.getRechLibArt(iDArt);
    }
    
    public String getRechTypeArt(Integer iDArt) throws  BdErreur,NoIdentification{
        return rDBA.getRechTypeArt(iDArt);
    }
    
    public  Integer  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,Exception{
        return rDBA.addReappro(reappro);
    }
    
    public  void  addLigneReappro (LigneReappro lReap)  throws  BdErreur,NoIdentification,Exception{
       rDBA .addLigneReappro(lReap);
    }
    
    
    
}
