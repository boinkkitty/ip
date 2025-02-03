import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * This class represents the BoinkChatter bot
 */

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
            } else if (input.startsWith("todo") || input.startsWith("deadline")
                    || input.startsWith("event")) {
                Task newTask = createTask(input);
            } else {
                System.out.println("Unknown command.");
            }
        }
    }

    /**
     * This class creates a task from input
     * @param input Type of task
     * @return Created task
     */

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
                LocalDateTime deadline = createDateTime(parts[1].trim());
                return new Deadline(parts[0].trim(), deadline);
            } else if (input.startsWith("event")) {
                input = input.replaceFirst("event ","");
                String[] parts = input.split("/from ");
                String name = parts[0];
                String[] secondParts = parts[1].split("/to ");
                LocalDateTime start = createDateTime(secondParts[0].trim());
                LocalDateTime end = createDateTime(secondParts[1].trim());
                return new Event(name.trim(), start, end);
            } else {
                throw new BoinkException("Sorry! I don't know what that means :<");
            }
        } catch (BoinkException err) {
            System.out.println(err.getMessage());
            return null;
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date-time format. Format: (dd/mm/yyyy HHmm)");
            return null;
        }
    }

    /**
     * Creates LocalDatetime object from String input (dd/MM/yyyy HHmm).
     * Throws DateTimeParseException if input format is incorrect.
     * @param input String datetime (dd/MM/yyyy HHmm)
     * @return LocalDateTime object
     * @throws DateTimeParseException
     */
    public static LocalDateTime createDateTime(String input) throws DateTimeParseException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        return LocalDateTime.parse(input, format);
    }
}
