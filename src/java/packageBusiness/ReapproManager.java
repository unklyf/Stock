/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.ReapproDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.LigneReappro;
import packageModel.Reappro;

/**
 *
 * @author Home
 */
public class ReapproManager {
    
    private ReapproDBAccess rDBA= new ReapproDBAccess();
    
    public  Integer  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,Exception{
        return rDBA.addReappro(reappro);
    }
    
    public  void  addLigneReappro (LigneReappro lReap, Integer iDReap)  throws  BdErreur,NoIdentification,Exception{
       rDBA .addLigneReappro(lReap,iDReap);
    }
    
    public ArrayList<Reappro> getAllReappro ()throws  BdErreur, NoIdentification{
        return rDBA.getAllReappro();
    }
    
    public ArrayList<LigneReappro> getAllLigneReappro (Integer iDR)throws  BdErreur, NoIdentification{
        return rDBA.getAllLigneReappro(iDR);
    }
    
    public void setQteStock (Reappro reap, LigneReappro lReap)throws  BdErreur, NoIdentification{
        rDBA.setQteStock(reap, lReap);
    }
     public void suppReappro(Integer idP) throws BdErreur, NoIdentification{
        rDBA.suppReappro(idP);
    }
    
    
}
