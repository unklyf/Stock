/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Fournisseur;
import packageModel.LigneReappro;
import packageModel.Reappro;



public class ReapproDBAccess {
    
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
    
    public  void  addLigneReappro (LigneReappro lReap,Integer iDReap)  throws  BdErreur,NoIdentification,Exception{
 
       try{ 
             
            //Insert ligne reappro
            String req = "insert into LigneReappro (IDProduit,IDReappro,Qte) values (?,?,?)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1, new ArticleDBAccess().getIDArticle(lReap.getArt().getLibelle(), lReap.getArt().getType()));
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
    
    public ArrayList<Reappro> getAllReappro ()throws  BdErreur, NoIdentification{
        
        ArrayList<Reappro> listeReap = new ArrayList<Reappro>();
        String  note;     
 
        try{
            String req ="select distinct r.IDReappro, r.Etat, r.DateApprovisionnement, r.NoteReappro, f.Nom\n"
                      + "from Reapprovisionnement r, Fournisseur f, Article a, LigneReappro lr \n"
                      + "where lr.IDReappro = r.IDReappro and lr.IDPRoduit = a.IDProduit\n"
                      + "and a.IDFournisseur = f.IDFournisseur order by r.DateApprovisionnement";
            
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                      
                      //Date
                      java.sql.Date dateEd = donnees.getDate("DateApprovisionnement");
                      GregorianCalendar dateR = new GregorianCalendar();
                      dateR.setTime(dateEd);
                        
                      Reappro reap = new Reappro (donnees.getInt("IDReappro"),
                                                  dateR,
                                                  donnees.getString("Etat"),
                                                  new Fournisseur(donnees.getString("Nom")));
                     
                                        
                      note = donnees.getString("NoteReappro");
                      if (donnees.wasNull()== false){
                            reap.setNote(note);
                      }                                         
                      listeReap.add(reap);
                 }
    
        }
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeReap;
        
    }    
    
    public ArrayList<LigneReappro> getAllLigneReappro (Integer iDR)throws  BdErreur, NoIdentification{
        
        ArrayList<LigneReappro> listeLigne = new ArrayList<LigneReappro>();    
 
        try{
            String req ="select a.Libelle, a.TypeA, a.Description, a.PrixMarchandise, lr.Qte\n"
                    + "from Article a, LigneReappro lr\n"
                    + "where lr.IDReappro = ?\n"
                    + "and a.IDProduit = lr.IDProduit";          
            
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1, iDR);
            ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                                         
                      LigneReappro lreap = new LigneReappro (donnees.getInt("Qte"),
                                                             new Article(donnees.getString("Libelle"),
                                                                         donnees.getString("TypeA"),
                                                                         donnees.getString("Description"),
                                                                         donnees.getDouble("PrixMarchandise")));
                      listeLigne.add(lreap);
                 }
    
        }
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeLigne;
        
    }    
    
    public void setQteStock (Reappro reap, LigneReappro lReap)throws  BdErreur, NoIdentification{
       Integer Qte=0;
       Qte = new ArticleDBAccess().getQtePrec(lReap.getArt().getLibelle(),lReap.getArt().getType());
       
       try{
            
            //Cloture du reéappro dans les stocks
            String req ="update Reapprovisionnement set Etat = ?, NoteReappro= ? where iDReappro = ?";  
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,reap.getEtat());
            prepStat.setString(2,reap.getNote());
            prepStat.setInt(3,reap.getiDReappro());
            prepStat.executeUpdate();
            
            //Mis à jour des quantités dans les stocks
            req ="update Article set Qte = ? where iDProduit= ?";  
            prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,Qte+ lReap.getQte());
            prepStat.setInt(2,new ArticleDBAccess().getIDArticle(lReap.getArt().getLibelle(),lReap.getArt().getType()));
            prepStat.executeUpdate();
            
    
        }
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
    }
    
    public void suppReappro(Integer idR) throws BdErreur, NoIdentification{
        
        try{  
            String  req = "delete from LigneReappro where IDReappro = ? ";
            PreparedStatement  prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,idR);
            prepStat.executeUpdate();
            
            req = "delete from Reapprovisionnement where IDReappro = ? ";
            prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,idR);
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
