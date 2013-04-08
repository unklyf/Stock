package packageModel;

import java.util.GregorianCalendar;


public class Article {
    private  String libelle, typeA ,desc, cadeau;
    private  double qte, prixM, prixC;
    private GregorianCalendar datePeremp; 
    

    public Article(String lib, String typ , String d , String c, double q, double pm , double pc, GregorianCalendar dp){
            this.libelle= lib; 
            this.typeA= typ;
            this.desc= d;
            this.qte= q; 
            this.datePeremp= dp;
            this.prixM =pm;
            this.prixC =pc; 
            this.cadeau= c;
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
    
    public double getQuantite(){
        return this.qte;
    }
    
    public double getPrixM(){
        return this.prixM;
    }
    
    public double getPrixC(){
        return this.prixC;
    }
    
    public GregorianCalendar getDatePeremp(){
        return this.datePeremp;
    }
    
}
