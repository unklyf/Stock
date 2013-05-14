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
import packageModel.Fournisseur;


public class FournisseurDBAccess {

    public ArrayList <Fournisseur> getFournisseur() throws  BdErreur, NoIdentification{   
         
          ArrayList <Fournisseur> listeNomF= new ArrayList <Fournisseur> ();
         
         try {  
                 String req = "select Nom from Fournisseur";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     Fournisseur fourn = new Fournisseur(donnees.getString("Nom"));
                     listeNomF.add(fourn);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeNomF;
    } 
    
    public Integer getIDFourn(String nom) throws  BdErreur, NoIdentification{
        
        Integer iDFourn=0;
        
        try{
            String req = "select IDFournisseur from Fournisseur where Nom = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,nom);
            ResultSet donnees = prepStat.executeQuery();
            
            while (donnees.next( )){
                     iDFourn = donnees.getInt("IDFournisseur");  
                 }    
            
        }
            
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        
    return iDFourn;
    }
    
    
    
    
}
