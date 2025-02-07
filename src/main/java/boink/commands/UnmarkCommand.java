package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

/**
 * This class represents the command to mark a task as not done.
 */

public class UnmarkCommand extends Command {
    private int index;

    /**
     * Constructor for UnmarkCommand.
     * @param index Index of task to be marked as not done.
     */

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.unmarkTask(this.index);
        storage.saveTasksToFile(tasks);
        ui.showCommand(output);
    }
}
