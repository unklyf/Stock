/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.ArticleDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;
import packageModel.Reappro;

/**
 *
 * @author Home
 */
public class ArticleManager {
    
    private ArticleDBAccess aDBA= new ArticleDBAccess();
    
     public void  addArticle (Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur,NoIdentification{
        aDBA.addArticle(nouvArt, fourn, cat);
    }
     public ArrayList <Article> getArticleReappro(Article art, Reappro reap) throws  BdErreur, NoIdentification{ 
            return aDBA.getArticleReappro(art, reap);
    }  
     public Integer getIDArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
            return aDBA.getIDArticle(libelle,typeA);
    }
     public ArrayList<Article> getAllArticle ()throws  BdErreur, NoIdentification{
        return aDBA.getAllArticle();
    }
      public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification{
         aDBA.modifArticle(artNouvVersion, artAncVersion);
    }
      
      public ArrayList <Article> getArticleCat(String typeArt,Categorie cat) throws  BdErreur, NoIdentification{
        return aDBA.getArticleCat(typeArt,cat);
    }
      public ArrayList<Article> getAllArticleRechCat (String typeArt, Categorie cat)throws  BdErreur, NoIdentification{
        return aDBA.getAllArticleRechCat(typeArt, cat);
    }
      public ArrayList<Article> getAllArticleRechFourn (Fournisseur fourn)throws  BdErreur, NoIdentification{
        return aDBA.getAllArticleRechFourn(fourn);
    }
    
}
