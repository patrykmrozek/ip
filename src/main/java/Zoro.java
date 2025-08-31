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

    /**enum to keep track of state**/
    public enum State {
        MENU,
        ECHO,
        TASK,
        EXIT
    } //decided to keep this in Zoro rather than StateHandler


    public void run() {//the only function that has to be run in main
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
