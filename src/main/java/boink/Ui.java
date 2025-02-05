package boink;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * This class deals with interactions with the user.
 */

public class Ui {

    private static final String DIVIDER = "===================================================";
    private final Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showCommand(String command) {
        System.out.println(command);
    }

    public void showWelcome() {
        System.out.println("Hello! I'm Boink\n" + "What can I do for you?");
    }

    public void showError(String err) {
        System.out.println("Exception encountered! " + err);
    }

    public void showLoadingError() {
        System.out.println("Error occurred. Failed to load tasks");
    }

    public void showExit() {
        System.out.println("Exiting from Boink...");
    }

    public void showLine() {
        System.out.println(DIVIDER);
    }

}
