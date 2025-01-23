import java.util.*;
import java.util.regex.*;

public class BoinkChatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        String logo = "Hello! I'm BoinkChatter\n" +
                "What can I do for you?\n";

        System.out.println(logo);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n");
                break;
            } else if (input.equals("list")) {
                for (int i = 0; i < tasks.size(); ++i) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            } else if (input.contains("unmark")) {
                String[] parts = input.split(" ");
                int pos = Integer.parseInt(parts[1]) - 1;
                tasks.get(pos).setNotDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(tasks.get(pos));
            } else if (input.contains("mark")) {
                String[] parts = input.split(" ");
                int pos = Integer.parseInt(parts[1]) - 1;
                tasks.get(pos).setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks.get(pos));
            } else {
                Task newTask = createTask(input);
                tasks.add(newTask);
                System.out.println("Got it. I've added this task:\n"
                        + newTask + "\n"
                        + "Now you have " + tasks.size() + " tasks in the list");
            }
        }
    }

    public static Task createTask (String input) {
        if (input.startsWith("todo")) {
            String name = input.replaceFirst("todo ","");
            return new ToDo(name);
        } else if (input.startsWith("deadline")) {
            input = input.replaceFirst("deadline ","");
            String[] parts = input.split("/by ");
            return new Deadline(parts[0].trim(), parts[1].trim());
        } else if (input.startsWith("event")) {
            input = input.replaceFirst("event ","");
            String[] parts = input.split("/from ");
            String name = parts[0];
            String[] secondParts = parts[1].split("/to ");
            return new Event(name.trim(), secondParts[0].trim(), secondParts[1].trim());
        } else {
            return new ToDo("Error");
        }
    }
}
