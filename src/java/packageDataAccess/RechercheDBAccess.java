package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Fournisseur;


public class RechercheDBAccess {
    
    //LISTE NOMS DES FOURNISSEUR    
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
    
}
