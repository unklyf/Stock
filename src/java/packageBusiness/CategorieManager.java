/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.CategorieDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;

/**
 *
 * @author Home
 */
public class CategorieManager {
    
    private CategorieDBAccess cDBA= new CategorieDBAccess();
    
    public ArrayList <Categorie> getCatArticle() throws  BdErreur, NoIdentification{
        return cDBA.getCatArticle();
    }
     public Integer getIDCat(String libelle) throws  BdErreur, NoIdentification{ 
            return cDBA.getIDCat(libelle);
    }
    
}
