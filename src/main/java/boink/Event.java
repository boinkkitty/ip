package boink;

import java.time.LocalDateTime;

/**
 * This class represents a task with a start and end datetime.
 */

public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    /**
     * Constructor for Event class.
     * @param name The name of task
     * @param start The start datetime of task
     * @param end The end datetime of task
     */

    public Event(String name, LocalDateTime start, LocalDateTime end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    /**
     * Creates output in format for saving task.
     * @return Task to save to file
     */

    @Override
    public String saveTask() {
        String output = "E | " + (this.checkDone() ? 1 : 0) + " | " + this.getName()
                + " | " + super.saveDateTime(this.start) + " | " + super.saveDateTime(this.end);
        return output;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " from: "
                + super.getDateTime(this.start) + " to: " + super.getDateTime(this.end) + ")";
    }
}
