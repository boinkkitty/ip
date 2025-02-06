package boink.exceptions;

/**
 * This class is a subclass of BoinkException.
 * This represents exceptions thrown from invalid task input format.
 */

public class TaskInputException extends BoinkException {

    /**
     * Constructor for TaskInputException.
     * @param msg Message for Exception.
     */

    public TaskInputException(String msg) {
        super("The input format for adding tasks is invalid. " + msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
