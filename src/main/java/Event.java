public class Event extends Task {
    private String start;
    private String end;

    /**
     * Constructor for Event class
     * @param name The name of task
     * @param start The start date of task
     * @param end The end date of task
     */

    public Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    /**
     * Creates output in format for saving task
     * @return Task to save to file
     */

    @Override
    public String saveTask() {
        String output = "E | " + (this.checkDone() ? 1 : 0) + " | " + this.getName()
                + " | " + this.start + " | " + this.end;
        return output;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString()
                + " from: " + this.start + " to: " + this.end + ")";
    }
}
