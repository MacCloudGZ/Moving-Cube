import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingGame extends JPanel implements ActionListener {

    private int x = 50;
    private int y = 50;
    private int xVelocity = 2;

    public SimpleSwingGame() {
        Timer timer = new Timer(10, this); // Create a timer that fires every 10 milliseconds
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a red circle
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update game state (move the circle)
        x += xVelocity;

        // Bounce off the edges
        if (x + 50 > getWidth() || x < 0) {
            xVelocity = -xVelocity;
        }

        // Repaint the panel
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Swing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new SimpleSwingGame());
        frame.setVisible(true);
    }
}