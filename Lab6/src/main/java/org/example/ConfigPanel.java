package org.example;
import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Line probability:");
        linesCombo = new JComboBox(new Double [] {1.0,0.9,0.8,0.7,0.6,0.5});
        createButton = new JButton("Create new game");
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}