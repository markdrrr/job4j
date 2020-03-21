package ru.job4j.list;

/**
 * 5.3.3.1 Очередь на двух стеках[#223098]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 21.03.2020
 */
public class SimpleQueue<T> {
    private SimpleStack<T> input  = new SimpleStack<>();
    private SimpleStack<T> output  = new SimpleStack<>();

    public T poll() {
        T temp = input.poll();
            while (temp != null) {
                output.push(temp);
                temp = null;
            }
        return output.poll();
    }

    public void push(T value) {
        input.push(value);
    }
}
