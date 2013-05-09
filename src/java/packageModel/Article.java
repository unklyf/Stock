package packageModel;


public class Article {
    private  String libelle, typeA ,desc, cadeau;
    private  double  prixM, prixC;
    private Categorie cat;
    private Fournisseur fourn;
    
    
    public Article(){};
    
    public Article(String lib, String typ , String d , String c, double pm , double pc){
            this.libelle= lib; 
            this.typeA= typ;
            this.desc= d;
            this.prixM =pm;
            this.prixC =pc; 
            this.cadeau= c;
            
    }
    
    public Article(String lib,String typ , String d,double pm){
        this.libelle=lib;
        this.typeA= typ;
        this.desc= d;
        this.prixM =pm;
    }
    
    public Article(String lib, String typ , String d , double pm , Fournisseur f, Categorie ca){
            this.libelle= lib; 
            this.typeA= typ;
            this.desc= d;
            this.prixM =pm;
            this.fourn= f;
            this.cat=ca;
            
    }
    
    public Article(String lib,String d){
        this.libelle=lib;
        this.desc= d;
    }
    
    public Categorie getCat() {
        return cat;
    }

    public Fournisseur getFourn() {
        return fourn;
    }
    
       
    public String getLibelle(){
        return this.libelle;
    }
    
    public String getType(){
        return this.typeA;
    }
    
    public String getDescription(){
        return this.desc;
    }
    
    public String getCadeau(){
        return this.cadeau;
    }
    
    public double getPrixM(){
        return this.prixM;
    }
    
    public double getPrixC(){
        return this.prixC;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }
    
     public void setCadeau(String cadeau) {
        this.cadeau = cadeau;
    }

    public void setPrixC(double prixC) {
        this.prixC = prixC;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


 
}
