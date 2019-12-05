package ru.job4j.tracker;

public class Delete extends BaseAction {
    protected Delete(int key, String name) {
        super(key, name);
    }


    /**
     * Удаления item по id из массива
     * @param input объект для использования пользовательиского ввода
     * @param tracker объект для обращения к классу Tracker
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Deleted");
        } else {
            System.out.println("Error not found");
        }
        return true;
    }
}
