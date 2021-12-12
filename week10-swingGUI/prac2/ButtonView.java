import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonView extends JFrame {
    public ButtonView() {
        JButton button1 = new JButton("Disable middle button");
        JButton button2 = new JButton("Middle button");
        JButton button3 = new JButton("Enable middle button");
        JPanel panel = new JPanel();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "dialog", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(false);
            }
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        add(panel, BorderLayout.CENTER);
    }
}
