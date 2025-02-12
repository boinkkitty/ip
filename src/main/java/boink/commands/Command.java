package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

/**
 * This is an abstract class of all commands to be executed from user input.
 */

public abstract class Command {
    public abstract String execute(Storage storage, Ui ui, TaskList tasks);

    public boolean isExit() {
        return false;
    }
}
