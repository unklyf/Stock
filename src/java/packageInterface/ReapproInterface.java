package packageInterface;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageException.AddReapException;
import packageException.EncodageReapproException;
import packageModel.Fournisseur;
import packageModel.LigneReappro;
import packageModel.Reappro;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public interface ReapproInterface {

    /**
     * Ajout d'un reappro
     *
     * @param reappro le reapprovisionnement a ajouter
     * @return id du reappro ajoute pour ajouter Lignereappro apres
     * @throws BdErreur
     * @throws NoIdentification
     * @throws AddReapException
     * @see Integer
     * @see Reappro
     */
    public Integer addReappro(Reappro reappro) throws BdErreur, NoIdentification, AddReapException;

    /**
     * Ajout LigneReappro
     *
     * @param lReap le LigneReappro a ajouter
     * @param iDReap id du reappro correspondant
     * @throws BdErreur
     * @throws NoIdentification
     * @throws AddReapException
     * @see LigneReappro
     * @see Integer
     */
    public void addLigneReappro(LigneReappro lReap, Integer iDReap) throws BdErreur, NoIdentification, AddReapException;

    /**
     * Tous les reappros pour une table
     *
     * @return une ArrayList contenant tous les reapprovisionnements effectues
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Reappro
     */
    public ArrayList<Reappro> getAllReappro() throws BdErreur, NoIdentification;

    /**
     * Tous les LigneReappro pour une table
     *
     * @param iDR id du reapprovisionnement selectionnee dans la table
     * @return une ArrayList contenant les LignesReappro correspondant
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Integer
     * @see LigneReappro
     */
    public ArrayList<LigneReappro> getAllLigneReappro(Integer iDR) throws BdErreur, NoIdentification;

    /**
     * Encoder la marchandise recue dans le stock - mise a jour quantite
     *
     * @param reap le Reappro qui va etre encoder dans le stock
     * @param lReap la LigneReappro dans lequel la quantite va etre mise a jour
     * @throws BdErreur
     * @throws NoIdentification
     * @throws EncodageReapproException
     * @see LigneReappro
     * @see Reappro
     */
    public void setQteStock(Reappro reap, LigneReappro lReap) throws BdErreur, NoIdentification,EncodageReapproException;

    /**
     * Supprimer un reappro
     *
     * @param idP id du reapprovisionnement a supprimer
     * @throws BdErreur
     * @throws NoIdentification
     * @see Integer
     */
    public void suppReappro(Integer idP) throws BdErreur, NoIdentification;

    /**
     * Tous les reappro a une date pour un fournisseur
     *
     * @param dateR la date a laquelle on veut consulter les
     * reapprovisionnements
     * @param fourn le fournisseur pour lequel on on veut consulter les
     * reapprovisionnements
     * @return une ArrayList des reapprovisionnements
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Reappro
     * @see GregorianCalendar
     * @see Fournisseur
     */
    public ArrayList<Reappro> getRechReappro(GregorianCalendar dateR, Fournisseur fourn) throws BdErreur, NoIdentification;
}
