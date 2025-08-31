import java.util.Scanner;

public class Zoro {

    private static UserInterface ui;

    public Zoro() {
        this.ui = new UserInterface();
    }

    //============================================
    //          STATE IMPLEMEMTATION
    //============================================

    /**enum to keep track of state**/
    public enum State {
        MENU,
        ECHO,
        LIST,
        EXIT
    }

    protected static State ZoroState = State.MENU;
    private static final Scanner scanner = new Scanner(System.in);


    public void run() { //the only function that has to be run in main
        while (ZoroState != State.EXIT) {
            handleState(ZoroState);
        }
    }

    public static void handleState(State state) {
        switch (state) {
        case MENU:
            menu();
            break;
        case ECHO:
            echo();
            break;
        case LIST:
            storeList();
            break;
        default:
            ZoroState = State.MENU;
            break;
    }
    }


    //============================================
    //          MAIN PUBLIC FUNCTIONS
    //============================================


    public static void menu() {
        ui.printMenuIntro();
        String user_input = scanner.nextLine().trim().toLowerCase();
        switch (user_input) {
        case "echo":
        case "1":
            ZoroState = State.ECHO;
            break;
        case "list":
        case "2":
        case "store list":
            ZoroState = State.LIST;
            break;
        case "exit":
        case "bye":
            System.out.println("See ya!");
            ZoroState = State.EXIT;
            break;
        default:
            System.out.println("Invalid input");
        }

    }

    public static void echo() {
        ui.printEchoInstructions();
        while (ZoroState ==  State.ECHO) {
            String user_input = scanner.nextLine();
            switch (user_input) {
            case "bye":
                ui.printGoodbye();
                ZoroState = State.EXIT;
                break;
            case "menu":
                ZoroState = State.MENU;
                break;
            default:
                System.out.println(user_input);
            }
        }
    }

    public static void storeList() {
        ui.printTaskInstructions();
        Task[] task_list = new Task[100];
        int task_list_index = 0;
        while (ZoroState == State.LIST) {
            String user_input = scanner.nextLine();
            switch (user_input.toLowerCase().split(" ")[0]) {
            case "list":
                _printList(task_list, task_list_index);
                break;
            case "mark":
                _markTask(task_list, task_list_index, user_input);
                break;
            case "menu":
                ZoroState = State.MENU;
                break;
            case "bye":
                ui.printGoodbye();
                ZoroState = State.EXIT;
                break;
                default:
                    _addTaskToList(task_list, user_input, task_list_index);
                    task_list_index++;
            }
        }
        ui.printGoodbye();
    }


    //============================================
    //         PRIVATE HELPER FUNCTIONS
    //============================================




    private static void _addTaskToList(Task[] task_list, String user_input, int task_list_index) {
        Task user_task = new Task(user_input); //create task with user desc
        task_list[task_list_index] = user_task; //add task to task_list at task_index
        System.out.println("Added {" + user_input + "} to your list");
    }

    private static void _printList(Task[] task_list, int task_list_index) {
        for (int i=0; i<task_list_index; i++) {
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
        if (!task_list[mark_idx].isDone()) {
            System.out.println("Task " + user_input + " has been marked as done!");
        } else {
            System.out.println("Task " + user_input + " has been unmarked!");
        }
        task_list[mark_idx].setDone();

    }



    public static void main(String[] args) {
        Zoro zoro = new Zoro();
        zoro.run();
    }
}
