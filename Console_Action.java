import java.util.Scanner;

public class Console_Action {
    public static Scanner playerInput = new Scanner(System.in);
    private static int x_position = 0;
    private static int y_position = 0;
    private static final int x_size = 20;
    private static final int y_size = 10;
    private static final int plusX = x_size / 2; // X position NORTH
    private static final int negX = -1 * plusX; // X position SOUTH
    private static final int plusY = y_size / 2; // Y position WEST
    private static final int negY = -1 * plusY; // Y position EAST

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

    public static void clear() {
        if (System.getProperty("os.name").contains("Windows")) {
            // For Windows
            System.out.print("\033c");
        } else {
            // For Linux/macOS
            System.out.print("\033[H\033[2J"); // ANSI escape code for clearing
            System.out.flush();
        }
    }

    public static void main(String[] args) {
        System.out.println("Use 'w', 's', 'a', 'd' to move, or 'q' to quit.");
        clear();
        while (true) {
            displayPosition();
            System.out.print("Enter a command: ");
            String pos = playerInput.nextLine().trim();

            switch (pos) {
                case "w" -> X_addpos();
                case "s" -> X_delpos();
                case "a" -> Y_addpos();
                case "d" -> Y_delpos();
                case "q" -> {
                    System.out.println("Exiting the game...");
                    return;
                }
                default -> System.out.println("Invalid command. Use 'w', 's', 'a', 'd', or 'q'.");
            }
            clear();
        }
    }
}
