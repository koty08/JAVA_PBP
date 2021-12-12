package com.fm.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ClientView extends JPanel implements ActionListener {
    private JTextField textField;
    private JButton button;
    private JTextArea textArea;
    private Task task;

    public ClientView(){
        super(new BorderLayout());
        button = new JButton("전송");
        button.addActionListener(this);
        textField = new JTextField(20);
        textArea = new JTextArea(5, 20);
        textArea.setMargin(new Insets(5,5,5,5));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        JPanel panel = new JPanel();
        panel.add(textField); panel.add(button);
        add(panel, BorderLayout.PAGE_START);
        add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String line = textField.getText();
        task = new Task(line);
        task.execute();
        try {
            String ret = task.get().toString();
            textArea.setText(ret);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
