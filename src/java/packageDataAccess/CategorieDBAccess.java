package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageInterface.CategorieInterface;
import packageModel.Categorie;

public class CategorieDBAccess implements CategorieInterface {

    /**
     * Liste des libelles categorie
     *
     * @return une ArrayList des categorie de la BD
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Categorie
     */
    @Override
    public ArrayList<Categorie> getCatArticle() throws BdErreur, NoIdentification {

        ArrayList<Categorie> tabCatDB = new ArrayList<Categorie>();

        try {
            //Select des libelles
            String req = "select Libelle from Categorie";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            ResultSet donnees = prepStat.executeQuery();
            //Recuperation des donnees
            while (donnees.next()) {
                Categorie cat = new Categorie(donnees.getString("Libelle"));
                tabCatDB.add(cat);
            }
        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }

        return tabCatDB;
    }

    /**
     * Obtenir id d'une categorie
     *
     * @param libelle libelle article souhaite
     * @return id categorie a partir du libelle
     * @throws BdErreur
     * @throws NoIdentification
     * @see String
     * @see Integer
     */
    @Override
    public Integer getIDCat(String libelle) throws BdErreur, NoIdentification {

        Integer iDCat = 0;

        try {
            //Select de id categorie
            String req = "select IDCategorie from Categorie where Libelle = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1, libelle);
            ResultSet donnees = prepStat.executeQuery();
            
            //Recuperation des donnees
            while (donnees.next()) {
                iDCat = donnees.getInt("IDCategorie");
            }

        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return iDCat;
    }
}
