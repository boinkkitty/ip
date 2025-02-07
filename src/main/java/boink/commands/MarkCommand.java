package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

/**
 * This class represents the command to mark a task as done.
 */

public class MarkCommand extends Command {
    private int index;

    /**
     * Constructor for MarkCommand.
     * @param index Index of task to be marked as done.
     */

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.markTask(this.index);
        storage.saveTasksToFile(tasks);
        ui.showCommand(output);
    }
}
