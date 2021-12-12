package com.fm.view;

import com.fm.controller.SearchPlayerController;
import com.fm.game.SearchCondition;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchPlayerActionListener implements ActionListener {
    private JTextField[] searchTermTextFields;
    private SearchPlayerController controller;

    public SearchPlayerActionListener(JTextField[] searchTermTextFields, SearchPlayerController controller) {
        super();
        this.searchTermTextFields = searchTermTextFields;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // your code here
        List<SearchCondition> searchConditions = new ArrayList<>();
        for(JTextField textField : searchTermTextFields){
            if(textField.getText().compareTo("") != 0){
                searchConditions.add(new SearchCondition(textField.getName(), textField.getText()));
            }
        }
        controller.searchPlayer(searchConditions);
    }
}