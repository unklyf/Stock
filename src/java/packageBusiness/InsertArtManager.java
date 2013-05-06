/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.InsertArtDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;


public class InsertArtManager {
    
    private InsertArtDBAccess iAMDB = new InsertArtDBAccess();
    
    public void  addArticle (Article nouvArt) throws BdErreur,NoIdentification{
        iAMDB.addArticle(nouvArt);
    }
    
    public ArrayList <String> getFournArticle() throws  BdErreur, NoIdentification{
        return iAMDB.getFournArticle();
    }
    
    public ArrayList <String> getCatArticle() throws  BdErreur, NoIdentification{
        return iAMDB.getCatArticle();
    }
    
    public Integer rechIDFourn(String libelle) throws  BdErreur, NoIdentification{
        return iAMDB.rechIDFourn(libelle);
    }
    
    public Integer rechIDCat(String libelle) throws  BdErreur, NoIdentification{
        return iAMDB.rechIDCat(libelle);
    }
}
