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
    
    // AJOUT ARTICLE
    public void  addArticle (Article nouvArt) throws BdErreur,NoIdentification{
        iAM.addArticle(nouvArt);
    }
    
    public ArrayList <String> getFournArticle()throws  BdErreur, NoIdentification{
        return iAM.getFournArticle();
    }

    
            
    
    
    
    
}
