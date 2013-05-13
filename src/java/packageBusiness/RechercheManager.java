package packageBusiness;
import java.util.ArrayList;
import packageDataAccess.RechercheDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;

public class RechercheManager {
    
    private RechercheDBAccess rDBA = new RechercheDBAccess();
    
    public ArrayList <Fournisseur> getFournisseur()throws  BdErreur, NoIdentification{
        return rDBA.getFournisseur();
    }
    public ArrayList <Article> getArticleCat(String typeArt,Categorie cat) throws  BdErreur, NoIdentification{
        return rDBA.getArticleCat(typeArt,cat);
    }
}
