package ru.job4j.iterator;

import java.util.Iterator;

/**
 * 5.1.4. Создать convert(Iterator<Iterator>)[#223103]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 12.01.2020
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            /**
             * текущий внутренний итератор
             */
            Iterator<Integer> inside = it.next();

            /**
             * Если в текущем внутреннем итераторе закончились элементы
             * переходим к следующему внутреннему итератору и проверяем наличие следующего элемента в нем.
             *
             * @return true если есть следующий элемент, иначе false.
             */
            @Override
            public boolean hasNext() {
                if (!inside.hasNext()) {
                    while (it.hasNext()) {
                        inside = it.next();
                        if (inside.hasNext()) {
                            break;
                        }
                    }
                }
                return inside.hasNext();
            }

            /**
             * Возвращает следующий элмент текущего внутреннего итератора
             * если внутренний итератор закончился, переходим к следующему внутреннему итератору.
             *
             * @return следующий элемент.
             */
            @Override
            public Integer next() {
                if (!inside.hasNext()) {
                    inside = it.next();
                }
                int i = inside.next();
                return i;
            }
        };
    }
}