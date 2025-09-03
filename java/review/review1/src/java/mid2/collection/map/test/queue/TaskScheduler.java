package java.mid2.collection.map.test.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskScheduler {

    private Queue<Task> tasks = new ArrayDeque<>();

    public void addTask(Task task) {
        tasks.offer(task);
    }


    public void processNextTask() {
        Task task = tasks.poll();
        if (task != null) {
            task.excute();
        }
    }

    public int getRemainingTasks() {
        return tasks.size();
    }
}
