
package packageException;


public class AddArtException extends Exception {
    private String message;
    
    public AddArtException(String message) {
        this.message=message;
    }
    
    @Override
    public String toString(){
        return ("Exception article: " +message);
    } 
    
}
