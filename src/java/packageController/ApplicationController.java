package packageController;
import java.util.ArrayList;
import packageBusiness.*;
import packageException.*;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;
import packageModel.Reappro;

public class ApplicationController {
    
    
    private LoginManager lM= new LoginManager();
    private ReapproManager rM= new ReapproManager();
    private InsertArtManager iAM = new InsertArtManager();
    private ModifArtManager mAM = new ModifArtManager();
    
    
    //IDENTIFICATION
    public void identification(String user, String pw) throws IdentificationErreur{
        lM.identification(user, pw);         
    }
    
    
    //AJOUT REAPPRO
    public ArrayList <String> getLibArticle(String typeA,String fourn) throws  BdErreur, NoIdentification{ 
        return rM.getLibArticle(typeA,fourn);
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
    
    public String getRechLibArt(Integer iDArt) throws  BdErreur,NoIdentification{
        return rM.getRechLibArt(iDArt);
    }
    
    public String getRechTypeArt(Integer iDArt) throws  BdErreur,NoIdentification{
        return rM.getRechTypeArt(iDArt);
    }
    
    
    
    
    
    // AJOUT ARTICLE
    public void  addArticle (Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur,NoIdentification{
        iAM.addArticle(nouvArt,fourn, cat);
    }
    
    public ArrayList <Fournisseur> getFournArticle()throws  BdErreur, NoIdentification{
        return iAM.getFournArticle();
    }
    public ArrayList <Categorie> getCatArticle()throws  BdErreur, NoIdentification{
        return iAM.getCatArticle();
    }
    
    
   
    
    
    //Modif article
    public ArrayList<Article> getAllArticle ()throws  BdErreur, NoIdentification{
        return mAM.getAllArticle();
    }
    

    
    
  

    
            
    
    
    
    
}
