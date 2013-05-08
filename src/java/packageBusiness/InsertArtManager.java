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
import packageModel.Categorie;
import packageModel.Fournisseur;


public class InsertArtManager {
    
    private InsertArtDBAccess iAMDB = new InsertArtDBAccess();
    
    public void  addArticle (Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur,NoIdentification{
        iAMDB.addArticle(nouvArt, fourn, cat);
    }
    
    public ArrayList <String> getFournArticle() throws  BdErreur, NoIdentification{
        return iAMDB.getFournArticle();
    }
    
    public ArrayList <String> getCatArticle() throws  BdErreur, NoIdentification{
        return iAMDB.getCatArticle();
    }
    
    
    
    
}
