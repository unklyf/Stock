package packageDataAccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.LigneReappro;
import packageModel.Reappro;



public class InsertReapproDBAccess {
     
    private String libelle, libelleD, nomF, libRechArt, typeRechArt;
    private ArrayList <String> listeLibA,listeNomF;
    private Integer IDArt;
    
    
    //LISTE NOMS DES FOURNISSEUR    
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
    public ArrayList <String> getLibArticle(String typeA, String nomF) throws  BdErreur, NoIdentification{   
         
         listeLibA= new ArrayList <String> ();
         
         try {  
                 String req = "select art.Libelle, fourn.IDFournisseur, fourn.Nom\n" +
                              "from Article art, Fournisseur fourn\n" +
                              "where TypeA = ? \n" +
                              "and fourn.Nom = ?\n" +
                              "and art.IDFournisseur = fourn.IDFournisseur";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, typeA);
                 prepStat.setString(2, nomF);
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
    
    
    //OBTENIR LA DESCRIPTION DE L'ARTICLE EN FONCTION DU LIBELLE ET DE SON TYPE
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
   
   
   //OBTENIR L'ID DU PRODUIT AFIN D'ENCODER NOUVEAU LIGNEREAPPRO 
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
   
   
   //Recherche libelle article a partir de l'ID pour remplir jTable
   public String getRechLibArt(Integer iDArt) throws  BdErreur,NoIdentification{
         
       try {  
                 String req = "select Libelle from Article where iDProduit= ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setInt(1, iDArt);
                 ResultSet donnees = prepStat.executeQuery(); 
                 while (donnees.next( )){
                     typeRechArt = donnees.getString("Libelle");
                 }
        }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return typeRechArt;
    }
   
   
   //Recherche type article a partir de l'ID pour remplir jTable
   public String getRechTypeArt(Integer iDArt) throws  BdErreur,NoIdentification{
         
       try {  
                 String req = "select typeA from Article where iDProduit= ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setInt(1, iDArt);
                 ResultSet donnees = prepStat.executeQuery(); 
                 while (donnees.next( )){
                     libRechArt = donnees.getString("typeA");
                 }
        }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return libRechArt;
    }
   
   
   //AJOUT BD REAPPRO
   public  Integer  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,Exception{
       int lastID=0;
       try{ 
             
            //Insert reappro
            String req = "insert into Reapprovisionnement (DateApprovisionnement,Etat,NoteReappro) values (?,?,?)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            prepStat.setDate(1,new java.sql.Date(reappro.getReapDate().getTimeInMillis()));
            prepStat.setString(2, reappro.getEtat());
            prepStat.setNull(3, Types.VARCHAR);
            prepStat.executeUpdate();             
            
            //Obtenir IDReappro venant d'être insérer
            ResultSet rs = prepStat.getGeneratedKeys();
            
            while(rs.next()){
                lastID = rs.getInt(1);                                
            } 
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
       
       return lastID;      
   }
   
   //AJOUT BD LIGNE REAPPRO
   public  void  addLigneReappro (LigneReappro lReap)  throws  BdErreur,NoIdentification,Exception{
 
       try{ 
             
            //Insert ligne reappro
            String req = "insert into LigneReappro (IDProduit,IDReappro,Qte) values (?,?,?)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1, lReap.getIDProd());
            prepStat.setInt(2, lReap.getIDReap());
            prepStat.setInt(3, lReap.getQte());
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
