package packageController;
import javax.swing.JComboBox;
import packageBusiness.*;
import packageException.*;

public class ApplicationController {
    
    
    private LoginManager lM= new LoginManager();
    private ReapproManager rM= new ReapproManager();
    
    public void identification(String user, String pw) throws IdentificationErreur{
        lM.identification(user, pw);         
    }
    
    public JComboBox getLibArticle() throws  SqlException, NoIdentification{ 
        return rM.getLibArticle();
    }
    
}
