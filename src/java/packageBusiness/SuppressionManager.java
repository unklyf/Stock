package packageBusiness;


import packageDataAccess.SuppressionDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;


public class SuppressionManager {
    
    private SuppressionDBAccess sADBA = new SuppressionDBAccess();
    
    public void suppArticle(Integer idP) throws BdErreur, NoIdentification{
        sADBA.suppReappro(idP);
    }
}
