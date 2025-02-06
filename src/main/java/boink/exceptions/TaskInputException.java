package boink.exceptions;

public class TaskInputException extends BoinkException {
    public TaskInputException(String msg) {
        super("The input format for adding tasks is invalid. " + msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
