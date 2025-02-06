package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

public abstract class Command {
    public abstract void execute(Storage storage, Ui ui, TaskList tasks);

    public boolean isExit() {
        return false;
    }
}
