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
        transfer();
        return output.poll();
    }

    public void push(T value) {
        input.push(value);
    }

    public void transfer() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                this.output.push(this.input.poll());
            }
        }
    }
}
