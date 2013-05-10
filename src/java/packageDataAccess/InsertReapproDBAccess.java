package packageDataAccess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Fournisseur;
import packageModel.LigneReappro;
import packageModel.Reappro;



public class InsertReapproDBAccess {
     
   

    //LISTE NOMS DES FOURNISSEUR    
     public ArrayList <Fournisseur> getFournReappro() throws  BdErreur, NoIdentification{   
         
         ArrayList <Fournisseur> listeNomF= new ArrayList <Fournisseur> ();
         
         try {  
                 String req = "select Nom from Fournisseur";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     Fournisseur fourn = new Fournisseur(donnees.getString("Nom"));
                     listeNomF.add(fourn);
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
    public ArrayList <Article> getArticleReappro(Article artC, Reappro reap) throws  BdErreur, NoIdentification{   
         
         ArrayList <Article> listeLibA= new ArrayList <Article> ();
         
         try {  
                String req =  "select a.Libelle, a.Description, a.TypeA, f.IDFournisseur, f.Nom\n" +
                              "from Article a, Fournisseur f\n" +
                              "where a.IDFournisseur = f.IDFournisseur\n" +
                              "and f.Nom = ? \n" +
                              "and a.TypeA= ? ";
          
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, reap.getFourn().getNom());
                 prepStat.setString(2, artC.getType());
                 ResultSet donnees = prepStat.executeQuery();
   
                 
                 while (donnees.next( )){
                     Article arti = new Article(donnees.getString("Libelle"),donnees.getString("Description"));
                     listeLibA.add(arti);
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
    
   
   
   //OBTENIR L'ID D'UN ARTICLE 
   //Reçoit : Libelle & type 
   public Integer getIDArticle(String libelleA, String typeA) throws  BdErreur, NoIdentification{   
         Integer IDArt=0;
                 
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
   public  void  addLigneReappro (LigneReappro lReap,Integer iDReap)  throws  BdErreur,NoIdentification,Exception{
 
       try{ 
             
            //Insert ligne reappro
            String req = "insert into LigneReappro (IDProduit,IDReappro,Qte) values (?,?,?)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1, this.getIDArticle(lReap.getArt().getLibelle(), lReap.getArt().getType()));
            prepStat.setInt(2, iDReap);
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
