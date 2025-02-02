public class Deadline extends Task {
    private String deadline;

    public Deadline (String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

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
