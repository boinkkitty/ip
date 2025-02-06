package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand (int index) {
        this.index = index;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.unmarkTask(this.index);
        storage.saveTasksToFile(tasks);
        ui.showCommand(output);
    }
}
