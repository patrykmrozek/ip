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
            "2: store list\n" +
            "More features coming soon!\n" +
            "Type \"bye\" or \"exit\" to exit"
        );
        System.out.println("________________________\n");
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
            "Storing a list for you!\n" +
            "Type something and I will store it.\n" +
            "Type \"list\" to see what you stored\n" +
            "Type \"mark [x]\" and I will mark/unmark the task at index [x].\n" +
            "Type \"bye\" to exit!"
        );
    }

    public void printTaskMarked(String user_input) {
        System.out.println("Task " + user_input + " has been marked as done!");
    }

    public void printTaskUnmarked(String user_input) {
        System.out.println("Task " + user_input + " has been unmarked!");
    }

    public void printTaskInvalidID() {
        System.out.println("Invalid task ID");
    }

    public void printTaskList(Task[] task_list, int task_list_index) {
        for (int i=0; i<task_list_index; i++) {
            if (task_list[i].isDone()) {
                System.out.println(i + "." + "[X]" + task_list[i].getDescription());
            } else {
                System.out.println(i + "." + "[ ]" + task_list[i].getDescription());
            }
        }
    }


    /*    GENERAL    */


    public void printGoodbye() {
        System.out.println("See ya!");
    }



}
