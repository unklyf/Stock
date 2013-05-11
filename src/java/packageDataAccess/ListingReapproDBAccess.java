package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Fournisseur;
import packageModel.LigneReappro;
import packageModel.Reappro;


public class ListingReapproDBAccess {    
    
    
        //Lister tous les r�appros
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
        
      
        
    //Lister tous les articles (ligne r�appro)
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

    
    //Modifier pour encoder les quantit�s
    public void setQteStock (Reappro reap, LigneReappro lReap)throws  BdErreur, NoIdentification{
       Integer Qte=0;
       Qte = this.getQtePrec(lReap.getArt().getLibelle(),lReap.getArt().getType());
       
       try{
            
            //Cloture du re�appro dans les stocks
            String req ="update Reapprovisionnement set Etat = ?, NoteReappro= ? where iDReappro = ?";  
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,reap.getEtat());
            prepStat.setString(2,reap.getNote());
            prepStat.setInt(3,reap.getiDReappro());
            prepStat.executeUpdate();
            
            //Mis � jour des quantit�s dans les stocks
            req ="update Article set Qte = ? where iDProduit= ?";  
            prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,Qte+ lReap.getQte());
            prepStat.setInt(2,this.getIDArticle(lReap.getArt().getLibelle(),lReap.getArt().getType()));
            prepStat.executeUpdate();
            
    
        }
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
    }
    
    
    //OBTENIR L'ID D'UN ARTICLE 
    //Re�oit : Libelle & type 
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
    
    //OBTENIR QTE ARTICLE PRECEDENT 
    //Re�oit : Libelle & type 
    public Integer getQtePrec(String libelleA, String typeA) throws  BdErreur, NoIdentification{   
         Integer Qte=0;
                 
         try {  
                 String req = "select Qte from Article where Libelle = ? and TypeA = ?";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1, libelleA);
                 prepStat.setString(2, typeA);
                 ResultSet donnees = prepStat.executeQuery(); 
                 while (donnees.next( )){
                     Qte = donnees.getInt("Qte");
                 }
        }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return Qte;
   }
}
