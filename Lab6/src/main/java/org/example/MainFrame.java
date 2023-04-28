package org.example;
import javax.swing.*;

import java.awt.Container;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    public MainFrame() {
        super("My Drawing Application");
        init();
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);canvas = new DrawingPanel(this);
        add(canvas, CENTER);
        add(controlPanel, SOUTH);
        add(configPanel, NORTH);
        pack();
    }
}

