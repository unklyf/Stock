package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;


public class RechercheDBAccess {
    
    //LISTE NOMS DES FOURNISSEUR    
     public ArrayList <Fournisseur> getFournisseur() throws  BdErreur, NoIdentification{   
         
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
    


    public ArrayList <Article> getArticleCat(String typeArt, Categorie cat) throws  BdErreur, NoIdentification{

        ArrayList <Article> listeArticle= new ArrayList <Article> ();
        String  cadeau;
        double  prixC;
        
        try {  
                 String req = "select * from Article where TypeA = ? AND IDCategorie = ? ";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1,typeArt);
                 prepStat.setInt(2,this.getIDCat(cat.getNom()));
                 ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                     Article art = new Article  (donnees.getString("Libelle"),
                                                 donnees.getString("TypeA"),
                                                 donnees.getString("Description"),
                                                 donnees.getInt("Qte"),
                                                 donnees.getDouble("PrixMarchandise")
                                                 );

                      cadeau = donnees.getString("Cadeau");
                      if (donnees.wasNull()== false){
                            art.setCadeau(cadeau);
                      }
                      
                      prixC = donnees.getDouble("PrixConsigne");
                      if (donnees.wasNull()== false){
                            art.setPrixC(prixC);
                       }
                      
                      listeArticle.add(art);
                 }    
         }
            
         catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
    return listeArticle;
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