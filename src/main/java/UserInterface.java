public class UserInterface {
    public void printIntro() {
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
}
