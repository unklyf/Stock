package packageController;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import packageBusiness.*;
import packageException.*;
import packageModel.*;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ApplicationController {

    private LoginManager lM = new LoginManager();
    private ReapproManager rM = new ReapproManager();
    private ArticleManager aM = new ArticleManager();
    private FournisseurManager fM = new FournisseurManager();
    private CategorieManager cM = new CategorieManager();

    /**
     * IDENTIFICATION
     *
     * @param user identifiant de la base de donnees
     * @param pw mode de pase de la base de donnees
     * @throws IdentificationErreur
     * @see String
     */
    public void identification(String user, String pw) throws IdentificationErreur {
        lM.identification(user, pw);
    }

    /**
     * DECONNECTION
     *
     * @throws DeconnectionErreur
     */
    public void deconnection() throws DeconnectionErreur {
        lM.deconnection();
    }

    //REAPPROVISIONNEMENT + LIGNE REAPPRO MANAGER
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
    public Integer addReappro(Reappro reappro) throws BdErreur, NoIdentification, AddReapException {
        return rM.addReappro(reappro);
    }

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
    public void addLigneReappro(LigneReappro lReap, Integer iDReap) throws BdErreur, NoIdentification, AddReapException {
        rM.addLigneReappro(lReap, iDReap);
    }

    /**
     * Tous les reappros pour une table
     *
     * @return une ArrayList contenant tous les reapprovisionnements effectues
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Reappro
     */
    public ArrayList<Reappro> getAllReappro() throws BdErreur, NoIdentification {
        return rM.getAllReappro();
    }

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
    public ArrayList<LigneReappro> getAllLigneReappro(Integer iDR) throws BdErreur, NoIdentification {
        return rM.getAllLigneReappro(iDR);
    }

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
    public void setQteStock(Reappro reap, LigneReappro lReap) throws BdErreur, NoIdentification,EncodageReapproException {
        rM.setQteStock(reap, lReap);
    }

    /**
     * Supprimer un reappro
     *
     * @param idP id du reapprovisionnement a supprimer
     * @throws BdErreur
     * @throws NoIdentification
     * @see Integer
     */
    public void suppReappro(Integer idP) throws BdErreur, NoIdentification {
        rM.suppReappro(idP);
    }

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
    public ArrayList<Reappro> getRechReappro(GregorianCalendar dateR, Fournisseur fourn) throws BdErreur, NoIdentification {
        return rM.getRechReappro(dateR, fourn);
    }

    
    //ARTICLE MANAGER
    /**
     * Ajouter un article 
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
    public void addArticle(Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur, NoIdentification, AddArtException {
        aM.addArticle(nouvArt, fourn, cat);
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
        return aM.getArticleReappro(art, reap);
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
        return aM.getAllArticle();
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
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification,ModifArtException{
        aM.modifArticle(artNouvVersion, artAncVersion);
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
        return aM.getAllArticleRechCat(typeArt, cat);
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
        return aM.getAllArticleRechFourn(fourn);
    }
        
    
    //FOURNISSEUR MANAGER    
    /**
     * Liste de libelle de fournisseurs
     * 
     * @return une ArrayList de fournisseur
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Fournisseur
     */public ArrayList<Fournisseur> getFournisseur() throws BdErreur, NoIdentification {
        return fM.getFournisseur();
    }

    //CATEGORIE MANAGER 
    /**
     * Liste des libelles categorie
     *
     * @return une ArrayList des categorie de la BD
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Categorie
     */
    public ArrayList<Categorie> getCatArticle() throws BdErreur, NoIdentification {
        return cM.getCatArticle();
    }
}
