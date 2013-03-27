package packageException;


public class IdentificationErreur extends Exception{
    public String toString(){
        return ("Erreur: les identifiants sont incorrects");
    }    
}
