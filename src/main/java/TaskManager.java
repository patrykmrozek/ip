import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks; //initialize to a List so that it works flexibly with any 'list'

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTaskToList(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
    }

   public void processMarkCommand(String user_input, UserInterface ui) {
        String[] args = user_input.split(" ");

        if (args.length < 2) { //if user entered less than 2 arguments
            ui.printUserInputLengthError();
            return;
        }

        try {
            int index = Integer.parseInt(args[1]); //get the index of the task the user wants to mark
            if (isValidMark(index)) {
                tasks.get(index).toggleDone();
                if  (tasks.get(index).isDone()) {
                    ui.printTaskMarked(tasks.get(index).getDescription());
                } else {
                    ui.printTaskUnmarked(tasks.get(index).getDescription());
                }
            } else {
                ui.printTaskInvalidID();
            }
        } catch (NumberFormatException e) {
            ui.printTaskInvalidID();
        }
   }

   private boolean  isValidMark(int index) {
       return (index < tasks.size() && index >= 0);
   }


    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

}
