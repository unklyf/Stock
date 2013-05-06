package packageController;
import java.util.ArrayList;
import packageBusiness.*;
import packageException.*;
import packageModel.Article;
import packageModel.Reappro;

public class ApplicationController {
    
    
    private LoginManager lM= new LoginManager();
    private ReapproManager rM= new ReapproManager();
    private InsertArtManager iAM = new InsertArtManager();
    
    
    //IDENTIFICATION
    public void identification(String user, String pw) throws IdentificationErreur{
        lM.identification(user, pw);         
    }
    
    
    //AJOUT REAPPRO
    public ArrayList <String> getLibArticle(String typeA) throws  BdErreur, NoIdentification{ 
        return rM.getLibArticle(typeA);
    }
    
     public ArrayList <String> getLibArticle(String typeA,String rech) throws  BdErreur, NoIdentification{ 
        return rM.getLibArticle(typeA,rech);
    }
    
    public String getDescArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
        return rM.getDescArticle(libelle, typeA);
    }
    public Integer getIDArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
        return rM.getIDArticle(libelle, typeA);
    }
    
    public  void  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,Exception{
        rM.addReappro(reappro);
    }
    
    public ArrayList <String> getNomFourn()throws  BdErreur, NoIdentification{
        return rM.getLibFourn();
    }

    
    // AJOUT ARTICLE
    public void  addArticle (Article nouvArt) throws BdErreur,NoIdentification{
        iAM.addArticle(nouvArt);
    }
    
    public ArrayList <String> getFournArticle()throws  BdErreur, NoIdentification{
        return iAM.getFournArticle();
    }
    public ArrayList <String> getCatArticle()throws  BdErreur, NoIdentification{
        return iAM.getCatArticle();
    }
    public Integer rechIDFourn(String libelle) throws  BdErreur, NoIdentification{
        return iAM.rechIDFourn(libelle);
    }
    public Integer rechIDCat(String libelle) throws  BdErreur, NoIdentification{
        return iAM.rechIDCat(libelle);
    }

    
            
    
    
    
    
}
