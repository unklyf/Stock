package packageModel;

import java.util.GregorianCalendar;


public class Article {
    private  String libelle, typeA ,desc, cadeau;
    private  double  prixM, prixC;
    private Integer  IDFourn, IDCat;
    

    public Article(String lib, String typ , String d , String c, double pm , double pc, Integer IDF, Integer IDC){
            this.libelle= lib; 
            this.typeA= typ;
            this.desc= d;
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
    
    public double getPrixM(){
        return this.prixM;
    }
    
    public double getPrixC(){
        return this.prixC;
    }
    
    public Integer getIDFourn(){
        return this.IDFourn;
    }
    
    public Integer getIDCat(){
        return this.IDCat;
    }
    
    
    
}
