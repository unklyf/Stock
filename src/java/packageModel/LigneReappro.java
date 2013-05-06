package packageModel;


public class LigneReappro {
    
    
    private Integer qte,iDReappro,iDProduit;
    
    public LigneReappro(Integer q, Integer iDR, Integer iDP){
        this.qte=q;
        this.iDReappro=iDR;
        this.iDProduit=iDP;  
    }
    
    public Integer getQte (){
        return this.qte;
    }
    
    public Integer getIDReap (){
        return this.iDReappro;
    }
    
    public Integer getIDProd (){
        return this.iDProduit;
    }
    
}
