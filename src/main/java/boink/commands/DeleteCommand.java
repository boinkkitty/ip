package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand (int index) {
        this.index = index;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.deleteTask(this.index);
        storage.saveTasksToFile(tasks);
        ui.showCommand(output);
    }
}
