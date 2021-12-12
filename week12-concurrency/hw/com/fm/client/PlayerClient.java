package com.fm.client;

import javax.swing.*;

public class PlayerClient {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("HW12");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new ClientView();
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
