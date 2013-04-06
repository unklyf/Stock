package packageDataAccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.naming.NamingException;
import javax.swing.JComboBox;
import packageException.SqlException;
import packageException.NoIdentification;
import packageModel.Article;


public class ReapproDBAccess {
     
    
    public JComboBox getLibArticle() throws  SqlException, NoIdentification{   
         
         String libelle;
         JComboBox listeLibA= new JComboBox();
          
         try {  
                 String req = "select Libelle from Article";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 
                 while (donnees.next( )){
                     libelle = donnees.getString("Titre");
                     listeLibA.addItem(libelle);
                 }    
         }
            
            catch (SQLException e) {                
        }                   
            catch (NoIdentification e) {
               throw new NoIdentification();
        }
        return listeLibA;
 }    
}
