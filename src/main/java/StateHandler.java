public class StateHandler {
    private final UserInterface ui;
    private final TaskManager taskManager;
    private final InputHandler inputHandler;

    public StateHandler(UserInterface ui, TaskManager taskManager, InputHandler inputHandler) {
        this.ui = ui;
        this.taskManager = taskManager;
        this.inputHandler = inputHandler;
    }


    public Zoro.State handleMenu() {
        ui.printMenuIntro();
        String user_input = inputHandler.getUserInput();
        switch (user_input) {
            case "echo":
            case "1":
                return Zoro.State.ECHO;
            case "list":
            case "task":
            case "todo":
            case "2":
            case "store list":
                return Zoro.State.TASK;
            case "exit":
            case "bye":
                ui.printGoodbye();
                return Zoro.State.EXIT;
            default:
                ui.printInvalidInput();
                return Zoro.State.MENU;
        }
    }

    public Zoro.State handleEcho() {
        ui.printEchoInstruction();
        while (true) {
            String user_input = inputHandler.getUserInput();
            switch (user_input) {
                case "bye":
                    ui.printGoodbye();
                    return Zoro.State.EXIT;
                case "menu":
                    return Zoro.State.MENU;
                default:
                    ui.printEchoMesssage(user_input);
            }
        }
    }

    public Zoro.State handleTask() {
        ui.printTaskInstruction();
        while (true) {
            String user_input = inputHandler.getUserInput();
            String user_command = user_input.split(" ")[0];
            switch (user_command) {
                case "todo":
                case "a":
                    return handleTodo();
                case "deadline":
                case "b":
                    return handleDeadline();
                case "event":
                case "c":
                    return handleEvent();
            }
        }
    }

    private Zoro.State handleTodo() {
        ui.printTodoInstruction();
        while (true) {
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
                    return Zoro.State.MENU;
                case "bye":
                    ui.printGoodbye();
                    return Zoro.State.EXIT;
                default:
                    taskManager.addTaskToList(user_input);
                    ui.printTaskAdded(user_input);
                    break;
            }
        }
    }

    private Zoro.State handleDeadline() {
        ui.printDeadlineInstruction();
        while(true) {
            break;
        }
        return null;
    }

    private Zoro.State handleEvent() {
        ui.printEventInstruction();
        while(true) {
            break;
        }
        return null;
    }
}
