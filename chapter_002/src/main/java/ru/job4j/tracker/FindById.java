package ru.job4j.tracker;

public class FindById implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    /**
     * Поиск по id item
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if(item != null) {
            System.out.println("Successful search");
            System.out.println("Заявка Name: " + item.getName() + " id: " + item.getId());
        } else {
            System.out.println("Not found");
        }
        return true;
    }
}
