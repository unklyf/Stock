package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import packageException.AddArtException;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageInterface.ArticleInterface;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;
import packageModel.Reappro;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ArticleDBAccess implements ArticleInterface {

    /**
     *
     * @param nouvArt nouvel article qui doit etre ajoute
     * @param fourn fournisseur de l article -foreign key
     * @param cat categorie de l article -foreign key
     * @throws BdErreur
     * @throws NoIdentification
     * @throws AddArtException
     * @see Article
     * @see Fournisseur
     * @see Categorie
     */
    @Override
    public void addArticle(Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur, NoIdentification, AddArtException {

        try {
            //Insert de l article
            String req = "insert into Article "
                    + "(Libelle, "
                    + "TypeA, "
                    + "Description, "
                    + "PrixMarchandise, "
                    + "IDFournisseur, "
                    + "IDCategorie, "
                    + "Cadeau, "
                    + "Qte) "
                    + "values( "
                    + "upper(substr(?,1,1))|| lower(substr(?,2)), ?, ?, ?, ?, ?, ?, NULL)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            prepStat.setString(1, nouvArt.getLibelle());
            prepStat.setString(2, nouvArt.getLibelle());
            prepStat.setString(3, nouvArt.getType());
            prepStat.setString(4, nouvArt.getDescription());
            prepStat.setDouble(5, nouvArt.getPrixM());
            prepStat.setInt(6, new FournisseurDBAccess().getIDFourn(fourn.getNom()));
            prepStat.setInt(7, new CategorieDBAccess().getIDCat(cat.getNom()));
            prepStat.setString(8, nouvArt.getCadeau());
            prepStat.executeUpdate();


            //Obtenir IDProduit venant d etre inserer
            ResultSet rs = prepStat.getGeneratedKeys();

            while (rs.next()) {
                int lastID = rs.getInt(1);
                //Update pour colonne facultative
                if (nouvArt.getPrixC() != 0) {
                    req = "update Article set PrixConsigne = ? where IDProduit= ?";
                    prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                    prepStat.setDouble(1, nouvArt.getPrixC());
                    prepStat.setInt(2, lastID);
                    prepStat.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        } catch (Exception e) {
            throw new AddArtException(e.getMessage());
        }
    }

    /**
     *
     * @return une ArrayList d articles de la BD
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Article
     */
    @Override
    public ArrayList<Article> getAllArticle() throws BdErreur, NoIdentification {

        ArrayList<Article> tabArt;
        tabArt = new ArrayList<Article>();
        String cadeau;
        double prixC;

        try {
            //Select des articles
            String req = "select a.IDProduit, a.Libelle, a.TypeA, a.Description, a.Qte, a.PrixMarchandise, a.PrixConsigne, a.Cadeau, "
                    + "f.Nom, c.Libelle libCat "
                    + "from Article a, Fournisseur f, Categorie c "
                    + "where a.IDFournisseur = f.IDFournisseur AND a.IDCategorie = c.IDCategorie "
                    + "order by a.Libelle";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            ResultSet donnees = prepStat.executeQuery();
            //Recuperation des donnees
            while (donnees.next()) {
                Article art = new Article(donnees.getInt("IDProduit"),
                        donnees.getString("Libelle"),
                        donnees.getString("TypeA"),
                        donnees.getString("Description"),
                        donnees.getInt("Qte"),
                        donnees.getDouble("PrixMarchandise"),
                        new Fournisseur(donnees.getString("Nom")),
                        new Categorie(donnees.getString("LibCat")));


                //Colonnes facultatives
                cadeau = donnees.getString("Cadeau");
                if (donnees.wasNull() == false) {
                    art.setCadeau(cadeau);
                }

                prixC = donnees.getDouble("PrixConsigne");
                if (donnees.wasNull() == false) {
                    art.setPrixC(prixC);
                }

                tabArt.add(art);
            }

        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return tabArt;

    }

    /**
     *
     * @param artNouvVersion le nouvel article avec les nouvelles donnees
     * @param artAncVersion l ancien article avec les vieilles donnees
     * @throws BdErreur
     * @throws NoIdentification
     * @see Article
     */
    @Override
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification {

        try {
            //Update pour la modification
            String req = "update Article  "
                    + "set    Description = ?,"
                    + "       PrixMarchandise = ?, "
                    + "       Cadeau = ? "
                    + "where  IDProduit = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1, artNouvVersion.getDescription());
            prepStat.setDouble(2, artNouvVersion.getPrixM());
            prepStat.setString(3, artNouvVersion.getCadeau());
            prepStat.setInt(4, artNouvVersion.getIdProduit());
            prepStat.executeUpdate();

            //Update du prix consigne uniquement si change
            if (artNouvVersion.getPrixC() == 0 && artAncVersion.getPrixC() != 0) {
                req = "update Article set PrixConsigne = NULL where IDProduit= ?";
                prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                prepStat.setInt(1, artNouvVersion.getIdProduit());
                prepStat.executeUpdate();
            } else {
                if (artNouvVersion.getPrixC() != artAncVersion.getPrixC()) {
                    req = "update Article set PrixConsigne = ? where IDProduit= ?";
                    prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                    prepStat.setDouble(1, artNouvVersion.getPrixC());
                    prepStat.setInt(2, artNouvVersion.getIdProduit());
                    prepStat.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
    }

    /**
     * Completer une comboBox suivant le type et le fournisseur selectionne
     *
     * @param art type de l article souhaite
     * @param reap fournisseur deja selectionne dans le reappro
     * @return une ArrayList d article suivant le type et le fournisseur
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Article
     * @see Reappro
     */
    @Override
    public ArrayList<Article> getArticleReappro(Article artC, Reappro reap) throws BdErreur, NoIdentification {

        ArrayList<Article> listeLibA = new ArrayList<Article>();
        double prixC;
        
        try {
            //Select des articles
            String req = "select a.Libelle, a.Description, a.TypeA, a.PrixMarchandise, a.PrixConsigne, f.IDFournisseur, f.Nom\n"
                    + "from Article a, Fournisseur f\n"
                    + "where a.IDFournisseur = f.IDFournisseur\n"
                    + "and f.Nom = ? \n"
                    + "and a.TypeA= ? ";

            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1, reap.getFourn().getNom());
            prepStat.setString(2, artC.getType());
            ResultSet donnees = prepStat.executeQuery();

               //Recuperation des donnees
                while (donnees.next()) {
                Article arti = new Article(donnees.getString("Libelle"), 
                                           donnees.getString("Description"),
                                           donnees.getDouble("PrixMarchandise"));
                
                //Colonne facultative
                prixC = donnees.getDouble("PrixConsigne");
                if (donnees.wasNull() == false) {
                    arti.setPrixC(prixC);
                }
                
                listeLibA.add(arti);
            }
        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeLibA;
    }

    /**
     *
     * @param libelle libelle de l article selectionne
     * @param typeA type de l article selectionne
     * @return id de l article dans la BD
     * @throws BdErreur
     * @throws NoIdentification
     * @see String
     * @see Integer
     */
    @Override
    public Integer getIDArticle(String libelleA, String typeA) throws BdErreur, NoIdentification {
        Integer IDArt = 0;

        try {
            //Select de l'id
            String req = "select IDProduit from Article where Libelle = ? and TypeA = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1, libelleA);
            prepStat.setString(2, typeA);
            ResultSet donnees = prepStat.executeQuery();
            //Recuperation des donnees
            while (donnees.next()) {
                IDArt = donnees.getInt("IDProduit");
            }
        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return IDArt;
    }

    /**
     *
     * @param libelleA libelle de l article a encoder
     * @param typeA    type de l article a encoder
     * @return         quantitee de l article dans le stock
     * @throws BdErreur
     * @throws NoIdentification
     * @see Integer
     * @see String
     */
    @Override
    public Integer getQtePrec(String libelleA, String typeA) throws BdErreur, NoIdentification {
        Integer Qte = 0;

        try {
            String req = "select Qte from Article where Libelle = ? and TypeA = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1, libelleA);
            prepStat.setString(2, typeA);
            ResultSet donnees = prepStat.executeQuery();
            while (donnees.next()) {
                Qte = donnees.getInt("Qte");
            }
        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return Qte;
    }

    /**
     *
     * @param typeArt type de l article
     * @param cat categorie de l article
     * @return une ArrayList d articles suivant les parametres souhaites
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Categorie
     * @see String
     * @see Article
     */
    @Override
    public ArrayList<Article> getAllArticleRechCat(String typeArt, Categorie cat) throws BdErreur, NoIdentification {

        ArrayList<Article> tabArt;
        tabArt = new ArrayList<Article>();
        String cadeau;
        double prixC;

        try {
            //Select des articles
            String req = "select a.IDProduit, a.Libelle, a.TypeA, a.Description, a.Qte, a.PrixMarchandise, a.PrixConsigne, a.Cadeau, "
                    + "f.Nom, c.Libelle libCat "
                    + "from Article a, Fournisseur f, Categorie c "
                    + "where a.IDFournisseur = f.IDFournisseur AND a.IDCategorie = c.IDCategorie AND a.TypeA = ? AND a.IDCategorie = ? "
                    + "order by a.Libelle";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1, typeArt);
            prepStat.setInt(2, new CategorieDBAccess().getIDCat(cat.getNom()));
            ResultSet donnees = prepStat.executeQuery();

            //Recuperation des donnees
            while (donnees.next()) {
                Article art = new Article(donnees.getInt("IDProduit"),
                        donnees.getString("Libelle"),
                        donnees.getString("TypeA"),
                        donnees.getString("Description"),
                        donnees.getInt("Qte"),
                        donnees.getDouble("PrixMarchandise"),
                        new Fournisseur(donnees.getString("Nom")),
                        new Categorie(donnees.getString("LibCat")));


                //Colonnes facultatives
                cadeau = donnees.getString("Cadeau");
                if (donnees.wasNull() == false) {
                    art.setCadeau(cadeau);
                }

                prixC = donnees.getDouble("PrixConsigne");
                if (donnees.wasNull() == false) {
                    art.setPrixC(prixC);
                }
                tabArt.add(art);
            }

        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return tabArt;
    }

    /**
     *
     * @param fourn le fournisseur souhaite
     * @return une ArrayList d articles suivant le fournisseur selectionne
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Article
     * @see Fournisseur
     */
    @Override
    public ArrayList<Article> getAllArticleRechFourn(Fournisseur fourn) throws BdErreur, NoIdentification {
        ArrayList<Article> tabArt;
        tabArt = new ArrayList<Article>();
        String cadeau;
        double prixC;

        try {
            //Select des articles
            String req = "select a.IDProduit, a.Libelle, a.TypeA, a.Description, a.Qte, a.PrixMarchandise, a.PrixConsigne, a.Cadeau, "
                    + "f.Nom, c.Libelle libCat "
                    + "from Article a, Fournisseur f, Categorie c "
                    + "where a.IDFournisseur = f.IDFournisseur AND a.IDCategorie = c.IDCategorie AND a.IDFournisseur = ?  "
                    + "order by a.Libelle";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1, new FournisseurDBAccess().getIDFourn(fourn.getNom()));
            ResultSet donnees = prepStat.executeQuery();
            //Recuperation des donnees
            while (donnees.next()) {
                Article art = new Article(donnees.getInt("IDProduit"),
                        donnees.getString("Libelle"),
                        donnees.getString("TypeA"),
                        donnees.getString("Description"),
                        donnees.getInt("Qte"),
                        donnees.getDouble("PrixMarchandise"),
                        new Fournisseur(donnees.getString("Nom")),
                        new Categorie(donnees.getString("LibCat")));


                //Colonnes facultatives
                cadeau = donnees.getString("Cadeau");
                if (donnees.wasNull() == false) {
                    art.setCadeau(cadeau);
                }

                prixC = donnees.getDouble("PrixConsigne");
                if (donnees.wasNull() == false) {
                    art.setPrixC(prixC);
                }
                tabArt.add(art);
            }

        } catch (SQLException e) {
            throw new BdErreur(e.getMessage());
        } catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return tabArt;

    }
}
