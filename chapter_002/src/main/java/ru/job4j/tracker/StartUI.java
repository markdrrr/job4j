package ru.job4j.tracker;

/**
 * 4.2. Статические методы.[#193283]
 * @author Andrey Markushin
 * @version 1.1
 * @since 30.11.2019
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
        tracker.replace(id, item);
        System.out.println("Edited");
    }

    /**
     * Удаления item по id из массива
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public static void delete(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        tracker.delete(id);
        System.out.println("Deleted");
    }

    /**
     * Поиск по id item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public static void findById(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        System.out.println("Заявка Name: " + item.getName() + " id: " + item.getId());
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
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAll(input, tracker);
            } else if (select == 2) {
                StartUI.replace(input, tracker);
            } else if (select == 3) {
                StartUI.delete(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                System.out.print("Good bye");
                run = false;
            }
        }
    }

    /**
     * Вывод меню
     */
    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
