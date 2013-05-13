package packageBusiness;
import java.util.ArrayList;
import packageDataAccess.RechercheDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;

public class RechercheManager {
    
    private RechercheDBAccess rDBA;
    
    public ArrayList <Fournisseur> getFournisseur()throws  BdErreur, NoIdentification{
        return rDBA.getFournisseur();
    }
}
