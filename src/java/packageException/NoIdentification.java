package packageException;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class NoIdentification extends Exception {

    @Override
    public String toString(){
            return "Vous n'�tes pas identifi�s";
    }
}