package packageBusiness;

//import packageDataAccess.ModifArtDBAccess;
import java.util.ArrayList;
import packageDataAccess.ModifArtDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;


public class ModifArtManager {
    
    private ModifArtDBAccess mADBA = new ModifArtDBAccess();
    
    public ArrayList<Article> getAllArticle ()throws  BdErreur, NoIdentification{
        return mADBA.getAllArticle();
    }
   
    
   
}
