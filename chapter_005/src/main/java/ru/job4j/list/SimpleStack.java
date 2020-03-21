package ru.job4j.list;

/**
 * 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack[#223095]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 21.03.2020
 */
public class SimpleStack<T> {
    private SimpleLinkedList<T> linked = new SimpleLinkedList<T>();

    /**
     * Метод удаляет и возвращает первый эелемент.
     * @return удаленный элемент.
     */
    public T poll() {
        return linked.delete();
    }

    /**
     * Метод помещает значение в коллекцию.
     * @param value значение для добавления.
     */
    public void push(T value) {
        linked.add(value);
    }
}
