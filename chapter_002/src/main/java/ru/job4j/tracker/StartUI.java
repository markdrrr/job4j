package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * 3. Изменить программу Tracker из 2-го модуля[#193251]
 * @author Andrey Markushin
 * @version 2.0
 * @since 11.12.2019
 */
public class StartUI {

    /**
     * Вызов методов на основе запроса пользователя
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    public void init(Input input, Tracker tracker, ArrayList<BaseAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            BaseAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Вывод меню
     */
    private void showMenu(ArrayList<BaseAction> actions) {
        System.out.println("Menu.");
        for (BaseAction action: actions) {
            System.out.println(action.key() + ". " + action.name());
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        ArrayList<BaseAction> actions = new ArrayList<>();
        actions.add(new CreateAction(0, "Add new Item"));
        actions.add(new FindAll(1, "Show all items"));
        actions.add(new Replace(2, "Edit item"));
        actions.add(new Delete(3, "Delete item"));
        actions.add(new FindById(4, "Find item by Id"));
        actions.add(new FindByName(5, "Find items by name"));
        actions.add(new Exit(6, "Exit Program"));
        new StartUI().init(validate, tracker, actions);
    }
}



