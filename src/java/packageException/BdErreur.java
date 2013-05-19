package packageException;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class BdErreur extends Exception {

    private String message;

    /**
     *
     * @param message
     */
    public BdErreur(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ("Erreur dans la BD: " + message);
    }
}
