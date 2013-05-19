package packageException;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ModifArtException extends Exception {
    private String message;

    /**
     *
     * @param message
     */
    public ModifArtException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ("Exception modification article: " + message);
    }
    
}
