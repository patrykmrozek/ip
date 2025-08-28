import java.util.Scanner;

public class Zoro {
    private static void printIntro() {
        System.out.println("ZZZZZ  OOOOO  RRRRR  OOOOO  ");
        System.out.println("   Z   O   O  R   R  O   O  ");
        System.out.println("  Z    O   O  RRRRR  O   O  ");
        System.out.println(" Z     O   O  R  R   O   O  ");
        System.out.println("ZZZZZ  OOOOO  R   R  OOOOO ");
        String name = "Zoro";
        System.out.println("________________________");
        System.out.println("Hello from, I'm " + name + " - I think I'm lost..");
        System.out.println("What can I do for you?");
        System.out.println("1: echo\n2: store list\nmore features coming soon!");
        System.out.println("________________________\n");

    }

    public static void echo(Scanner scanner, String userInput) {
        System.out.println("Echo activated!\nType something and I will echo it!\nType \"bye\" to exit!");
        userInput = scanner.nextLine();
        while (!(userInput.toLowerCase().equals("bye"))) {
            System.out.println(userInput);
            userInput = scanner.nextLine();
        }
        System.out.println("Goodbye - see you soon");
    }

    public static void storeList(Scanner scanner, String userInput) {
       System.out.println("Storing a list for you!\nType something and I will store it!\nType \"list\" to see what you stored!");
        String[] user_list = new String[100];
        int user_list_index = 0;
        userInput = scanner.nextLine();
        while (!(userInput.toLowerCase().equals("list"))) {
            user_list[user_list_index] = userInput;
            user_list_index++;
            System.out.println("Added {" + userInput + "} to your list");
            userInput = scanner.nextLine();
        }
        for (int i = 0; i < user_list_index; i++) {
            System.out.println(i + ":" + user_list[i]);
        }
    }
    public static void main(String[] args) {
        printIntro();
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput = scanner.nextLine();
            if (userInput.toLowerCase().equals("echo")) {
                echo(scanner, userInput);
            } else if (userInput.toLowerCase().replace(" ", "").equals("storelist")) {
                storeList(scanner, userInput);
            }
        }
    }
}
