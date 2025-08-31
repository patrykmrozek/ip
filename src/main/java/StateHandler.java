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
                case "exit":
                    ui.printGoodbye();
                    return Zoro.State.EXIT;
                case "menu":
                case "return":
                case "back":
                    return Zoro.State.MENU;
                default:
                    ui.printEchoMesssage(user_input);
            }
        }
    }

    //instead of creating a state for each task - TASK is the state and ttodo, deadline, event are like substates
    //that live within the main TASK state - they are all going to be internally processed
    // via the taskManager
    public Zoro.State handleTask() {
        ui.printTaskInstruction();
        while (true) {
            String user_input = inputHandler.getUserInput();
            String user_command = user_input.split(" ")[0];
            switch (user_command) {
                case "todo":
                case "a":
                    taskManager.processTodoCommand(user_input, ui);
                    break;
                case "deadline":
                case "b":
                    taskManager.processDeadlineCommand(user_input, ui);
                    break;
                case "event":
                case "c":
                    taskManager.processEventCommand(user_input, ui);
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

}
