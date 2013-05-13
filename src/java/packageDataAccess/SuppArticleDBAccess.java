package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import packageException.BdErreur;
import packageException.NoIdentification;


public class SuppArticleDBAccess {
    
    
    public void suppArticle(Integer idP) throws BdErreur, NoIdentification{
        
        try{   
            String req = "delete from Article where IDProduit = ? ";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,idP);
            prepStat.executeUpdate(); 
        }
        catch (SQLException e){       
            throw new BdErreur(e.getMessage());
        }
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        catch (Exception e){
           throw new BdErreur(e.getMessage());
        }
    }
}
