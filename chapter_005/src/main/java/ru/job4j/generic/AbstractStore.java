package ru.job4j.generic;


/**
 * 5.2.2. Реализовать Store<T extends Base>[#223108]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 17.01.2020
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> value = new SimpleArray<>(5);

    /**
     * Добавляет указанный элемент (model) в список.
     *
     * @param model элемент для добавления.
     */
    @Override
    public void add(T model) {
        value.add(model);
    }

    /**
     * Заменяет указанным элементом (model) у элемента со схожем id.
     *
     * @param id элемента который будем заменять.
     * @param model элемент для добавления.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean valid = false;
        for (int index = 0; value.iterator().hasNext(); index++) {
            if (value.get(index).getId().equals(id)) {
                value.set(index, model);
                valid = true;
                break;
            }
        }
        return valid;
    }

    /**
     * Удаляет элемент со схожем id.
     *
     * @param id элемента.
     */
    @Override
    public boolean delete(String id) {
        boolean valid = false;
        for (int index = 0; value.iterator().hasNext(); index++) {
            if (value.get(index).getId().equals(id)) {
                value.remove(index);
                valid = true;
                break;
            }
        }
        return valid;
    }

    /**
     * Находит элемент по id.
     *
     * @param id элемента.
     * @return найденеый элемент
     */
    @Override
    public T findById(String id) {
        for (int index = 0; value.iterator().hasNext(); index++) {
            if (value.get(index).getId().equals(id)) {
                return value.get(index);
            }
        }
        return null;
    }
}
