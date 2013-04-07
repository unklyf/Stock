package packageController;
import java.util.ArrayList;
import javax.swing.JComboBox;
import packageBusiness.*;
import packageException.*;

public class ApplicationController {
    
    
    private LoginManager lM= new LoginManager();
    private ReapproManager rM= new ReapproManager();
    
    public void identification(String user, String pw) throws IdentificationErreur{
        lM.identification(user, pw);         
    }
    
    public ArrayList <String> getLibArticle(String typeA) throws  BdErreur, NoIdentification{ 
        return rM.getLibArticle(typeA);
    }
    
     public ArrayList <String> getLibArticle(String typeA,String rech) throws  BdErreur, NoIdentification{ 
        return rM.getLibArticle(typeA,rech);
    }
    
    public String getDescArticle(String libelle,String typeA) throws  BdErreur, NoIdentification{ 
        return rM.getDescArticle(libelle, typeA);
    }
    
    
    
}
