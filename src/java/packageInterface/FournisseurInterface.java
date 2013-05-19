package packageInterface;

import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;


public interface FournisseurInterface {

    /**
     * Liste de libelle de fournisseurs
     * @return une ArrayList de fournisseur
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Fournisseur
     */
    public ArrayList <Fournisseur> getFournisseur() throws  BdErreur, NoIdentification;
    
    
    /**
     *
     * @param nom
     * @return id du fournisseur suivant son nom
     * @throws BdErreur
     * @throws NoIdentification
     * @see Integer
     * @see String
     */
    public Integer getIDFourn(String nom) throws  BdErreur, NoIdentification;
    
    
    
    
}
