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
import packageModel.Categorie;


public class CategorieDBAccess {
    
    private ArrayList <Categorie>  tabCatDB;
    
    
    public ArrayList <Categorie> getCatArticle() throws  BdErreur, NoIdentification{
       
        tabCatDB =new ArrayList <Categorie> ();
        
        try {  
                 String req = "select Libelle from Categorie";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     Categorie cat = new Categorie (donnees.getString("Libelle"));
                     tabCatDB.add(cat);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
   
        return tabCatDB;
    }
    
    
    
    
    public Integer getIDCat(String libelle) throws  BdErreur, NoIdentification{
        
        Integer iDCat=0;
        
        try{
            String req = "select IDCategorie from Categorie where Libelle = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,libelle);
            ResultSet donnees = prepStat.executeQuery();
            
            while (donnees.next( )){
                     iDCat = donnees.getInt("IDCategorie");  
                 }    
            
        }
            
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        
    return iDCat;
    }
    
   
    
    
}
