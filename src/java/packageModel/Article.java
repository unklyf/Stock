package packageModel;

import java.util.GregorianCalendar;


public class Article {
    private  String libelle, typeA ,desc, cadeau;
    private  double  prixM, prixC;
    private GregorianCalendar datePeremp;
    private Integer qte, IDFourn, IDCat;
    

    public Article(String lib, String typ , String d , String c, Integer q, double pm , double pc, GregorianCalendar dp, Integer IDF, Integer IDC){
            this.libelle= lib; 
            this.typeA= typ;
            this.desc= d;
            this.qte= q; 
            this.datePeremp= dp;
            this.prixM =pm;
            this.prixC =pc; 
            this.cadeau= c;
            this.IDFourn=IDF;
            this.IDCat= IDC;
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
    
    public Integer getQuantite(){
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
    
    public Integer getIDFourn(){
        return this.IDFourn;
    }
    
    public Integer getIDCat(){
        return this.IDCat;
    }
    
}
