public class ToDo extends Task {
    public ToDo (String name) {
        super(name);
    }

    @Override
    public String saveTask() {
        String output = "E | " + (this.checkDone() ? 1 : 0) + " | " + this.getName();
        return output;
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}
