package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.ArticleDBAccess;
import packageException.AddArtException;
import packageException.BdErreur;
import packageException.ModifArtException;
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
     * 
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
        if (fourn.getNom() == null) {
            throw new AddArtException("Erreur : aucun fournisseur.");
        } else {
            if (nouvArt.getType() == null) {
                throw new AddArtException("Erreur : aucun type");
            } else {
                if (cat.getNom() == null) {
                    throw new AddArtException("Erreur : aucune catégorie");
                } else {
                    if (nouvArt.getLibelle() == null) {
                        throw new AddArtException("Erreur : aucun libelle");
                    } else {
                        if (nouvArt.getDescription() == null) {
                            throw new AddArtException("Erreur : aucune description");
                        } else {
                            if (nouvArt.getPrixM() == 0) {
                                throw new AddArtException("Erreur : aucun prix marchandise");
                            } else {
                                    aDBA.addArticle(nouvArt, fourn, cat);
                                }
                            }
                        }

                    }
                }

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
    public ArrayList<Article> getArticleReappro(Article art, Reappro reap) throws BdErreur, NoIdentification {
        return aDBA.getArticleReappro(art, reap);
    }

    /**
     * Recupérer id d'un article
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
     * Recupérer une arrayList d'articles pour table
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
     * Modifier un article
     * 
     * @param artNouvVersion le nouvel article avec les nouvelles donnees
     * @param artAncVersion l ancien article avec les vieilles donnees
     * @throws BdErreur
     * @throws NoIdentification
     * @throws ModifArtException
     * @see Article
     */
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification, ModifArtException {
        if (artNouvVersion.getDescription() == null) {
            throw new ModifArtException("Erreur : aucune description");
        } else {
            if (artNouvVersion.getPrixM() == 0) {
                throw new ModifArtException("Erreur : aucun prix marchandise");
            } else {
                aDBA.modifArticle(artNouvVersion, artAncVersion);
            }
        }

    }

    /**
     * Tous les articles d'une categorie
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
     * Tous les articles d'un fournisseur
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
