import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    public int compare(Task one, Task two){
        return (one.getPriority() - two.getPriority());
    }}
