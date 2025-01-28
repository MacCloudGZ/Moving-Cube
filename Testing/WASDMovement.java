package Testing;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class WASDMovement {
    public static void main(String[] args) {
        JFrame frame = new JFrame("WASD Movement");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout()); // Center the container in the frame

        // Container Panel to mimic "div" in HTML+-
        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(400, 200)); // Restrict size to 400x200
        container.setLayout(new BorderLayout());
        container.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional: Border for clarity

        // Create output panel (top 5%)
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        JLabel outputLabel = new JLabel("Press W, A, S, or D", SwingConstants.NORTH_EAST);
        outputPanel.add(outputLabel, BorderLayout.CENTER);
        outputPanel.setPreferredSize(new Dimension(400, 10)); // 5% of the container height
        outputPanel.setBackground(Color.LIGHT_GRAY); // Optional: To distinguish sections

        // Create action panel (remaining 95%)
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        JLabel actionLabel = new JLabel("Action Frame (Add more functionality here)", SwingConstants.CENTER);
        actionPanel.add(actionLabel, BorderLayout.CENTER);
        actionPanel.setBackground(Color.WHITE); // Optional: To distinguish sections

        // Add panels to the container
        container.add(outputPanel, BorderLayout.NORTH);
        container.add(actionPanel, BorderLayout.CENTER);

        // Add KeyListener for WASD movement
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                String output; // Movement indicator
                output = switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> "Arrow up";
                    case KeyEvent.VK_S -> "Arrow Down";
                    case KeyEvent.VK_A -> "Arrow Left";
                    case KeyEvent.VK_D -> "Arrow right";
                    default -> "Invalid key. Use W, A, S, or D.";
                };
                outputLabel.setText(output); // Update the output label
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Optionally handle key release
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not used here
            }
        });

        // Add container to the frame
        frame.add(container);
        frame.setVisible(true);
    }
}
