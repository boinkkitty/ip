package boink;

public class EndCommand extends Command {
    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        storage.saveTasksToFile(tasks);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
