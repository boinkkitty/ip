package boink;

public abstract class Command {
    public abstract void execute(Storage storage, Ui ui, TaskList tasks);

    public boolean isExit() {
        return false;
    }
}
