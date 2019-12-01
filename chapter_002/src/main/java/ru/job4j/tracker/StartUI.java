package ru.job4j.tracker;

/**
 * 2.1. Реализация класса StartUI[#193272]
 * @author Andrey Markushin
 * @version 1.1
 * @since 30.11.2019
 */
public class StartUI {

    /**
     * Вызов методов на основе запроса пользователя
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = input.askStr("");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item created");
            } else if (select == 1) {
                System.out.println("All items: ");
                Item[] items = tracker.findAll();
                int j = 0;
                for(Item item : items) {
                    System.out.println("Заявка " + j++ +". Name: " + item.getName() + " id: " + item.getId());
                }

            } else if (select == 2) {
                System.out.print("Enter id: ");
                String id = input.askStr("");
                System.out.print("Enter new name: ");
                String name = input.askStr("");
                Item item = new Item(name);
                tracker.replace(id, item);
                System.out.println("Edited");
            } else if (select == 3) {
                System.out.print("Enter id: ");
                String id = input.askStr("");
                tracker.delete(id);
                System.out.println("Deleted");
            } else if (select == 4) {
                System.out.print("Enter id: ");
                String id = input.askStr("");
                Item item = tracker.findById(id);
                System.out.println("Заявка Name: " + item.getName() + " id: " + item.getId());
            } else if (select == 5) {
                System.out.print("Enter name: ");
                String name = input.askStr("");
                Item[] items = tracker.findByName(name);
                for (int i = 0; i < items.length; i++) {
                    System.out.println("Заявка Name: " + items[i].getName() + " id: " + items[i].getId());
                }
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
        System.out.print("Select: ");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
