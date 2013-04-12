/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;

import packageDataAccess.InsertArtDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;


public class InsertArtManager {
    
    private InsertArtDBAccess iAMDB = new InsertArtDBAccess();
    
    public void  addArticle (Article nouvArt) throws BdErreur,NoIdentification{
        iAMDB.addArticle(nouvArt);
    }
}
