package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

/**
 * This class represents the command to delete a task.
 */

public class DeleteCommand extends Command {
    private int index;

    /**
     * Constructor for DeleteCommand
     * @param index Index of task to delete
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Delete task in task list, update task list to Storage and return UI response
     * @param storage Storage
     * @param ui UI
     * @param tasks TaskList
     * @return String containing UI Response
     */
    @Override
    public String execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.deleteTask(this.index);
        storage.saveTasksToFile(tasks);
        return ui.showCommand(output);
    }
}
