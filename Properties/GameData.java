import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameData extends JFrame implements KeyListener {

    private static int x_position = 0;
    private static int y_position = 0;
    private static final int x_size = 40;
    private static final int y_size = 20;
    private static final int plusX = x_size / 2; // X position NORTH
    private static final int negX = -1 * plusX; // X position SOUTH
    private static final int plusY = y_size / 2; // Y position WEST
    private static final int negY = -1 * plusY; // Y position EAST;

    private AnimationPanel animationPanel;

    public GameData() {
        // Set up the JFrame
        this.setTitle("WASD Movement with Animation");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this); // Add KeyListener to the JFrame

        // Make the JFrame non-resizable
        this.setResizable(false);

        // Add the animation panel
        animationPanel = new AnimationPanel();
        this.add(animationPanel);

        this.setVisible(true);
    }

    public static void X_addpos() {
        if (x_position < plusX) {
            x_position++;
        }
    }

    public static void X_delpos() {
        if (x_position > negX) {
            x_position--;
        }
    }

    public static void Y_addpos() {
        if (y_position < plusY) {
            y_position++;
        }
    }

    public static void Y_delpos() {
        if (y_position > negY) {
            y_position--;
        }
    }

    public static void displayPosition() {
        System.out.println("Current Position: ( X:" + x_position + ", Y:" + y_position + ")");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Get the key code
        int keyCode = e.getKeyCode();
        clear();
        switch (keyCode) {
            case KeyEvent.VK_A -> X_delpos(); // Move up
            case KeyEvent.VK_D -> X_addpos(); // Move down
            case KeyEvent.VK_W -> Y_addpos(); // Move left
            case KeyEvent.VK_S -> Y_delpos(); // Move right
            case KeyEvent.VK_Q -> {
                System.out.println("Exiting the game...");
                System.exit(0); // Quit the program
            }
            case KeyEvent.VK_ESCAPE -> System.out.println("Escape the game...");
            default -> System.out.println("Invalid key. Use 'W', 'S', 'A', 'D', or 'Q'.");
        }
        displayPosition();
        animationPanel.updatePosition(x_position, y_position); // Update the circle position
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used, but must be implemented
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used, but must be implemented
    }

    public static void clear() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.out.print("\033c");
        } else {
            System.out.print("\033[H\033[2J"); // ANSI escape code for clearing
            System.out.flush();
        }
    }

    public static void main(String[] args) {
        System.out.println("Use 'W', 'S', 'A', 'D' to move, or 'Q' to quit.");
        new GameData();
    }

    // Inner class for the animation panel
    class AnimationPanel extends JPanel {
        private static final int GRID_WIDTH = 400; // Width of the movement area
        private static final int GRID_HEIGHT = 200; // Height of the movement area
        private static final int STEP_SIZE = 10;
        private int circleX;
        private int circleY;

        public AnimationPanel() {
            // Initialize circleX and circleY to the center of the grid
            circleX = GRID_WIDTH / 2;
            circleY = GRID_HEIGHT / 2;
        }

        public void updatePosition(int x, int y) {
            // Update the circle's position based on the logical x and y positions,
            // but keep it within the bounds of the grid
            circleX = GRID_WIDTH / 2 + (x * STEP_SIZE);
            circleY = GRID_HEIGHT / 2 - (y * STEP_SIZE);

            // Keep the circle within the grid boundaries
            circleX = Math.max(0, Math.min(circleX, GRID_WIDTH - STEP_SIZE));
            circleY = Math.max(0, Math.min(circleY, GRID_HEIGHT - STEP_SIZE));

            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Calculate the top-left corner of the grid to center it
            int gridX = (((x_position + x_position) * -10) / 2) + 1 + (getWidth() - GRID_WIDTH) / 2;
            int gridY = (((y_position + y_position) * 10) / 2) + 1 + (getHeight() - GRID_HEIGHT) / 2;

            // Draw the grid
            g.setColor(Color.LIGHT_GRAY);
            for (int i = 0; i <= GRID_WIDTH; i += STEP_SIZE) {
                g.drawLine(gridX + i, gridY, gridX + i, gridY + GRID_HEIGHT); // Vertical lines
            }
            for (int i = 0; i <= GRID_HEIGHT; i += STEP_SIZE) {
                g.drawLine(gridX, gridY + i, gridX + GRID_WIDTH, gridY + i); // Horizontal lines
            }

            // Draw the circle relative to the grid's position
            g.setColor(Color.RED);
            g.fillRect(gridX + circleX, gridY + circleY, STEP_SIZE, STEP_SIZE);
        }
    }
}