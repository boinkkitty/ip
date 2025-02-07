package boink.commands;

import boink.Storage;
import boink.TaskList;
import boink.Ui;

/**
 * This class represents the command to find all tasks containing the keyword.
 */

public class FindCommand extends Command {

    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        String output = tasks.findWord(this.keyword);
        ui.showCommand(output);
    }
}
