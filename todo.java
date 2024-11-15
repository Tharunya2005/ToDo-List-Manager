import java.util.ArrayList;
import java.util.Scanner;

public class todo {

    private static ArrayList<String> liveTasks = new ArrayList<>();
    private static ArrayList<String> completedTasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        System.out.println("Welcome to the To-Do List Application!");

        while (run) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Display Live Tasks");
            System.out.println("4. Display Completed Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    displayLiveTasks();
                    break;
                case 4:
                    displayCompletedTasks();
                    break;
                case 5:
                    System.out.println("Exiting To-Do List Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 5.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter the task: ");
        String task = sc.nextLine();
        liveTasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void updateTask() {
        displayLiveTasks();
        if (liveTasks.isEmpty()) {
            System.out.println("No tasks to update.");
            return;
        }

        System.out.print("Enter the task number to update: ");
        int taskNumber = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (taskNumber > 0 && taskNumber <= liveTasks.size()) {
            System.out.print("Enter the new description for the task: ");
            String newDescription = sc.nextLine();

            // Move the old task to the completed tasks list and remove it from live tasks
            String oldTask = liveTasks.remove(taskNumber - 1);
            completedTasks.add(oldTask);

            // Add the updated task to the live tasks list
            liveTasks.add(newDescription);

            System.out.println("Task updated and old task moved to completed tasks.");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private static void displayLiveTasks() {
        if (liveTasks.isEmpty()) {
            System.out.println("No live tasks.");
        } else {
            System.out.println("\nLive Tasks:");
            for (int i = 0; i < liveTasks.size(); i++) {
                System.out.println((i + 1) + ". " + liveTasks.get(i));
            }
        }
    }

    private static void displayCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            System.out.println("\nCompleted Tasks:");
            for (int i = 0; i < completedTasks.size(); i++) {
                System.out.println((i + 1) + ". " + completedTasks.get(i));
            }
        }
    }
}
