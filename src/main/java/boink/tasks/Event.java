package boink.tasks;

import boink.utils.Utils;

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
     * @return Task as string to write to file.
     */

    @Override
    public String saveTask() {
        String output = "E | " + (this.isDone() ? 1 : 0) + " | " + this.getName()
                + " | " + Utils.saveDateTime(this.start) + " | " + Utils.saveDateTime(this.end);
        return output;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + " from: "
                + Utils.getDateTime(this.start) + " to: " + Utils.getDateTime(this.end) + ")";
    }
}
