import java.util.PriorityQueue;
import java.util.Scanner;


public class TaskDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        PriorityQueue<Task> pq = new PriorityQueue<>(new TaskComparator());

        System.out.print("Ready to enter tasks? (y/n): ");
        String r = input.nextLine();

        if (r.equals("y")) {
            do {
                System.out.print("Enter task description: ");
                String r2 = input.nextLine();

                System.out.print("Enter task priority: ");
                int pr = input.nextInt();
                input.nextLine();

                Task task = new Task(pr, r2);
                pq.add(task);

                System.out.print("Another task? (y/n): ");
                String s3 = input.nextLine();

                if (s3.equals("n"))
                    flag = true;

            } while (flag == false);

            System.out.println();
            System.out.println("Your tasks are: ");

            while (!pq.isEmpty()) {
                Task task = pq.poll();

                System.out.print(task.getPriority() + ", ");
                System.out.println(task.getDescription());
            }
        }
    }
}
