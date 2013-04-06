package packageBusiness;

import packageDataAccess.*;
import packageException.*;


public class LoginManager {
    
    //Identification
    public void identification (String user, String pw) throws IdentificationErreur{
        SingletonConnexion.getInstance(user,pw);
    }
    
}
