package packageException;


public class BdErreur extends Exception {
    
    private String message;
    
    public BdErreur(String message) {
        this.message=message;
    }
    
    public String toString(){
        return ("Erreur: " +message);
    } 
    
}
