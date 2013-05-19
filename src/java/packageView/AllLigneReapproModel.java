package packageView;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import packageModel.LigneReappro;

/**
 * Remplir une jTable de LigneReappro a partir d'une arrayList
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class AllLigneReapproModel extends AbstractTableModel {

    private ArrayList<String> columnNames = new ArrayList<String>();
    private ArrayList<LigneReappro> contents = new ArrayList<LigneReappro>();

    /**
     * Nommer les colonnes et initialiser contenu table
     *
     * @param lReappro une arrayList de LigneReappro
     * @see ArrayList
     * @see LigneReappro
     */
    public AllLigneReapproModel(ArrayList<LigneReappro> lReappro) {
        contents = lReappro;
        columnNames.add("Libelle");
        columnNames.add("Type");
        columnNames.add("Quantité");
    }

    /**
     * Modifier la quantité article dans la table
     * 
     * @param qte quantité de l'article
     * @param row rangée article souhaité
     * @see Integer
     */ 
    public void setQte(Integer qte, int row) {
        contents.get(row).setQte(qte);
    }

    /**
     * Pour récupérer contenu du tableau
     * 
     * @return une arrayList de LigneReappro
     * @see LigneReappro
     * @see ArrayList
     */
    public ArrayList<LigneReappro> getContents() {
        return contents;
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    @Override
    public Object getValueAt(int row, int col) {
        LigneReappro reap = contents.get(row);


        switch (col) {
            case 0:
                return reap.getArt().getLibelle();
            case 1:
                return reap.getArt().getType();
            case 2:
                return reap.getQte();
            default:
                return null;
        }

    }

    @Override
    public Class getColumnClass(int col) {

        Class c;

        switch (col) {
            case 0:
                c = String.class;
                break;
            case 1:
                c = String.class;
                break;
            case 2:
                c = Integer.class;
                break;
            default:
                c = String.class;
        }
        return c;
    }
}
