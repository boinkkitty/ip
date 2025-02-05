package boink;

public class UnknownCommand extends Command {
    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        ui.showCommand("Unknown command received. Please try again.");
    }
}
