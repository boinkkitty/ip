package boink.gui;

import boink.Boink;
import boink.exceptions.BoinkException;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private boolean isExit = false;

    private Boink boink;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image boinkImage = new Image(this.getClass().getResourceAsStream("/images/DaBoink.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Loads welcome message and displays number of tasks in tasklist.
     */

    public void loadWelcome() {
        String welcome = this.boink.sayWelcome();
        dialogContainer.getChildren().addAll(
                DialogBox.getBoinkDialog(welcome, boinkImage)
        );
    }

    /** Injects the Boink instance */
    public void setBoink(Boink b) {
        this.boink = b;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Boink's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */

    @FXML
    private void handleUserInput() {
        String input = userInput.getText();

        try {
            String response = boink.getResponse(input);
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getBoinkDialog(response, boinkImage)
            );

            if (isExitResponse(response)) {
                isExit = true;
            }
        } catch (BoinkException e) {
            String response = boink.getErrorResponse(e.getMessage());

            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getBoinkDialog(response, boinkImage)
            );
        }

        if (isExit) {
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(event -> {
                Platform.exit();
            });
            pause.play();
        }
        userInput.clear();
    }

    private boolean isExitResponse(String response) {
        return response.equals("Exiting from Boink...\n");
    }
}
