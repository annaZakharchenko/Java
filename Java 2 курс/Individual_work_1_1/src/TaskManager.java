import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

class TaskManager {
    private ArrayList<Task> tasks;
    private TreeMap<User, ArrayList<Task>> tasksByAssignee;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.tasksByAssignee = new TreeMap<>();
    }

    public void addEmployee(User employee) {
        tasksByAssignee.put(employee, new ArrayList<>());
    }

    public void addTask(Task task)
    {
        tasks.add(task);
        User assignee = task.getAssignee();
        tasksByAssignee.get(assignee).add(task);
    }

    public void printTaskDetails() {
        for (Task task : tasks) {
            if (task != null) {
                System.out.println(task);
            }
        }
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
        User assignee = task.getAssignee();
        tasksByAssignee.get(assignee).remove(task);
    }

    public void updateTask(Task task, User assignee, Date deadline) {
        User oldAssignee = task.getAssignee();
        task.setAssignee(assignee);
        task.setDeadline(deadline);
        tasksByAssignee.get(oldAssignee).remove(task);
        tasksByAssignee.get(assignee).add(task);
    }

    public ArrayList<Task> findTaskByTitle(String title) {
        ArrayList<Task> foundTask = new ArrayList<>();
        for (Task task : tasks) {
            if (task != null && task.getTitle() != null && task.getTitle().equals(title)) {
                foundTask.add(task);
            }
        }
        return foundTask.isEmpty() ? null : foundTask;
    }

    public ArrayList<Task> findTaskByAssigneeName(String assigneeName) {
        User assigneeToFind = new User(assigneeName, null);
        return tasksByAssignee.get(assigneeToFind);

        /*for (User assignee : tasksByAssignee.keySet()) {
        if (user.getName().equals(assigneeName)) {
                return tasksByAssignee.get(assignee);
                }
        }
        return null;*/
    }

    public void createCustomTask(User assignee, String title, String description, Date startdate, Date deadline) {
        Task t = new Task(assignee, title, description, startdate, deadline);
        addTask(t);
        //return t;
    }

    public void createCustomTask(User assignee, String title, String description, Date startdate, Date deadline, int priority) {
        Task t = new PriorityTask(assignee, title, description, startdate, deadline, priority);
        addTask(t);
        //return t;
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
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                System.out.println(task);
            }
        }
    }
    public TreeMap<User, ArrayList<Task>> getTasksByAssignee() {
        return tasksByAssignee;
    }


}