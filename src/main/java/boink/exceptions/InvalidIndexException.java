package boink.exceptions;

/**
 * This class represents an exception thrown when invalid index is given for user command
 */

public class InvalidIndexException extends BoinkException {

    public InvalidIndexException(String message) {
        super(message);
    }
}
