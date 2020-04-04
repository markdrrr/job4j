package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;


/**
 * 2. Не перекрывать equals hashCode[#223118]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 04.04.2020
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User first = new User("Jonh", 2,new GregorianCalendar(1990, Calendar.JANUARY , 25));
        User second = new User("Jonh", 2,new GregorianCalendar(1990, Calendar.JANUARY , 25));
        Map<User, Object> map = new HashMap<>();
        map.put(first, first);
        map.put(second, second);
        System.out.println(map);
        System.out.println(first.equals(second));
        /*
        На печать вышло два идентичных объекта, так как метод equals() дает false и Map считает ключи уникальными.
        */
    }
}
