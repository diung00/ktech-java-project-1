package todolist;

import java.util.ArrayList;

public class Todo {
    private String task;
    private String deadline;


    public Todo(String task, String deadline) {
        this.task = task;
        this.deadline = deadline;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "task='" + task + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
