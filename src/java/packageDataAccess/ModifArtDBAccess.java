/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;

/**
 *
 * @author Home
 */
public class ModifArtDBAccess {
    
    
    private ArrayList<Article> tabArt;
    
    
       public ArrayList<Article> getAllArticle ()throws  BdErreur, NoIdentification{
        
        tabArt = new ArrayList<Article>();
        String  cadeau;
        double  prixC;
          
        try{
            String req =" select * from Article";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                      Article art = new Article (donnees.getString("Libelle"),
                                                 donnees.getString("TypeA"),
                                                 donnees.getString("Description"),
                                                 donnees.getDouble("PrixMarchandise"));
                     
                     
                    
                      cadeau = donnees.getString("Cadeau");
                      if (donnees.wasNull()){
                            art.setCadeau(cadeau);
                      }
                      
                      prixC = donnees.getDouble("PrixConsigne");
                      if (donnees.wasNull()){
                            art.setPrixC(prixC);
                       }
                      
                      tabArt.add(art);
                 }
                 
            
            
            
            
            
        }
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return null;
        
    }
    
    
            
            
            
            
}
