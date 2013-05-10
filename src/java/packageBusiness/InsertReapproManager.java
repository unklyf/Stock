package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.InsertReapproDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.*;


public class InsertReapproManager {
    
    private InsertReapproDBAccess rDBA = new InsertReapproDBAccess();
    
    
    //AJOUT REAPPRO
    public ArrayList <Fournisseur> getFournReappro()throws  BdErreur, NoIdentification{
        return rDBA.getFournReappro();
    }
     
    public ArrayList <Article> getArticleReappro(Article art, Reappro reap) throws  BdErreur, NoIdentification{ 
            return rDBA.getArticleReappro(art, reap);
    }  
    
    public Integer getIDArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
            return rDBA.getIDArticle(libelle,typeA);
    }
           
    public  Integer  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,Exception{
        return rDBA.addReappro(reappro);
    }
    
    public  void  addLigneReappro (LigneReappro lReap, Integer iDReap)  throws  BdErreur,NoIdentification,Exception{
       rDBA .addLigneReappro(lReap,iDReap);
    }
    
    
    
}
