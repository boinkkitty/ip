package boink.commands;

import boink.Storage;
import boink.tasks.Task;
import boink.TaskList;
import boink.Ui;

public class AddCommand extends Command {
    private Task task;

    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.addTask(this.task);
        storage.saveTasksToFile(tasks);
        ui.showCommand(output);
    }
}
