package packageException;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class EncodageReapproException extends Exception{
    private String message;

    /**
     *
     * @param message
     */
    public EncodageReapproException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ("Exception encodage réappro: " + message);
    }
    
}
