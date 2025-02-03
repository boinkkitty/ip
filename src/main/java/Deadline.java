public class Deadline extends Task {
    private String deadline;

    /**
     * Constructor for Deadline class
     * @param name The name of task
     * @param deadline The deadline of task
     */

    public Deadline (String name, String deadline) {
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
                + " | " + this.deadline;
        return output;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + this.deadline + ")";
    }
}
