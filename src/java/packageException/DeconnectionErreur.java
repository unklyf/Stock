package packageException;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class DeconnectionErreur extends Exception{
    private String message;
    
    /**
     *
     * @param message
     */
    public DeconnectionErreur(String message) {
        this.message=message;
    }
    
    @Override
    public String toString(){
        return ("Erreur: " +message);
    }
    
}
