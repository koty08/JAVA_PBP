package com.fm.view;

import com.fm.controller.SearchPlayerController;
import com.fm.model.SearchPlayerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SearchPlayerView extends JFrame {
    private JTextField nameField;
    private JTextField clubField;
    private JTextField posField;
    private JTextField nationField;
    private JButton createButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JTable table;
    private JLabel name;
    private JLabel club;
    private JLabel position;
    private JLabel nationality;
    public SearchPlayerView(SearchPlayerController controller, SearchPlayerModel model){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;

        name = new JLabel("name");
        club = new JLabel("club");
        position = new JLabel("position");
        nationality = new JLabel("nationality");
        nameField = new JTextField(30);
        nameField.setName("name");
        clubField = new JTextField(30);
        clubField.setName("club");
        posField = new JTextField(30);
        posField.setName("position");
        nationField = new JTextField(30);
        nationField.setName("nationality");

        searchButton = new JButton("Search");
        searchButton.setName("Search");
        JTextField[] textFields = {nameField,clubField,posField,nationField};
        SearchPlayerActionListener listener = new SearchPlayerActionListener(textFields, controller);
        searchButton.addActionListener(listener);

        JDialog dialog = new CreatePlayerDialog(controller);
        createButton = new JButton("Create");
        createButton.setName("Create");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });

        DeletePlayerActionListener listener1 = new DeletePlayerActionListener(table, controller);
        deleteButton = new JButton("Delete");
        deleteButton.setName("Delete");
        deleteButton.addActionListener(listener1);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 2));
        panel1.add(name);
        panel1.add(nameField);
        panel1.add(club);
        panel1.add(clubField);
        panel1.add(position);
        panel1.add(posField);
        panel1.add(nationality);
        panel1.add(nationField);
        panel1.add(new JLabel());
        JPanel panel2 = new JPanel();
        panel2.add(createButton);
        panel2.add(deleteButton);
        panel2.add(searchButton);

        JTable table = new JTable();
        table.setModel(model);
        table.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(table);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        add(panel1, gbc);
        gbc.gridy = 1;
        add(panel2, gbc);
        gbc.gridy = 2;
        gbc.gridheight = 3;
        add(scrollPane, gbc);
    }
}
