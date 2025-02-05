package boink;

public class TaskInputException extends BoinkException {
    public TaskInputException(String m) {
        super("The input format for adding tasks is invalid. " );
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
