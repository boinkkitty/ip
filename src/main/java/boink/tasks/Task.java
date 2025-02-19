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

    public boolean isDone() {
        return this.isDone;
    }

    public void setNotDone() {
        this.isDone = false;
    }

    public void setDone() {
        this.isDone = true;
    }

    /**
     * Finds word in task description and returns true or false.
     * @param word Word to find.
     * @return True if task description contains word, false otherwise.
     */

    public boolean hasWord(String word) {
        return this.name.contains(word);
    };

    public abstract String saveTask();

    @Override
    public String toString() {
        return "[" + (this.isDone ? "X" : " ") + "] " + this.name;
    }
}
