package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand (int index) {
        this.index = index;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.markTask(this.index);
        storage.saveTasksToFile(tasks);
        ui.showCommand(output);
    }
}
