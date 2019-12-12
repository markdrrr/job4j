package ru.job4j.search;

import java.util.LinkedList;

/**
 * 2. Очередь с приоритетом на LinkedList[#193245]
 *
 * @author Andrey Markushin
 * @version 1.1
 * @since 11.12.2019
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Добавляет задачи по очереди с приоритетом.
     * @param task задача.
     */
    public void put(Task task) {
        int priorityNewTask = task.getPriority();
        int index = 0;
        for (Task taskFromList : tasks) {
            if (priorityNewTask <= taskFromList.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}