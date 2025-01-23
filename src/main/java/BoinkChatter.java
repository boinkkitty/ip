import java.util.*;

public class BoinkChatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logo = "Hello! I'm BoinkChatter \n" +
                "What can I do for you? \n \n";

        System.out.println(logo);

        while (true) {
            String input = scanner.nextLine();

            if(input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon! \n");
                break;
            } else {
                System.out.println(input);
            }
        }

    }
}
