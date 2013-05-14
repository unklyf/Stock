/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;

import java.util.ArrayList;
import packageDataAccess.FournisseurDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;

/**
 *
 * @author Home
 */
public class FournisseurManager {
    
    private FournisseurDBAccess fDBA= new FournisseurDBAccess();
    
     public ArrayList <Fournisseur> getFournisseur()throws  BdErreur, NoIdentification{
        return fDBA.getFournisseur();
    }
     
     public Integer getIDFourn(String nom) throws  BdErreur, NoIdentification{
        return fDBA.getIDFourn(nom);
    }
    
}
