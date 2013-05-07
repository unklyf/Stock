/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import packageException.BdErreur;
import packageException.NoIdentification;

/**
 *
 * @author Home
 */
public class ModifArtDBAccess {
    
    private String nomFourn, nomCat;
    
    public String rechNomFourn(Integer iDArt) throws  BdErreur, NoIdentification{
        
        try {  
                 String req = "select Nom from Fournisseur where iDFournisseur= ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setInt(1, iDArt);
                 ResultSet donnees = prepStat.executeQuery(); 
                 while (donnees.next( )){
                     nomFourn = donnees.getString("Nom");
                 }
        }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return nomFourn;
     
        
    }
    public String rechNomCat(Integer iDArt) throws  BdErreur, NoIdentification{
        
      try {  
                 String req = "select Libelle from Categorie where iDCategorie= ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setInt(1, iDArt);
                 ResultSet donnees = prepStat.executeQuery(); 
                 while (donnees.next( )){
                     nomCat = donnees.getString("Libelle");
                 }
        }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return nomCat;
        
    }
            
            
            
            
}
