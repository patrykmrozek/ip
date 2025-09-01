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

    //TTODO
    public void processTodoCommand(String user_input, UserInterface ui) {
        Validator.ValidationResult validation = Validator.validateTodoCommand(user_input);

        if (!validation.isValid()) {
            ui.printValidationError(validation.getErrorMessage());
            ui.printValidInputTodo();
            return;
        }

        String description = getTaskSubstring(user_input);
        if (description.trim().isEmpty()) {
            ui.printUserInputLengthError();
        }

        Task task = new Task(description);
        addTask(task);
        ui.printTaskAdded(task);
    }

    //MARK
   public void processMarkCommand(String user_input, UserInterface ui) {
       Validator.ValidationResult validation = Validator.validateMarkCommand(user_input, tasks);

       if (!validation.isValid()) {
           ui.printValidationError(validation.getErrorMessage());
           ui.printValidInputMark();
           return;
       }

        String[] args = user_input.split(" ");

        int index = Integer.parseInt(args[1]); //get the index of the task the user wants to mark
        tasks.get(index).toggleDone();
        if  (tasks.get(index).isDone()) {
            ui.printTaskMarked(tasks.get(index).getDescription());
        } else {
            ui.printTaskUnmarked(tasks.get(index).getDescription());
            }
   }

   //DEADLINE
   public void processDeadlineCommand(String user_input, UserInterface ui) {
        Validator.ValidationResult validation = Validator.validateDeadlineCommand(user_input);

       if(!validation.isValid()) {
           ui.printValidationError(validation.getErrorMessage());
           ui.printValidInputDeadline();
           return;
       }

       String[] args = user_input.split(" ");
       List<String> argsList = Arrays.asList(args);

       //i=1 so that it skips 'deadline'
       int by_index = -10;
       for (int i=1; i<argsList.size(); i++) {
           if (argsList.get(i).equals("/by")) {
               by_index = i;
               break;
           }
       }

       Deadline deadline = new Deadline(
               String.join(" ", argsList.subList(1, by_index)), //string before /by
               String.join(" ", argsList.subList(by_index + 1, argsList.size())) //string after /by
       );

       addTask(deadline);
       ui.printTaskAdded(deadline);
   }

   //EVENT
   public void processEventCommand(String user_input, UserInterface ui) {
        Validator.ValidationResult validation = Validator.validateEventCommand(user_input);

        if (!validation.isValid()) {
           ui.printValidationError(validation.getErrorMessage());
           ui.printValidInputEvent();
           return;
        }

       String[] args = user_input.split(" ");
       List<String> argsList = Arrays.asList(args);

       int from_index = -10;
       int to_index = -10;

       //find the index's of the /ffrom and /to
       for (int i=1; i<argsList.size(); i++) {
           if (argsList.get(i).equals("/from")) {
               from_index = i;
           } else if (argsList.get(i).equals("/to")) {
               to_index = i;
           }
       }
       Event event = new Event(
               String.join(" ", argsList.subList(1, from_index)),
               String.join(" ", argsList.subList(from_index+1, to_index)),
               String.join(" ", argsList.subList(to_index+1, argsList.size()))
       );

       addTask(event);
       ui.printTaskAdded(event);
   }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public String getTaskSubstring(String user_input) {
        return user_input.substring(user_input.split(" ")[0].length()+1); //skips the keyword
    }

}
