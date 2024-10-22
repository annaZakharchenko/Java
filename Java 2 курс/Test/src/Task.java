import java.util.Date;
import java.util.Objects;

class Task implements Comparable<Task> {
    private String title;
    private String description;
    private User assignee;
    private Date startdate;
    private Date deadline;
    private boolean completed;
    String comment;

    public Task(User assignee, String title, String description, Date startdate, Date deadline) {
        this.assignee = assignee;
        this.title = title;
        this.description = description;
        this.startdate = startdate;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    public String resolve(String comment) {
        if (isCompleted()) {
            if (this.comment != null && !this.comment.isEmpty()) {
                this.comment = comment;
            } else {
                this.comment = comment;
            }
        }
        return this.comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("Assignee: ").append(assignee != null ? assignee.getName() : "Unassigned").append("\n");
        sb.append("Beginning: ").append(startdate).append("\n");
        sb.append("Deadline: ").append(deadline).append("\n");
        sb.append("Completed: ").append(completed ? "Yes" : "No").append("\n");
        sb.append("Resolution comment: ").append(resolve(comment)).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(assignee, task.assignee) &&
                Objects.equals(startdate, task.startdate) &&
                Objects.equals(deadline, task.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, assignee, startdate, deadline);
    }

    @Override
    public int compareTo(Task other) {
        return this.title.compareTo(other.title);
    }
}
