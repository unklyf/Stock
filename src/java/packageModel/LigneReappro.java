package packageModel;


public class LigneReappro {
    
    
    private Integer qte;
    private Article art;
    
    public LigneReappro(Integer q,Article a){
        this.qte=q;
        this.art=a;
    }
    
    public Integer getQte (){
        return this.qte;
    }  

    public Article getArt() {
        return art;
    } 

    public void setQte(Integer qte) {
        this.qte = qte;
    }
    
    
}
