import java.util.Date;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        taskManager.addEmployee(new User("John", Position.PROGRAMMER_TEAM_LEADER));
        taskManager.addEmployee(new User("Alice", Position.HR));
        taskManager.addEmployee(new User("Eva", Position.DIRECTOR));

        PriorityTask testProgramTask = new PriorityTask(taskManager.findEmployeeByName("John"), "Test the program", "Find the issue", new Date(124, 4, 1), new Date(124, 4, 15), 2);
        testProgramTask.resolve("Send the issue to backend specialist");

        PriorityTask programTask = new PriorityTask(taskManager.findEmployeeByName("John"), "Update code", "Develop new feature", new Date(124, 4, 3), new Date(124, 4, 20), 1);
        programTask.resolve("Made an option to sort by name");

        PriorityTask contractTask = new PriorityTask(taskManager.findEmployeeByName("Eva"), "Sign Contract", "Review and sign the contract", new Date(124, 4, 1), new Date(124, 4, 15), 2);
        contractTask.resolve("Deal NOT Done");

        Task documentTask = new Task(taskManager.findEmployeeByName("Alice"), "Hire a new employee", "Find marketing specialist", new Date(124, 4, 5), new Date(124, 4, 14));

        taskManager.addTask(testProgramTask);
        taskManager.addTask(programTask);
        taskManager.addTask(contractTask);
        taskManager.addTask(documentTask);

        TreeMap<User, TreeMap<Task, Task>> tasksByAssignee = taskManager.getTasksByAssignee();

        try (FileWriter writer = new FileWriter("output1.txt")) {
            for (User user : tasksByAssignee.keySet()) {
                writer.write("Name: " + user.getName() + "\nPosition: " + user.getPosition() + ":\n");
                TreeMap<Task, Task> tasks = tasksByAssignee.get(user);
                for (Task task : tasks.keySet()) {
                    writer.write(task + "\n");
                }
                writer.write("\n");
            }
            System.out.println("Data saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader("output1.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    String userName = line.substring(6);
                    bufferedReader.readLine(); // Skip the "Position" line
                    String taskLine;
                    while ((taskLine = bufferedReader.readLine()) != null && !taskLine.isEmpty()) {
                        String[] taskParts = taskLine.split(", ");
                        if (taskParts.length >= 5) {
                            String taskTitle = taskParts[0].substring(7); // Skip "Title: "
                            String taskDesc = taskParts[1].substring(13); // Skip "Description: "
                            Date taskStartDate = new Date(Long.parseLong(taskParts[2].substring(12))); // Skip "Startdate: "
                            Date taskDeadline = new Date(Long.parseLong(taskParts[3].substring(10))); // Skip "Deadline: "
                            int taskPriority = Integer.parseInt(taskParts[4].substring(10)); // Skip "Priority: "

                            User user = new User(userName, null);
                            Task task = new PriorityTask(user, taskTitle, taskDesc, taskStartDate, taskDeadline, taskPriority);

                            TreeMap<Task, Task> userTasks = tasksByAssignee.getOrDefault(user, new TreeMap<>());
                            userTasks.put(task, task);
                            tasksByAssignee.put(user, userTasks);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }

        System.out.println("Contents of TreeMap (Read from file):");
        for (User user : tasksByAssignee.keySet()) {
            System.out.print("Name: " + user.getName() + "\nPosition: " + user.getPosition() + "\n\n");
            TreeMap<Task, Task> tasks = tasksByAssignee.get(user);
            for (Task task : tasks.keySet()) {
                System.out.println(task);
            }
            System.out.println();
        }

        System.out.println("Enter the user name to check if exists in the file:");
        String checkUser = scanner.nextLine();
        User userToCheck = new User(checkUser, null);
        if (tasksByAssignee.containsKey(userToCheck)) {
            System.out.println("Tasks for user " + checkUser + ":");
            TreeMap<Task, Task> userTasks = tasksByAssignee.get(userToCheck);
            for (Task task : userTasks.keySet()) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks found for user " + checkUser + " in the file.");
        }

        System.out.println("Enter the user name to delete tasks:");
        String deleteUser = scanner.nextLine();
        User userToDelete = new User(deleteUser, null);
        if (tasksByAssignee.containsKey(userToDelete)) {
            tasksByAssignee.remove(userToDelete);
            System.out.println("Tasks for user " + deleteUser + " deleted successfully.");
        } else {
            System.out.println("No tasks found for user " + deleteUser + ". Nothing deleted.");
        }

        System.out.println("Contents of TreeMap after deletion:");
        for (User user : tasksByAssignee.keySet()) {
            System.out.print("Name: " + user.getName() + "\nPosition: " + user.getPosition() + "\n");
            TreeMap<Task, Task> tasks = tasksByAssignee.get(user);
            for (Task task : tasks.keySet()) {
                System.out.println(task);
            }
            System.out.println();
        }

        try (FileWriter writer = new FileWriter("output1.txt")) {
            for (User user : tasksByAssignee.keySet()) {
                writer.write("Name: " + user.getName() + "\nPosition: " + user.getPosition() + ":\n");
                TreeMap<Task, Task> tasks = tasksByAssignee.get(user);
                for (Task task : tasks.keySet()) {
                    writer.write(task + "\n");
                }
                writer.write("\n");
            }
            System.out.println("Updated data saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
