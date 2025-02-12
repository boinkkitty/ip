package boink;

import java.io.FileNotFoundException;

import boink.commands.Command;
import boink.exceptions.BoinkException;

/**
 * This class represents an instance of Boink bot
 */

public class Boink {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Public constructor for Boink bot.
     */

    public Boink() {
        this.ui = new Ui();
        this.storage = new Storage("./data/data.txt");
        this.tasks = new TaskList();

        try {
            this.storage.loadTasksFromFile(this.tasks);
        } catch (FileNotFoundException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Returns welcome message to display
     *
     * @return String containing welcome message
     */

    public String sayWelcome() {
        return this.ui.showWelcome();
    }
    /**
     * Processes the user input, executes the corresponding command,
     * and returns Boink's response to print.
     *
     * @param userInput The command input from the user.
     * @return A string representing the system's response after executing the command.
     * @throws BoinkException If an error occurs during command execution.
     */

    public String getResponse(String userInput) throws BoinkException {
        Command c = Parser.parse(userInput);
        String output = c.execute(this.storage, this.ui, this.tasks);
        return output;
    }

    /**
     * Returns an error response message to be displayed to the user.
     *
     * @param err The error message to be shown.
     * @return A string containing the formatted error response.
     */

    public String getErrorResponse(String err) {
        return this.ui.showError(err);
    }
}

