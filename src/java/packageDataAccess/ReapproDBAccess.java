package packageDataAccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;



public class ReapproDBAccess {
     
    private String libelle, libelleD;
    private ArrayList <String> listeLibA;
    
    
    public ArrayList <String> getLibArticle(String typeA) throws  BdErreur, NoIdentification{   
         
         listeLibA= new ArrayList <String> ();
         
         try {  
                 String req = "select Libelle from Article where TypeA = ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, typeA);
                 ResultSet donnees = prepStat.executeQuery();
   
                 
                 while (donnees.next( )){
                     libelle = donnees.getString("Libelle");
                     listeLibA.add(libelle);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeLibA;
   } 
    
    
    
    public ArrayList <String> getLibArticle(String typeA,String rech) throws  BdErreur, NoIdentification{   
         
         listeLibA= new ArrayList <String> ();
         
         try {  
                 String req = "select Libelle from Article where TypeA = ? and Libelle like ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, typeA);
                 prepStat.setString(2, "%"+rech+"%");
                 ResultSet donnees = prepStat.executeQuery();
   
                 
                 while (donnees.next( )){
                     libelle = donnees.getString("Libelle");
                     listeLibA.add(libelle);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeLibA;
   } 
    
    
   public String getDescArticle(String libelleA, String typeA) throws  BdErreur, NoIdentification{   
                  
         try {  
                 String req = "select Description from Article where Libelle = ? and TypeA = ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, libelleA);
                 prepStat.setString(2, typeA);
                 ResultSet donnees = prepStat.executeQuery(); 
                 while (donnees.next( )){
                     libelleD = donnees.getString("Description");
                 }
        }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return libelleD;
 }
}
