package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;


public class InsertArtDBAccess {
    
    private ArrayList <String> tabFournDB;
    private String nomFourn;
            
    public void  addArticle (Article nouvArt) throws BdErreur,NoIdentification{
    }
    
    
    
    
    public ArrayList <String> getFournArticle() throws  BdErreur, NoIdentification{
       
        tabFournDB =new ArrayList <String> ();
        
        try {  
                 String req = "select Nom from Fournisseur";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     nomFourn = donnees.getString("Nom");
                     tabFournDB.add(nomFourn);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
   
        return tabFournDB;
    }
    
}
