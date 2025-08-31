public class Zoro {

    private State ZoroState;
    private StateHandler stateHandler;

    public Zoro() {
        UserInterface ui = new UserInterface();
        TaskManager taskManager = new TaskManager();
        InputHandler inputHandler = new InputHandler();

        this.stateHandler = new StateHandler(ui, taskManager, inputHandler);
        this.ZoroState = State.MENU;
    }

    /**enum to keep track of state**/
    public enum State {
        MENU,
        ECHO,
        TASK_LIST,
        EXIT
    } //decided to keep this in Zoro rather than StateHandler


    public void run() { //the only function that has to be run in main
        while (ZoroState != State.EXIT) {
            ZoroState = handleState(ZoroState);
        }
    }

    private State handleState(State state) {
        switch (state) {
        case MENU:
            return stateHandler.handleMenu();
        case ECHO:
            return stateHandler.handleEcho();
        case TASK_LIST:
            return stateHandler.handleTaskList();
        default:
            return State.MENU;
        }
    }

    public static void main(String[] args) {
        Zoro zoro = new Zoro();
        zoro.run();
    }
}
