
package ui.renderer;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRenderDouble extends DefaultTableCellRenderer{
    private DecimalFormat decimalFormat;

    public TableCellRenderDouble(){
        Locale idLocale = new Locale("id");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(idLocale);
        dfs.setCurrencySymbol("Rp. ");
        decimalFormat = new DecimalFormat("\u00A4##,###.##", dfs);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column){
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setText(decimalFormat.format(value));
        return label;
    }        
}
