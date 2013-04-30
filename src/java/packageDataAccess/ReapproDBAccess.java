package packageDataAccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Reappro;



public class ReapproDBAccess {
     
    private String libelle, libelleD, nomF;
    private ArrayList <String> listeLibA,listeNomF;
    private Integer IDArt;
    
    
    //LIBELLE DES FOURNISSEUR    
     public ArrayList <String> getNomFourn() throws  BdErreur, NoIdentification{   
         
         listeNomF= new ArrayList <String> ();
         
         try {  
                 String req = "select Nom from Fournisseur";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     nomF = donnees.getString("Nom");
                     listeNomF.add(nomF);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeNomF;
    } 
    
    //REMPLIR LA JComboBox EN FONCTION DU TYPE ARTICLE CHOISIT
    public ArrayList <String> getLibArticle(String typeA) throws  BdErreur, NoIdentification{   
         
         listeLibA= new ArrayList <String> ();
         
         try {  
                 String req = "select Libelle from Article where TypeA = ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, typeA);
                 ResultSet donnees = prepStat.executeQuery();
   
                 
                 while (donnees.next( )){
                     libelle = donnees.getString("Libelle");
                     listeLibA.add(libelle);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeLibA;
   } 
    
    
    //LIKE POUR EFFECTUER UNE RECHERCHE DANS LA JComboBox
    public ArrayList <String> getLibArticle(String typeA,String rech) throws  BdErreur, NoIdentification{   
         
         listeLibA= new ArrayList <String> ();
         
         try {  
                 String req = "select Libelle from Article where TypeA = ? and Libelle like ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, typeA);
                 prepStat.setString(2, "%"+rech+"%");
                 ResultSet donnees = prepStat.executeQuery();
   
                 
                 while (donnees.next( )){
                     libelle = donnees.getString("Libelle");
                     listeLibA.add(libelle);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeLibA;
   } 
    
   
    //OBTENIR LA DESCRIPTION DE L'ARTICLE EN FONCTION DU LIBBELLE ET DE SON TYPE
   public String getDescArticle(String libelleA, String typeA) throws  BdErreur, NoIdentification{   
                  
         try {  
                 String req = "select Description from Article where Libelle = ? and TypeA = ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, libelleA);
                 prepStat.setString(2, typeA);
                 ResultSet donnees = prepStat.executeQuery(); 
                 while (donnees.next( )){
                     libelleD = donnees.getString("Description");
                 }
        }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return libelleD;
  }
   
   
   //OBTENIR L'ID DU PRODUIT AFIN D'ENCODER NOUVEAU REAPPRO 
   //Reçoit : Libelle choisit dans JComboBox & Le type article choisit
   public Integer getIDArticle(String libelleA, String typeA) throws  BdErreur, NoIdentification{   
                  
         try {  
                 String req = "select IDProduit from Article where Libelle = ? and TypeA = ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, libelleA);
                 prepStat.setString(2, typeA);
                 ResultSet donnees = prepStat.executeQuery(); 
                 while (donnees.next( )){
                     IDArt = donnees.getInt("IDProduit");
                 }
        }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return IDArt;
   }
   
   
   //AJOUT BD
   public  void  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,Exception{

       try{ 
             
            //Update pour colonne obligatoire
            String req = "insert into Reapprovisionnement (DateApprovisionnement,Qte,IDProduit) values (?,?,?)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            prepStat.setDate(1,new java.sql.Date(reappro.getReapDate().getTimeInMillis()));
            prepStat.setInt(2, reappro.getQuantitee());
            prepStat.setInt(3, reappro.getIDArticle());
            prepStat.executeUpdate();             
            
            //Obtenir IDReappro venant d'être insérer
            ResultSet rs = prepStat.getGeneratedKeys();
            
            while(rs.next()){
                int lastID = rs.getInt(1);
                //Update pour colonne facultative
                if(reappro.getNote()!=null){
                    req = "update Reapprovisionnement set NoteReappro = ? where IDReappro= ?";
                    prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                    prepStat.setString(1, reappro.getNote());
                    prepStat.setInt(2, lastID);
                    prepStat.executeUpdate();                
                }
            }
            
            
            //Récuperer ancienne quantitée
            int newQte=0;
            req = "select Qte from Article where IDProduit= ?";
            prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1, reappro.getIDArticle());
            ResultSet donnees = prepStat.executeQuery(); 
            while (donnees.next( )){
                newQte = donnees.getInt("Qte");
            }
            
            newQte+=reappro.getQuantitee();
            
            //Ajout dans les stocks article (modifier quantitée)
            req = "update Article set Qte = ? where IDProduit= ?";
            prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1, newQte);
            prepStat.setInt(2, reappro.getIDArticle());
            prepStat.executeUpdate();
             
        }
        catch (SQLException e){       
            throw new BdErreur(e.getMessage());
        }
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        catch (Exception e){
           throw new BdErreur(e.getMessage());
       }
      
   }
}
