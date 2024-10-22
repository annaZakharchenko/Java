import java.util.Date;
import java.util.TreeMap;

class TaskManager {
    private TreeMap<User, TreeMap<Task, Task>> tasksByAssignee;

    public TaskManager() {
        this.tasksByAssignee = new TreeMap<>();
    }

    public void addEmployee(User employee) {
        tasksByAssignee.put(employee, new TreeMap<>());
    }

    public void addTask(Task task) {
        User assignee = task.getAssignee();
        tasksByAssignee.get(assignee).put(task, task);
    }

    public void printTaskDetails() {
        for (TreeMap<Task, Task> tasks : tasksByAssignee.values()) {
            for (Task task : tasks.keySet()) {
                if (task != null) {
                    System.out.println(task);
                }
            }
        }
    }

    public void deleteTask(Task task) {
        User assignee = task.getAssignee();
        tasksByAssignee.get(assignee).remove(task);
    }

    public void updateTask(Task task, User assignee, Date deadline) {
        User oldAssignee = task.getAssignee();
        task.setAssignee(assignee);
        task.setDeadline(deadline);
        tasksByAssignee.get(oldAssignee).remove(task);
        tasksByAssignee.get(assignee).put(task, task);
    }

    public TreeMap<Task, Task> findTaskByTitle(String title) {
        TreeMap<Task, Task> foundTask = new TreeMap<>();
        for (TreeMap<Task, Task> tasks : tasksByAssignee.values()) {
            for (Task task : tasks.keySet()) {
                if (task != null && task.getTitle() != null && task.getTitle().equals(title)) {
                    foundTask.put(task, task);
                }
            }
        }
        return foundTask.isEmpty() ? null : foundTask;
    }

    public TreeMap<Task, Task> findTaskByAssigneeName(String assigneeName) {
        for (User assignee : tasksByAssignee.keySet()) {
            if (assignee.getName().equals(assigneeName)) {
                return tasksByAssignee.get(assignee);
            }
        }
        return null;
    }

    public void createCustomTask(User assignee, String title, String description, Date startdate, Date deadline) {
        Task t = new Task(assignee, title, description, startdate, deadline);
        addTask(t);
    }

    public void createCustomTask(User assignee, String title, String description, Date startdate, Date deadline, int priority) {
        Task t = new PriorityTask(assignee, title, description, startdate, deadline, priority);
        addTask(t);
    }

    public User findEmployeeByName(String name) {
        for (User employee : tasksByAssignee.keySet()) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public void sortAndPrintTasks(boolean completed) {
        for (TreeMap<Task, Task> tasks : tasksByAssignee.values()) {
            for (Task task : tasks.keySet()) {
                if (task.isCompleted() == completed) {
                    System.out.println(task);
                }
            }
        }
    }

    public TreeMap<User, TreeMap<Task, Task>> getTasksByAssignee() {
        return tasksByAssignee;
    }
}
