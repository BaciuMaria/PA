package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    private int radius;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                a = e.getX(); b = e.getY();
                radius = 50 + (int) (100 * Math.random());
                repaint();
            }
        });
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }
    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }
    private void createVertices() {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }
    private void drawLines() {
        for (int i = 0; i < x.length - 1; i++) {
            if (Math.random() < edgeProbability) {
                graphics.drawLine(x[i], y[i], x[i+1], y[i+1]);
            }
        }
    }
    private void drawVertices() {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        graphics.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 2, y[i] - 2, 4, 4);
        }
    }
    @Override
    public void update(Graphics g) { }
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}