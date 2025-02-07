package boink;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import boink.tasks.Deadline;
import boink.tasks.Event;
import boink.tasks.Task;
import boink.tasks.ToDoTask;

/**
 * This class deals with loading tasks from the file and saving tasks in the file.
 */

public class Storage {

    private String filePath;

    /**
     * Constructor for storage.
     * @param filePath
     */

    public Storage(String filePath) {
        this.filePath = filePath;
    }


    /**
     * Loads tasks from file into taskList.
     * @param tasklist Tasklist to load tasks from file into.
     * @throws FileNotFoundException If file does not exist.
     */

    public void loadTasksFromFile(TaskList tasklist) throws FileNotFoundException {
        File tasksFile = new File(this.filePath);
        Scanner scanner = new Scanner(tasksFile);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Task task = this.parseTaskLog(line);
            tasklist.loadTask(task);
        }
    }


    /**
     * Writes tasks from taskList into file
     * IOException thrown and caught if error occurred.
     * @param taskList Tasklist to read tasks for writing.
     */

    public void saveTasksToFile(TaskList taskList) {
        try {
            FileWriter fw = new FileWriter(filePath, false);
            StringBuilder sb = new StringBuilder();
            fw.write(taskList.saveTasks());
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occurred while saving tasks to file " + e.getMessage());
        }
    }

    /**
     * Parse file entry into tasks for loading to tasklist.
     * @param input Entry to be parsed.
     * @return Task to be loaded.
     */

    private Task parseTaskLog(String input) {
        String[] parts = input.split("\\|");
        boolean isDone = parts[1].trim().equals("1");
        switch (parts[0].trim()) {
        case "T":
            Task task = new ToDoTask(parts[2].trim());
            if (isDone) {
                task.setDone();
            }
            return task;
        case "D":
            task = new Deadline(parts[2].trim(), Parser.createDateTime(parts[3].trim()));
            if (isDone) {
                task.setDone();
            }
            return task;
        case "E":
            task = new Event(parts[2].trim(), Parser.createDateTime(parts[3].trim()),
                    Parser.createDateTime(parts[4].trim()));
            if (isDone) {
                task.setDone();
            }
            return task;
        default:
            return null;
        }
    }
}
