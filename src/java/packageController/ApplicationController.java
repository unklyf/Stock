package packageController;
import packageBusiness.*;
import packageException.*;

public class ApplicationController {
    
    
    private LoginManager lM= new LoginManager();
    
    public void identification(String user, String pw) throws IdentificationErreur{
        lM.identification(user, pw);         
    }
    
}
