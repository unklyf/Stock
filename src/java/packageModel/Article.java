/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageModel;


public class Article {
    
    private  String libelle, typeA ,desc, cadeau;
    private  double  prixM, prixC;
    private  Categorie cat;
    private  Fournisseur fourn;
    private  Integer idProduit, quantite;
    
    
    public Article (){    
    }
    
    public Article(String lib, String typ , String d , String c, double pm , double pc){
            this.libelle = lib; 
            this.typeA = typ;
            this.desc = d;
            this.prixM = pm;
            this.prixC = pc; 
            this.cadeau = c;
            
    }
    
    public Article(String lib,String typ , String d,double pm){
        this.libelle = lib;
        this.typeA = typ;
        this.desc = d;
        this.prixM = pm;
    }
    
    public Article(Integer id, String lib, String typ , String d ,Integer q, double pm , Fournisseur f, Categorie ca){
        this.idProduit = id;
        this.libelle = lib; 
        this.typeA = typ;
        this.desc = d;
        this.quantite=q;
        this.prixM = pm;
        this.fourn = f;
        this.cat = ca;       
    }
      
    public Article(String lib,String d){
        this.libelle=lib;
        this.desc= d;
    }
    
    public Article (Integer id, String d, Double pm, double pc,String c){
        this.idProduit=id;
        this.desc=d;
        this.prixM=pm;
        this.prixC=pc;
        this.cadeau=c;
    }

    public Integer getIdProduit() {
        return idProduit;
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

    public Integer getQuantite() {
        return quantite;
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
