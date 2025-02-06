package boink.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This abstract class represents a task.
 */

public abstract class Task {
    private String name;
    private boolean isDone;

    /**
     * Constructor for Task class.
     * @param name The name of task.
     */

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String getName() {
        return this.name;
    }

    public boolean checkDone() {
        return this.isDone;
    }

    public void setNotDone() {
        this.isDone = false;
    }

    public void setDone() {
        this.isDone = true;
    }

    public abstract String saveTask();

    /**
     * Converts LocalDateTime to String output in (dd MMM yyyy HH:mm) format
     * for printing out.
     * @param dt DateTime object.
     * @return DateTime (dd MMM yyyy HH:mm).
     */

    public String getDateTime(LocalDateTime dt) {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
        return dt.format(outputFormat);
    }

    /**
     * Converts LocalDateTime to String output in (dd MMM yyyy HH:mm) format
     * for writing to file.
     * @param dt DateTime object.
     * @return DateTime (dd/MM/yyyy HHmm).
     */

    public String saveDateTime(LocalDateTime dt) {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        return dt.format(outputFormat);
    }

    @Override
    public String toString() {
        return "[" + (this.isDone ? "X" : " ") + "] " + this.name;
    }
}
