import java.util.ArrayList;
import java.util.Scanner;

public class BoinkChatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();

        String logo = "Hello! I'm BoinkChatter\n" +
                "What can I do for you?\n";

        System.out.println(logo);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n");
                break;
            } else if (input.equals("list")) {
                System.out.println(taskList.printTasks());
            } else if (input.startsWith("unmark")) {
                String[] parts = input.split(" ");
                int pos = Integer.parseInt(parts[1]) - 1;
                System.out.println(taskList.unmarkTask(pos));
            } else if (input.startsWith("mark")) {
                String[] parts = input.split(" ");
                int pos = Integer.parseInt(parts[1]) - 1;
                System.out.println(taskList.markTask(pos));
            } else if (input.startsWith("delete")) {
                String[] parts = input.split(" ");
                int pos = Integer.parseInt(parts[1]) - 1;
                System.out.println(taskList.deleteTask(pos));
            } else {
                Task newTask = createTask(input);
                System.out.println(taskList.addTask(newTask));
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
                return new ToDoTask(name);
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
