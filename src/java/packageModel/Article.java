package packageModel;

/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class Article {

    private String libelle, typeA, desc, cadeau;
    private double prixM, prixC;
    private Categorie cat;
    private Fournisseur fourn;
    private Integer idProduit, quantite;
    private Boolean interMoins18ans;

    /**
     *
     */
    public Article() {
    }

    /**
     *
     * @param lib libelle article
     * @param typ type article
     * @param d   description article
     * @param c   cadeau lie a article
     * @param pm  prix marchandise article
     * @param pc  prix consigne article
     * @param in  booleen boisson interdite -18
     * @see String
     * @see Double
     */
    public Article(String lib, String typ, String d, String c, double pm, double pc, Boolean in) {
        this.libelle = lib;
        this.typeA = typ;
        this.desc = d;
        this.prixM = pm;
        this.prixC = pc;
        this.cadeau = c;
        this.interMoins18ans=in;
    }

    /**
     *
     * @param lib libelle article
     * @param typ type article
     * @param d   description article
     * @param q   quantite article
     * @param pm  prix marchandise article
     * @see Integer
     * @see String
     * @see Double
     */
    public Article(String lib, String typ, String d, Integer q, double pm) {
        this.libelle = lib;
        this.typeA = typ;
        this.desc = d;
        this.quantite = q;
        this.prixM = pm;
    }

    /**
     *
     * @param lib libelle article
     * @param typ type article
     * @param d   description article
     * @param pm  prix marchandise article
     * @see String
     * @see Double
     */
    public Article(String lib, String typ, String d, double pm) {
        this.libelle = lib;
        this.typeA = typ;
        this.desc = d;
        this.prixM = pm;
    }

    /**
     *
     * @param id  id article
     * @param lib libelle article
     * @param typ type article
     * @param d   description article
     * @param q   quantite article
     * @param pm  prix marchandise article
     * @param f   fournisseur article
     * @param ca  categorie article
     * @param in  booleen boisson interdite -18
     * @see Integer
     * @see String
     * @see Double
     * @see Fournisseur
     * @see Categorie
     */
    public Article(Integer id, String lib, String typ, String d, Integer q, double pm, Fournisseur f, Categorie ca,Boolean in) {
        this.idProduit = id;
        this.libelle = lib;
        this.typeA = typ;
        this.desc = d;
        this.quantite = q;
        this.prixM = pm;
        this.fourn = f;
        this.cat = ca;
        this.interMoins18ans=in;
    }

    /**
     *
     * @param lib libelle article
     * @param d   description article
     * @param pM  prix marchandise article
     * @see String 
     */
    public Article(String lib, String d,double pM) {
        this.libelle = lib;
        this.desc = d;
        this.prixM = pM;
    }
    

    /**
     *
     * @param id id article
     * @param d  description article
     * @param pm prix marchandise article
     * @param pc prix consigne article
     * @param c  cadeau article
     * @see Integer
     * @see String
     * @see Double
     */
    public Article(Integer id, String d, Double pm, double pc, String c) {
        this.idProduit = id;
        this.desc = d;
        this.prixM = pm;
        this.prixC = pc;
        this.cadeau = c;
    }

    /**
     *
     * @return id article
     * @see Integer
     */
    public Integer getIdProduit() {
        return idProduit;
    }

    /**
     *
     * @return categorie article
     * @see Categorie
     */
    public Categorie getCat() {
        return cat;
    }

    /**
     *
     * @return fournisseur article
     * @see Fournisseur
     */
    public Fournisseur getFourn() {
        return fourn;
    }

    /**
     *
     * @return libelle article
     * @see String
     */
    public String getLibelle() {
        return this.libelle;
    }

    /**
     *
     * @return type article
     * @see String 
     */
    public String getType() {
        return this.typeA;
    }

    /**
     *
     * @return description article
     * @see String 
     */
    public String getDescription() {
        return this.desc;
    }

    /**
     *
     * @return cadeau article
     * @see String 
     */
    public String getCadeau() {
        return this.cadeau;
    }

    /**
     *
     * @return quantite article
     * @see Integer 
     */
    public Integer getQuantite() {
        return quantite;
    }

    /**
     *
     * @return prix marchandise
     * @see Double
     */
    public double getPrixM() {
        return this.prixM;
    }

    /**
     *
     * @return prix consigne
     * @see Double
     */
    public double getPrixC() {
        return this.prixC;
    }
    
    /**
     *
     * @return booleen boisson interdite -18
     * @see Boolean
     */
    public Boolean getInterMoins18ans() {
        return interMoins18ans;
    }

    /**
     *
     * @param typeA type Article
     * @see String 
     */
    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    /**
     *
     * @param cadeau cadeau article
     * @see String
     */
    public void setCadeau(String cadeau) {
        this.cadeau = cadeau;
    }

    /**
     *
     * @param prixC prix consigne
     * @see Double
     */
    public void setPrixC(double prixC) {
        this.prixC = prixC;
    }
    
    /**
     *
     * @param prixM prix marchandise article
     * @see Double
     */
    public void setPrixM(double prixM) {
        this.prixM = prixM;
    }

    /**
     *
     * @param libelle libelle article
     * @see String
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
