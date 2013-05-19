package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.FournisseurDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class FournisseurManager {

    private FournisseurDBAccess fDBA = new FournisseurDBAccess();

    /**
     * Liste de libelle de fournisseurs
     * 
     * @return une ArrayList de fournisseur
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Fournisseur
     */
    public ArrayList<Fournisseur> getFournisseur() throws BdErreur, NoIdentification {
        return fDBA.getFournisseur();
    }
}
