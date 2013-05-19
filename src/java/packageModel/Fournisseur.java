package packageModel;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class Fournisseur {

    private String nom;

    /**
     *
     * @param n nom du fournisseur
     */
    public Fournisseur(String n) {
        nom = n;
    }

    /**
     *
     * @return nom du fournisseur
     * @seeString
     */
    public String getNom() {
        return nom;
    }
}
