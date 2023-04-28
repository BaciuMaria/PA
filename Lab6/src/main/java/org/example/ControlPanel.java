package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.BorderLayout.*;

public class ControlPanel extends JPanel{
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        add(exitBtn);
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveGame);
        loadBtn.addActionListener(this::loadGame);
        resetBtn.addActionListener(this::resetGame);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    private void saveGame(ActionEvent e) {
    }
    private void loadGame(ActionEvent e) {
    }
    private void resetGame(ActionEvent e){
    }
}
