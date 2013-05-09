package packageModel;

import java.util.logging.Logger;




public class Article {
    private  String libelle, typeA ,desc, cadeau;
    private  double  prixM, prixC;
    
    
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
    
    public Article(String lib,String d){
        this.libelle=lib;
        this.desc= d;
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
