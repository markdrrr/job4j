package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    private Input input; // хранит ссылку на объект
    private Tracker tracker; // хранит ссылку на объект
    ArrayList<BaseAction> actions = new ArrayList<>(); // хранит ссылку на массив типа UserAction

    /**
     * Реализация вывода данных с помощью Consumer
     * @since 11.10.2019 0.2
     */
    private final Consumer<String> output;

    /**
     * Конструктор.
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     * @param output
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения длинны массива меню.
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new CreateAction(0, "Add new Item"));
        this.actions.add(new FindAll(1, "Show all items"));
        this.actions.add(new Replace(2, "Edit item"));
        this.actions.add(new Delete(3, "Delete item"));
        this.actions.add(new FindById(4, "Find item by Id"));
        this.actions.add(new FindByName(5, "Find items by name"));
        this.actions.add(new Exit(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker, output);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.key() + " " + action.name());
            }
        }
    }
}