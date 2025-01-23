public class Task {
    private String name;
    private boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setNotDone() {
        this.done = false;
    }

    public void setDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return "[" + (this.done ? "X" : " ") + "] " + this.name;
    }
}
