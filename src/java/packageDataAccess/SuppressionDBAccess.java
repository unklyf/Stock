package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import packageException.BdErreur;
import packageException.NoIdentification;


public class SuppressionDBAccess {
    
    
    public void suppReappro(Integer idR) throws BdErreur, NoIdentification{
        
        try{  
            String  req = "delete from LigneReappro where IDReappro = ? ";
            PreparedStatement  prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,idR);
            prepStat.executeUpdate();
            
            req = "delete from Reapprovisionnement where IDReappro = ? ";
            prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,idR);
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
