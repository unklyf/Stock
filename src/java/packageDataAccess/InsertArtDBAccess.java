/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDataAccess;

import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;

/**
 *
 * @author Home
 */
public class InsertArtDBAccess {
    
    private ArrayList <String> tabFournDB;
            
    public void  addArticle (Article nouvArt) throws BdErreur,NoIdentification{
    }
    
    
    
    
    public ArrayList <String> getFournArticle() throws  BdErreur, NoIdentification{
       
        tabFournDB =new ArrayList <String> ();
        
        
        
        
        return tabFournDB;
    }
    
}
