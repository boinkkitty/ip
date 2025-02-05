package boink;

import java.time.LocalDateTime;

/**
 * This class represents a task with a datetime deadline
 */

public class Deadline extends Task {
    private LocalDateTime deadline;

    /**
     * Constructor for Deadline class
     * @param name The name of task
     * @param deadline The deadline of task
     */

    public Deadline (String name, LocalDateTime deadline) {
        super(name);
        this.deadline = deadline;
    }

    /**
     * Creates output in format for saving task
     * @return Task to save to file
     */

    @Override
    public String saveTask() {
        String output = "D | " + (this.checkDone() ? 1 : 0) + " | " + this.getName()
                + " | " + super.saveDateTime(this.deadline);
        return output;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + super.getDateTime(this.deadline) + ")";
    }
}
