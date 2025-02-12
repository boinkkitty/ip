package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

/**
 * This class represents the command to end the application.
 */

public class EndCommand extends Command {

    /**
     * Saves task list to storage before returning Exit response
     * @param storage Storage
     * @param ui UI
     * @param tasks TaskList
     * @return String containing UI Response
     */

    @Override
    public String execute(Storage storage, Ui ui, TaskList tasks) {
        storage.saveTasksToFile(tasks);
        return ui.showExit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
