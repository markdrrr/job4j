package ru.job4j.search;

import java.util.LinkedList;

/**
 * 2. Очередь с приоритетом на LinkedList[#193245]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 09.12.2019
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Добавляет задачи по очереди с приоритетом.
     * @param task задача.
     */
    public void put(Task task) {
        int PriorityNewTask = task.getPriority();
        int indexForNewTask = 0;
        for (int index = 0; index < tasks.size(); index++){
            int PriorityTaskFromList = tasks.get(index).getPriority();
            if (PriorityNewTask <= PriorityTaskFromList) {
                indexForNewTask = index;
            }
        }
        tasks.add(indexForNewTask,task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}