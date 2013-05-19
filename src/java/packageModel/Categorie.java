package packageModel;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class Categorie {

    private String nom;
    private Integer iDCat;

    /**
     *
     * @param n nom de la categorie
     */
    public Categorie(String n) {
        nom = n;
    }

    /**
     *
     * @return le nom de la categorie
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return id de la categorie
     */
    public Integer getiDCat() {
        return iDCat;
    }
}
