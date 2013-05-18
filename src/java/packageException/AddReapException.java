
package packageException;


public class AddReapException extends Exception{
    private String message;
    
    public AddReapException(String message) {
        this.message=message;
    }
    
    public String toString(){
        return ("Exception dans réapprovisionnement: " +message);
    }
}
