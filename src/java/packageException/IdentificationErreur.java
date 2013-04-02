package packageException;


public class IdentificationErreur extends Exception{
    
    private String message;
    
    public IdentificationErreur(String message) {
        this.message=message;
    }
    
    public String toString(){
        return ("Erreur: " +message);
    }    
}
