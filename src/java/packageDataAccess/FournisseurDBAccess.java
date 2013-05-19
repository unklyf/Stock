package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageInterface.FournisseurInterface;
import packageModel.Fournisseur;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class FournisseurDBAccess implements FournisseurInterface {

    /**
     * Liste de libelle de fournisseurs
     * 
     * @return une ArrayList de fournisseur
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Fournisseur
     */
    @Override
    public ArrayList<Fournisseur> getFournisseur() throws BdErreur, NoIdentification {

        ArrayList<Fournisseur> listeNomF = new ArrayList<Fournisseur>();

        try {
            //Select nom des fournisseurs
            String req = "select Nom from Fournisseur";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            ResultSet donnees = prepStat.executeQuery();
            
            //Recuperation des donnees
            while (donnees.next()) {
                Fournisseur fourn = new Fournisseur(donnees.getString("Nom"));
                listeNomF.add(fourn);
            }
        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeNomF;
    }

    /**
     * Obtenir id d'un fournisseur
     *
     * @param nom
     * @return id du fournisseur suivant son nom
     * @throws BdErreur
     * @throws NoIdentification
     * @see Integer
     * @see String
     */
    @Override
    public Integer getIDFourn(String nom) throws BdErreur, NoIdentification {

        Integer iDFourn = 0;

        try {
            //Select id du fournisseur
            String req = "select IDFournisseur from Fournisseur where Nom = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1, nom);
            ResultSet donnees = prepStat.executeQuery();
            
            //Recuperation des donnees
            while (donnees.next()) {
                iDFourn = donnees.getInt("IDFournisseur");
            }
        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return iDFourn;
    }
}
