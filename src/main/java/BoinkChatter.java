import java.util.*;

public class BoinkChatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cmds = new ArrayList<>();

        String logo = "Hello! I'm BoinkChatter \n" +
                "What can I do for you? \n";

        System.out.println(logo);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon! \n");
                break;
            } else if (input.equals("list")) {
                for (int i = 0; i < cmds.size(); ++i) {
                    System.out.println((i + 1) + ". " + cmds.get(i));
                }
            } else {
                cmds.add(input);
                System.out.println("added: " + input);
            }
        }

    }
}
