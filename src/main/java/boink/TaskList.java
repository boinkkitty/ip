package boink;

import boink.tasks.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This class represents a list containing user's tasks.
 */

public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructor for task list.
     */

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Loads task into tasklist.
     * @param task Task to load.
     */
    public void loadTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * Adds task into tasklist and returns output to print.
     * @param task
     * @return Print output for added task.
     */

    public String addTask (Task task) {
        this.tasks.add(task);
        this.saveTasks();
        return "Got it. I've added this task:\n" + task + "\n"
                + "Now you have " + this.tasks.size() + " tasks in the list \n";
    }

    public int getSize() {
        return this.tasks.size();
    }

    /**
     * Marks task done and returns print output.
     * @param index
     * @return Print output for marked task.
     */

    public String markTask(int index) {
        tasks.get(index).setDone();
        this.saveTasks();
        return "Nice! I've marked this task as done: \n" + tasks.get(index);
    }

    /**
     * Unmark task as not done and returns print output.
     * @param index
     * @return Print output for unmarked task.
     */

    public String unmarkTask(int index) {
        this.tasks.get(index).setNotDone();
        this.saveTasks();
        return "OK, I've marked this task as not done yet: \n" + tasks.get(index);
    }

    /**
     * Delete task and returns print output.
     * @param index
     * @return Print output for deleted task.
     */

    public String deleteTask (int index) {
        Task removedTask = this.tasks.get(index);
        this.tasks.remove(index);
        this.saveTasks();
        return "OK, I've removed this task from the list \n" + removedTask;
    }

    /**
     * Create output for printing lists of tasks.
     * @return Print output for list of tasks.
     */

    public String printTasks() {
        List<String> output = IntStream.range(0, this.tasks.size()).mapToObj(
                i -> ((i + 1) + "." + this.tasks.get(i) + "\n"))
                .collect(Collectors.toList());
        return String.join("", output);
    }

    /**
     *
     *  Returns tasks from TaskList as string to save into file.
     * @return String output to save
     */

    public String saveTasks() {
        StringBuilder sb = new StringBuilder();
        for (Task task: tasks) {
            sb.append(task.saveTask() + "\n");
        }
        return sb.toString();
    }

    /**
     * Creates LocalDatetime object from String input (dd/MM/yyyy HHmm).
     * Throws DateTimeParseException if input format is incorrect.
     * @param input String datetime (dd/MM/yyyy HHmm).
     * @return LocalDateTime object.
     * @throws DateTimeParseException
     */
    public static LocalDateTime createDateTime(String input) throws DateTimeParseException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        return LocalDateTime.parse(input, format);
    }
}
