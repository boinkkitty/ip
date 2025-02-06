package boink.commands;

import boink.Storage;
import boink.tasks.Task;
import boink.TaskList;
import boink.Ui;

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

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.addTask(this.task);
        storage.saveTasksToFile(tasks);
        ui.showCommand(output);
    }
}
