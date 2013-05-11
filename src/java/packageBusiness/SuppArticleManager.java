/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageBusiness;


import packageDataAccess.SuppArticleDBAccess;
import packageException.BdErreur;
import packageException.NoIdentification;

/**
 *
 * @author Home
 */
public class SuppArticleManager {
    
    private SuppArticleDBAccess sADBA = new SuppArticleDBAccess();
    
    public void suppArticle(Integer idP) throws BdErreur, NoIdentification{
        sADBA.suppArticle(idP);
    }
}
