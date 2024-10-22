import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

class TaskManager {
    private ArrayList<Task> tasks;
    private ArrayList<User> employees;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public void printTaskDetails() {
        for (Task task : tasks) {
            if (task != null) {
                System.out.println(task);
            }
        }
    }
    public void addEmployee(User employee) {
        employees.add(employee);
    }
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(Task task) {
        task.markAsCompleted();
    }
  /* public void markTaskAsCompleted(Task task) {
       task.isCompleted();
   }*/


    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public void updateTask(Task task, User assignee, Date deadline) {
        task.setAssignee(assignee);
        task.setDeadline(deadline);
        //task.setDescription(description);
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

    public ArrayList<Task> findTaskByAssigneeName(String assigneeName) {//через трімеп через ім'я
        ArrayList<Task> foundTasks = new ArrayList<>();
       for (Task task : tasks) {
            if (task != null && task.getAssignee() != null && task.getAssignee().getName().equals(assigneeName)) {
                foundTasks.add(task);
            }
        }
        return foundTasks.isEmpty() ? null : foundTasks;
    }

    public Task createCustomTask(User assignee,String title, String description, Date startdate, Date deadline) {
       /* Task t = new Task(assignee,title, description, startdate, deadline);
        tasks.add(t);//одати до юзера в тримеп*/
        return new Task(assignee,title, description, startdate, deadline);
    }

    public Task createCustomTask(User assignee,String title, String description, Date startdate, Date deadline, int priority) {
        return new PriorityTask(assignee,title, description, startdate, deadline, priority);
    }

    public User findEmployeeByName(String name) {
        for (User employee : employees) {
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

}
