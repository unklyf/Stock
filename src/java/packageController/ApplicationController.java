package packageController;
import java.util.ArrayList;
import packageBusiness.*;
import packageException.*;
import packageModel.*;

public class ApplicationController {
    
    
    private LoginManager lM= new LoginManager();
    private InsertReapproManager rM= new InsertReapproManager();
    private InsertArtManager iAM = new InsertArtManager();
    private ModifArtManager mAM = new ModifArtManager();
    private ListingReapproManager lrm = new ListingReapproManager();
    private SuppressionManager sAM =new SuppressionManager();
    private RechercheManager rechM =new RechercheManager();
    
    
    //IDENTIFICATION
    public void identification(String user, String pw) throws IdentificationErreur{
        lM.identification(user, pw);         
    }
    
    
    
    //AJOUT REAPPRO
    public ArrayList <Fournisseur> getFournReappro()throws  BdErreur, NoIdentification{
        return rM.getFournReappro();
    }
    
    public ArrayList <Article> getArticleReappro(Article art,Reappro reap) throws  BdErreur, NoIdentification{ 
        return rM.getArticleReappro(art,reap);
    }
     
    public Integer getIDArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
        return rM.getIDArticle(libelle, typeA);
    }
    
    public  Integer  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,Exception{
        return rM.addReappro(reappro);
    }
    
    public  void  addLigneReappro (LigneReappro lReap, Integer iDReap)  throws  BdErreur,NoIdentification,Exception{
        rM.addLigneReappro(lReap,iDReap);
    }
    
    
    //LISTING REAPPRO
    public ArrayList<Reappro> getAllReappro ()throws  BdErreur, NoIdentification{
        return lrm.getAllReappro();
    }
    
    public ArrayList<LigneReappro> getAllLigneReappro (Integer iDR)throws  BdErreur, NoIdentification{
        return lrm.getAllLigneReappro(iDR);
    }
    
    public void setQteStock (Reappro reap, LigneReappro lReap)throws  BdErreur, NoIdentification{
        lrm.setQteStock(reap, lReap);
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
    
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification{
         mAM.modifArticle(artNouvVersion, artAncVersion);
    }
    
    
    
    // Suppression r�appro
    public void suppArticle(Integer idP) throws BdErreur, NoIdentification{
        sAM.suppArticle(idP);
    }
    
    
    //Recherches
    public ArrayList <Fournisseur> getFournisseur()throws  BdErreur, NoIdentification{
        return rechM.getFournisseur();
    }
    public ArrayList <Article> getArticleCat(String typeArt,Categorie cat) throws  BdErreur, NoIdentification{
        return rechM.getArticleCat(typeArt,cat);
    }
    
    
    

    
    
  

    
            
    
    
    
    
}
