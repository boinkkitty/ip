package boink;

import boink.commands.Command;
import boink.exceptions.BoinkException;

import java.io.FileNotFoundException;

/**
 * This class represents the Boink bot
 */

public class Boink {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Boink(String filePath) {
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        this.tasks = new TaskList();

        try {
            this.storage.loadTasksFromFile(this.tasks);
        } catch (FileNotFoundException err) {
            System.out.println(err.getMessage());
            ui.showLoadingError();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while(!isExit) {
            try {
                String command = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(command);
                c.execute(this.storage, this.ui, this.tasks);
                isExit = c.isExit();
            } catch (BoinkException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
        ui.showExit();
        ui.showLine();
    }

    public static void main(String[] args) {
        new Boink("./data/data.txt").run();
    }
}

