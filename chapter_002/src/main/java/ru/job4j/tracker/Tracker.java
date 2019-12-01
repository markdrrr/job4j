package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * 5. Реализовать класс Tracker[#193318]
 * @author Andrey Markushin
 * @version 1.1
 * @since 29.11.2019
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод заменяет ячейку в массиве. Для этого необходимо найти ячейку в массиве по id.
     * @param id   идентификатор ячейки в массиве объектов
     * @param item обьект item (товар)
     * @return true если операция завершилась удачно
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        Item foundItem = this.findById(id);
        if (foundItem != null) {
            foundItem.setName(item.getName());
            result = true;
        }
        return result;
    }

    /**
     * Метод должен удалить ячейку в массиве. Для этого необходимо найти ячейку в массиве по id.
     * Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с помощью System.arraycopy().
     * @param id идентификатор ячейки в массиве объектов
     * @return true если операция завершилась успешно
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод возвращает копию массива без null элементов.
     * @return массив.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод проверяет в цикле все элементы массива, сравнивая name с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его.
     * @param key имя для поиска.
     * @return массив.
     */
    public Item[] findByName(String key) {
        int j = 0;
        Item[] result = new Item[position];
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(key)) {
                result[j++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, j);
    }

    /**
     * Метод проверяет в цикле все элементы массива сравнивая id с аргументом String id.
     * @param id идентификатор искомого объекта.
     * @return возвращает найденный Item, если Item не найден - возвращает null.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

}
