package riva.vincent.mytodolist;


public class TodoTask {

    private String task;
    private boolean isImportant = false;

    public TodoTask(String task, boolean isImportant) {
        this.task = task;
        this.isImportant = isImportant;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}
