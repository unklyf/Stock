package packageView;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Apparence tableau listing article
 *
 * @author BELLENGER JORDAN/SCHMITZ LOIC
 */
public class JTableRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Récupérer composant
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        //Modification apparence cellule
        this.setForeground(Color.white);
        Object o = table.getValueAt(row, 3);
        if (o != null && component instanceof JLabel && column == 3) {
            JLabel label = (JLabel) component;
            //Rouge si Qte <20
            if (Integer.parseInt(label.getText()) < 20) {
                Color red = new Color(255, 0, 0);
                label.setBackground(red);
            } else {
                //Sinon vert
                Color green = new Color(51, 153, 51);
                label.setBackground(green);
            }


        }

        return this;
    }
}
