public abstract class Task {
    private String name;
    private boolean isDone;

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

    @Override
    public String toString() {
        return "[" + (this.isDone ? "X" : " ") + "] " + this.name;
    }
}
