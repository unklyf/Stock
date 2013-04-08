
package packageModel;

import java.util.GregorianCalendar;

public class Reappro {
    
    private Integer quantitee, iDProduit;
    private GregorianCalendar dateReappro;
    
    public Reappro (Integer q,Integer iDP, GregorianCalendar dR ){
        this.quantitee=q;
        this.iDProduit=iDP;
        this.dateReappro=dR;             
    }
    
    public Integer getQuantitee(){
        return this.quantitee;
    }
    
    public Integer getIDArticle(){
        return this.iDProduit;
    } 
    
     public GregorianCalendar getReapDate(){
        return this.dateReappro;        
    }
    
}
