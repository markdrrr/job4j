package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    /**
     * Поиск по имени item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (0 < items.length) {
            for (int i = 0; i < items.length; i++) {
                System.out.println("Заявка Name: " + items[i].getName() + " id: " + items[i].getId());
            }
        } else {
            System.out.println("Not found");
        }
        return true;
    }
}
