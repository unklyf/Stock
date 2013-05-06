
package packageModel;

import java.util.GregorianCalendar;

public class Reappro {
    
    private GregorianCalendar dateReappro;
    private String note,etat;
    
    public Reappro (GregorianCalendar dR, String n,String e){
        this.dateReappro=dR;
        this.note=n;
        this.etat=e;
    }

    public GregorianCalendar getReapDate(){
        return this.dateReappro;        
    }
    
    public String getNote(){
        return this.note;        
    }
    
    public String getEtat(){
        return this.etat;        
    }
    
}
