
package packageModel;

import java.util.GregorianCalendar;

public class Reappro {
    
    private Integer quantitee, iDProduit;
    private GregorianCalendar dateReappro;
    private String note;
    
    public Reappro (Integer q,Integer iDP, GregorianCalendar dR, String n ){
        this.quantitee=q;
        this.iDProduit=iDP;
        this.dateReappro=dR;
        this.note=n;
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
    
    public String getNote(){
        return this.note;        
    }
    
}
