package boink;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import boink.exceptions.BoinkException;
import boink.exceptions.InvalidCommandException;
import boink.exceptions.InvalidTaskInputException;
import boink.tasks.Deadline;
import boink.tasks.Event;
import boink.tasks.Task;
import boink.tasks.ToDoTask;
import boink.utils.Utils;

/**
 * This class deals with making sense of the user command.
 */

public class Parser {

    /**
     * Parses user input entry into a command to be executed.
     * @param command User command.
     * @return Command to be executed.
     * @throws BoinkException If user enters empty input, invalid date format or task format
     */

    public static Command parseUserInput(String command) throws BoinkException {
        String[] parts = command.split(" ");

        switch (parts[0]) {
        case "":
            throw new BoinkException("Empty input. Please enter a valid command!");
        case "bye":
            return Command.BYE;
        case "list":
            return Command.LIST;
        case "unmark":
            return Command.UNMARK;
        case "mark":
            return Command.MARK;
        case "delete":
            return Command.DELETE;
        case "find":
            return Command.FIND;
        case "todo":
            return Command.TODO;
        case "deadline":
            return Command.DEADLINE;
        case "event":
            return Command.EVENT;
        default:
            throw new InvalidCommandException("Unknown command. Please enter a valid command");
        }
    }

    /**
     * Creates task from user input.
     * @param input User input entry.
     * @return Task to be created from user input.
     * @throws BoinkException If user did not state any task details.
     * @throws DateTimeParseException If date input format is invalid.
     */

    public static Task createTaskFromInput(String input) throws BoinkException {
        try {
            assert !input.isEmpty() : "User input should not be empty";
            String[] check = input.split(" ");
            if (check.length <= 1) {
                throw new InvalidTaskInputException("Task must have name!");
            }

            switch (check[0]) {
                case "todo":
                    String name = input.substring(5);
                    return new ToDoTask(name);
                case "deadline":
                    input = input.substring(9);
                    String[] parts = input.split("/by ");
                    name = parts[0].trim();
                    LocalDateTime deadline = Utils.createDateTime(parts[1].trim());
                    return new Deadline(name, deadline);
                case "event":
                    input = input.substring(6);
                    parts = input.split("/from ");
                    name = parts[0].trim();
                    String[] secondParts = parts[1].split("/to ");
                    LocalDateTime start = Utils.createDateTime(secondParts[0].trim());
                    LocalDateTime end = Utils.createDateTime(secondParts[1].trim());
                    assert (start.compareTo(end) <= 0) : "End cannot be earlier than start";
                    return new Event(name, start, end);
                default:
                    return null;
            }
        } catch (DateTimeParseException err) {
            throw new InvalidTaskInputException("Invalid date format");
        }
    }
}
