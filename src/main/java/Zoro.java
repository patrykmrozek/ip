import java.util.Scanner;

public class Zoro {
    public static void main(String[] args) {
        String name = "Zoro";
        System.out.println("________________________");
        System.out.println("Hello from, I'm " + name + " - I think I'm lost..");
        System.out.println("What can I do for you?");
        System.out.println("________________________");
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput = scanner.nextLine();
            while (!(userInput.toLowerCase().equals("bye"))) {
                System.out.println(userInput);
                userInput = scanner.nextLine();
            }
            System.out.println("Goodbye - see you soon");
        }
    }
}
