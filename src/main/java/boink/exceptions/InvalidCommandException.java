package boink.exceptions;

/**
 * This class represents an exception thrown when user command is invalid
 */

public class InvalidCommandException extends BoinkException {

    public InvalidCommandException(String message) {
        super(message);
    }
}
