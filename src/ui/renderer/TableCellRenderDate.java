package ui.renderer;

import java.awt.Component;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellRenderDate extends DefaultTableCellRenderer{
    private static final long serialVersionUID = 1L;
    private SimpleDateFormat format;
    public TableCellRenderDate(){
        format = new SimpleDateFormat("dd-MM-yyyy");
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
            boolean hasFocus, int row, int column){
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        if(value != null && value instanceof Date){
            Date date = (Date) value;
            String text = format.format(date);
            label.setText(text);
        }
        return label;
    }
}
