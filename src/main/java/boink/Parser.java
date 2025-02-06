package boink;

import boink.commands.*;
import boink.exceptions.BoinkException;
import boink.exceptions.TaskInputException;
import boink.tasks.Deadline;
import boink.tasks.Event;
import boink.tasks.Task;
import boink.tasks.ToDoTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

    public static Command parse (String command) throws BoinkException {
        String[] parts = command.split(" ");

        switch (parts[0]) {
        case "":
            throw new BoinkException("Empty input. Please enter a valid command!");
        case "bye":
            if (parts.length == 1) {
                return new EndCommand();
            }
            // Fallthrough
        case "list":
            if (parts.length == 1) {
                return new ListCommand();
            }
            // Fallthrough
        case "unmark":
            return new UnmarkCommand(Integer.parseInt(parts[1]) - 1);
        case "mark":
            return new MarkCommand(Integer.parseInt(parts[1]) - 1);
        case "delete":
            return new DeleteCommand(Integer.parseInt(parts[1]) - 1);
        case "find":
            return new FindCommand(parts[1].trim());
        case "todo":
        case "deadline":
        case "event":
            try {
                Task task = Parser.parseTaskFromInput(command);
                return new AddCommand(task);
            } catch (DateTimeParseException err) {
                throw new TaskInputException("Error: Date Format");
            } catch (BoinkException err) {
                throw new TaskInputException("Error: Task Details");
            }
        default:
            return new UnknownCommand();
        }
    }

    /**
     * Creates task from user input.
     * @param input User input entry.
     * @return Task to be created from user input.
     * @throws BoinkException If user did not state any task details.
     * @throws DateTimeParseException If date input format is invalid.
     */

    private static Task parseTaskFromInput(String input) throws BoinkException, DateTimeParseException {
        String[] check = input.split(" ");
        if (check.length <= 1) {
            throw new BoinkException("Can't be empty!");
        }

        switch (check[0]) {
        case "todo":
            String name = input.substring(5);
            return new ToDoTask(name);
        case "deadline":
            input = input.substring(9);
            String[] parts = input.split("/by ");
            name = parts[0].trim();
            LocalDateTime deadline = createDateTime(parts[1].trim());
            return new Deadline(name, deadline);
        case "event":
            input = input.substring(6);
            parts = input.split("/from ");
            name = parts[0].trim();
            String[] secondParts = parts[1].split("/to ");
            LocalDateTime start = createDateTime(secondParts[0].trim());
            LocalDateTime end = createDateTime(secondParts[1].trim());
            return new Event(name, start, end);
        default:
            return null;
        }
    }

    /**
     * Creates LocalDatetime object from String input (dd/MM/yyyy HHmm).
     * @param input String datetime (dd/MM/yyyy HHmm)
     * @return LocalDateTime object.
     * @throws DateTimeParseException thrown if input format is incorrect.
     */

    public static LocalDateTime createDateTime(String input) throws DateTimeParseException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        return LocalDateTime.parse(input, format);
    }

}
