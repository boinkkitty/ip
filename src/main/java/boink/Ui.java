package boink;

import java.util.Scanner;

/**
 * This class deals with interactions with the user.
 */

public class Ui {

    private final Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public String showCommand(String output) {
        return output;
    }

    public String showWelcome() {
        return "Hello! I'm Boink!\n" + "What can I do for you?\n";
    }

    public String showError(String err) {
        return "Exception encountered! " + err + "\n";
    }

    public String showLoadingError() {
        return "Error occurred. Failed to load tasks";
    }

    public String showExit() {
        return "Exiting from Boink...\n";
    }

}
