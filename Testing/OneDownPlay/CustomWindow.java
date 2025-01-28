import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

public class CustomWindow extends JFrame {

    private int xOffset = 0;
    private int yOffset = 0;

    public CustomWindow() {
        setUndecorated(true); // Remove default decorations
        setSize(400, 300);
        setLocationRelativeTo(null); // Center on screen
        setBackground(new Color(0, 0, 0, 0)); // Transparent background

        // Make the window a rounded rectangle
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));

        // Create a custom title bar (JPanel)
        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.DARK_GRAY);
        titleBar.setLayout(new BorderLayout());

        // Add a title label
        JLabel titleLabel = new JLabel("My Custom Window");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleBar.add(titleLabel, BorderLayout.CENTER);

        // Add a close button (you'd need an image or custom drawing)
        JButton closeButton = new JButton("X");
        closeButton.setBackground(Color.RED);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusable(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        closeButton.addActionListener(e -> System.exit(0)); // Close on click
        titleBar.add(closeButton, BorderLayout.EAST);

        // Make the title bar draggable
        titleBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xOffset = e.getX();
                yOffset = e.getY();
            }
        });

        titleBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getXOnScreen() - xOffset, e.getYOnScreen() - yOffset);
            }
        });

        // Add the title bar to the NORTH of the content pane
        getContentPane().add(titleBar, BorderLayout.NORTH);

        // Add some content to the center
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.LIGHT_GRAY);
        JLabel contentLabel = new JLabel("Window Content");
        contentLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPanel.add(contentLabel);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomWindow();
    }
}