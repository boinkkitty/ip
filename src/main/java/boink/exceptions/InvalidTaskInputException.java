package boink.exceptions;

/**
 * This class is a subclass of BoinkException.
 * This represents exceptions thrown when task input format is invalid.
 */

public class InvalidTaskInputException extends BoinkException {

    /**
     * Constructor for InvalidTaskInputException.
     * @param msg Message for Exception.
     */

    public InvalidTaskInputException(String msg) {
        super("Invalid Task Input. Error: " + msg);
    }

}
