package packageDataAccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import packageException.*;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class SingletonConnexion {

    private static Connection connexionUnique;

    /**
     *
     * @return @throws NoIdentification
     */
    public static Connection getInstance() throws NoIdentification {
        if (connexionUnique == null) {
            throw new NoIdentification();
        } else {
            return connexionUnique;
        }

    }

    /**
     * Connection a la BD 
     * 
     * @param user identifiant de la base de donnees
     * @param pw mode de pase de la base de donnees
     * @return
     * @throws IdentificationErreur
     * @see String
     */
    public static Connection getInstance(String user, String pw) throws IdentificationErreur {
        if (connexionUnique == null) {
            try {
                //Connexion a la base de données
                Context cont = new InitialContext();
                DataSource source = (DataSource) cont.lookup("jdbc/myDatasource");
                connexionUnique = source.getConnection(user, pw);
            } catch (SQLException e) {
                throw new IdentificationErreur(e.getMessage());
            } catch (NamingException ex) {
                Logger.getLogger(SingletonConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            return connexionUnique;
        } else {
            return connexionUnique;
        }
    }

    /**
     * Deconnection de la BD
     *
     * @throws IdentificationErreur
     */
    public static void deconnection() throws DeconnectionErreur {
        try {
            connexionUnique.close();
            connexionUnique = null;
        } catch (SQLException e) {
            throw new DeconnectionErreur(e.getMessage());
        }

    }
}
