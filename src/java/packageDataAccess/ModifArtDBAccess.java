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


public class ModifArtDBAccess {
        
       private ArrayList<Article> tabArt;  

       public ArrayList<Article> getAllArticle ()throws  BdErreur, NoIdentification{
        
        tabArt = new ArrayList<Article>();
        String  cadeau;
        double  prixC;
       
 
        try{
            String req ="select a.Libelle, a.TypeA, a.Description, a.PrixMarchandise, a.PrixConsigne, a.Cadeau, "
                    + "f.Nom, c.Libelle libCat "
                    + "from Article a, Fournisseur f, Categorie c "
                    + "where a.IDFournisseur = f.IDFournisseur AND a.IDCategorie = c.IDCategorie "
                    + "order by a.Libelle";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                      Article art = new Article (donnees.getString("Libelle"),
                                                 donnees.getString("TypeA"),
                                                 donnees.getString("Description"),
                                                 donnees.getDouble("PrixMarchandise"),
                                                 new Fournisseur (donnees.getString("Nom")),
                                                 new Categorie (donnees.getString("LibCat")));
                     
                     
                    
                      cadeau = donnees.getString("Cadeau");
                      if (donnees.wasNull()== false){
                            art.setCadeau(cadeau);
                      }
                      
                      prixC = donnees.getDouble("PrixConsigne");
                      if (donnees.wasNull()== false){
                            art.setPrixC(prixC);
                       }
                      
                      tabArt.add(art);
                 }
    
        }
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
        return tabArt;
        
    }           
}
