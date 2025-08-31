import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks; //initialize to a List so that it works flexibly with any 'list'

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
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

   public void processTodoCommand(String user_input, UserInterface ui) {
        String description = getTaskSubstring(user_input);
        if (description.trim().isEmpty()) {
            ui.printUserInputLengthError();
        }

       Task task = new Task(description);
       addTask(task);
       ui.printTaskAdded(task);
   }


   public void processDeadlineCommand(String user_input, UserInterface ui) {
       String[] args = user_input.split(" ");
       List<String> argsList = Arrays.asList(args);

       if (args.length < 2) {
           ui.printUserInputLengthError();
           return;
       }

       Deadline deadline = null;
       //i=1 so that it skips 'deadline'
       for (int i=1; i<argsList.size(); i++) {
           if (argsList.get(i).equals("/by")) {
               //from /by - creates a sublist of the remaining elements and casts to strin separated by space
               deadline = new Deadline(
                       String.join(" ", argsList.subList(1, i)), //string before /by
                       String.join(" ", argsList.subList(i+1, argsList.size())) //string after /by
               );
               break;
           }
       }
       if (deadline != null) {
           ui.printDeadlineAdded(deadline);
       } else {
           ui.printDeadlineError();
       }
   }

   public void processEventCommand(String user_task, UserInterface ui) {
       String[] args = user_task.split(" ");
       List<String> argsList = Arrays.asList(args);

       if (args.length < 1) {
           ui.printUserInputLengthError();
       }
   }

   private boolean  isValidMark(int index) {
       return (index < tasks.size() && index >= 0);
   }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public String getTaskSubstring(String user_input) {
        return user_input.substring(user_input.split(" ")[0].length()+1); //skips the keyword
    }

}
