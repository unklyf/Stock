package packageException;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class AddArtException extends Exception {

    private String message;

    /**
     *
     * @param message
     */
    public AddArtException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ("Exception article: " + message);
    }
}
