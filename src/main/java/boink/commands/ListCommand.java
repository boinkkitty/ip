package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

/**
 * This class represents the command to list all tasks.
 */

public class ListCommand extends Command {

    /**
     * Return UI response containing list of tasks
     * @param storage Storage
     * @param ui UI
     * @param tasks TaskList
     * @return String containing UI Response
     */

    @Override
    public String execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.printTasks();
        return ui.showCommand(output);
    }
}
