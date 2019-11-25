public class Task {

    private int priority;
    private String description;

    public Task(int priority, String description)
    {
        this.priority = priority;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
