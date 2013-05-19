package packageInterface;

import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Categorie;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public interface CategorieInterface {
    
    /**
     * Liste des libelles categorie
     *
     * @return une ArrayList des categorie de la BD
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Categorie
     */
    public ArrayList<Categorie> getCatArticle() throws BdErreur, NoIdentification;

    /**
     * Obtenir id d'une categorie
     *
     * @param libelle libelle article souhaite
     * @return id article a partir du libelle
     * @throws BdErreur
     * @throws NoIdentification
     * @see String
     * @see Integer
     */
    public Integer getIDCat(String libelle) throws BdErreur, NoIdentification;
}
