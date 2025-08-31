import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoro {

    private UserInterface ui;
    private TaskManager taskManager;
    private State ZoroState;
    private InputHandler inputHandler;

    public Zoro() {
        this.ui = new UserInterface();
        this.taskManager = new TaskManager();
        this.ZoroState = State.MENU;
        this.inputHandler = new InputHandler();
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

    public void run() { //the only function that has to be run in main
        while (ZoroState != State.EXIT) {
            handleState(ZoroState);
        }
    }

    private void handleState(State state) {
        switch (state) {
        case MENU:
            handleMenu();
            break;
        case ECHO:
            handleEcho();
            break;
        case LIST:
            handleTaskList();
            break;
        default:
            ZoroState = State.MENU;
            break;
    }
    }


    private void handleMenu() {
        ui.printMenuIntro();
        String user_input = inputHandler.getUserInput();
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
            ui.printGoodbye();
            ZoroState = State.EXIT;
            break;
        default:
            ui.printInvalidInput();
        }

    }

    private void handleEcho() {
        ui.printEchoInstruction();
        while (ZoroState ==  State.ECHO) {
            String user_input = inputHandler.getUserInput();
            switch (user_input) {
            case "bye":
                ui.printGoodbye();
                ZoroState = State.EXIT;
                break;
            case "menu":
                ZoroState = State.MENU;
                break;
            default:
                ui.printEchoMesssage(user_input);
            }
        }
    }

    public void handleTaskList() {
        ui.printTaskInstruction();
        while (ZoroState == State.LIST) {
            String user_input = inputHandler.getUserInput();
            String user_command = user_input.split(" ")[0];
            switch (user_command) {
            case "list":
                ui.printTaskList(taskManager.getTasks());
                break;
            case "mark":
                taskManager.processMarkCommand(user_input, ui);
                break;
            case "menu":
                ZoroState = State.MENU;
                break;
            case "bye":
                ui.printGoodbye();
                ZoroState = State.EXIT;
                break;
            default:
                taskManager.addTaskToList(user_input);
                ui.printTaskAdded(user_input);
                break;
            }
        }
    }


    public static void main(String[] args) {
        Zoro zoro = new Zoro();
        zoro.run();
    }
}
