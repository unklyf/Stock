package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.CategorieDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Categorie;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
*/
public class CategorieManager {

    private CategorieDBAccess cDBA = new CategorieDBAccess();

    /**
     * Liste des libelles categorie
     * 
     * @return une ArrayList des categorie de la BD
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Categorie
     */
    public ArrayList<Categorie> getCatArticle() throws BdErreur, NoIdentification {
        return cDBA.getCatArticle();
    }
}
