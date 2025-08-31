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

    //instead of creating a state for each task - TASK is the state and ttodo, deadline, event are like substates
    //that live within the main TASK state - hence why I'm leaving them as private methods which are only going to be
    //called here by handleTask
    public Zoro.State handleTask() {
        ui.printTaskInstruction();
        while (true) {
            String user_input = inputHandler.getUserInput();
            String user_command = user_input.split(" ")[0];
            switch (user_command) {
                case "todo":
                case "a":
                    handleTodo(user_input);
                    break;
                case "deadline":
                case "b":
                    handleDeadline(user_input);
                    break;
                case "event":
                case "c":
                    handleEvent(user_input);
                    break;
                case "list":
                    ui.printTaskList(taskManager.getTasks());
                    break;
                case "mark":
                    taskManager.processMarkCommand(user_input, ui);
                    break;
                case "menu":
                case "back":
                case "return":
                case "zoro":
                    return Zoro.State.MENU;
                case "bye":
                    ui.printGoodbye();
                    return Zoro.State.EXIT;
            }
        }
    }

    private void handleTodo(String user_input) {
        String user_task = taskManager.getTodoSubstring(user_input);
        taskManager.addTaskToList(user_task);
        ui.printTaskAdded(user_task);
    }

    private void handleDeadline(String user_input) {

    }

    private void handleEvent(String user_input) {

    }
}
