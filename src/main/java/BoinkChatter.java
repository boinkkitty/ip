import java.sql.SQLOutput;
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
            } else if (input.startsWith("unmark")) {
                String[] parts = input.split(" ");
                int pos = Integer.parseInt(parts[1]) - 1;
                tasks.get(pos).setNotDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(tasks.get(pos));
            } else if (input.startsWith("mark")) {
                String[] parts = input.split(" ");
                int pos = Integer.parseInt(parts[1]) - 1;
                tasks.get(pos).setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks.get(pos));
            } else if (input.startsWith("delete")) {
                String[] parts = input.split(" ");
                int pos = Integer.parseInt(parts[1]) - 1;
                Task task = tasks.get(pos);
                tasks.remove(pos);
                System.out.println("OK, I've removed this task from the list");
                System.out.println(task);
            } else {
                Task newTask = createTask(input);
                if (newTask != null) {
                    tasks.add(newTask);
                    System.out.println("Got it. I've added this task:\n"
                            + newTask + "\n"
                            + "Now you have " + tasks.size() + " tasks in the list");
                }
            }
        }
    }

    public static Task createTask (String input) {
        try {
            String[] check = input.split(" ");
            if (check.length <= 1) {
                throw new BoinkException("Can't be empty!");
            }

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
                throw new BoinkException("Sorry! I don't know what that means :<");
            }
        } catch (BoinkException err) {
            System.out.println(err.getMessage());
            return null;
        }
    }
}
