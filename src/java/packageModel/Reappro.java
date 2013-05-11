
package packageModel;

import java.util.GregorianCalendar;

public class Reappro {
    
    private Integer iDReappro;
    private GregorianCalendar dateReappro;
    private String note,etat;
    private Fournisseur fourn;
    
    public Reappro (GregorianCalendar dR, String n,String e,Fournisseur f){
        this.dateReappro=dR;
        this.note=n;
        this.etat=e;
        this.fourn=f;
    }
    
    public Reappro (Integer idR, GregorianCalendar dR, String e,Fournisseur f){
        this.iDReappro=idR;
        this.dateReappro=dR;
        this.etat=e;
        this.fourn=f;
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

    public Integer getiDReappro() {
        return iDReappro;
    }

    public Fournisseur getFourn() {
        return fourn;
    }
     
    public void setNote(String note) {
        this.note = note;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
    
}
