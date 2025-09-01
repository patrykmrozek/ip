import java.util.List;

public class UserInterface {


    /*    MENU    */


    public void printMenuIntro() {
        String ZORO_LOGO =
            "╔═════════════════════════════════════╗\n" +
            "║  ███████╗ ██████╗ ██████╗  ██████╗  ║\n" +
            "║  ╚══███╔╝██╔═══██╗██╔══██╗██╔═══██╗ ║\n" +
            "║    ███╔╝ ██║   ██║██████╔╝██║   ██║ ║\n" +
            "║   ███╔╝  ██║   ██║██╔══██╗██║   ██║ ║\n" +
            "║  ███████╗╚██████╔╝██║  ██║╚██████╔  ║\n" +
            "║  ╚══════╝ ╚═════╝ ╚═╝  ╚═╝ ╚═════╝  ║\n" +
            "╚═════════════════════════════════════╝";
        System.out.println(ZORO_LOGO);
        String name = "Zoro";
        System.out.println("________________________");
        System.out.println("Hello, I'm " + name + " - I think I'm lost..");
        System.out.println("What can I do for you?");
        System.out.println(
            "1: echo\n" +
            "2: task\n" +
            "More features coming soon!\n" +
            "Type \"bye\" or \"exit\" to exit"
        );
        System.out.println("________________________");
    }


    /*    ECHO    */


    public void printEchoInstruction() {
        System.out.println(
            "Echo activated!\n" +
            "Type something and I will echo it!\n" +
            "Type \"bye\" to exit!"
        );
    }

    public void printEchoMesssage(String userInput) {
        System.out.println(userInput);
    }


    /*    TASK    */


    public void printTaskInstruction() {
        System.out.println(
            "a) todo [task]\n" +
            "b) deadline [task] /by [deadline_day]\n" +
            "c) event [event] /from [startTime] /to [endTime]\n" +
            "list (lists your tasks)\n" +
            "mark [task_name] (mark done/undone)\n"
        );
    }

    public void printValidInputTodo() {
        System.out.println("Format: todo [task]");
    }

    public void printValidInputMark() {
        System.out.println("Format: mark [task_index]");
    }

    public void printValidInputDeadline() {
        System.out.println("Format: deadline [task] /by [deadline_day]");
    }

    public void printValidInputEvent() {
        System.out.println("Format: event [event] /from [startTime] /to [endTime]");
    }

    public void printTaskMarked(String userInput) {
        System.out.println("Task " + userInput + " has been marked as done!");
    }

   public void printTaskAdded(Task task) {
        System.out.println(task.toString());

   }

    public void printTaskUnmarked(String userInput) {
        System.out.println("Task " + userInput + " has been unmarked!");
    }

    public void printTaskList(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
        }

        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ". " + tasks.get(i).toString());
        }
    }

    /*    GENERAL    */


    public void printGoodbye() {
        System.out.println("See ya!");
    }

    public void printInvalidInput() {
        System.out.println("INVALID INPUT!");
    }

    public void printValidationError(String errorMessage) {
        System.out.println("ERROR!!!!!!!!!\n" + errorMessage);
    }



}
