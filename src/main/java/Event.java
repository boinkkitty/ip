public class Event extends Task {
    private String start;
    private String end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

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
