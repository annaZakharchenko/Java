import java.util.Date;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        taskManager.addEmployee(new User("John", Position.PROGRAMMER_TEAM_LEADER));
        taskManager.addEmployee(new User("Alice", Position.HR));
        taskManager.addEmployee(new User("Eva", Position.DIRECTOR));

        PriorityTask testProgramTask = new PriorityTask(taskManager.findEmployeeByName("John"), "Test the program", "Find the issue", new Date(124, 4, 13), new Date(124, 4, 22), 2);
        testProgramTask.resolve("Send the issue to backend specialist");

        PriorityTask programTask = new PriorityTask(taskManager.findEmployeeByName("John"), "Update code", "Develop new feature", new Date(124, 4, 3), new Date(124, 4, 20), 1);
        programTask.resolve("Made an option to sort by name");

        PriorityTask contractTask =  new PriorityTask(taskManager.findEmployeeByName("Eva"),"Sign Contract", "Review and sign the contract", new Date(124, 4, 18), new Date(124, 4, 25),2);
        contractTask.resolve("Deal Done");

        Task documentTask = new Task(taskManager.findEmployeeByName("Alice"), "Hire a new employee", "Find marketing specialist", new Date(124, 4, 5), new Date(124, 4, 21));

        taskManager.addTask(testProgramTask);
        taskManager.addTask(programTask);
        taskManager.addTask(contractTask);
        taskManager.addTask(documentTask);

        TreeMap<User, ArrayList<Task>> tasksByAssignee = taskManager.getTasksByAssignee();

        try {
            FileWriter writer = new FileWriter("output1.txt");

            for (User user : taskManager.getTasksByAssignee().keySet()) {
                writer.write("Name: " + user.getName() + "\nPosition: " + user.getPosition() + ":\n");
                ArrayList<Task> tasks = taskManager.findTaskByAssigneeName(user.getName());
                if (tasks != null) {
                    for (Task task : tasks) {
                        writer.write(task + "\n");
                    }
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("Data saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader("output1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String userName = parts[0].trim();
                    String taskDescription = parts[1].trim();

                    String[] taskParts = taskDescription.split(",");
                    if (taskParts.length >= 5) {
                        String taskTitle = taskParts[0].trim();
                        String taskDesc = taskParts[1].trim();
                        Date taskStartDate = new Date(Long.parseLong(taskParts[2].trim()));
                        Date taskDeadline = new Date(Long.parseLong(taskParts[3].trim()));
                        int taskPriority = Integer.parseInt(taskParts[4].trim());

                        User user = new User(userName, null);
                        Task task = new PriorityTask(user, taskTitle, taskDesc, taskStartDate, taskDeadline, taskPriority);

                        ArrayList<Task> userTasks = tasksByAssignee.getOrDefault(user, new ArrayList<>());
                        userTasks.add(task);
                        tasksByAssignee.put(user, userTasks);
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }

        System.out.println("Contents of TreeMap (Read from file):");
        for (User user : taskManager.getTasksByAssignee().keySet()) {
            System.out.print("Name: " + user.getName() + "\nPosition: " + user.getPosition() + "\n");
            ArrayList<Task> tasks = taskManager.findTaskByAssigneeName(user.getName());
            if (tasks != null) {
                for (Task task : tasks) {
                    System.out.println(task);
                }
            }
            System.out.println();
        }


        System.out.println("Enter the user name to check if exists in the file:");
        String checkUser = scanner.nextLine();
        User userToCheck = new User(checkUser, null);
        if (tasksByAssignee.containsKey(userToCheck)) {
            System.out.println("Tasks for user " + checkUser + ":");
            ArrayList<Task> userTasks = tasksByAssignee.get(userToCheck);
            for (Task task : userTasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks found for user " + checkUser + " in the file.");
        }

        System.out.println("List of employees:");
        for (User user : taskManager.getTasksByAssignee().keySet()) {
            System.out.println("\nName: " + user.getName() + "\nPosition: " + user.getPosition());
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

        System.out.println("\nContents of TreeMap after deletion:");
        for (User user : tasksByAssignee.keySet()) {
            ArrayList<Task> tasks = taskManager.findTaskByAssigneeName(user.getName());
            if (tasks != null) {
                System.out.print("Name: " + user.getName() + "\nPosition: " + user.getPosition() +"\n");
                for (Task task : tasks) {
                    System.out.println(task);
                }
                System.out.println();
            }
        }

        try {
            FileWriter writer = new FileWriter("output1.txt");

            for (User user : taskManager.getTasksByAssignee().keySet()) {
                writer.write("Name: " + user.getName() + "\nPosition: " + user.getPosition() + ":\n");
                ArrayList<Task> tasks = taskManager.findTaskByAssigneeName(user.getName());
                if (tasks != null) {
                    for (Task task : tasks) {
                        writer.write(task + "\n");
                    }
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Updated data saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
