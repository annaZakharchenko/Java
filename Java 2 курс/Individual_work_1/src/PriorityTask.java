import java.util.Date;

public class PriorityTask extends Task {
    private int priority;

    public PriorityTask(User assignee,String title, String description, Date startdate, Date deadline, int priority) {
        super(assignee,title, description, startdate, deadline);
        this.priority = priority;
    }
/*
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
*/
    @Override
    public String resolve(String comment) {
        if (isCompleted()) {
            if (comment == null || comment.isEmpty()) {
                throw new UnsupportedOperationException("Error: Resolution comment cannot be empty for completed task");
            }
            else  this.comment = comment;

        }
        else {
            markAsCompleted();
            if (comment == null || comment.isEmpty()) {
                throw new UnsupportedOperationException("Error: Resolution comment cannot be empty for completed task");
            }
            else this.comment = comment;
        }
        return this.comment;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Priority: ").append(priority).append("\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        PriorityTask that = (PriorityTask) obj;
        return priority == that.priority;
    }

   /* @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), priority);
    }*/
}
