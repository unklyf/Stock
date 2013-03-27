package packageBusiness;
import packageDataAccess.SingletonConnexion;


public class LoginManager {
    
   
    
    //Identification
    public void identification (String user, String pw){
        SingletonConnexion.getInstance(user,pw);
    }
    
}
