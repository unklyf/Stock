package packageController;
import packageBusiness.LoginManager;

public class ApplicationController {
    
    
    private LoginManager lM= new LoginManager();
    
    public void identification(String user, String pw){
        lM.identification(user, pw);         
    }
    
}
