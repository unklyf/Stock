package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.ListingReapproDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.LigneReappro;
import packageModel.Reappro;


public class ListingReapproManager {
    
    
    private ListingReapproDBAccess lrm = new ListingReapproDBAccess();
    
    
    public ArrayList<Reappro> getAllReappro ()throws  BdErreur, NoIdentification{
        return lrm.getAllReappro();
    }
    
    public ArrayList<LigneReappro> getAllLigneReappro (Integer iDR)throws  BdErreur, NoIdentification{
        return lrm.getAllLigneReappro(iDR);
    }
    
    public void setQteStock (Reappro reap, LigneReappro lReap)throws  BdErreur, NoIdentification{
        lrm.setQteStock(reap, lReap);
    }
    
}
