import javax.swing.*;
import java.awt.event.*;

public class Java_Action extends JFrame implements KeyListener {
    private static int x_position = 0;
    private static int y_position = 0;
    private static final int x_size = 20;
    private static final int y_size = 1;
    private static final int plusX = x_size / 2; // X position NORTH
    private static final int negX = -1 * plusX; // X position SOUTH
    private static final int plusY = y_size / 2; // Y position WEST
    private static final int negY = -1 * plusY; // Y position EAST;

    public Java_Action() {
        this.setTitle("Movement with KeyListener");
        this.setSize(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addKeyListener(this); // Add KeyListener to the JFrame
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
        System.out.println("Current Position: (" + x_position + ", " + y_position + ")");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Get the key code
        int keyCode = e.getKeyCode();
        clear();
        switch (keyCode) {
            case KeyEvent.VK_W -> X_addpos(); // Move up
            case KeyEvent.VK_S -> X_delpos(); // Move down
            case KeyEvent.VK_A -> Y_addpos(); // Move left
            case KeyEvent.VK_D -> Y_delpos(); // Move right
            case KeyEvent.VK_Q -> {
                System.out.println("Exiting the game...");
                System.exit(0); // Quit the program
            }
            default -> System.out.println("Invalid key. Use 'W', 'S', 'A', 'D', or 'Q'.");
        }
        displayPosition();
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
        new Java_Action();
    }
}
