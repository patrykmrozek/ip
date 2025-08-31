import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        return scanner.nextLine().trim();
    }

    public void closeScanner() {
        scanner.close();
    }
}
