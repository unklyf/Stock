package packageDataAccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class SingletonConnexion {
   
    private static Connection connexionUnique;
            
    
        //Recoit un password
        public static Connection getInstance(String user, String pw){ 
            if (connexionUnique == null){ 
                    try {
                        //Connexion à la base de données
                        Context cont = new InitialContext();
                        DataSource source = (DataSource)cont.lookup("jdbc/myDatasource");
                        connexionUnique = source.getConnection(user, pw);
                     } 
                    
                    catch (SQLException ex) { 
                        Logger.getLogger(SingletonConnexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    catch (NamingException ex) {
                        Logger.getLogger(SingletonConnexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                return connexionUnique;
            }
            
            else{
                return connexionUnique;
            }
          
        }    
    
}
