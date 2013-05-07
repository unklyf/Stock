/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;

import packageDataAccess.ModifArtDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;

/**
 *
 * @author Home
 */
public class ModifArtManager {
    
    private ModifArtDBAccess mADBA = new ModifArtDBAccess();
    
    
    public String rechNomFourn(Integer iDArt) throws  BdErreur, NoIdentification{
        return mADBA.rechNomFourn(iDArt);
    }
    public String rechNomCat(Integer iDArt) throws  BdErreur, NoIdentification{
        return mADBA.rechNomFourn(iDArt);
    }
}
