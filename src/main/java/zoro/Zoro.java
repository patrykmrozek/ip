package zoro;

import zoro.core.State;
import zoro.ui.UserInterface;
import zoro.ui.InputHandler;
import zoro.core.TaskManager;
import zoro.core.StateHandler;

public class Zoro {

    private State ZoroState;
    private final StateHandler stateHandler;
    private final InputHandler inputHandler;

    public Zoro() {
        UserInterface ui = new UserInterface();
        TaskManager taskManager = new TaskManager();

        this.inputHandler = new InputHandler();
        this.stateHandler = new StateHandler(ui, taskManager, inputHandler);
        this.ZoroState = State.MENU;
    }

    public void run() {
        try {
            while (ZoroState != State.EXIT) {
                ZoroState = handleState(ZoroState);

            }
        } finally {
            inputHandler.closeScanner();
        }
    }

    private State handleState(State state) {
        switch (state) {
        case MENU:
            return stateHandler.handleMenu();
        case ECHO:
            return stateHandler.handleEcho();
        case TASK:
            return stateHandler.handleTask();
        default:
            return State.MENU;
        }
    }

    public static void main(String[] args) {
        Zoro zoro = new Zoro();
        zoro.run();
    }
}
