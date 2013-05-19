package packageBusiness;

import packageDataAccess.*;
import packageException.*;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class LoginManager {

    /**
     * Connection a la BD
     *
     * @param user identifiant de la base de donnees
     * @param pw mode de pase de la base de donnees
     * @throws IdentificationErreur
     * @see String
     */
    public void identification(String user, String pw) throws IdentificationErreur {
        SingletonConnexion.getInstance(user, pw);
    }

    /**
     * Deconnection de la BD
     *
     * @throws IdentificationErreur
     */
    public void deconnection() throws DeconnectionErreur {
        SingletonConnexion.deconnection();
    }
}
