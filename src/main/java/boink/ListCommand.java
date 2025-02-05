package boink;

public class ListCommand extends Command {

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.printTasks();
        ui.showCommand(output);
    }
}
