package packageInterface;

import java.util.ArrayList;
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
public interface ArticleInterface {

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
    public void addArticle(Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur, NoIdentification, AddArtException;

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
    public ArrayList<Article> getArticleReappro(Article art, Reappro reap) throws BdErreur, NoIdentification;

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
    public Integer getIDArticle(String libelle, String typeA) throws BdErreur, NoIdentification;

    /**
     *
     * @return une ArrayList d articles de la BD
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Article
     */
    public ArrayList<Article> getAllArticle() throws BdErreur, NoIdentification;

    /**
     *
     * @param artNouvVersion le nouvel article avec les nouvelles donnees
     * @param artAncVersion l ancien article avec les vieilles donnees
     * @throws BdErreur
     * @throws NoIdentification
     * @see Article
     */
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification;

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
    public ArrayList<Article> getAllArticleRechCat(String typeArt, Categorie cat) throws BdErreur, NoIdentification;

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
    public ArrayList<Article> getAllArticleRechFourn(Fournisseur fourn) throws BdErreur, NoIdentification;
    
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
    public Integer getQtePrec(String libelleA, String typeA) throws BdErreur, NoIdentification;
}
