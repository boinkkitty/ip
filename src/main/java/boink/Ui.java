package boink;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import boink.exceptions.BoinkException;
import boink.exceptions.InvalidCommandException;
import boink.exceptions.TaskInputException;
import boink.tasks.Deadline;
import boink.tasks.Event;
import boink.tasks.Task;
import boink.tasks.ToDoTask;

/**
 * This class deals with interactions with the user.
 */

public class Ui {

    private final Scanner sc;
    private Storage storage;
    private TaskList tasks;

    public Ui(Storage storage, TaskList tasks) {
        this.sc = new Scanner(System.in);
        this.storage = storage;
        this.tasks = tasks;
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public String showCommand(String output) {
        return output;
    }

    public String showWelcome() {
        return "Hello! I'm Boink!\n" + "What can I do for you?\n";
    }

    public String showError(String err) {
        return "Exception encountered! " + err + "\n";
    }

    public String showLoadingError() {
        return "Error occurred. Failed to load tasks";
    }

    public String showExit() {
        return "Exiting from Boink...\n";
    }

    public String listTasks() {
        String output = tasks.printTasks();
        return output;
    }

    public String markTask(String input) {
        String[] parts = input.split(" ");
        int index = Integer.parseInt(parts[1]);
        String output = tasks.markTask(index);
        storage.saveTasksToFile(tasks);
        return output;
    }

    public String unmarkTask(String input) {
        String[] parts = input.split(" ");
        int index = Integer.parseInt(parts[1]);
        String output = tasks.unmarkTask(index);
        storage.saveTasksToFile(tasks);
        return output;
    }

    public String deleteTask(String input) {
        String[] parts = input.split(" ");
        int index = Integer.parseInt(parts[1]);
        String output = tasks.deleteTask(index);
        storage.saveTasksToFile(tasks);
        return output;
    }

    public String findTasks(String input) {
        String[] parts = input.split(" ");
        String word = parts[1].trim();
        String output = tasks.findWord(word);
        return output;
    }

    public String createTask(String input) throws BoinkException, DateTimeParseException {
        Task newTask = Parser.createTaskFromInput(input);
        String output = tasks.addTask(newTask);
        storage.saveTasksToFile(tasks);
        return output;
    }
}
