public class ToDo extends Task {

    /**
     * Constructor for ToDo class
     * @param name The name of task
     */

    public ToDo (String name) {
        super(name);
    }

    /**
     * Creates output in format for saving task
     * @return Task to save to file
     */

    @Override
    public String saveTask() {
        String output = "T | " + (this.checkDone() ? 1 : 0) + " | " + this.getName();
        return output;
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}
