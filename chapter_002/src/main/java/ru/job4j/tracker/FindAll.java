package ru.job4j.tracker;

public class FindAll implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    /**
     * Вывод всех item, кроме null
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("All items: ");
        Item[] items = tracker.findAll();
        int j = 0;
        for(Item item : items) {
            System.out.println("Заявка " + j++ +". Name: " + item.getName() + " id: " + item.getId());
        }
        return true;
    }
}
