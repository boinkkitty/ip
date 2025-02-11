package boink.tasks;

/**
 * This class represents a task without deadline.
 */

public class ToDoTask extends Task {

    /**
     * Constructor for ToDoTask class.
     * @param name The name of task.
     */

    public ToDoTask(String name) {
        super(name);
    }

    /**
     * Creates output in format for saving task.
     * @return Task as string to write to file.
     */

    @Override
    public String saveTask() {
        String output = "T | " + (this.isDone() ? 1 : 0) + " | " + this.getName();
        return output;
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}
