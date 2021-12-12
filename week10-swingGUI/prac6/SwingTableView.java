import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SwingTableView extends JFrame implements ActionListener {
    JTable table;

    public SwingTableView(DefaultTableModel model){
        Font font = new Font("Serif", Font.PLAIN, 24);
        UIManager.put("Table.font", font);
        table = new JTable();
        table.setModel(model);
        table.setRowHeight(24);
        table.getTableHeader().setFont(font);
        table.setPreferredScrollableViewportSize(new Dimension(800,150));

        JScrollPane scrollPane = new JScrollPane(table);
        final JButton button = new JButton("Info");
        button.setMnemonic(KeyEvent.VK_I);
        button.setAlignmentX(RIGHT_ALIGNMENT);
        button.setFont(font);
        button.addActionListener(this);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(scrollPane);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(0<= table.getSelectedRow()){
            int numCols = table.getColumnCount();
            System.out.print(table.getSelectedRow());
            for(int i =0; i<numCols; i++){
                System.out.print("\t\t\t" + table.getModel().getValueAt(table.getSelectedRow(), i));
            }
            System.out.println();
        }
    }
}
