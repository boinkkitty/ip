package boink.exceptions;

/**
 * This class is a subclass of BoinkException.
 * This represents exceptions thrown from invalid task input format.
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
