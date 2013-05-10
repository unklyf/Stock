/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;

//import packageDataAccess.ModifArtDBAccess;
import java.util.ArrayList;
import packageDataAccess.ModifArtDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;

/**
 *
 * @author Home
 */
public class ModifArtManager {
    
    private ModifArtDBAccess mADBA = new ModifArtDBAccess();
    
    public ArrayList<Article> getAllArticle ()throws  BdErreur, NoIdentification{
        return mADBA.getAllArticle();
    }
    
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification{
         mADBA.modifArticle(artNouvVersion, artAncVersion);
    }
   
    
   
}
