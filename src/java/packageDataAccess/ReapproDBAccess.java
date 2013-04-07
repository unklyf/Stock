package packageDataAccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.naming.NamingException;
import javax.swing.JComboBox;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;


public class ReapproDBAccess {
     
    private String libelle, type;
    private JComboBox listeLibA;
    
    public JComboBox getLibArticle(String typeA) throws  BdErreur, NoIdentification{   
         
         JComboBox listeLibA= new JComboBox();
         type=typeA;
         
         try {  
                 String req = "select Libelle from Article where TypeA = ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, type);
                 ResultSet donnees = prepStat.executeQuery();
   
                 
                 while (donnees.next( )){
                     libelle = donnees.getString("Libelle");
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
