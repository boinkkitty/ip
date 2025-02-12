package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

/**
 * This class represents an unknown command that was entered.
 */

public class UnknownCommand extends Command {

    /**
     * Return UI Response for unknown command
     * @param storage Storage
     * @param ui UI
     * @param tasks TaskList
     * @return String containing UI Response
     */

    @Override
    public String execute(Storage storage, Ui ui, TaskList tasks) {
        return ui.showCommand("Unknown command received. Please try again.");
    }
}
