package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;
import boink.tasks.Task;

/**
 * This class represents the command to add a task.
 */

public class AddCommand extends Command {
    private Task task;

    /**
     * Constructor for AddCommand
     * @param task Task to be added
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Adds task to task list, updates task list to Storage and return UI response
     * @param storage Storage
     * @param ui UI
     * @param tasks TaskList
     * @return String containing UI Response
     */

    @Override
    public String execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.addTask(this.task);
        storage.saveTasksToFile(tasks);
        return ui.showCommand(output);
    }
}
