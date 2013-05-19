package packageException;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class IdentificationErreur extends Exception {

    private String message;

    /**
     *
     * @param message
     */
    public IdentificationErreur(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ("Erreur: " + message);
    }
}
