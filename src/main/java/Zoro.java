import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zoro {
    public enum State { //enum to keep track of state
        MENU,
        ECHO,
        LIST,
        EXIT
    }

    protected static State ZoroState = State.MENU;

    public static void menu() {
        _printIntro();
    }

    private static void _printIntro() {
        System.out.println("ZZZZZ  OOOOO  RRRRR  OOOOO  ");
        System.out.println("   Z   O   O  R   R  O   O  ");
        System.out.println("  Z    O   O  RRRRR  O   O  ");
        System.out.println(" Z     O   O  R  R   O   O  ");
        System.out.println("ZZZZZ  OOOOO  R   R  OOOOO ");
        String name = "Zoro";
        System.out.println("________________________");
        System.out.println("Hello, I'm " + name + " - I think I'm lost..");
        System.out.println("What can I do for you?");
        System.out.println("1: echo\n2: store list\nmore features coming soon!");
        System.out.println("________________________\n");
    }

    public static void echo(Scanner scanner, String user_input) {
        System.out.println("Echo activated!\nType something and I will echo it!\nType \"bye\" to exit!");
        user_input = scanner.nextLine();
        while (!(user_input.toLowerCase().equals("bye"))) {
            System.out.println(user_input);
            user_input = scanner.nextLine();
        }
        System.out.println("Goodbye - see you soon");
        ;
    }

    private static void _addTaskToList(Task[] task_list, String user_input, int task_list_index) {
        Task user_task = new Task(user_input); //create task with user desc
        task_list[task_list_index] = user_task; //add task to task_list at task_index
        System.out.println("Added {" + user_input + "} to your list");
    }

    private static void _printList(Task[] task_list, int task_list_index) {
        for (int i = 0; i < task_list_index; i++) {
            if (task_list[i].isDone()) {
                System.out.println(i + "." + "[X]" + task_list[i].getDescription());
            } else {
                System.out.println(i + "." + "[ ]" + task_list[i].getDescription());
            }
        }
    }

    private static void _markTask(Task[] task_list, int task_list_index, String user_input) {
        int mark_idx = Integer.parseInt(user_input.split(" ")[1]);
        if (mark_idx < 0 || mark_idx > task_list_index) {
            System.out.println("Invalid task ID");
            return;
        }
        //if the user types "mark 5" - split the string into ["mark", "5"] on the space " "
        //cast the second item, in this case "5" to int and use it as index into task_list to set task to done
        if (task_list[mark_idx].setDone()) {
            System.out.println("Task " + user_input + " has been marked as done!");
        } else {
           System.out.println("Task " + user_input + " has been unmarked!");
        }

    }

    public static void storeList(Scanner scanner, String user_input) {
       System.out.println("Storing a list for you!\nType something and I will store it.\nType \"list\" to see what you stored\nType \"mark [x]\" and I will mark/unmark the task at index [x].\nType \"bye\" to exit!");
        Task[] task_list = new Task[100];
        int task_list_index = 0;
        user_input = scanner.nextLine();
        while (!(user_input.toLowerCase().equals("bye"))) {
            switch (user_input.toLowerCase().split(" ")[0]) {
                case "list":
                    _printList(task_list, task_list_index);
                    user_input = scanner.nextLine();
                    break;
                case "mark":
                    _markTask(task_list, task_list_index, user_input);
                    user_input = scanner.nextLine();
                    break;
                case "back":
                    ZoroState = State.MENU;
                    handleState(ZoroState, scanner, user_input);
                    break;
                default:
                    _addTaskToList(task_list, user_input, task_list_index);
                    task_list_index++;
                    user_input = scanner.nextLine();
            }
        }
        System.out.println("Goodbye! - see you soon");
    }

    public static void handleState(State state, Scanner scanner, String user_input) {
        switch (state) {
            case MENU:
                menu();
                break;
            case ECHO:
                echo(scanner, user_input);
                break;
            case LIST:
                storeList(scanner, user_input);
                break;
            default:
                menu();
                break;
        }
    }


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String user_input = scanner.nextLine();
            if (user_input.toLowerCase().split(" ")[0].equals("echo")) {
                ZoroState = State.ECHO;
            } else if (user_input.toLowerCase().replace(" ", "").equals("storelist")) {
                ZoroState = State.LIST;
            }
            handleState(ZoroState, scanner, user_input);
        }
    }
}
