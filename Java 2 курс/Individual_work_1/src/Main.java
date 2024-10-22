import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addEmployee(new User("John", Position.DIRECTOR));
        taskManager.addEmployee(new User("Alice", Position.SECRETARY));
        taskManager.addEmployee(new User("Bob", Position.PROGRAMMER_JUNIOR));
        taskManager.addEmployee(new User("Mari", Position.PROGRAMMER_TEAM_LEADER));
        taskManager.addEmployee(new User("Eva", Position.HR));

        Task contractTask =  taskManager.createCustomTask(taskManager.findEmployeeByName("John"),"Sign Contract", "Review and sign the contract", new Date(124, 4, 1), new Date(124, 4, 15),2);
        Task programTask = taskManager.createCustomTask(taskManager.findEmployeeByName("Bob"),"Update code", "Develop new feature", new Date(124, 4, 3), new Date(124, 4, 20), 1);
        Task testingTask = taskManager.createCustomTask(taskManager.findEmployeeByName("Mari"),"Test the program", "Find the issue", new Date(124, 4, 5), new Date(124, 4, 14));
        Task documentTask = taskManager.createCustomTask(taskManager.findEmployeeByName("Alice"),"Prepare documents", "", new Date(124, 4, 2), new Date(124, 4, 4));
        Task hrTask = taskManager.createCustomTask(taskManager.findEmployeeByName("Eva"),"Hire a new employee", "Find marketing specialist", new Date(124, 4, 1), new Date(124, 4, 20));

        taskManager.addTask(hrTask);
        taskManager.addTask(contractTask);
        taskManager.addTask(programTask);
        taskManager.addTask(testingTask);
        taskManager.addTask(documentTask);


        //contractTask.markAsCompleted();
        taskManager.deleteTask(documentTask);
        contractTask.resolve("Deal Done");
        programTask.resolve("Made an option to sort by name");
        hrTask.resolve("");

        System.out.println("\nDetails of all tasks: \n");
        taskManager.printTaskDetails();

        taskManager.updateTask(contractTask, taskManager.findEmployeeByName("Mari"), new Date(124, 6, 30));

        String taskName = "Update code";
        ArrayList<Task> foundTaskByTitle = taskManager.findTaskByTitle(taskName);
        if (foundTaskByTitle != null) {
            System.out.println("\nFound task by title: " + taskName + "\n");
            for(Task task : foundTaskByTitle)
            {
                System.out.println(task);
            }
        } else {
            System.out.println("Task not found");
        }

        String assigneeName = "Mari";
        ArrayList<Task> foundTaskByAssignee = taskManager.findTaskByAssigneeName(assigneeName);
        if (foundTaskByAssignee != null) {
            System.out.println("\nFound task by assignee name: " + assigneeName + "\n");
            for(Task task : foundTaskByAssignee)
            {
                System.out.println(task);
            }
        } else {
            System.out.println("Task not found");
        }
        System.out.println("\nCompleted tasks:\n");
        taskManager.sortAndPrintTasks(true);

        System.out.println("\nIncompleted tasks:\n");
        taskManager.sortAndPrintTasks(false);
    }
}
//в таск менеджер додати treemap<user,Arraylist<Task>>
//всі методи  що з юзером через трімеп