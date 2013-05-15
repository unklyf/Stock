package packageController;
import java.util.ArrayList;
import packageBusiness.*;
import packageException.*;
import packageModel.*;

public class ApplicationController {
    
    
    private LoginManager lM= new LoginManager();
    private ReapproManager rM= new ReapproManager();
    private ArticleManager aM = new ArticleManager();
    private FournisseurManager fM = new FournisseurManager();
    private CategorieManager cM = new CategorieManager();
   
    
    
    //IDENTIFICATION
    public void identification(String user, String pw) throws IdentificationErreur{
        lM.identification(user, pw);         
    }
    
    
    
    //AJOUT REAPPRO

    public ArrayList <Article> getArticleReappro(Article art,Reappro reap) throws  BdErreur, NoIdentification{ 
        return aM.getArticleReappro(art,reap);
    }
     
    public Integer getIDArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
        return aM.getIDArticle(libelle, typeA);
    }
    
    public  Integer  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,Exception{
        return rM.addReappro(reappro);
    }
    
    public  void  addLigneReappro (LigneReappro lReap, Integer iDReap)  throws  BdErreur,NoIdentification,Exception{
        rM.addLigneReappro(lReap,iDReap);
    }
    
    
    //LISTING REAPPRO
    public ArrayList<Reappro> getAllReappro ()throws  BdErreur, NoIdentification{
        return rM.getAllReappro();
    }
    
    public ArrayList<LigneReappro> getAllLigneReappro (Integer iDR)throws  BdErreur, NoIdentification{
        return rM.getAllLigneReappro(iDR);
    }
    
    public void setQteStock (Reappro reap, LigneReappro lReap)throws  BdErreur, NoIdentification{
        rM.setQteStock(reap, lReap);
    }
       
    // AJOUT ARTICLE
    public void  addArticle (Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur,NoIdentification{
        aM.addArticle(nouvArt,fourn, cat);
    }

    public ArrayList <Categorie> getCatArticle()throws  BdErreur, NoIdentification{
        return cM.getCatArticle();
    }
    public Integer getIDFourn(String nom) throws  BdErreur, NoIdentification{
        return fM.getIDFourn(nom);
    }
    public Integer getIDCat(String libelle) throws  BdErreur, NoIdentification{ 
            return cM.getIDCat(libelle);
    }
    
   
    
    
    //Modif article
    public ArrayList<Article> getAllArticle ()throws  BdErreur, NoIdentification{
        return aM.getAllArticle();
    }
    
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification{
         aM.modifArticle(artNouvVersion, artAncVersion);
    }
    
    
    
    // Suppression réappro
    public void suppReappro(Integer idP) throws BdErreur, NoIdentification{
        rM.suppReappro(idP);
    }
    
    
    //Recherches
    public ArrayList <Fournisseur> getFournisseur()throws  BdErreur, NoIdentification{
        return fM.getFournisseur();
    }
    public ArrayList <Article> getArticleCat(String typeArt,Categorie cat) throws  BdErreur, NoIdentification{
        return aM.getArticleCat(typeArt,cat);
    }
    public ArrayList<Article> getAllArticleRech (String typeArt, Categorie cat)throws  BdErreur, NoIdentification{
        return aM.getAllArticleRech(typeArt, cat);
    }
    

    
    
  

    
            
    
    
    
    
}
