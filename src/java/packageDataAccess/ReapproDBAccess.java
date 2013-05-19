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
import packageException.AddReapException;
import packageInterface.ReapproInterface;
import packageModel.Article;
import packageModel.Fournisseur;
import packageModel.LigneReappro;
import packageModel.Reappro;



/**
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class ReapproDBAccess implements ReapproInterface{
    
    /**
     *
     * @param reappro le reapprovisionnement a ajouter
     * @return        id du reappro ajoute pour ajouter Lignereappro apres
     * @throws BdErreur
     * @throws NoIdentification
     * @throws AddReapException
     * @see Integer
     * @see Reappro
     */
    @Override
    public  Integer  addReappro (Reappro reappro)  throws  BdErreur,NoIdentification,AddReapException{
       int lastID=0;
       try{              
            //Insert reappro
            String req = "insert into Reapprovisionnement (DateApprovisionnement,Etat,NoteReappro) values (?,?,?)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            prepStat.setDate(1,new java.sql.Date(reappro.getReapDate().getTimeInMillis()));
            prepStat.setString(2, reappro.getEtat());
            prepStat.setNull(3, Types.VARCHAR);
            prepStat.executeUpdate();             
            
            //Obtenir IDReappro venant d etre inserer
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
           throw new AddReapException(e.getMessage());
       }
       
       return lastID;      
   }
   
     /**
     *
     * @param lReap   le LigneReappro a ajouter
     * @param iDReap  id du reappro correspondant
     * @throws BdErreur
     * @throws NoIdentification
     * @throws AddReapException
     * @see LigneReappro
     * @see Integer
     */
    @Override
    public  void  addLigneReappro (LigneReappro lReap,Integer iDReap)  throws  BdErreur,NoIdentification,AddReapException{
 
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
           throw new AddReapException(e.getMessage());
       }    
   }

    /**
     *
     * @return une ArrayList contenant tous les reapprovisionnements effectues
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Reappro
     */
    @Override
    public ArrayList<Reappro> getAllReappro ()throws  BdErreur, NoIdentification{
        
        
        ArrayList<Reappro> listeReap = new ArrayList<Reappro>();
        String  note;     
 
        try{
            //Select du reappro
            String req ="select distinct r.IDReappro, r.Etat, r.DateApprovisionnement, r.NoteReappro, f.Nom\n"
                      + "from Reapprovisionnement r, Fournisseur f, Article a, LigneReappro lr \n"
                      + "where lr.IDReappro = r.IDReappro and lr.IDPRoduit = a.IDProduit\n"
                      + "and a.IDFournisseur = f.IDFournisseur order by r.DateApprovisionnement";
            
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            ResultSet donnees = prepStat.executeQuery();
                 
                 //Recuperation des donnees
                 while (donnees.next( )){
                      
                      //Date
                      java.sql.Date dateEd = donnees.getDate("DateApprovisionnement");
                      GregorianCalendar dateR = new GregorianCalendar();
                      dateR.setTime(dateEd);
                        
                      //Reappro
                      Reappro reap = new Reappro (donnees.getInt("IDReappro"),
                                                  dateR,
                                                  donnees.getString("Etat"),
                                                  new Fournisseur(donnees.getString("Nom")));
                     
                      //Facultatif-Note                 
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
    
    /**
     *
     * @param iDR id du reapprovisionnement selectionnee dans la table 
     * @return    une ArrayList contenant les LignesReappro correspondant
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Integer
     * @see LigneReappro
     */
    @Override
    public ArrayList<LigneReappro> getAllLigneReappro (Integer iDR)throws  BdErreur, NoIdentification{
        
        ArrayList<LigneReappro> listeLigne = new ArrayList<LigneReappro>();    
 
        try{
            //Select LigneReappro
            String req ="select a.Libelle, a.TypeA, a.Description, a.PrixMarchandise, lr.Qte\n"
                    + "from Article a, LigneReappro lr\n"
                    + "where lr.IDReappro = ?\n"
                    + "and a.IDProduit = lr.IDProduit";          
            
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1, iDR);
            ResultSet donnees = prepStat.executeQuery();
                 
                 //Recuperation des donnees
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
    
    /**
     * Encoder la marchandise recue dans le stock - mise a jour quantite
     * @param reap   le Reappro qui va etre encoder dans le stock
     * @param lReap  la LigneReappro dans lequel la quantite va etre mise a jour
     * @throws BdErreur
     * @throws NoIdentification
     * @see LigneReappro
     * @see Reappro
     */
    @Override
    public void setQteStock (Reappro reap, LigneReappro lReap)throws  BdErreur, NoIdentification{
       Integer Qte;
       Qte = new ArticleDBAccess().getQtePrec(lReap.getArt().getLibelle(),lReap.getArt().getType());
       
       try{            
            //Cloture du reappro dans le stock
            String req ="update Reapprovisionnement set Etat = ?, NoteReappro= ? where iDReappro = ?";  
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,reap.getEtat());
            prepStat.setString(2,reap.getNote());
            prepStat.setInt(3,reap.getiDReappro());
            prepStat.executeUpdate();
            
            //Mis a jour des quantites dans le stock
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
    
    
    
    /**
     *
     * @param idP  id du reapprovisionnement  a supprimer
     * @throws BdErreur
     * @throws NoIdentification
     * @see Integer
     */
    @Override
    public void suppReappro(Integer idR) throws BdErreur, NoIdentification{
        
        try{  
            //Suppression d abord de tous les articles
            String  req = "delete from LigneReappro where IDReappro = ? ";
            PreparedStatement  prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,idR);
            prepStat.executeUpdate();
            
            //Suppresion du reappro ensuite
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
        
    }
    
    /**
     *
     * @param dateR la date a laquelle on veut consulter les reapprovisionnements
     * @param fourn le fournisseur pour lequel on on veut consulter les reapprovisionnements
     * @return une ArrayList des reapprovisionnements 
     * @throws BdErreur
     * @throws NoIdentification
     * @see ArrayList
     * @see Reappro
     * @see GregorianCalendar
     * @see Fournisseur
     */
    @Override
    public ArrayList<Reappro> getRechReappro (GregorianCalendar dateR,Fournisseur fourn)throws  BdErreur, NoIdentification{
        
        ArrayList<Reappro> listeReapRech = new ArrayList<Reappro>();
        String  note;     
        
        try{
            //Select des reappros
            String req ="select distinct r.IDReappro, r.Etat, r.NoteReappro, r.DateApprovisionnement, f.Nom\n"
                      + "from Reapprovisionnement r, Fournisseur f, Article a, LigneReappro lr \n"
                      + "where lr.IDReappro = r.IDReappro and lr.IDPRoduit = a.IDProduit\n"
                      + "and a.IDFournisseur = f.IDFournisseur "
                      + "and f.Nom = ? and r.DateApprovisionnement= ?\n"
                      + "order by r.DateApprovisionnement";
            
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);            
            prepStat.setString(1,fourn.getNom());
            java.sql.Date sqlDateR = new java.sql.Date(dateR.getTimeInMillis());
            prepStat.setDate(2,sqlDateR);
            ResultSet donnees = prepStat.executeQuery();
            
                 //Recuperation des donnees
                 while (donnees.next( )){
                      Reappro reap = new Reappro (donnees.getInt("IDReappro"),
                                                  dateR,
                                                  donnees.getString("Etat"),
                                                  new Fournisseur(donnees.getString("Nom")));
                     
                                        
                      note = donnees.getString("NoteReappro");
                      if (donnees.wasNull()== false){
                            reap.setNote(note);
                      }                                         
                      listeReapRech.add(reap);
                 }
        }
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return listeReapRech;    
    }  
}
