package packageException;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class AddReapException extends Exception{
    private String message;
    
    /**
     *
     * @param message
     */
    public AddReapException(String message) {
        this.message=message;
    }
    
    @Override
    public String toString(){
        return ("Exception dans reapprovisionnement: " +message);
    }
}
