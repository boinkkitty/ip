package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

public class UnknownCommand extends Command {
    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        ui.showCommand("Unknown command received. Please try again.");
    }
}
