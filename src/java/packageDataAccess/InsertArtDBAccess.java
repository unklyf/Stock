package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;


public class InsertArtDBAccess {
    
    private ArrayList <Fournisseur> tabFournDB;
    private ArrayList <Categorie>  tabCatDB;
     
   
    
            
    public void  addArticle (Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur,NoIdentification{
        
        try { 
            String req = "insert into Article (Libelle,TypeA,Description,PrixMarchandise,IDFournisseur,IDCategorie,Cadeau,Qte) values(?,?,?,?,?,?,?,NULL)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            prepStat.setString(1,nouvArt.getLibelle());
            prepStat.setString(2,nouvArt.getType());
            prepStat.setString(3,nouvArt.getDescription());
            prepStat.setDouble(4, nouvArt.getPrixM());
            prepStat.setInt(5, this.getIDFourn(fourn.getNom()));
            prepStat.setInt(6, this.getIDCat(cat.getNom()));
            prepStat.setString(7, nouvArt.getCadeau());
            prepStat.executeUpdate(); 
            
            /*
            req= "update Article set Libelle = ";
            prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.executeUpdate();
             */   
            //Obtenir IDProduit venant d'�tre ins�rer
            ResultSet rs = prepStat.getGeneratedKeys();
            
            while(rs.next()){
                int lastID = rs.getInt(1);
                //Update pour colonne facultative
                if(nouvArt.getPrixC()!=0){
                    req = "update Article set PrixConsigne = ? where IDProduit= ?";
                    prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                    prepStat.setDouble(1,nouvArt.getPrixC());
                    prepStat.setInt(2, lastID);
                    prepStat.executeUpdate();                
                }
                
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
       
       
      
   }

    
    public ArrayList <Fournisseur> getFournArticle() throws  BdErreur, NoIdentification{
       
        tabFournDB =new ArrayList <Fournisseur> ();
        
        try {  
                 String req = "select Nom from Fournisseur";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     Fournisseur nomF = new Fournisseur (donnees.getString("Nom"));
                     tabFournDB.add(nomF);
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
    
    public ArrayList <Categorie> getCatArticle() throws  BdErreur, NoIdentification{
       
        tabCatDB =new ArrayList <Categorie> ();
        
        try {  
                 String req = "select Libelle from Categorie";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     Categorie cat = new Categorie (donnees.getString("Libelle"));
                     tabCatDB.add(cat);
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
    
    public Integer getIDFourn(String nom) throws  BdErreur, NoIdentification{
        
        Integer iDFourn=0;
        
        try{
            String req = "select IDFournisseur from Fournisseur where Nom = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,nom);
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
    
    public Integer getIDCat(String libelle) throws  BdErreur, NoIdentification{
        
        Integer iDCat=0;
        
        try{
            String req = "select IDCategorie from Categorie where Libelle = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,libelle);
            ResultSet donnees = prepStat.executeQuery();
            
            while (donnees.next( )){
                     iDCat = donnees.getInt("IDCategorie");  
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
