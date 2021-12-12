import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SwingTextFieldView extends JFrame implements ActionListener {
    JTextArea textArea;
    JTextField textField;

    public SwingTextFieldView(){
        textField = new JTextField(20);
        textField.addActionListener(this);
        JButton button = new JButton("Enter");
        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        button.addActionListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 0.4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(textField, gbc);
        gbc.weightx = 0.1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(button, gbc);
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(scrollPane, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append(textField.getText() + "\n");
        textField.selectAll();

        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
