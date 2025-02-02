import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

/**
 * This class represents a list containing user's tasks
 */

public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Constructor for task list
     */
    public TaskList() {
        try {
            this.loadTasks("../../../data/data.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error loading tasks! " + e.getMessage());
        }
    }

    /**
     * Loads tasks from file into ArrayList<Task> tasks.
     * Throws an exception if file does not exist.
     * @param filePath The location of file to be read from
     */
    public void loadTasks(String filePath) throws FileNotFoundException {
        File tasksFile = new File(filePath);
        Scanner scanner = new Scanner(tasksFile);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\|");

            if (parts[0].trim().equals("T")) {
                ToDo todo = new ToDo(parts[2].trim());
                if (parts[1].trim().equals("1")) {
                    todo.setDone();
                }
                this.tasks.add(todo);
            } else if (parts[0].trim().equals("D")) {
                Deadline deadline = new Deadline(parts[2].trim(), parts[3].trim());
                if (parts[1].trim().equals("1")) {
                    deadline.setDone();
                }
                this.tasks.add(deadline);
            } else if (parts[0].trim().equals("E")) {
                Event event = new Event(parts[2].trim(), parts[3].trim(), parts[4].trim());
                if (parts[1].trim().equals("1")) {
                    event.setDone();
                }
                this.tasks.add(event);
            }
        }
    }

    /**
     * Adds task into tasklist and returns output to print.
     * @param task
     * @return Output to print
     */

    public String addTask (Task task) {
        this.tasks.add(task);
        this.saveTasks();
        return "Got it. I've added this task:\n" + task + "\n"
                + "Now you have " + this.tasks.size() + " tasks in the list \n";
    }

    /**
     * Returns number of tasks in tasklist.
     * @return Tasklist size.
     */
    public int getSize() {
        return this.tasks.size();
    }

    public String markTask(int index) {
        tasks.get(index).setDone();
        this.saveTasks();
        return "Nice! I've marked this task as done: \n" + tasks.get(index);
    }

    public String unmarkTask(int index) {
        this.tasks.get(index).setNotDone();
        this.saveTasks();
        return "OK, I've marked this task as not done yet: \n" + tasks.get(index);
    }

    public String deleteTask (int index) {
        Task removedTask = this.tasks.get(index);
        this.tasks.remove(index);
        this.saveTasks();
        return "OK, I've removed this task from the list \n" + removedTask;
    }

    public String printTasks() {
        List<String> output = IntStream.range(0, this.tasks.size()).mapToObj(
                i -> ((i + 1) + "." + this.tasks.get(i) + "\n"))
                .collect(Collectors.toList());
        return String.join("", output);
    }

    public void saveTasks() {
        try {
            FileWriter fw = new FileWriter("../../../data/data.txt", false);
            StringBuilder sb = new StringBuilder();
            for (Task task: tasks) {
                sb.append(task.saveTask() + "\n");
            }
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occurred while saving tasks to file " + e.getMessage());
        }
    }
}
