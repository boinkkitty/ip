package boink;

import java.util.Scanner;

import boink.exceptions.BoinkException;
import boink.exceptions.InvalidIndexException;
import boink.exceptions.InvalidTaskInputException;
import boink.tasks.Task;
import boink.utils.Utils;

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

    public String showWelcome() {
        return "Hello! I'm Boink!\n" + "What can I do for you?\n";
    }

    public String showError(String err) {
        return "Exception encountered! " + err + "\n";
    }

    public String showExit() {
        return "Exiting from Boink...\n";
    }

    public String listTasks() {
        String output = tasks.printTasks();
        return output;
    }

    public String markTask(String input) throws InvalidTaskInputException, InvalidIndexException {
        String[] parts = input.split(" ");
        if (!Utils.isInteger(parts[1])) {
            throw new InvalidTaskInputException("Index must be a number!");
        }
        int index = Integer.parseInt(parts[1]) - 1;
        String output = tasks.markTask(index);
        storage.saveTasksToFile(tasks);
        return output;
    }

    public String unmarkTask(String input) throws InvalidTaskInputException, InvalidIndexException {
        String[] parts = input.split(" ");
        if (!Utils.isInteger(parts[1])) {
            throw new InvalidTaskInputException("Index must be a number!");
        }
        int index = Integer.parseInt(parts[1]) - 1;
        String output = tasks.unmarkTask(index);
        storage.saveTasksToFile(tasks);
        return output;
    }

    public String deleteTask(String input) throws InvalidTaskInputException, InvalidIndexException {
        String[] parts = input.split(" ");
        if (!Utils.isInteger(parts[1])) {
            throw new InvalidTaskInputException("Index must be a number!");
        }
        int index = Integer.parseInt(parts[1]) - 1;
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

    public String createTask(String input) throws BoinkException {
        Task newTask = Parser.createTaskFromInput(input);
        assert (newTask != null) : "Task should not be null";
        String output = tasks.addTask(newTask);
        storage.saveTasksToFile(tasks);
        return output;
    }
}
