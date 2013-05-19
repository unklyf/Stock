package packageModel;

/**
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class LigneReappro {

    private Integer qte;
    private Article art;

    /**
     *
     * @param q quantite du LigneReappro
     * @param a article  du LigneReappro
     * @see Integer
     * @see Article
     */
    public LigneReappro(Integer q, Article a) {
        this.qte = q;
        this.art = a;
    }

    /**
     *
     * @return quantite du LigneReappro
     * @see Integer
     */
    public Integer getQte() {
        return this.qte;
    }

    /**
     *
     * @return article du LigneReappro
     * @see Article
     */
    public Article getArt() {
        return art;
    }

    /**
     *
     * @param qte quantite du LigneReappro
     * @see Integer
     */
    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
