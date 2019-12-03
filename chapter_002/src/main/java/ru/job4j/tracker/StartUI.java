package ru.job4j.tracker;

/**
 * 1. Обеспечить бесперебойную работу приложения Tracker.[#193289]
 * @author Andrey Markushin
 * @version 1.1
 * @since 03.12.2019
 */
public class StartUI {

    /**
     * Создание нового item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item created");
    }

    /**
     * Вывод всех item, кроме null
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public static void findAll(Input input, Tracker tracker) {
        System.out.println("All items: ");
        Item[] items = tracker.findAll();
        int j = 0;
        for(Item item : items) {
            System.out.println("Заявка " + j++ +". Name: " + item.getName() + " id: " + item.getId());
        }
    }

    /**
     * Изменение name item на новое
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public static void replace(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Edited");
        } else {
            System.out.println("Error");
        }
    }

    /**
     * Удаления item по id из массива
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public static void delete(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Deleted");
        } else {
            System.out.println("Error");
        }
    }

    /**
     * Поиск по id item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public static void findById(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if(item != null) {
            System.out.println("Successful search");
            System.out.println("Заявка Name: " + item.getName() + " id: " + item.getId());
        } else {
            System.out.println("Not found");
        }
    }

    /**
     * Поиск по имени item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public static void findByName(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        for (int i = 0; i < items.length; i++) {
            System.out.println("Заявка Name: " + items[i].getName() + " id: " + items[i].getId());
        }
    }

    /**
     * Вызов методов на основе запроса пользователя
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Вывод меню
     */
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
                System.out.println(index + ". " + actions[index].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAll(),
                new Replace(),
                new Delete(),
                new FindById(),
                new FindByName(),
                new Exit()
        };
        new StartUI().init(input, tracker, actions);
    }
}
