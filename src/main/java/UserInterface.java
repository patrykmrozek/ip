public class UserInterface {
    public void printIntroMenu() {
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

    public void printInstructionEcho() {
        System.out.println(
            "Echo activated!\n" +
            "Type something and I will echo it!\n" +
            "Type \"bye\" to exit!"
        );
    }

    public void printInstructionTask() {
        System.out.println(
            "Storing a list for you!\n" +
            "Type something and I will store it.\n" +
            "Type \"list\" to see what you stored\n" +
            "Type \"mark [x]\" and I will mark/unmark the task at index [x].\n" +
            "Type \"bye\" to exit!"
        );
    }

    public void printGoodbye() {
        System.out.println("See ya!");
    }


}
