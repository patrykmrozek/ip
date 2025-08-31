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

    public void printEchoMesssage(String user_input) {
        System.out.println(user_input);
    }


    /*    TASK    */


    public void printTaskInstruction() {
        System.out.println(
            "a) todo [task]\n" +
            "b) deadline [task] /by[deadline_day]\n" +
            "c) event [event] /from[start_time day] /to[end time day]\n" +
            "list (lists your tasks)\n" +
            "mark [task_name] (mark done/undone)\n"
        );
    }

    public void printTaskMarked(String user_input) {
        System.out.println("Task " + user_input + " has been marked as done!");
    }

   public void printTaskAdded(Task task) {
        System.out.println(task.toString());

   }

    public void printTaskUnmarked(String user_input) {
        System.out.println("Task " + user_input + " has been unmarked!");
    }

    public void printTaskInvalidID() {
        System.out.println("INVALID TASK ID");
    }

    public void printTaskList(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
        }
        for (int i=0; i<tasks.size(); i++) {
            if (tasks.get(i).isDone()) {
                System.out.println(i + "." + "[X]" + tasks.get(i).getDescription());
            } else {
                System.out.println(i + "." + "[ ]" + tasks.get(i).getDescription());
            }
        }
    }

    public void printUserInputLengthError() {
        System.out.println("INPUT LENGTH ERROR: Please format like \'mark task_index\'");
    }

    public void printDeadlineAdded(Deadline deadline) {
        System.out.println(deadline.toString());
    }

    public void printDeadlineError() {
        System.out.println("Deadline error!");
    }


    /*    GENERAL    */


    public void printGoodbye() {
        System.out.println("See ya!");
    }

    public void printInvalidInput() {
        System.out.println("INVALID INPUT!");
    }



}
