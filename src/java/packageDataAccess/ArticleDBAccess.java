
package packageDataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import packageException.AddArtException;
import packageException.BdErreur;
import packageException.NoIdentification;
import packageModel.Article;
import packageModel.Categorie;
import packageModel.Fournisseur;
import packageModel.Reappro;


public class ArticleDBAccess {
    
    private ArrayList<Article> tabArt;
    
    public void  addArticle (Article nouvArt, Fournisseur fourn, Categorie cat) throws BdErreur,NoIdentification,AddArtException{
        
        try { 
            String req = "insert into Article (Libelle,TypeA,Description,PrixMarchandise,IDFournisseur,IDCategorie,Cadeau,Qte) values(?,?,?,?,?,?,?,NULL)";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            prepStat.setString(1,nouvArt.getLibelle());
            prepStat.setString(2,nouvArt.getType());
            prepStat.setString(3,nouvArt.getDescription());
            prepStat.setDouble(4, nouvArt.getPrixM());
            prepStat.setInt(5, new FournisseurDBAccess().getIDFourn(fourn.getNom()));
            prepStat.setInt(6, new CategorieDBAccess().getIDCat(cat.getNom()));
            prepStat.setString(7, nouvArt.getCadeau());
            prepStat.executeUpdate(); 
            
               
            //Obtenir IDProduit venant d'être insérer
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
           throw new AddArtException(e.getMessage());
        }
       
       
      
   }
    
    public ArrayList<Article> getAllArticle ()throws  BdErreur, NoIdentification{
        
        tabArt = new ArrayList<Article>();
        String  cadeau;
        double  prixC;

        try{
            String req ="select a.IDProduit, a.Libelle, a.TypeA, a.Description, a.Qte, a.PrixMarchandise, a.PrixConsigne, a.Cadeau, "
                    + "f.Nom, c.Libelle libCat "
                    + "from Article a, Fournisseur f, Categorie c "
                    + "where a.IDFournisseur = f.IDFournisseur AND a.IDCategorie = c.IDCategorie "
                    + "order by a.Libelle";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                      Article art = new Article (donnees.getInt("IDProduit"),
                                                 donnees.getString("Libelle"),
                                                 donnees.getString("TypeA"),
                                                 donnees.getString("Description"),
                                                 donnees.getInt("Qte"),
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
    
    public void modifArticle(Article artNouvVersion, Article artAncVersion) throws BdErreur, NoIdentification{
       
        try{
            String req ="update Article  " +
                        "set    Description = ?," +
                        "       PrixMarchandise = ?, "+
                        "       Cadeau = ? " +
                        "where  IDProduit = ?";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1, artNouvVersion.getDescription());
            prepStat.setDouble(2, artNouvVersion.getPrixM());
            prepStat.setString(3,artNouvVersion.getCadeau());
            prepStat.setInt(4, artNouvVersion.getIdProduit());
            prepStat.executeUpdate();

            //Update du prix consigné uniquement si changé 
            if(artNouvVersion.getPrixC() == 0 && artAncVersion.getPrixC() != 0) {
                    req = "update Article set PrixConsigne = NULL where IDProduit= ?";
                    prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                    prepStat.setInt(1, artNouvVersion.getIdProduit());
                    prepStat.executeUpdate();       
            }      
            else {
                if(artNouvVersion.getPrixC() != artAncVersion.getPrixC()){
                   req = "update Article set PrixConsigne = ? where IDProduit= ?";
                   prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                   prepStat.setDouble(1,artNouvVersion.getPrixC());
                   prepStat.setInt(2, artNouvVersion.getIdProduit());
                   prepStat.executeUpdate();                
                }
            } 
        }
        catch (SQLException e) {  
            throw new BdErreur(e.getMessage());   
        }                   
        catch (NoIdentification e) {
            throw new NoIdentification();
        }
    }
    
    
    
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
    
    
    
    public ArrayList <Article> getArticleCat(String typeArt, Categorie cat) throws  BdErreur, NoIdentification{

        ArrayList <Article> listeArticle= new ArrayList <Article> ();
        String  cadeau;
        double  prixC;
        
        try {  
                 String req = "select Libelle, TypeA, Description, Qte, PrixMarchandise, PrixConsigne, Cadeau "
                         + "from Article "
                         + "where TypeA = ? AND IDCategorie = ? ";
                 PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
                 prepStat.setString(1,typeArt);
                 prepStat.setInt(2,new CategorieDBAccess().getIDCat(cat.getNom()));
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
    
    
    
    public ArrayList<Article> getAllArticleRechCat (String typeArt, Categorie cat)throws  BdErreur, NoIdentification{
        
        tabArt = new ArrayList<Article>();
        String  cadeau;
        double  prixC;

        try{
            String req ="select a.IDProduit, a.Libelle, a.TypeA, a.Description, a.Qte, a.PrixMarchandise, a.PrixConsigne, a.Cadeau, "
                    + "f.Nom, c.Libelle libCat "
                    + "from Article a, Fournisseur f, Categorie c "
                    + "where a.IDFournisseur = f.IDFournisseur AND a.IDCategorie = c.IDCategorie AND a.TypeA = ? AND a.IDCategorie = ? "
                    + "order by a.Libelle";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setString(1,typeArt);
            prepStat.setInt(2,new CategorieDBAccess().getIDCat(cat.getNom()));
            ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                      Article art = new Article (donnees.getInt("IDProduit"),
                                                 donnees.getString("Libelle"),
                                                 donnees.getString("TypeA"),
                                                 donnees.getString("Description"),
                                                 donnees.getInt("Qte"),
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
    
    
    
    public ArrayList<Article> getAllArticleRechFourn (Fournisseur fourn)throws  BdErreur, NoIdentification{
        tabArt = new ArrayList<Article>();
        String  cadeau;
        double  prixC;

        try{
            String req ="select a.IDProduit, a.Libelle, a.TypeA, a.Description, a.Qte, a.PrixMarchandise, a.PrixConsigne, a.Cadeau, "
                    + "f.Nom, c.Libelle libCat "
                    + "from Article a, Fournisseur f, Categorie c "
                    + "where a.IDFournisseur = f.IDFournisseur AND a.IDCategorie = c.IDCategorie AND a.IDFournisseur = ?  "
                    + "order by a.Libelle";
            PreparedStatement prepStat = SingletonConnexion.getInstance().prepareStatement(req);
            prepStat.setInt(1,new FournisseurDBAccess().getIDFourn(fourn.getNom()));
            ResultSet donnees = prepStat.executeQuery();
   
                 while (donnees.next( )){
                      Article art = new Article (donnees.getInt("IDProduit"),
                                                 donnees.getString("Libelle"),
                                                 donnees.getString("TypeA"),
                                                 donnees.getString("Description"),
                                                 donnees.getInt("Qte"),
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
