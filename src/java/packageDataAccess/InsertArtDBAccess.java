package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;


public class InsertArtDBAccess {
    
    private ArrayList <String> tabFournDB, tabCatDB;
    private String nomFourn,nomCat;
            
    public void  addArticle (Article nouvArt) throws BdErreur,NoIdentification{
        
        try { 
            String req = "insert into Article (Libelle,TypeA,Description,Qte,PrixMarchandise,IDFournisseur,IDCategorie)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,nouvArt.getLibelle());
            prepStat.setString(2,nouvArt.getType());
            prepStat.setString(3,nouvArt.getDescription());
            prepStat.setInt(4,nouvArt.getQuantite() );
            prepStat.setDouble(5, nouvArt.getPrixM());
            prepStat.setInt(6, nouvArt.getIDFourn());
            prepStat.setInt(7, nouvArt.getIDCat());
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

    
    public ArrayList <String> getFournArticle() throws  BdErreur, NoIdentification{
       
        tabFournDB =new ArrayList <String> ();
        
        try {  
                 String req = "select Nom from Fournisseur";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     nomFourn = donnees.getString("Nom");
                     tabFournDB.add(nomFourn);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
   
        return tabFournDB;
    }
    
    public ArrayList <String> getCatArticle() throws  BdErreur, NoIdentification{
       
        tabCatDB =new ArrayList <String> ();
        
        try {  
                 String req = "select Libelle from Categorie";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     nomCat = donnees.getString("Libelle");
                     tabCatDB.add(nomCat);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
   
        return tabCatDB;
    }
    
    public Integer rechIDFourn(String libelle) throws  BdErreur, NoIdentification{
        
        Integer iDFourn=0;
        
        try{
            String req = "select IDFournisseur from Fournisseur where Nom = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,libelle);
            ResultSet donnees = prepStat.executeQuery();
            
            while (donnees.next( )){
                     iDFourn = donnees.getInt("IDFournisseur");  
                 }    
            
        }
            
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        
    return iDFourn;
    }
    
    public Integer rechIDCat(String libelle) throws  BdErreur, NoIdentification{
        
        Integer iDCat=0;
        
        try{
            String req = "select IDCategorie from Categorie where Libelle = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,libelle);
            ResultSet donnees = prepStat.executeQuery();
            
            while (donnees.next( )){
                     iDCat = donnees.getInt("IDFournisseur");  
                 }    
            
        }
            
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        
    return iDCat;
    }
}
