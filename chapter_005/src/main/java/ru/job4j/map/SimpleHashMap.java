package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 8. Реализовать собственную структуру данных - HashMap[#223121]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 21.04.2020
 */
public class SimpleHashMap<K, V> implements Iterable<K> {

    private static final int DEFAULT_CAPACITY = 10;
    private Node<K, V>[] table;
    private int size = 0;
    private int threshold = 0;

    public SimpleHashMap() {
        this.table = new Node[DEFAULT_CAPACITY];
        threshold = (int) (table.length * 0.75f);
    }

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }
        public final V getValue() {
            return value;
        }
        public final String toString() {
            return key + "=" + value;
        }
    }

    /**
     * Добавляет объект ключ, значение.
     *
     * @param key
     * @param value
     * @return удачно прошло добавление или нет.
     */
    boolean insert(K key, V value) {
        boolean result = false;
        if (size + 1 > threshold) {
            growtable();
        }
        int hashcode = hash(key);
        if (this.table[hashcode] == null) {
            this.table[hashcode] = new Node<>(hashcode, key, value);
            this.size++;
            result = true;
        }
        if (this.table[hashcode].hash == hash(key) && !this.table[hashcode].value.equals(value)) {
            int i = hashcode;
            while (this.table[i] != null) {
                ++i;
                i %= threshold;
            }
            this.table[i] = new Node<>(hashcode, key, value);
            size++;
            result = true;
        }
        return result;
    }

    /**
     * Увеличивает размер изначального массива.
     */
    private void growtable() {
        this.threshold = this.threshold * 2;
        Node<K, V>[] oldTable = table;
        table = new Node[threshold];
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                int i = hash((K) node.key);
                while (this.table[i] != null) {
                    ++i;
                    i %= threshold;
                }
                table[i] = node;
            }
        }
    }

    /**
     * Получаем Хэш значение по ключу.
     */
    private int hash(K key) {
        return key.hashCode() % threshold;
    }

    /**
     * Удаляет объект по ключу.
     *
     * @param key
     * @return удачно прошло удаление или нет.
     */
    public boolean delete(K key) {
        boolean result = false;
        int hashcode = hash(key);
        if (this.table[hashcode] != null && key.equals(this.table[hashcode].key)) {
            this.table[hashcode] = null;
            this.size--;
            result = true;
        }
        return result;
    }

    /**
     * Получаем размер списка.
     */
    public int getSize() {
        return this.size;
    }


    /**
     * Получаем объект по ключу.
     *
     * @param key
     * @return value значение.
     */
    public V get(K key) {
        int hashcode = hash(key);
        while (this.table[hashcode].key != key) {
            ++hashcode;
            hashcode %= threshold;
        }
        return this.table[hashcode].value;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                while (index < table.length) {
                    if (table[index] != null) {
                        result = true;
                        break;
                    }
                    index++;
                }
                return result;
            }

            @Override
            public K next() {
                while (index < table.length && table[index] == null) {
                    index++;
                }
                if (index >= table.length) {
                    throw new NoSuchElementException();
                }
                return (K) table[index++].key;
            }
        };
    }
}

