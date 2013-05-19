package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.ArticleDBAccess;
import packageException.AddArtException;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;
import packageModel.Reappro;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ArticleManager {

    private ArticleDBAccess aDBA = new ArticleDBAccess();

    /**
     * Ajouter un article 
     * @param nouvArt nouvel article qui doit etre ajoute
     * @param fourn fournisseur de l article  foreign key
     * @param cat categorie de l article  foreign key
     * @throws BdErreur
     * @throws NoIdentification
     * @throws AddArtException
     * @see Article
     * @see Fournisseur
     * @see Categorie
     */
    public void addArticle(Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur, NoIdentification, AddArtException {
        aDBA.addArticle(nouvArt, fourn, cat);
    }

    /**
     * Completer une comboBox suivant le type et le fournisseur selectionne
     * @param art type de l article souhaite
     * @param reap fournisseur deja selectionne dans le reappro
     * @return une ArrayList d article suivant le type et le fournisseur
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Article
     * @see Reappro
     */
    public ArrayList<Article> getArticleReappro(Article art, Reappro reap) throws BdErreur, NoIdentification {
        return aDBA.getArticleReappro(art, reap);
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
    public Integer getIDArticle(String libelle, String typeA) throws BdErreur, NoIdentification {
        return aDBA.getIDArticle(libelle, typeA);
    }

    /**
     *
     * @return une ArrayList d articles de la BD
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Article
     */
    public ArrayList<Article> getAllArticle() throws BdErreur, NoIdentification {
        return aDBA.getAllArticle();
    }

    /**
     *
     * @param artNouvVersion le nouvel article avec les nouvelles donnees
     * @param artAncVersion l ancien article avec les vieilles donnees
     * @throws BdErreur
     * @throws NoIdentification
     * @see Article
     */
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification {
        aDBA.modifArticle(artNouvVersion, artAncVersion);
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
    public ArrayList<Article> getAllArticleRechCat(String typeArt, Categorie cat) throws BdErreur, NoIdentification {
        return aDBA.getAllArticleRechCat(typeArt, cat);
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
    public ArrayList<Article> getAllArticleRechFourn(Fournisseur fourn) throws BdErreur, NoIdentification {
        return aDBA.getAllArticleRechFourn(fourn);
    }
 }
